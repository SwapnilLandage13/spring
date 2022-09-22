package org.example.Serviceimpl;


import com.spring.services.model.User;
import org.example.Entity.BlogEntity;
import org.example.Entity.UserEntity;
import org.example.Exception.ErrorHandler;
import org.example.Repository.BlogRepository;
import org.example.Repository.UserRepository;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogRepository blogRepository;

    @Override
    public ResponseEntity<List<User>> getallusers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> userArrayList = new ArrayList<>();
        userEntities.stream().filter(e-> e.getIs_deleted().equalsIgnoreCase("N")).forEach(e->{
            User user = new User();
            user.setUserId(e.getUserId());
            user.setFirstName(e.getFirstName());
            user.setLastName(e.getLastName());
            user.setEmail(e.getEmail());
            user.setCity(e.getCity());
            user.setPassword(e.getPassword());
            user.setCreatedOn(String.valueOf(e.getCreated_on()));
            user.setUpdatedOn(String.valueOf(e.getUpdated_on()));
            userArrayList.add(user);
        });
        return new ResponseEntity<List<User>>(userArrayList, HttpStatus.OK);
    }

//   public ResponseEntity<Void> postusers(User user){
//
//       try {
//
//           UserEntity user11 = new UserEntity();
//           // user1.setUserId(user.getUserId());
//           user11.setFirstName(user.getFirstName());
//           user11.setLastName(user.getLastName());
//           user11.setEmail(user.getEmail());
//           user11.setCity(user.getCity());
//           user11.setPassword(user.getPassword());
//           user11.setIs_deleted("N");
//           user11.setCreated_on(new Timestamp(System.currentTimeMillis()));
//           userRepository.save(user11);
//           return new ResponseEntity<>(HttpStatus.OK);
//       }catch (ErrorHandler errorHandler){
//           throw new ErrorHandler("User not found",400);
//       }
//   }


//   public ResponseEntity<List<User>> getallusers(){
//       try {
//
//       List<UserEntity> userEntities = userRepository.findAll();
//       List<User> modelList = new ArrayList<>();
//       userEntities.forEach(e->{
//
//           User model = new User();
//           if (e.getIs_deleted().equalsIgnoreCase("N")) {
//
//               model.setUserId(e.getUserId());
//               model.setFirstName(e.getFirstName());
//               model.setLastName(e.getLastName());
//               model.setEmail(e.getEmail());
//               model.setCity(e.getCity());
//               model.setIsDeleted(e.getIs_deleted());
//               model.setCreatedOn(String.valueOf(e.getCreated_on()));
//               model.setUpdatedOn(String.valueOf(e.getUpdated_on()));
//               modelList.add(model);
//           }
//           else{
//                throw new ErrorHandler();
//           }
//       });
//       return new ResponseEntity<List<User>>(modelList, HttpStatus.OK);
//       }
//       catch(ErrorHandler e)
//       {
//           throw new ErrorHandler("User Not Found",400);
//       }
//
//   }
@Override
public ResponseEntity<User> getUserByIdGet(Integer userId) {
    try {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        if (userEntity.getIs_deleted().equalsIgnoreCase("N")) {
            User user = new User();
            user.setUserId(userEntity.getUserId());
            user.setFirstName(userEntity.getFirstName());
            user.setLastName(userEntity.getLastName());
            user.setEmail(userEntity.getEmail());
            user.setCity(userEntity.getCity());
            user.setPassword(userEntity.getPassword());
            user.setCreatedOn(String.valueOf(userEntity.getCreated_on()));
            user.setUpdatedOn(String.valueOf(userEntity.getUpdated_on()));
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        else{
            throw new ErrorHandler("Data not found",400);
        }
    } catch (Exception e) {
        throw new ErrorHandler("Data not found",400);
    }
}
//   public ResponseEntity<User> getUserByIdGet(Integer userId){
//       UserEntity entity = userRepository.findById(userId).orElse(null);
//       User model = new User();
//       try {
//
//       if (entity.getIs_deleted().equalsIgnoreCase("N")) {
//           model.setUserId(entity.getUserId());
//           model.setFirstName(entity.getFirstName());
//           model.setLastName(entity.getLastName());
//           model.setEmail(entity.getEmail());
//           model.setCity(entity.getCity());
////           model.setIsDeleted(entity.getIs_deleted());
////           model.setCreatedOn(String.valueOf(entity.getCreated_on()));
//       }
//       else {
//           throw new ErrorHandler();
//       }
//       return new ResponseEntity<User>(model,HttpStatus.OK);
//       }
//       catch(NullPointerException e)
//       {
//           throw new ErrorHandler("user Not Found with id ",400);
//       }
//       catch(ErrorHandler e) {
//           throw new ErrorHandler("User Not Found", 400);
//       }
//
//   }
   public ResponseEntity<Void> deleteById(Integer userId) {
       try {
           UserEntity userEntity = userRepository.findById(userId).get();
           // Integer id = userEntity.getUserId();
           Integer id = userId;
           List<BlogEntity> blogEntity = blogRepository.findAll();
           blogEntity.forEach(e -> {
               BlogEntity blog = new BlogEntity();
               if (id==e.getUserEntity().getUserId()) {
                   e.setIsdeleted("Y");
                   blogRepository.save(e);
               }
           });
           userEntity.setIs_deleted("Y");
           userRepository.save(userEntity);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch(ErrorHandler e)
       {
           throw new ErrorHandler("User id Not Found",400);
       }
   }
//
//    public ResponseEntity<Void> UpdateUser(Integer userId, User user)
//    {
//        try {
//            UserEntity entity = userRepository.findById(userId).orElse(null);
////        entity.setUserId(user.getUserId());
//            entity.setFirstName(user.getFirstName());
//            entity.setLastName(user.getLastName());
//            entity.setEmail(user.getEmail());
//            entity.setCity(user.getCity());
//            entity.setIs_deleted("N");
//            //  entity.setCreated_on(new Timestamp(System.currentTimeMillis()));
//            entity.setUpdated_on(new Timestamp(System.currentTimeMillis()));
//            userRepository.save(entity);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch (ErrorHandler errorHandler){
//            throw new ErrorHandler();
//        }
//    }

    @Override
    public ResponseEntity<Void> updateUser(User user) {
       Optional<UserEntity> userEntity1 = userRepository.findById(user.getUserId());
        if(userEntity1.isPresent()) {
            UserEntity userEntity = userEntity1.get();
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setEmail(user.getEmail());
            userEntity.setCity(user.getCity());
            userEntity.setPassword(user.getPassword());
            userEntity.setUpdated_on(new Timestamp(System.currentTimeMillis()));
            userRepository.save(userEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else throw new ErrorHandler();
    }
    @Override
    public ResponseEntity<Void> postUser(User user) {
        UserEntity userEntity = new UserEntity(user.getFirstName(), user.getLastName(), user.getEmail(),user.getCity());
        userEntity.setCreated_on(new Timestamp(System.currentTimeMillis()));
        userEntity.setPassword(user.getPassword());
        userEntity.setIs_deleted("N");
        userRepository.save(userEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        List<UserEntity> userEntities = userRepository.findAll();
        UserEntity user = new UserEntity();
        userEntities.forEach(e-> {
            if(e.getEmail().equalsIgnoreCase(email)) {
                user.setUserId(e.getUserId());
                user.setEmail(e.getEmail());
                user.setFirstName(e.getFirstName());
                user.setCity(e.getCity());
                user.setPassword(e.getPassword());
                user.setLastName(e.getLastName());
                user.setIs_deleted(e.getIs_deleted());
                user.setUpdated_on(e.getUpdated_on());
                user.setCreated_on(e.getUpdated_on());
            }
        });
        return user;
    }
}
