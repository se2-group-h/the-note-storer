import React from 'react';
import './navbar.css';
import {NavLink} from 'react-router-dom';

const Navbar = () => {

    return (
        <div>
        <header>
        <i class="fa fa-sticky-note" aria-hidden="true"></i><h2>noteit</h2>
            <nav>
                <ul class="nav__links">
                    <li><strong>About</strong></li>
                    <li><strong>Contact Us</strong></li>      
                </ul>
            </nav>
            <a class="cta" href="/#"><NavLink exact to="/register" activeClassName="selectedlink"><button id="register" title="signupbtn">Register</button></NavLink></a>
            <a class="cta" href="/#"><NavLink exact to="/signin" activeClassName="selectedlink"><button id="sign-in" title="signinbtn">Sign-In</button></NavLink></a>
        </header> 
        </div>
    )
}


export default Navbar