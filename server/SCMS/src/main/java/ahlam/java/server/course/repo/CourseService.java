package ahlam.java.server.course.repo;

import java.util.List;

import ahlam.java.server.course.entity.Courses;
import ahlam.java.server.student.entity.Students;

public interface CourseService {
    List<Courses> getAllCourses();
    List<Students> getStudentsEnrolledInCourse(Long courseId);
    Courses getCourseById(Long id);
    void addCourse(Courses course);
    void updateCourse(Long id, Courses course);
    void deleteCourse(Long id);
}