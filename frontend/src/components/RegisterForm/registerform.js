import React from 'react';
import './registerform.css';
import noteadderimg from '../../images/cheflogo.png';
import env from '../../appsettings.json';

class RegisterForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {name: '', surname: '', password: '', email: '', login: ''};
    }

    handleChange = (event) => {
        this.setState({[event.target.name]: event.target.value});
    }

    handleSubmit = (event) => {
        event.preventDefault();

        fetch(`${env.url}/api/signup`, {
            method: 'POST',
            // We convert the React state to JSON and send it as the POST body
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.state)
        }).then(response =>
            response.text().then(data => ({
                    data: data,
                    status: response.status,
                })
            ).then(res => {
                if (res.status === 400) {
                    alert(res.data)
                }
            })).catch(e => alert(e))
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
                                id='name'
                                placeholder='Enter your name'
                                value={this.state.value}
                                onChange={this.handleChange}
                                name="name"
                            />
                            <label className='form-label'>Last Name:</label>
                            <input
                                className='form-input'
                                type='text'
                                id='surname'
                                placeholder='Enter your surname'
                                value={this.state.value}
                                onChange={this.handleChange}
                                name="surname"
                            />
                            <label className='form-label'>Login:</label>
                            <input
                                className='form-input'
                                type='text'
                                id='login'
                                placeholder='Enter your login'
                                value={this.state.value}
                                onChange={this.handleChange}
                                name="login"
                            />
                            <label className='form-label'>Password:</label>
                            <input
                                className='form-input'
                                type='password'
                                id='password'
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