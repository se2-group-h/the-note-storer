import React from 'react';
import './registerform.css';
import noteadderimg from '../../images/cheflogo.png';

class RegisterForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = { firstName: '' , lastName: '' , password: '', email: '', login: '' };
      }
    
      handleChange = (event) => {
        this.setState({[event.target.name]: event.target.value});
      }
    
      handleSubmit = (event) => {
        
    
        fetch('http://trn-staging-back.us-east-2.elasticbeanstalk.com/api/signup', {
            method: 'POST',
            // We convert the React state to JSON and send it as the POST body
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.state)
          }).then(function(response) {
            
          });
    
        event.preventDefault();
    }
    render() {
    return (
        <div className="form-container">
         <div className="form-content-left">
                <form className="form" onSubmit={this.handleSubmit}>
                    <h2>Please fill in the required fields:</h2>
                    <div className="form-inputs">
                        <label className='form-label'>First Name:</label>
                        <input
                            className='form-input'
                            type='text'
                            id='firstname'
                            placeholder='Enter your username'
                            value={this.state.value}
                            onChange={this.handleChange}
                            name="firstName"
                        />
                        <label className='form-label'>Last Name:</label>
                        <input
                            className='form-input'
                            type='text'
                            id='lastname'
                            placeholder='Enter your username'
                            value={this.state.value}
                            onChange={this.handleChange}
                            name="lastName"
                        />
                        <label className='form-label'>Login:</label>
                        <input
                            className='form-input'
                            type='text'
                            id='login'
                            placeholder='Enter your username'
                            value={this.state.value}
                            onChange={this.handleChange}
                            name="login"
                        />
                        <label className='form-label'>Password:</label>
                        <input
                            className='form-input'
                            type='password'
                            id='pass'
                            placeholder='Enter password'
                            value={this.state.value}
                            onChange={this.handleChange}
                            name="password"
                        />
                        <label className='form-label'>Email:</label>
                        <input
                            className='form-input'
                            type='text'
                            id='email'
                            placeholder='example@ex.com'
                            value={this.state.value}
                            onChange={this.handleChange}
                            name="email"
                        />
                        <button type="submit" className='form-input-btn' title="signupbutn">
                            Sign-Up
                        </button>
                    </div>
                </form>
        </div>
        <div className='form-content-right'>
            <img src={noteadderimg} alt="noteadderimg" width="400" height="510" title="imageright"></img>
        </div>
     </div>
    );
    }
}

export default RegisterForm