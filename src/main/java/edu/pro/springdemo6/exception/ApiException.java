package edu.pro.springdemo6.exception;
/*
  @author   george
  @project   spring-demo6
  @class  ApiException
  @version  1.0.0 
  @since 07.09.22 - 20.33
*/

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public ApiException(String message,
                        Throwable throwable,
                        HttpStatus httpStatus,
                        ZonedDateTime timestamp) {

        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "message='" + message + '\'' +
                ", throwable=" + throwable +
                ", httpStatus=" + httpStatus +
                ", timestamp=" + timestamp +
                '}';
    }
}
