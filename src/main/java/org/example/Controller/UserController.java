package org.example.Controller;

import com.spring.services.api.UsersApi;
import com.spring.services.model.User;
import io.swagger.annotations.Api;
import org.example.Entity.UserEntity;
import org.example.Exception.ErrorHandler;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "User", tags = "User")
@CrossOrigin(origins = "*")
public class UserController implements UsersApi {
    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<Void> usersAddUserPost(User user){
            return userService.postUser(user);

    }
    @Override
    public ResponseEntity<List<User>> usersGet(){
        try {
            return userService.getallusers();
        }catch (ErrorHandler e)
        {
            throw new ErrorHandler();
        }
    }
    @Override
    public ResponseEntity<User> usersGetUserByIdGet(Integer userId){
        try {

            return userService.getUserByIdGet(userId);
        }catch (ErrorHandler e){
            throw new ErrorHandler();
        }
    }
    @Override
    public ResponseEntity<Void> usersUpdateUserPost(User user){
            return userService.updateUser(user);

    }
    @Override
    public ResponseEntity<Void> usersDeleteByIdDelete(Integer userId)
    {
        try {
            return userService.deleteById(userId);
        }
        catch (ErrorHandler e){
            throw new ErrorHandler();
        }
    }

//    @Override
//    public ResponseEntity<Void> usersUpdateUserByIdPut(Integer userId, User user)
//    {
//        try {
//            return userService.UpdateUser(userId, user);
//        }catch (ErrorHandler e){
//            throw new ErrorHandler();
//        }
//    }
    @GetMapping("/getUser/{email}")
    public UserEntity getUser(@PathVariable String email){
        try {
            return userService.findUserByEmail(email);
        }catch (Exception e){
            throw new ErrorHandler();
        }
    }
}

