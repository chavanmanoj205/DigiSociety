package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.dto.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(ResouceNotFoundException.class)
	public @ResponseBody ExceptionResponse handlingExaception(ResouceNotFoundException exception,HttpServletRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMsg(exception.getMessage());
		exceptionResponse.setUrl(request.getRequestURI());
		return exceptionResponse;
	}
	
	@ExceptionHandler(EmployeeNotFound.class)
	public @ResponseBody ExceptionResponse handleEmployeenotFound(EmployeeNotFound exception,HttpServletRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMsg(exception.getMessage());
		exceptionResponse.setUrl(request.getRequestURI());
		return exceptionResponse;
	}
	
	 @ExceptionHandler(value = {DocUploadException.class})
	    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	    public ResponseEntity<ExceptionResponse> reportingDashboardException(DocUploadException e,HttpServletRequest request) {
	        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;
	        ExceptionResponse exceptionResponse = new ExceptionResponse();
			exceptionResponse.setMsg(e.getMessage());
			exceptionResponse.setUrl(request.getRequestURI());
	        return ResponseEntity.status(internalServerError).body(exceptionResponse);
	    }
}
