package ahlam.java.server.course.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahlam.java.server.course.entity.Courses;
import ahlam.java.server.student.entity.Students;

@Service
public class CourseServiceImplementation implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void addCourse(Courses course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Long id, Courses course) {
        if (courseRepository.existsById(id)) {
            course.setCourseID(id);
            courseRepository.save(course);
        }
    }
    

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

	@Override
	public List<Students> getStudentsEnrolledInCourse(Long courseId) {
		// TODO Auto-generated method stub
		return null;
	}
}