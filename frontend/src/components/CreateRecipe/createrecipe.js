import React from 'react';
//import validateregister from '../../Validate/validateregister';
import './createrecipe.css';
import { Form, Button } from "react-bootstrap";


class RecipeForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = { name: '' , description: '' , tag: '' , rating: '' };
      }
    
      handleChange = (event) => {
        this.setState({[event.target.name]: event.target.value});
      }
    
      handleSubmit = (event) => {
    
        fetch('http://se2-h-backend.herokuapp.com/api/recipes', {
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
      <div className="contain">
      <Form className="createform" onSubmit={this.handleSubmit}>
      <Form.Group controlId="exampleForm.ControlInput1">
        <Form.Label className="labs"><strong>Recipe Name:</strong></Form.Label>
        <Form.Control type="textarea" placeholder="Ex: Chicken Curry" name="name" value={this.state.value} onChange={this.handleChange}/>
      </Form.Group>
      <Form.Group controlId="exampleForm.ControlSelect1">
        <Form.Label className="labs"><strong>Tags:</strong></Form.Label>
        <Form.Control as="select" multiple name="tag"  value={this.state.value} onChange={this.handleChange}>
          <option>#Vegetarian</option>
          <option>#Protein</option>
          <option>#Fried</option>
          <option>#Sauce</option>
          <option>#Meat</option>
        </Form.Control>
      </Form.Group>
      <Form.Group controlId="exampleForm.ControlSelect2">
        <Form.Label className="labs"><strong>Ratings 1(lowest) - 5(highest):</strong></Form.Label>
        <Form.Control as="select" multiple name="rating"  value={this.state.value} onChange={this.handleChange}>
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
        </Form.Control>
      </Form.Group>
      <Form.Group controlId="exampleForm.ControlTextarea1">
        <Form.Label className="labs"><strong>Description:</strong></Form.Label>
        <Form.Control as="textarea" rows={12} name="description"  value={this.state.value} onChange={this.handleChange}/>
      </Form.Group>
      <Button className="btn-lg btn-success btn-block" type="submit">
      Create
      </Button>
    </Form>
    </div>
    );
    }
}

export default RecipeForm