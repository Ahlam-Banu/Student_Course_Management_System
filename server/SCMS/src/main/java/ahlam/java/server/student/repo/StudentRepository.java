package ahlam.java.server.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ahlam.java.server.student.entity.Students;

public interface StudentRepository extends JpaRepository<Students, Long> {
}
