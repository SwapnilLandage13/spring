package org.example.Controller;

import com.spring.services.api.BlogsApi;
import com.spring.services.model.Blog;
import com.spring.services.model.User;
import org.example.Exception.ErrorHandler;
import org.example.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BlogController implements BlogsApi {

    @Autowired
    BlogService blogService;

    @Override
   public ResponseEntity<Void> blogsAddBlogPost(Blog blog)
    {
        try {
            return blogService.BlogPost(blog);
        }catch (ErrorHandler errorHandler){
            throw new ErrorHandler();
        }
    }
    @Override
    public ResponseEntity<Void> blogsDeleteByIdDelete(Integer blogId)
    {
        try {
            return blogService.deleteBlogById(blogId);
        }catch (ErrorHandler errorHandler){
            throw new ErrorHandler();
        }
    }
    @Override
   public ResponseEntity<List<Blog>> blogsGet()
    {
        try {
            return blogService.BlogGetAll();
        }catch (ErrorHandler errorHandler){
            throw new ErrorHandler();
        }
    }
    @Override
   public ResponseEntity<Blog> blogsGetBlogByIdGet(Integer blogId)
    {
        try {
            return blogService.blogsGetBlogById(blogId);
        }catch (ErrorHandler errorHandler){
            throw new ErrorHandler();
        }
    }
//    @Override
//    public ResponseEntity<Void> blogsUpdateBlogByIdPut(Integer blogId, Blog blog)
//    {
//        try {
//            return blogService.UpdateBlog(blogId, blog);
//        }catch (ErrorHandler errorHandler){
//            throw new ErrorHandler();
//        }
//    }
    @Override
    public ResponseEntity<Void> blogsUpdateBlogPut(Blog blog){
        return blogService.updateBlog(blog);
    }
    @Override
    public ResponseEntity<List<Blog>> blogsGetAllBlogByUserIdGet(Integer userId){
        try {
            return blogService.getAllBlogByUserId(userId);
        }catch(Exception e){
            throw new ErrorHandler();
        }
    }
}
