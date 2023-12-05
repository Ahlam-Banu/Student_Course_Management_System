package ahlam.java.server.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ahlam.java.server.course.entity.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long>{

}
