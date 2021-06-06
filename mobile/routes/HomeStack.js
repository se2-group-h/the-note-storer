import { createStackNavigator } from "react-navigation-stack";
import { createAppContainer, createContainer } from "react-navigation";
import CreateAccount from "../screens/CreateAccount";
import Login from "../screens/Login";
import Home from "../screens/Home";
import UserProfilePage from "../screens/UserProfilePage";
import UserSettingsPage from "../screens/UserSettingsPage";
import ReceiptPage from "../screens/ReceiptPage";

const screens = {
  Login: {
    screen: Login,
  },
  CreateAccount: {
    screen: CreateAccount,
  },
  Home: {
    screen: Home,
  },
  UserProfilePage: {
    screen: UserProfilePage,
  },
  UserSettingsPage: {
    screen: UserSettingsPage,
  },
  ReceiptPage: {
    screen: ReceiptPage,
  },
};

const HomeStack = createStackNavigator(screens);

export default createAppContainer(HomeStack);
