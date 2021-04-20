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
                <ul class="nav__links">
                    <li><strong><i class="fa fa-home" aria-hidden="true"></i></strong></li>
                    <li><Search /></li>
                    
                </ul>
            </nav>
            
            <a class="cta" href="/#"><NavLink exact to="/register" activeClassName="selectedlink"><button id="register" title="signupbtn">Register</button></NavLink></a>
            <a class="cta" href="/#"><NavLink exact to="/signin" activeClassName="selectedlink"><button id="sign-in" title="signinbtn">Sign-In</button></NavLink></a>
            <ul class="menulinks">
            <li><i class="fa fa-plus-square-o" aria-hidden="true" name="addsign"></i></li>
            <li><i class="fa fa-shopping-basket" aria-hidden="true" name="shoppingcartsign"></i></li>
            <li><i class="fa fa-user" aria-hidden="true" name="profilesign"></i></li>
            </ul>
        </header> 
        </div>
    )
}


export default Navbar