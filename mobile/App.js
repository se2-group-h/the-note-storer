import React, { useState } from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createDrawerNavigator } from "@react-navigation/drawer";
import SideMenu from "./app/components/sideMenu/SideMenu";
import EditUsersProfile from "./app/components/account/editUserAccount/EditUserAccount";
import ReceiptList from "./app/components/receiptList/ReceiptList";
import CreateAccount from "./app/components/account/createAccount/CreateAccount";
import Temporary from "./app/components/temporary/Temporary";
import Login from "./app/components/login/Login";

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
              <SideMenu
                {...props}
                setIsLoggedIn={setIsLoggedIn}
                userInfo={userInfo}
                username={username}
                setUsername={setUsername}
                setPassword={setPassword}
              />
            )}
          >
            <Drawer.Screen name="Temporary" component={Temporary} />
            <Drawer.Screen name="Receipts" component={ReceiptList} />
            <Drawer.Screen name="Edit Profile" component={EditUsersProfile} />
          </Drawer.Navigator>
        </NavigationContainer>
      );
    } else if (isLoggedIn == false && createAccountPressed == false) {
      return (
        <Login
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
