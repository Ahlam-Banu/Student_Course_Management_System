package ahlam.java.server.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;
    private String name;
    //@Column(name = "teacherName")
    private String teacherName;

 // Default constructor
    public Courses() {}
    public Courses(String name, String teacherName) {
        this.name = name;
        this.teacherName = teacherName;
    }

    // Getters and setters
    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
