import React from 'react';
import Navbar from '../components/Navbar/navbar.js';
import Signinform from '../components/SignInForm/signinform.js';

const Signin = () => {
    return (
        <div>
            <Navbar/>
            <div id="body">
                <Signinform/>
            </div>
        </div>
    )
}


export default Signin