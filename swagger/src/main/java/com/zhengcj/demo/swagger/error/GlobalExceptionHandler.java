package com.zhengcj.demo.swagger.error;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
            return errorList.stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(";"));
        } else if (e instanceof HttpMessageNotReadableException) {
            return getParamErrorMessage(e);
        } else {
            e.printStackTrace();
            return "default error message";
        }
    }

    private static String getParamErrorMessage(Exception e) {
        String message = e.getMessage();
        Throwable throwable = e.getCause();
        if (throwable instanceof MismatchedInputException) {
            int start = message.lastIndexOf("[") + 2;
            int end = message.lastIndexOf("]") - 2;
            if (start >= 0 && start < end + 1 && end + 1 < message.length()) {
                String paramKey = message.substring(start, end + 1);
                return "param error: " + paramKey;
            }
        }
        return message;
    }

}
