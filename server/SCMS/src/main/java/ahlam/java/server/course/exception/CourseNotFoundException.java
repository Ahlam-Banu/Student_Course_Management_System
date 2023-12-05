package ahlam.java.server.course.exception;

public class CourseNotFoundException extends RuntimeException{
	private static final long serialVersionID = 1L;
	public CourseNotFoundException(int id) {
		super("Course not found: " + id);
	}

}
