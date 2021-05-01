//import logo from './logo.svg';
import './App.css';
import Home from './pages/home.js';
import Signup from './pages/signup.js';
import Signin from './pages/signin.js';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

function App() {
    return (
        <Router>
            <div>
                <Switch>
                    <Route path="/" exact={true} component={Home}/>
                    <Route path="/register" component={Signup}/>
                    <Route path="/signin" component={Signin}/>
                </Switch>
            </div>
        </Router>
    )
}

export default App;

