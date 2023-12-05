package ahlam.java.server.studentjoincourse.repo;

import java.util.List;

import ahlam.java.server.course.entity.Courses;
import ahlam.java.server.student.entity.Students;
import ahlam.java.server.studentjoincourse.entity.StudentJoinCourse;

public interface SJCservice {
	List<StudentJoinCourse> getAllEnrollments();
	StudentJoinCourse getEnrollmentByStudentAndCourse(Students student, Courses course);
    void enrollStudentInCourse(Students student, Courses course);
    void withdrawStudentFromCourse(Students student, Courses course);

}
