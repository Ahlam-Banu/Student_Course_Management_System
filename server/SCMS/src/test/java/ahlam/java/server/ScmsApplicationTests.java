package ahlam.java.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScmsApplicationTests {

    @Test
    void contextLoads() {
    }
/*
    @Test
    void testCreate() {
        Students s = new Students(7, "Hanna", "Jung", "hnj@gmail.com");
        studentRepository.save(s);
    }

    @Test
    void testRead() {
        Students s = studentRepository.findById(1).orElse(null);
        assertThat(s).isNotNull();
        assertThat(s.getFirstname()).isEqualTo("Ahmed");
    }

    @Test
    void testUpdate() {
        Students s = studentRepository.findById(1).orElse(null);
        assertThat(s).isNotNull();
        s.setEmail("ahmedanwar@gmail.com");
        studentRepository.save(s);
    }*/
/*
   @Test
    void testCreateCourse() {
        Courses c = new Courses(4, "CS", "John");
        assertThat(c).isNotNull();
        courseRepository.save(c);
    }

    @Test
    void testReadCourse() {
        Courses c = courseRepository.findById(4).orElse(null);
        assertThat(c).isNotNull();
        assertThat(c.getName()).isEqualTo("English");
    }

    @Test
    void testUpdateCourse() {
        Courses c = courseRepository.findById(4).orElse(null);
        assertThat(c).isNotNull();
        c.setTeacherName("Daniel");
        courseRepository.save(c);
    }*/
}
