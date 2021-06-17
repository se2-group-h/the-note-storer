import React from 'react';
import './signinform.css';
import noteadderimg from '../../images/signinform_img.png';
import env from '../../appsettings.json';

class SignInForm extends React.Component {

    constructor(props) {
        super(props);
        this.state = {password: '', username: ''};

    }

    handleChange = (event) => {
        this.setState({[event.target.name]: event.target.value});
        
    }


    handleSubmit = (event) => {


        fetch(`${env.url}/api/login`, {
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
                if (res.status === 401) {
                    alert(res.data)
                }
                if (res.status === 200) {
                    alert('Logged in successfully!')
                    const token = JSON.parse(res.data).token
                    const user_id = JSON.parse(res.data).userId
                    const firstName = JSON.parse(res.data).firstName
                    //const recipeList = [JSON.parse(res.data).recipeList]
                    const recipeList = JSON.parse(res.data).recipeList
                    console.log(JSON.parse(res.data).recipeList)
                    localStorage.setItem('token',token)
                    localStorage.setItem('user_id',user_id)
                    localStorage.setItem('firstName', firstName)
                    localStorage.setItem('recipeList', recipeList)
                }
            })).catch(e => alert(e))

        event.preventDefault();
    }

    render() {
        return (
            <div>
                <div className="form-container">
                    <div className="form-content-left">
                        <form className="form" onSubmit={this.handleSubmit}>
                            <h1>Please fill in the required fields:</h1>
                            <div className="form-inputs">
                                <label className='form-label'>User Name:</label>
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

export default SignInForm