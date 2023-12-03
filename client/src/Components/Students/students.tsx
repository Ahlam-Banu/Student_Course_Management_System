import React, { useState, useEffect } from 'react';
import './students.css';


const Students: React.FC = () => {
  const [students, setStudents] = useState([]);
  const [searchId, setSearchId] = useState('');
  
  // Fetch list of students
  useEffect(() => {
    fetch('/api/students') // Replace with your API endpoint
      .then(response => response.json())
      .then(data => setStudents(data))
      .catch(error => console.error('Error fetching students', error));
  }, []);

  // Function to handle search by ID
  const handleSearch = () => {
    // Make API call with searchId
    // Fetch students by ID
    // Update 'students' state with the search result
  };

  return (
    <div>
      <h2>Students</h2>
      <input
        type="text"
        placeholder="Search by ID"
        value={searchId}
        onChange={(e) => setSearchId(e.target.value)}
      />
      <button onClick={handleSearch}>Search</button>
      {/* Display students list */}
      <ul>
        {students.map((student: any) => (
          <li key={student.id}>{student.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default Students;
