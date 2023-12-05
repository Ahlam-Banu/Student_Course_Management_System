package ahlam.java.server.studentjoincourse.exception;

public class EnrollmentNotFoundException extends RuntimeException{
	private static final long serialVersionID = 1L;
	public EnrollmentNotFoundException(int id) {
		super("Enrollment not found: " + id);
	}

}
