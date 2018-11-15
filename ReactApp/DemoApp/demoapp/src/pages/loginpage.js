import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../styles/loginstyle.css';
import '../styles/footerstyle.css';
import '../styles/style.css';

import NavBar from '../components/navbar.js';
import LoginComponent from '../components/login.js';
import Footer from '../components/footer.js';

export default class LoginPage extends React.Component {
    render() {
      return (
        <div>
          <NavBar />
          <LoginComponent />
          <Footer />
        </div>
    );
  }
}

