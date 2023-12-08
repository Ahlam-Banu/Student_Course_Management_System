// header.tsx
import { text } from 'stream/consumers';
import './header.css';

const Header = () => {
  return (
    <header className="header">
      <div className="navbar">
      <h1>Student Course Management System</h1>
        <nav>
          <ul className="nav-links">
            <li><a href="/login">Login</a></li>
            <li><a href="/students">Students</a></li>
            <li><a href="/courses">Courses</a></li>
            {/* Add other links */}
          </ul>
        </nav>
      </div>
    </header>
  );
};

export default Header;
