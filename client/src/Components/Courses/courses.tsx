import React, { useState, useEffect } from 'react';
import './courses.css';


const Courses: React.FC = () => {
  const [courses, setCourses] = useState([]);

  // Fetch list of courses
  useEffect(() => {
    fetch('/api/courses') // Replace with your API endpoint
      .then(response => response.json())
      .then(data => setCourses(data))
      .catch(error => console.error('Error fetching courses', error));
  }, []);

  return (
    <div>
      <h2>Courses</h2>
      {/* Display courses list */}
      <ul>
        {courses.map((course: any) => (
          <li key={course.id}>{course.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default Courses;
