import React from 'react';
//import validateregister from '../../Validate/validateregister';
import './createrecipe.css';


class RecipeForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = { name: '' , description: '' , tag: '' };
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
        <div className="form-containers">
         <div className="form-content-lefts">
                <form className="form" onSubmit={this.handleSubmit}>
                    <h2>Create your own recipe and share it with the world:</h2>
                    <div className="form-inputs">
                        <label className='form-label'>Recipe Name:</label>
                        <input
                            className='form-input'
                            type='text'
                            id='name'
                            placeholder='Recipe name'
                            value={this.state.value}
                            onChange={this.handleChange}
                            name="name"
                        />
                       
                        <label className='form-label'>Description:</label>
                        <input
                            className='form-input'
                            type='text'
                            id='description'
                            placeholder='Describe the steps/ingredients usage'
                            value={this.state.value}
                            onChange={this.handleChange}
                            name="description"
                        />
                        <label className='form-label'>Tag:</label>
                        <input
                            className='form-input'
                            type='text'
                            id='tag'
                            placeholder='#'
                            value={this.state.value}
                            onChange={this.handleChange}
                            name="tag"
                        />
                        <button type="submit" className='form-input-btn' title="createbutn">
                            Create
                        </button>
                    </div>
                </form>
        </div>
     </div>
    );
    }
}

export default RecipeForm