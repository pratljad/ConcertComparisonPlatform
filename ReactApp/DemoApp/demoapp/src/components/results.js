import React from 'react';
import '../styles/results.css';

export default class Results extends React.Component {
    constructor (props) {
        super(props);
    }

    
    render () {
        return (
         <div className="container bootstrap snippet">
            <div className="row">
                <div className="col-lg-12">
                    <div className="ibox float-e-margins scrollClass">
                            <h2>
                                <b>4 results found for: <span className="text-navy">"UFO361"</span></b>
                            </h2>
                            <br />
                
                            <div className="search-form">
                                <form action="#" method="get">
                                    <div className="input-group">
                                        <input type="text" placeholder="UFO361" name="search" className="form-control input-lg" />
                                        <div className="input-group-btn">
                                            <button className="btn btn-lg btn-primary" type="submit">
                                                Search
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>

                            <div className="hr-line-dashed"></div>
                            <div className="search-result">
                                <h3><a href="#">UFO361 (oeticket.at)</a></h3>
                                <a href="#" className="search-link">https://www.oeticket.at/</a>
                                <p>
                                    UFO361 Tour Tickets auf <a href="#">www.oeticket.at</a>
                                </p>
                            </div>

                            <div className="hr-line-dashed"></div>
                            <div className="search-result">
                                <h3><a href="#">UFO361 (eventim.de)</a></h3>
                                <a href="#" className="search-link">https://www.eventim.de/</a>
                                <p>
                                    UFO361 Tour Tickets auf <a href="#">www.eventim.de</a>
                                </p>
                            </div>
                            <div className="hr-line-dashed"></div>

                            <div className="search-result">
                                <h3><a href="#">UFO361 (tickets.at)</a></h3>
                                <a href="#" className="search-link">https://www.tickets.at/</a>
                                <p>
                                    UFO361 Tour Tickets auf <a href="#">www.tickets.at</a>
                                </p>
                            </div>
                            <div className="hr-line-dashed"></div>

                            <div className="search-result">
                                <h3><a href="#">UFO361 (tickets.at)</a></h3>
                                <a href="#" className="search-link">https://www.tickets.at/</a>
                                <p>
                                    UFO361 Tour Tickets auf <a href="#">www.tickets.at</a>
                                </p>
                            </div>
                            <div className="hr-line-dashed"></div>
                    </div>
                </div>
            </div>
        </div>
                            
        );
    }
}