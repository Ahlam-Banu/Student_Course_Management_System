package ahlam.java.server.student.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahlam.java.server.student.entity.Students;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Students getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void addStudent(Students student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, Students student) {
        if (studentRepository.existsById(id)) {
            student.setStudentID(id);
            studentRepository.save(student);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}