package ahlam.java.server.student.repo;

import java.util.List;

import ahlam.java.server.student.entity.Students;

public interface StudentService {
    List<Students> getAllStudents();
    Students getStudentById(Long id);
    void addStudent(Students student);
    void updateStudent(Long id, Students student);
    void deleteStudent(Long id);
}
