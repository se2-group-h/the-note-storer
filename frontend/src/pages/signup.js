import React from 'react';
import Navbar from '../components/Navbar/navbar.js';
import RegisterForm from '../components/RegisterForm/registerform.js';

const Signup = () => {
    return (
        <div>
            <Navbar/>
            <div id="body">
                <RegisterForm/>
            </div>
        </div>
    )
}


export default Signup