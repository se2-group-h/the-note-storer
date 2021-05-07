import { createStackNavigator } from 'react-navigation-stack';
import { createAppContainer, createContainer } from 'react-navigation';
import CreateAccount from '../screens/CreateAccount';
import Login from '../screens/Login';
import Home from '../screens/Home'

const screens = {
    Login : {
        screen: Login
    },
    CreateAccount: {
        screen: CreateAccount
    },
    Home: {
        screen: Home
    }
}

const HomeStack = createStackNavigator(screens);

export default createAppContainer(HomeStack);

