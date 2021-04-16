import React from 'react';
import './signinform.css';
import noteadderimg from '../../images/signinform_img.png';

const Signinform = () => {
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
                       
                        <button className='form-input-btn' type="button" title="signinbutn">
                            Sign-In
                        </button>
                    </div>
                </form>
        </div>
        <div className='form-content-right'>
            <img src={noteadderimg} alt="noteadderimg" width="400" height="510" title="imageright"></img>
        </div>
     </div>
    </div>
    );
}

export default Signinform