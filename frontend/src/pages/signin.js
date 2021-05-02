import React from 'react';
import Navbar from '../components/Navbar/navbar.js';
import SignInForm from '../components/SignInForm/signInForm.js';

const Signin = () => {
    return (
        <div>
            <Navbar/>
            <div id="body">
                <SignInForm/>
            </div>
        </div>
    )
}


export default Signin