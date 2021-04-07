import React from 'react';
import './registerform.css';
import noteadderimg from '../../images/undraw_Add_notes_re_ln36.png';

const RegisterForm = () => {
    return (
        <div>
        <div className="form-container">
         <div className="form-content-left">
                <form className="form">
                    <h1>Please fill in the required fields:</h1>
                    <div className="form-inputs">
                        <label className='form-label'>User Name:</label>
                        <input
                            className='form-input'
                            type='text'
                            id='username'
                            placeholder='Enter your username'
                        />
                        <label className='form-label'>Password:</label>
                        <input
                            className='form-input'
                            type='password'
                            id='pass'
                            placeholder='Enter password'
                        />
                        <label className='form-label'>Email:</label>
                        <input
                            className='form-input'
                            type='text'
                            id='email'
                            placeholder='example@ex.com'
                        />
                        <button className='form-input-btn' type="button">
                            Sign-Up
                        </button>
                    </div>
                </form>
        </div>
        <div className='form-content-right'>
            <img src={noteadderimg} alt="noteadderimg" width="400" height="510"></img>
        </div>
     </div>
    </div>
    );
}

export default RegisterForm