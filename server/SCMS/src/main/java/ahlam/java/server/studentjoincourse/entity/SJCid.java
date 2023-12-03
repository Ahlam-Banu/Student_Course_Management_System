package ahlam.java.server.studentjoincourse.entity;

import java.io.Serializable;
import java.util.Objects;

import ahlam.java.server.course.entity.Courses;
import ahlam.java.server.student.entity.Students;

public class SJCid implements Serializable{
	private static final long serialVersionUID = 1L;

    private Long student;
    private Long course;

    // Constructors

    public SJCid() {
    }

    public SJCid(Students student, Courses course) {
        this.student = student.getStudentID();
        this.course = course.getCourseID();
    }

    // Equals and hashCode

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SJCid that = (SJCid) obj;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }

}
