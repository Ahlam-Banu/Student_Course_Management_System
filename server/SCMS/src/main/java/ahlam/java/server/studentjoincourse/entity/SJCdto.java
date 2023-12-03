package ahlam.java.server.studentjoincourse.entity;

import java.util.List;

public class SJCdto {
	private Long courseId;
    private List<Long> studentIds;
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public List<Long> getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(List<Long> studentIds) {
		this.studentIds = studentIds;
	}
}