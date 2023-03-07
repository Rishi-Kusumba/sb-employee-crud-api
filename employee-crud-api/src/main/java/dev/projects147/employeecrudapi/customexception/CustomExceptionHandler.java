package dev.projects147.employeecrudapi.customexception;

import dev.projects147.employeecrudapi.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private CustomErrorResponse employeeNotFoundExceptionHandler(EmployeeNotFoundException exception) {
        return new CustomErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private CustomErrorResponse genericExceptionHandler(RuntimeException exception) {
        return new CustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

}
