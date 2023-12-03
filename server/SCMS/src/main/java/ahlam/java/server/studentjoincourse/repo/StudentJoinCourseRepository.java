package ahlam.java.server.studentjoincourse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ahlam.java.server.studentjoincourse.entity.StudentJoinCourse;

public interface StudentJoinCourseRepository extends JpaRepository<StudentJoinCourse, Object> {
    // Custom methods if needed
}
