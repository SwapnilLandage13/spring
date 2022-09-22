package org.example.Serviceimpl;

import com.spring.services.model.Blog;
import org.example.Entity.BlogEntity;
import org.example.Entity.UserEntity;
import org.example.Exception.ErrorHandler;
import org.example.Repository.BlogRepository;
import org.example.Repository.UserRepository;
import org.example.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

//
//    public ResponseEntity<Void> BlogPost(Blog blog){
//        BlogEntity user12 = new BlogEntity();
//        Optional<UserEntity> userEntity = userRepository.findById(blog.getUserBlogId());
//        if(userEntity.isPresent()) {
//            user12.setUserEntity(userEntity.get());
//        }
//        else {
//            throw new ErrorHandler("Blog with entered userid not present",404);
//        }
//        user12.setBlogid(blog.getBlogid());
//        user12.setBlogbody(blog.getBlogbody());
//        user12.setBlogtitle(blog.getBlogtitle());
//        user12.setIsdeleted("N");
//        user12.setPublishby(userEntity.get().getFirstName() + "" + userEntity.get().getLastName());
//      //  user1.setUserEntity(userEntity.get());
//        user12.setCreatedon(new Timestamp(System.currentTimeMillis()));
//
//    //    Optional<UserEntity> userEntity = userRepository.findById(blog.getUserBlogId());
//
//        blogRepository.save(user12);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    public ResponseEntity<Void> deleteBlogById(Integer blogId){
    if(blogRepository.findById(blogId).isPresent())
    {
        BlogEntity entity = blogRepository.findById(blogId).get();
        entity.setIsdeleted("Y");
        blogRepository.save(entity);

    }
    else {
        throw new ErrorHandler();
    }
    return new ResponseEntity<Void>(HttpStatus.OK);

    }
//    public ResponseEntity<Void> blogsDeleteById(Integer blogId){
//
//        if(blogRepository.findById(blogId).isPresent())
//        {
//            BlogEntity blogEntity = blogRepository.findById(blogId).get();
//            blogEntity.setIsdeleted("Y");
//            blogEntity.setIsdeleted(String.valueOf(new Timestamp(System.currentTimeMillis())));
//            blogRepository.save(blogEntity);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        else {
//            throw new ErrorHandler("Blog with entered userid not present",404);
//        }
//    }


    public ResponseEntity<List<Blog>> BlogGetAll() {
        try {
            List<BlogEntity> blogEntities = blogRepository.findAll();
            List<Blog> modelList = new ArrayList<>();
            blogEntities.forEach(e -> {
                Blog model1 = new Blog();
                if(e.getIsdeleted().equalsIgnoreCase("N")) {
                    model1.setBlogId(e.getBlogId());
                    model1.setBlogtitle(e.getBlogtitle());
                    model1.setBlogbody(e.getBlogbody());
                    model1.setPublishby(e.getPublishby());
                    model1.isdeleted(e.getIsdeleted());
                    model1.setUserBlogId(e.getUserEntity().getUserId());
                    model1.setCreatedon(String.valueOf(e.getCreatedon()));
                    model1.setUpdatedon(String.valueOf(e.getUpdatedon()));
                    modelList.add(model1);
                }
            });
            return new ResponseEntity<List<Blog>>(modelList, HttpStatus.OK);
        }
        catch(Exception e)
        {
            throw new ErrorHandler();
        }

    }

//    @Override
//    public ResponseEntity<List<Blog>> BlogGetAll() {
//        List<BlogEntity> blogEntity = blogRepository.findAll();
//        List<Blog> blogs = new ArrayList<>();
//        blogEntity.stream().filter(e -> e.getIsdeleted().equalsIgnoreCase("N")).forEach(e -> {
//            Blog blog = new Blog();
//            blog.setBlogId(e.getBlogId());
//            blog.setUserBlogId((e.getUserEntity()).getUserId());
//            blog.setBlogtitle(e.getBlogtitle());
//            blog.setBlogbody( e.getBlogbody());
//            blog.setPublishby(e.getPublishby());
//            blog.setIsdeleted(e.getIsdeleted());
//            blog.setCreatedon(String.valueOf(e.getCreatedon()));
//            blog.setIsdeleted(String.valueOf(e.getIsdeleted()));
//            blogs.add(blog);
//        });
//        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
//    }


    //
//    public ResponseEntity<List<Blog>> BlogGetAll(){
//
//        List<BlogEntity> blogEntities = blogRepository.findAll();
//        List<Blog> modelList = new ArrayList<>();
//        try{
//        blogEntities.forEach(e->{
//
//            Blog model = new Blog();
//
//            if (e.getIsdeleted().equalsIgnoreCase("N")) {
//
//                model.setBlogid(e.getBlogid());
//                model.setBlogbody(e.getBlogbody());
//                model.setBlogtitle(e.getBlogtitle());
//                model.setPublishby(e.getPublishby());
//                model.setIsdeleted(e.getIsdeleted());
//                model.setUserBlogId(e.getUserEntity().getUserId());
////                model.setCreatedon(String.valueOf(e.getCreatedon()));
//                modelList.add(model);
//            }
//            else{
//                throw new ErrorHandler();
//            }
//        });
//        return new ResponseEntity<List<Blog>>(modelList, HttpStatus.OK);
//        }
//        catch(ErrorHandler e)
//        {
//            throw new ErrorHandler();
//        }
//
//    }
//    @Override
//    public ResponseEntity<List<Blog>> getAllBlogByUserId(Integer userId) {
//        try {
//            List<BlogEntity> blogEntities = blogRepository.findAll();
//            List<Blog> blogs = new ArrayList<>();
//            blogEntities.stream().filter(e -> e.getUserEntity().getUserId().equals(userId)).filter(e->e.getIsdeleted().equalsIgnoreCase("N")).forEach(e -> {
//                Blog blog = new Blog();
//                blog.setBlogid(e.getBlogid());
//                blog.setUserBlogId((e.getUserEntity()).getUserId());
//                blog.setBlogtitle(e.getBlogtitle());
//                blog.setBlogbody(e.getBlogbody());
//                blog.setPublishby(e.getPublishby());
//                blog.setIsdeleted(e.getIsdeleted());
//                blog.setCreatedon(String.valueOf(e.getCreatedon()));
//                blog.setIsdeleted(String.valueOf(e.getIsdeleted()));
//                blogs.add(blog);
//            });
//            return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
//        }catch(Exception e){
//            throw new ErrorHandler();
//        }
//    }

    public ResponseEntity<Blog> blogsGetBlogById(Integer blogId){

        BlogEntity entity = blogRepository.findById(blogId).orElse(null);
        Blog model = new Blog();

        try {

        if (entity.getIsdeleted().equalsIgnoreCase("N")) {

            model.setBlogId(entity.getBlogId());
            model.setUserBlogId(entity.getUserEntity().getUserId());
            model.setBlogbody(entity.getBlogbody());
          //  model.setBlogtitle(entity.getBlogtitle());
            model.setPublishby(entity.getPublishby());
            model.setIsdeleted(entity.getIsdeleted());
//            model.setCreatedon(String.valueOf(entity.getCreatedon()));
        }
        return new ResponseEntity<Blog>(model,HttpStatus.OK);
        }
        catch(NullPointerException e) {
            throw new ErrorHandler("blog Not Found with id ", 400);
        }
        catch(ErrorHandler e)
        {
            throw new ErrorHandler("Blog Not Found",400);
        }

    }
//    public ResponseEntity<Void> UpdateBlog(Integer blogId, Blog blog){
//
//        BlogEntity entity = blogRepository.findById(blogId).orElse(null);
////        entity.setBlogid(blog.getBlogid());
//        entity.setBlogbody(blog.getBlogbody());
//        entity.setBlogtitle(blog.getBlogtitle());
//        entity.setIsdeleted("N");
//        entity.setPublishby(blog.getPublishby());
//      //  entity.setCreatedon(new Timestamp(System.currentTimeMillis()));
//        entity.setUpdatedon(new Timestamp(System.currentTimeMillis()));
//        Optional<UserEntity> userEntity = userRepository.findById(blog.getUserBlogId());
//        if(userEntity.isPresent())
//        {
//            entity.setUserEntity(userEntity.get());
//        }
//
//        blogRepository.save(entity);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    @Override
//    public ResponseEntity<Void> BlogPost(Blog blog) {
//        Optional<UserEntity> user1 = userRepository.findById(blog.getUserBlogId());
//        if (user1.isPresent()) {
//            BlogEntity blogEntity = new BlogEntity();
//            Optional<UserEntity> user = userRepository.findById(blog.getUserBlogId());
//            blogEntity.setPublishby(user.get().getFirstName() + user.get().getLastName());
//            blogEntity.setBlogtitle(blog.getBlogtitle());
//            blogEntity.setBlogbody(blog.getBlogbody());
//            blogEntity.setUserEntity(user.get());
//            blogRepository.save(blogEntity);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else throw new ErrorHandler("Data not found",400);
//    }
    @Override
    public ResponseEntity<Void> updateBlog(Blog blog){
        Optional<BlogEntity> blogEntity = blogRepository.findById(blog.getBlogId());
        if(blogEntity.isPresent()){
            BlogEntity blogEntity1 = blogEntity.get();
            blogEntity1.setBlogId(blogEntity1.getBlogId());
            blogEntity1.setBlogtitle(blog.getBlogtitle());
            blogEntity1.setBlogbody(blog.getBlogbody());
            UserEntity user= userRepository.findById(blogEntity1.getUserEntity().getUserId()).get();
            blogEntity1.setPublishby(user.getFirstName()+user.getLastName());
            blogRepository.save(blogEntity1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else throw new ErrorHandler();
    }
//        Optional<BlogEntity> blogEntity = blogRepository.findById(blog.getBlogid());
//        if(blogEntity.isPresent()){
//            BlogEntity blogEntity1 = blogEntity.get();
//            blogEntity1.setBlogid(blogEntity1.getBlogid());
//            blogEntity1.setBlogtitle(blog.getBlogtitle());
//            blogEntity1.setBlogbody(blog.getBlogbody());
//            UserEntity user= userRepository.findById(blogEntity1.getUserEntity().getUserId()).get();
//            blogEntity1.setPublishby(user.getFirstName()+user.getLastName());
//            blogRepository.save(blogEntity1);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        else throw new ErrorHandler();
//    }

    @Override
    public ResponseEntity<List<Blog>> getAllBlogByUserId(Integer userId) {
        try {
            List<BlogEntity> blogEntities = blogRepository.findAll();
            List<Blog> blogs = new ArrayList<>();
            blogEntities.stream().filter(e -> e.getUserEntity().getUserId().equals(userId)).filter(e->e.getIsdeleted().equalsIgnoreCase("N")).forEach(e -> {
                Blog blog = new Blog();
                blog.setBlogId(e.getBlogId());
                blog.setUserBlogId((e.getUserEntity()).getUserId());
                blog.setBlogtitle(e.getBlogtitle());
                blog.setBlogbody(e.getBlogbody());
                blog.setPublishby(e.getPublishby());
                blog.setIsdeleted(e.getIsdeleted());
                blog.setCreatedon(String.valueOf(e.getCreatedon()));
                blog.setIsdeleted(String.valueOf(e.getIsdeleted()));
                blogs.add(blog);
            });
            return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
        }catch(Exception e){
            throw new ErrorHandler();
        }
    }

    public ResponseEntity<Void> BlogPost(Blog blog) {
        try {
            BlogEntity e = new BlogEntity();
            e.setBlogId(blog.getBlogId());
            e.setBlogtitle(blog.getBlogtitle());
            e.setBlogbody(blog.getBlogbody());
            e.setPublishby(blog.getPublishby());
            e.setIsdeleted("N");
            e.setCreatedon(new Timestamp(System.currentTimeMillis()));
            Optional<UserEntity> user = userRepository.findById(blog.getUserBlogId());
            if (user.isPresent()) {
                e.setUserEntity(user.get());
            }
            blogRepository.save(e);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new ErrorHandler();
        }
    }
//    @Override
//    public ResponseEntity<Void> BlogPost(Blog blog) {
//        Optional<UserEntity> user1 = userRepository.findById(blog.getUserBlogId());
//        if (user1.isPresent()) {
//            BlogEntity blogEntity = new BlogEntity(blog.getBlogtitle(), blog.getBlogbody(), "N", new Timestamp(System.currentTimeMillis()));
//            Optional<UserEntity> user = userRepository.findById(blog.getUserBlogId());
//            blogEntity.setPublishby(user.get().getFirstName() + user.get().getLastName());
//            blogEntity.setUserEntity(user.get());
//            blogRepository.save(blogEntity);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else throw new ErrorHandler("Data not found",400);
//    }

}
