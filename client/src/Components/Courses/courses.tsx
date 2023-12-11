import React, { useEffect, useState } from 'react';
import { fetchCourses, fetchEnrollments } from '../../API/api';
import './courses.css'; 

const Courses: React.FC = () => {
  const [courses, setCourses] = useState<any[]>([]);
  const [searchId, setSearchId] = useState<string>('');
  const [showModal, setShowModal] = useState<boolean>(false);
  const [enrolledStudents, setEnrolledStudents] = useState<any[]>([]);

  useEffect(() => {
    // Fetch all courses when the component mounts
    fetchAllCourses();
  }, [searchId]);

  const fetchAllCourses = async () => {
    try {
      const data = await fetchCourses();
      //console.log('Fetched Courses:', data); // Log the fetched data for verification

      // If searchId is empty, show all courses; otherwise, filter by course ID
      const filteredCourses = searchId
        ? data.filter((course: { courseID: { toString: () => string | string[]; }; }) => course.courseID.toString().includes(searchId))
        : data;

      setCourses(filteredCourses);
    } catch (error) {
      console.error('Error fetching courses:', error);
    }
  };

  const handleShowEnrolledStudents = async (id: number) => {
    try {
      const enrolledStudentsData = await fetchEnrollments(id);
      //console.log(`Enrolled Students in Course ${id}:`, enrolledStudentsData);

      var data = enrolledStudentsData.filter((entry: { course: { courseID: number; }; }) => entry.course.courseID === id).map((entry: { student: any; }) => entry.student);
      console.log(`Enrolled Students in Course ${id}:`, data);
      
      setEnrolledStudents(data);
      setShowModal(true);
    } catch (error) {
      console.error('Error fetching enrolled students:', error);
    }
  };

  const handleCloseModal = () => {
    setShowModal(false);
  };

  return (
    <div>
      <h1 className="h1">Courses List</h1>
      <div className="search-bar">
        <input
          type="text"
          placeholder="Search by course ID"
          value={searchId}
          onChange={(e) => setSearchId(e.target.value)}
        />
      </div>
      <div className="courses-container">
        {courses.map((course) => (
          <div key={course.courseID} className="course-card">
            <p>
              <strong>Id:</strong> {course.courseID}
            </p>
            <p>
              <strong>Name:</strong> {course.name}
            </p>
            <p>
              <strong>Teacher:</strong> {course.teacherName}
            </p>
            <button className="more-button" onClick={() => handleShowEnrolledStudents(course.courseID)}>
              More
            </button>
          </div>
        ))}
      </div>

      {showModal && (
  <div className="modal">
    <div className="modal-content">
      <span className="close" onClick={handleCloseModal}>
        &times;
      </span>
      <h3>Enrolled Students</h3>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {enrolledStudents.map((student) => (
            <tr key={student.studentID}>
              <td>{student.studentID}</td>
              <td>{student.firstname}</td>
              <td>{student.lastname}</td>
              <td>{student.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  </div>
)}
    </div>
  );
};

export default Courses;