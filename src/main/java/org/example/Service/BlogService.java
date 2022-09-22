package org.example.Service;

import com.spring.services.model.Blog;
import com.spring.services.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogService {

    public ResponseEntity<Void> BlogPost(Blog blog);

    public ResponseEntity<Void> deleteBlogById(Integer blogId);

    public ResponseEntity<List<Blog>> BlogGetAll();

    public ResponseEntity<Blog> blogsGetBlogById(Integer blogId);

//    public ResponseEntity<Void> UpdateBlog(Integer blogId, Blog blog);
    public ResponseEntity<Void> updateBlog(Blog blog);
    public ResponseEntity<List<Blog>> getAllBlogByUserId(Integer userId);
}
