import React from 'react';
import { Row, Col } from 'reactstrap';
import '../styles/footerstyle.css';

export default class Footer extends React.Component {
  render() {
    return (
      <footer>
        <Row>
          <Col sm="12" md="12" lg="12">
            <p className="align-self-center">&copy; 2018. conSert - All rights reserved.</p>
          </Col>
        </Row>
      </footer>
    );
  }
}
