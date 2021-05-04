import React from 'react';
import Navbar from '../components/Navbar/navbar.js';
import CreateForm from '../components/CreateRecipe/createrecipe.js';

const Create = () => {
    return (
        <div>
            <Navbar />
            <div id="body">
            <CreateForm />
            </div>
        </div>
    )
}


export default Create