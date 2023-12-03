package ahlam.java.server.course.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ahlam.java.server.course.exception.CourseNotFoundException;

@ControllerAdvice
public class CourseNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(CourseNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String coursetNotFoundHandler(CourseNotFoundException e) {
		return e.getMessage();
	}
}
