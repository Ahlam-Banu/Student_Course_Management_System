import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './login.css';
import { loginUser } from '../../API/api';

const Login: React.FC = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async () => {
    const data = [username,password]
    await loginUser(data)
    setUsername('')
    setPassword('')
    navigate("/students")
  };

  return (
    <div className="container">
      <div className="screen">
        <div className="screen__content">
          <form className="login">
            <div className="login__field">
              <label>
                Username
                <input
                  type="text"
                  className="login__input"
                  placeholder="username"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                />
              </label>
            </div>
            <div className="login__field">
              <label>
                Password
                <input
                  type="password"
                  className="login__input"
                  placeholder="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
              </label>
            </div>
            <button type="button" onClick={handleLogin} className="button login__submit">
              <span className="button__text">LOG IN</span>
              <i className="button__icon fas fa-chevron-right"></i>
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;