import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import Students from './Components/Students/students';
import Courses from './Components/Courses/courses';
import Header from './Components/Header/header';
import Footer from './Components/Footer/footer';
import Login from './Components/Authorization/login';

const App: React.FC = () => {
  // const location = useLocation();
  return (
    <div className="App">
      <Router>
        <Header />
        <main className="main-content">
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/students" element={<Students />} />
          <Route path="/courses" element={<Courses />} />
        </Routes>        </main>
        <Footer />
      </Router>
    </div>
  );
};

export default App;
