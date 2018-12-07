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
    //if(this.state.active === false) {
        $('.search').toggleClass('active');
        //this.loadGraphicCards(1);
        //this.setState({active: true});
        this.fetchDataFromOE();
    //}

    //else {
        //console.log("This searchbar is already active.");
    //}
}

find(e) {
    if(e.keyCode === 13) {
        console.log("Enter pressed.");
        const s = document.getElementById("input_search").value;

        artists.forEach(function (name) {
            if(name.toLocaleLowerCase() === s.toLocaleLowerCase()) {
                console.log("Got a hit");
            }

        });
        console.log(s);

    }
}

fetchDataFromOE() {
    var proxy = "http://anyorigin.com/go?url=";
    var url = encodeURIComponent("https://www.oeticket.com/bonez-mc-raf-camora-palmen-aus-plastik-2-tour-2019-tickets.html?affiliate=EOE&doc=artistPages%2Ftickets&fun=artist&action=tickets&erid=1967835&kuid=502401"); // site that doesn’t send Access-Control-*
    var addition = "&callback=?";
    $.getJSON('http://allorigins.me/get?url=' + url + '&callback=?', function(data){
        
        
        
        //console.log("REGEX: "+ data.contents.split("var initEvents").split("}];"));

    });
}

render() {
    return (
      <div className="row">
        <h1><span className="badge badge-secondary">New</span> [{artistName}] Tour 2018/19</h1>
            <div className="search">
                <input type="text" id="input_search" placeholder="Search..." onKeyDown={this.find}/>
                <div className="icon" onClick={this.toggle}></div>
            </div>
        </div>
    );
  }
}
