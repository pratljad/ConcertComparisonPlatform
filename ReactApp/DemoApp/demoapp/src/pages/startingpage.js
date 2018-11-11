import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../styles/loginstyle.css';
import '../styles/footerstyle.css';
import '../styles/style.css';

import NavBar from '../components/navbar.js';
import Footer from '../components/footer.js';
import SearchBar from '../components/searchbar.js';

export default class StartingPage extends React.Component {
    render() {
      return (
        <div>
          <NavBar />
          <SearchBar />
          <Footer />
        </div>
    );
  }
}

