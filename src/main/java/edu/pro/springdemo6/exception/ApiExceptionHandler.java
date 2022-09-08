package edu.pro.springdemo6.exception;
/*
  @author   george
  @project   spring-demo6
  @class  ApiExceptionHandler
  @version  1.0.0 
  @since 08.09.22 - 12.01
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

        ApiException apiException = new ApiException(
                e.getMessage(),
               e,
               HttpStatus.NOT_FOUND,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
}
