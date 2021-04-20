import React from 'react';
import './signinform.css';
import noteadderimg from '../../images/signinform_img.png';

class Signinform extends React.Component {
    constructor(props) {
        super(props);
        this.state = { password: '' , username: '' };
      }
    
      handleChange = (event) => {
        this.setState({[event.target.name]: event.target.value});
      }
    
      handleSubmit = (event) => {
        alert('A form was submitted: ' + this.state);
    
        fetch('http://trn-staging-back.us-east-2.elasticbeanstalk.com/api/login', {
            method: 'POST',
            // We convert the React state to JSON and send it as the POST body
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.state)
          }).then(function(response) {
            console.log(response)
            return response.json();
          });
    
        event.preventDefault();
    }
    render () {
        return (
        <div>
        <div className="form-container">
         <div className="form-content-left">
                <form className="form" onSubmit={this.handleSubmit}>
                    <h1>Please fill in the required fields:</h1>
                    <div className="form-inputs">
                        <label className='form-label'>UserName:</label>
                        <input
                            className='form-input'
                            type='text'
                            id='username'
                            placeholder='Enter your username'
                            onChange={this.handleChange}
                            name="username"
                        />
                        <label className='form-label'>Password:</label>
                        <input
                            className='form-input'
                            type='password'
                            id='pass'
                            placeholder='Enter password'
                            onChange={this.handleChange}
                            name="password"
                        />
                       
                        <button className='form-input-btn' type="submit" title="signinbutn">
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
}

export default Signinform