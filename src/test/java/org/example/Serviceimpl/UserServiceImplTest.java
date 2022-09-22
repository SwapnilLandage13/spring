package org.example.Serviceimpl;

import com.spring.services.model.User;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @InjectMocks
    private BlogServiceImpl blogService;

    @Mock
    BlogRepository blogRepository;

    @Mock
    UserRepository userRepository;

    private BlogEntity blog1;
    private BlogEntity blog2;

    private UserEntity user1;

    private UserEntity user2;

    public UserServiceImplTest() {

    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user1 = new UserEntity();
        user2 = new UserEntity();
        blog1 = new BlogEntity(1,"ncp","congress","gandhi","N",user1);
        blog2 = new BlogEntity(2,"aap","aam adami party","kejriwal","N",user1);

    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void usersGetAllUsersGetTest() {
//        List<UserEntity> userList = new ArrayList<UserEntity>();
//        userList.add(user1);
//        userList.add(user2);
//        when(userRepository.findAll()).thenReturn(userList);
//        ResponseEntity<List<User>> user = userService.getallusers();
//        assertNotNull(user);
//    }

    @Test
    void postusers() {
        User user = new User();
        user.setUserId(user1.getUserId());
        user.setFirstName("Swapnil");
        user.setLastName("Landage");
        user.setEmail("Swapnil@gmail.com");
        user.setCity("Sangli");
        user.setIsDeleted("N");
      //  when(userRepository.findById(1)).thenReturn(Optional.of((new UserEntity())));
        ResponseEntity<Void> Output = userService.postUser(user);
        assertNotNull(Output);

    }


//    @Test
//    void getUserByIdTest() {
//        when(userRepository.findById(1)).thenReturn(Optional.of(new UserEntity()));
//        ResponseEntity<User> userResponse = userService.getUserByIdGet(1);
//        org.assertj.core.api.Assertions.assertThat(userResponse).isNotNull();
//        assertThat(userService.getUserByIdGet(1)).isNotNull();
//    }

    @Test
    void deleteByidTest() {
        when(userRepository.findById(1)).thenReturn(Optional.of(new UserEntity()));
        List<BlogEntity> blogs = new ArrayList<>();
        blogs.add(blog1);
        blogs.add(blog2);
        when(blogRepository.findAll()).thenReturn(blogs);
        ResponseEntity<Void> output = userService.deleteById(1);
        assertNotNull(output);
    }

//
//        @Test
//    void usersUpdate() {
//        User user = new User();
//        user.setUserId(user1.getUserId());
//        user.setFirstName("Swapnil");
//        user.setLastName("Landage");
//        user.setEmail("Swapnil@gmail.com");
//        user.setCity("Sangli");
//        user.setIsDeleted("N");
//        when(userRepository.findById(1)).thenReturn(Optional.of((new UserEntity())));
//        ResponseEntity<Void> Output = userService.updateUser(user);
//        assertNotNull(Output);
//
//    }
    @Test
    void getEleByIdUserNotPresentTest(){
        when(userRepository.findById(4)).thenThrow(new ErrorHandler());
        assertThrows(ErrorHandler.class,()-> userService.getUserByIdGet(4));
    }

//    @Test
//    void getAllUserNullUserTest(){
//        List<UserEntity> userList=new ArrayList<UserEntity>();
//        userList.add(user1);
//        userList.add(user2);
//        when(userRepository.findAll()).thenReturn(userList);
//        ResponseEntity<List<User>> user = userService.getallusers();
//        assertNotNull(user.getBody().size());
//        assertNotNull(user);
//        assertEquals("null",user.getBody().get(1).getFirstName());
//        assertEquals(3,user.getBody().get(1).getUserId());
//
//    }

//    @Test
//    void deleteisnotpresent(){
//        when(blogRepository.findAll()).thenThrow(ErrorHandler.class);
//        assertThrows(ErrorHandler.class,()-> userService.deleteById(3));
//    }

    @Test
    void updateNonExistingUser(){
        User user = new User();
        user.setUserId(user1.getUserId());
        user.setFirstName("Swapnil");
        user.setLastName("landage");
        user.setEmail("swapnil@gmail.com");
        user.setCity("sangli");
        when(userRepository.findById(1)).thenThrow(ErrorHandler.class);
        assertThrows(ErrorHandler.class,()->userService.updateUser(user),"user is not present to update");

    }

}

