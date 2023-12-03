package ahlam.java.server.student.exception;

public class StudentNotFoundException extends RuntimeException{
	
	private static final long serialVersionID = 1L;
	public StudentNotFoundException(int id) {
		super("Student not found: " + id);
	}

}
