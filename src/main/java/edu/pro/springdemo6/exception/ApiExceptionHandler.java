package edu.pro.springdemo6.exception;
/*
  @author   george
  @project   spring-demo6
  @class  ApiExceptionHandler
  @version  1.0.0 
  @since 07.09.22 - 20.30
*/

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        final ApiException apiException = new ApiException(e.getMessage(),
                e,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }
}
