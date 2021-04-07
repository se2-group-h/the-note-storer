//import logo from './logo.svg';
import './App.css';
import Home from './pages/home.js';
import Signup from './pages/signup.js';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

function App() {
  return (
    <Router>
    <div>
    <Switch>
        <Route path exact="/" component={Home} />
        <Route path="/register" component={Signup} />
    </Switch>
    </div>
    </Router>
  )
}

export default App;

