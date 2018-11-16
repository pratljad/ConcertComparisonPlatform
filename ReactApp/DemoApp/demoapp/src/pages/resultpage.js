import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

import NavBar from '../components/navbar.js';
import Footer from '../components/footer.js';
import Results from '../components/results.js';

export default class ResultPage extends React.Component {
    render() {
      return (
        <div>
          <NavBar />
          <Results />
          <Footer />
        </div>
    );
  }
}

