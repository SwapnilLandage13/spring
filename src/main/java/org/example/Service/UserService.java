package org.example.Service;

import com.spring.services.model.User;
import org.example.Entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

 public   ResponseEntity<Void> postUser(User user);
//public ResponseEntity<Void> postusers(User user);
 public ResponseEntity<List<User>> getallusers();

 public ResponseEntity<User> getUserByIdGet(Integer userId);

 public ResponseEntity<Void> deleteById(Integer userId);
 public ResponseEntity<Void> updateUser(User user);

// public ResponseEntity<Void> UpdateUser(Integer userId, User user);
 public UserEntity findUserByEmail(String email);
}