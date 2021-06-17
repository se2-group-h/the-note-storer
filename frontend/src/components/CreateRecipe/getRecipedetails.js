import React  from 'react';
import { Card } from "react-bootstrap";
import './createrecipe.css';

class GetRecipedetails extends React.Component{
    constructor(props){
      super(props);
      this.state = {
        name: '' , description: '' , tag: '' , rating: '' , ingredients: ''
      }
    }
  
    componentWillMount(){
      this.getRecipedata();
    }
  
    getRecipedata() {
        const userid = localStorage.getItem('user_id')
        fetch(`https://se2-h-backend.herokuapp.com/api/recipes/user/${userid}`, {
              method: 'GET'
            }).then(response=> {
                this.setState({
                    name: JSON.parse(response.data).name,
                    description: JSON.parse(response.data).description,
                    tag: JSON.parse(response.data).tag,
                    rating: JSON.parse(response.data).rating,
                    ingredients: JSON.parse(response.data).ingredients
                }, () => {
                  console.log(this.state);
                })
            })
            .catch(err => console.log(err));
    }
    
    onDelete() {
        const userid = localStorage.getItem('user_id')
        fetch(`https://se2-h-backend.herokuapp.com/api/recipes/${userid}`,{
            method: 'DELETE'
        }).then(response => {
            console.log(response.data);
        }).catch(err => console.log(err));
    }

    render(){
      return (
       <div>
         <div className="containermyrecipe">
         <label className="labelz">{localStorage.getItem('firstName')} Recipes: </label>
    <Card style={{ width: '25rem' }}>
      <Card.Body>
        <Card.Title>Recipe Name: {this.state.name}<i className="fa fa-edit" id="updatebut" aria-hidden="true"></i>
        <i className="fa fa-trash-o" id="trashbut" aria-hidden="true" onClick={this.onDelete.bind(this)}></i></Card.Title>
        <Card.Subtitle className="mb-2 text-muted">Tags: {this.state.tag}</Card.Subtitle>
        <Card.Subtitle className="mb-2 text-muted">Ratings: {this.state.rating} <i className="fa fa-star" aria-hidden="true"></i></Card.Subtitle>
        <Card.Text>
          Ingredients:
          {this.state.ingredients}
        </Card.Text>
        <Card.Text>
          Description:
          {this.state.description}
        </Card.Text>
      </Card.Body>
    </Card>
  </div>
        </div>
      )
    }
  }
  
  export default GetRecipedetails;