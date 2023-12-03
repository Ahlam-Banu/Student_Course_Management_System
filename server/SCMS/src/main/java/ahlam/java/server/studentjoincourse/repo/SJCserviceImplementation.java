package ahlam.java.server.studentjoincourse.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahlam.java.server.course.entity.Courses;
import ahlam.java.server.student.entity.Students;
import ahlam.java.server.studentjoincourse.entity.SJCid;
import ahlam.java.server.studentjoincourse.entity.StudentJoinCourse;
import ahlam.java.server.studentjoincourse.repo.StudentJoinCourseRepository;

@Service
public class SJCserviceImplementation implements SJCservice{

    @Autowired
    private StudentJoinCourseRepository enrollmentRepository;

    @Override
    public List<StudentJoinCourse> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public StudentJoinCourse getEnrollmentByStudentAndCourse(Students student, Courses course) {
        SJCid sjcId = new SJCid(student, course);
        return enrollmentRepository.findById(sjcId).orElse(null);
    }

    @Override
    public void enrollStudentInCourse(Students student, Courses course) {
    	StudentJoinCourse enrollment = new StudentJoinCourse(student, course);
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void withdrawStudentFromCourse(Students student, Courses course) {
    	SJCid sjcId = new SJCid(student, course);
        enrollmentRepository.deleteById(sjcId);
    }
}