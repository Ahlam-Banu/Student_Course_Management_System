import React, { useEffect, useState } from 'react';
import { fetchStudents, deleteStudent } from '../../API/api';
import './students.css';

const Students: React.FC = () => {
  const [students, setStudents] = useState<any[]>([]);
  const [searchTerm, setSearchTerm] = useState<string>('');

  useEffect(() => {
    fetchAllStudents();     // Fetch all students when the component mounts
  }, []);

  const fetchAllStudents = async () => {
    try {
      const data = await fetchStudents();
      setStudents(data);
    } catch (error) {
      console.error('Error fetching students:', error);
    }
  };

  const handleDeleteStudent = async (studentID: number) => {
    try {
      await deleteStudent(studentID);
      await fetchAllStudents();       // After successful deletion, fetch the updated list of students
    } catch (error) {
      console.error('Error deleting student:', error);
    }
  };

  const filteredStudents = students.filter((student) =>
    student.studentID.toString().includes(searchTerm)
  );

  return (
    <div>
      <h1 style={{ textAlign: 'center', fontFamily:'serif' }}>STUDENTS</h1>
      <div style={{ textAlign: 'center', margin: '20px 0' }}>
        <input
          type="text"
          placeholder="Search by ID"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          style={{ fontSize: '1rem', padding: '10px', width: '900px'}}
        />
      </div>
      <div className="students-container">
        {filteredStudents.map((student) => (
          <div key={student.studentID} className="student-card">
            <div className="student-image-container">
              <img
                src={student.imageUrl || 'https://picsum.photos/id/447/1280/853.jpg'}
                alt={`${student.firstName} ${student.lastName}`}
                className="student-image"
              />
            </div>
            <p>
              <strong>Id:</strong> {student.studentID}
            </p>
            <p>
              <strong>Name:</strong> {student.firstname} {student.lastname}
            </p>
            <p>
              <strong>Email:</strong> {student.email}
            </p>

            <button className="delete-button" onClick={() => handleDeleteStudent(student.studentID)}>Delete</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Students;