package ahlam.java.server.student.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ahlam.java.server.student.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String studentNotFoundHandler(StudentNotFoundException e) {
		return e.getMessage();
	}
}
