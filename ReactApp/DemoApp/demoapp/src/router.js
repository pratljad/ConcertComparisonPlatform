import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import LoginPage from './pages/loginpage.js';
import RegisterPage from './pages/registerpage.js';
import StartingPage from './pages/startingpage.js';

export default class App extends React.Component {
  render() {
    return (
      <BrowserRouter>
        <div>
          <Route path="/" component={StartingPage} exact />
          <Route path="/login" component={LoginPage} />
          <Route path="/register" component={RegisterPage} />
        </div>
      </BrowserRouter>
    );
  }
}
