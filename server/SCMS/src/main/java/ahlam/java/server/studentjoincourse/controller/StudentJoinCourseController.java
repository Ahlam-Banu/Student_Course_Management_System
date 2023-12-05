package ahlam.java.server.studentjoincourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ahlam.java.server.course.entity.Courses;
import ahlam.java.server.course.repo.CourseService;
import ahlam.java.server.student.entity.Students;
import ahlam.java.server.student.repo.StudentService;
import ahlam.java.server.studentjoincourse.entity.StudentJoinCourse;
import ahlam.java.server.studentjoincourse.repo.SJCservice;

@RestController
@RequestMapping("/api/enrollments")
public class StudentJoinCourseController {

    @Autowired
    private SJCservice sjcService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private CourseService courseService;
    
    @GetMapping
    public List<StudentJoinCourse> getAllStudentJoinCourse() {
        return sjcService.getAllEnrollments();
    }

    @GetMapping("/students/{studentId}/courses/{courseId}")
    public StudentJoinCourse getEnrollmentByStudentAndCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {
        // Assuming you have methods to retrieve Student and Course by their IDs
        Students student = getStudentById(studentId);
        Courses course = getCourseById(courseId);
        return sjcService.getEnrollmentByStudentAndCourse(student, course);
    }

    @PostMapping("/enroll")
    public void enrollStudentInCourse(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {
        // Assuming you have methods to retrieve Student and Course by their IDs
        Students student = getStudentById(studentId);
        Courses course = getCourseById(courseId);
        sjcService.enrollStudentInCourse(student, course);
    }

    @PostMapping("/withdraw")
    public void withdrawStudentFromCourse(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {
        // Assuming you have methods to retrieve Student and Course by their IDs
        Students student = getStudentById(studentId);
        Courses course = getCourseById(courseId);
        sjcService.withdrawStudentFromCourse(student, course);
    }

    // You should have methods to retrieve Student and Course by their IDs
    private Students getStudentById(Long studentId) {
        // Implement the logic to retrieve a Student by ID
         return studentService.getStudentById(studentId);
    }

    private Courses getCourseById(Long courseId) {
        // Implement the logic to retrieve a Course by ID
    	return courseService.getCourseById(courseId);
    }
}