import React from 'react';
import '../styles/footerstyle.css';

export default class Footer extends React.Component {
  render() {
    return (
      <footer>
          <div className="fixed-bottom">
            <p className="align-self-center">&copy; 2018. conSert - All rights reserved.</p>
          </div>
      </footer>
      
    );
  }
}
