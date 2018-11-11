import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.js';
import '../styles/searchbar.css';
import React from 'react';
import $ from 'jquery';

const artistName = "UFO361";
const artists = ["UFO361", "Captial Bra", "Rolexesh"];

export default class SearchBar extends React.Component {
constructor(props) {
    super(props);
    this.toggle = this.toggle.bind(this);
    this.state = {
        active: false
    };
}
toggle() {
    $('.search').toggleClass('active');
}  

find(e) {
    console.log(e.keyCode);
}

render() {
    return (
      <div className="container">
        <h1><span className="badge badge-secondary">New</span> [{artistName}] Tour 2018/19</h1>
            <div className="search">
                <input type="text" placeholder="Search..." onKeyDown={this.find}/>
                <div className="icon" onClick={this.toggle}></div>
            </div>
        </div> 
    );
  }
}
