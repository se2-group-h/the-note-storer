import React from 'react';
import './navbar.css';
import {NavLink} from 'react-router-dom';
import logoimg from '../../images/cheflogo.png'
import Search from '../SearchBar/searchbar';

const Navbar = () => {

    return (
        <div>
            <header>
                <img src={logoimg} alt="noteadderimg" width="50" height="50" title="imagelog"></img><h2>RecipeIT</h2>
                <nav>
                    <ul className="nav__links">
                        <li><strong><i className="fa fa-home" aria-hidden="true"></i></strong></li>
                        <li><Search/></li>

                    </ul>
                </nav>

                <NavLink exact={true} to="/register" activeClassName="selectedlink">
                    <button id="register" title="signupbtn">Register</button>
                </NavLink>
                <NavLink exact={true} to="/signin" activeClassName="selectedlink">
                    <button id="sign-in" title="signinbtn">Sign-In</button>
                </NavLink>
                <ul className="menulinks">
                    <li><i className="fa fa-plus-square-o" aria-hidden="true" name="addsign"/></li>
                    <li><i className="fa fa-shopping-basket" aria-hidden="true" name="shoppingcartsign"/></li>
                    <li><i className="fa fa-user" aria-hidden="true" name="profilesign"/></li>
                </ul>
            </header>
        </div>
    )
}


export default Navbar