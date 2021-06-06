import React, { useState } from "react";
import { Text } from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { createDrawerNavigator } from "@react-navigation/drawer";
import DrawerContent from "./screens/DrawerContent";

import MainScreen from "./screens/HomeScreen";
import EditUsersProfile from "./screens/EditUsersProfile";
import ReceiptsScreen from "./screens/ReceiptsScreen";
import LoginScreen from "./screens/LoginScreen";
import CreateAccount from "./screens/CreateAccount";

const Drawer = createDrawerNavigator();

export default function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [createAccountPressed, setCreateAccountPressed] = useState(false);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  let userInfo = {};

  const decideWhatToReturn = () => {
    if (isLoggedIn == true && createAccountPressed == false) {
      return (
        <NavigationContainer>
          <Drawer.Navigator
            drawerContent={(props) => (
              <DrawerContent
                {...props}
                setIsLoggedIn={setIsLoggedIn}
                userInfo={userInfo}
                username={username}
                setUsername={setUsername}
                setPassword={setPassword}
              />
            )}
          >
            <Drawer.Screen name="Home" component={MainScreen} />
            <Drawer.Screen name="Receipts" component={ReceiptsScreen} />
            <Drawer.Screen name="Edit Profile" component={EditUsersProfile} />
          </Drawer.Navigator>
        </NavigationContainer>
      );
    } else if (isLoggedIn == false && createAccountPressed == false) {
      return (
        <LoginScreen
          setIsLoggedIn={setIsLoggedIn}
          setUsername={setUsername}
          setPassword={setPassword}
          username={username}
          password={password}
          userInfo={userInfo}
          setCreateAccountPressed={setCreateAccountPressed}
        />
      );
    } else {
      return <CreateAccount setCreateAccountPressed={setCreateAccountPressed} />;
    }
  };

  return decideWhatToReturn();
}
