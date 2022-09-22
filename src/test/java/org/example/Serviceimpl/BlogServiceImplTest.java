package org.example.Serviceimpl;

import com.spring.services.model.Blog;
import org.example.Entity.BlogEntity;
import org.example.Entity.UserEntity;
import org.example.Exception.ErrorHandler;
import org.example.Repository.BlogRepository;
import org.example.Repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class BlogServiceImplTest{
        @InjectMocks
        private BlogServiceImpl blogService;

        @Mock
        BlogRepository blogRepository;

        @Mock
        UserRepository userRepository;

        private BlogEntity blog1;
        private BlogEntity blog2;
        private UserEntity user1;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
            user1 = new UserEntity();
            blog1 = new BlogEntity(1,"ncp","congress","gandhi","N",user1);
            blog2 = new BlogEntity(2,"aap","aam adami party","kejriwal","N",user1);

        }

        @AfterEach
        void tearDown() {
        }
    @Test
    void blogsGetTset() {
        List<BlogEntity> blogEntities = new ArrayList<BlogEntity>();
        blogEntities.add(blog1);
        blogEntities.add(blog2);
        when(blogRepository.findAll()).thenReturn(blogEntities);
        ResponseEntity<List<Blog>> blog = blogService.BlogGetAll();
        assertNotNull(blog);
    }


    @Test
    void deleteBlogById()
    {
            when(blogRepository.findById(1)).thenReturn(Optional.of(new BlogEntity(1,"ncp","congress","gandhi","N",user1)));
            List<BlogEntity> blogEntities= new ArrayList<>();
            blogEntities.add(blog1);
    }
    @Test
    void addBlogDetailsTest() {
        Blog blog =new Blog();
        blog.setBlogId(blog1.getBlogId());
        blog.setBlogbody(blog1.getBlogbody());
        blog.setBlogtitle(blog1.getBlogtitle());
        blog.setIsdeleted(blog1.getIsdeleted());
        blog.setPublishby(user1.getFirstName()+user1.getLastName());
        blog.setUserBlogId(blog1.getUserEntity().getUserId());
        when(userRepository.findById(blog1.getUserEntity().getUserId())).thenReturn(Optional.of(new UserEntity()));
        ResponseEntity<Void> output = blogService.BlogPost(blog);
        assertNotNull(output);
    }


    @Test
    void postBlogTest() {
        Blog blog = new Blog();
        blog.setUserBlogId(blog1.getBlogId());
        blog.setBlogtitle(blog1.getBlogtitle());
        blog.setBlogbody(blog1.getBlogbody());
        blog.setUserBlogId(blog1.getUserEntity().getUserId());
        blog.setPublishby(blog1.getPublishby());
        blog.setIsdeleted(blog1.getIsdeleted());
        when(userRepository.findById(blog1.getUserEntity().getUserId())).thenReturn(Optional.of((new UserEntity())));
        //when(userRepository.findById(blog1.getBlogId())).thenThrow(new ErrorHandler());
        ResponseEntity<Void> output = blogService.BlogPost(blog);
        assertNotNull(output);
    }

//    @Test
//    void postBlogOfAbsentUser() {
//        Blog blog = new Blog();
//        blog.setUserBlogId(blog1.getBlogId());
//        blog.setBlogtitle(blog1.getBlogtitle());
//        blog.setBlogbody(blog1.getBlogbody());
//        blog.setUserBlogId(blog1.getUserEntity().getUserId());
//        blog.setPublishby(blog1.getPublishby());
//        blog.setIsdeleted(blog1.getIsdeleted());
//        when(userRepository.findById(1)).thenThrow(new ErrorHandler());
//
//        assertThrows(ErrorHandler.class,()->blogService.BlogPost(blog));
//    }

    @Test
    void deleteNotExistBlogById() {
        when(blogRepository.findById(1)).thenThrow(new ErrorHandler());
        assertThrows(ErrorHandler.class,()->blogService.deleteBlogById(10));
    }

    @Test
    void getNotExistBlogById() {
        when(blogRepository.findById(10)).thenThrow(new ErrorHandler());
        assertThrows(ErrorHandler.class,()->blogService.blogsGetBlogById(10));
    }
}
