package com.edurumluemrullah.northwind_backend.common.aspects.controlleradvices;

import com.edurumluemrullah.northwind_backend.common.exceptions.*;
import com.edurumluemrullah.northwind_backend.common.results.ErrorDataResult;
import com.edurumluemrullah.northwind_backend.common.results.ErrorResult;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    Map<String,String> errors = new HashMap<>();

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage()+ ". ";
            errors.put(fieldName,message);

        });

        return ResponseEntity.badRequest().body(new ErrorDataResult<>("Validation error!",errors));
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok( new ErrorResult("Entered query parameters not valid"));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult("Method not supported."));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(new ErrorResult("query param missing"));
    }


    @ExceptionHandler(VerificationCodeNotFoundException.class)
    protected ResponseEntity<Object> verificationCodeNotFoundExceptionHandler(WebRequest request,VerificationCodeNotFoundException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(NoAttemptException.class)
    protected ResponseEntity<Object> noAttemptExceptionHandler(WebRequest request,NoAttemptException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(VerificationCodeExpiredException.class)
    protected ResponseEntity<Object> verificationCodeExpiredExceptionHandler(WebRequest request,VerificationCodeExpiredException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(WrongVerifcationCodeException.class)
    protected ResponseEntity<Object> wrongVerifcationCodeExceptionHandler(WebRequest request,WrongVerifcationCodeException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> userNotFoundExceptionHandler(WebRequest request,UserNotFoundException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(LoginException.class)
    protected ResponseEntity<Object> loginExceptionHandler(WebRequest request,LoginException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(EmailNotValidatedException.class)
    protected ResponseEntity<Object> emailNotValidatedExceptionHandler(WebRequest request,EmailNotValidatedException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    protected ResponseEntity<Object> userAlreadyExistExceptionHandler(WebRequest request,UserAlreadyExistException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    protected ResponseEntity<Object> emailAlreadyExistExceptionHandler(WebRequest request,EmailAlreadyExistException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(EmailNotFoundException.class)
    protected ResponseEntity<Object> emailNotFoundExceptionHandler(WebRequest request,EmailNotFoundException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }

    @ExceptionHandler(MailException.class)
    protected ResponseEntity<Object> mailExceptionHandler(WebRequest request,MailException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }


    @ExceptionHandler(AlreadyHaveVerificationCodeException.class)
    protected ResponseEntity<Object> AlreadyHaveVerificationCodeExceptionHandler(WebRequest request,AlreadyHaveVerificationCodeException exception){
        return ResponseEntity.badRequest().body(new ErrorResult(exception.getMessage()));
    }
}
