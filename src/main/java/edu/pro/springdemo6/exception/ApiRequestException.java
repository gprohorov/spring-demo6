package edu.pro.springdemo6.exception;
/*
  @author   george
  @project   spring-demo6
  @class  ApiRequestException
  @version  1.0.0 
  @since 08.09.22 - 11.55
*/

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message){
        super(message);
    }

    public ApiRequestException(String message, Throwable cause){
        super(message, cause);
    }


}
