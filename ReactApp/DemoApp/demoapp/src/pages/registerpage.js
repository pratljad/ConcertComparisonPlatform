import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../styles/registerstyle.css';
import '../styles/footerstyle.css';
import '../styles/style.css';

import NavBar from '../components/navbar.js';
import RegisterComponent from '../components/register.js';
import Footer from '../components/footer';

export default class RegisterPage extends React.Component {
    render() {
      return (
        <div>
          <NavBar />
          <RegisterComponent />
          <Footer />
        </div>
    );
  }
}
