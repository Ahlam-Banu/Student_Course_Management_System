package ahlam.java.server.studentjoincourse.entity;

import ahlam.java.server.course.entity.Courses;
import ahlam.java.server.student.entity.Students;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_join_course")
@IdClass(SJCid.class)
public class StudentJoinCourse {

    @Id
    @ManyToOne
    @JoinColumn(name = "studentid")
    private Students student;

    @Id
    @ManyToOne
    @JoinColumn(name = "courseid")
    private Courses course;

    // Constructors

    public StudentJoinCourse() {
    }

    public StudentJoinCourse(Students student, Courses course) {
        this.student = student;
        this.course = course;
    }

    // Getters and setters

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }
}