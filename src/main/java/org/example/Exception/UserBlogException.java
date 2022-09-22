package org.example.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserBlogException {

    @ExceptionHandler(value = ErrorHandler.class)
    public ResponseEntity<Object> exception(ErrorHandler errorHandler)
    {
        return new ResponseEntity<>("Data Not found", HttpStatus.NOT_FOUND);
    }


}
