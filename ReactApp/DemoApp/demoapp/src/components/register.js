import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../styles/registerstyle.css';

export default class RegisterComponent extends React.Component {

  render() {
    return (
        <div className="row">
          <div className="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div className="card card-signin my-5">
              <div className="card-body">
                <h5 className="card-title text-center">Register</h5>
                <form className="form-signin">
                  <div className="form-label-group">
                    <input type="email" id="inputEmail" className="form-control" placeholder="Email address" required autoFocus />
                    <label htmlFor="inputEmail">Email address</label>
                  </div>

                  <div className="form-label-group">
                    <input type="text" id="inputFirstName" className="form-control" placeholder="First name" required autoFocus />
                    <label htmlFor="inputFirstName">First name</label>
                  </div>

                  <div className="form-label-group">
                    <input type="text" id="inputLastName" className="form-control" placeholder="Last name" required autoFocus />
                    <label htmlFor="inputLastName">Last name</label>
                  </div>

                  <div className="form-label-group">
                    <input type="password" id="inputPassword" className="form-control" placeholder="Password" required />
                    <label htmlFor="inputPassword">Password</label>
                  </div>
                  <button className="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
                </form>
              </div>
            </div>
          </div>
        </div>
  );
 }
}

