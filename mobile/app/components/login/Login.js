import React from "react";
import { Text, TouchableOpacity, View, TextInput, Alert } from "react-native";
import { styles } from "../../globals/styles/styles";
import { BASE_URL, LOGIN } from "../../globals/constants/url";

export default function Login({
  setIsLoggedIn,
  setUsername,
  setPassword,
  username,
  password,
  setUserInfo,
  setCreateAccountPressed,
}) {
  const pressHandlerRegister = () => {
    setCreateAccountPressed(true);
  };

  const createAlert = () => Alert.alert("Invalid Login or Password", "Please try again", [{ text: "OK" }]);

  const pressHandlerLogIn = () => {
    fetch(BASE_URL + LOGIN, {
      method: "POST", // *GET, POST, PUT, DELETE, etc.
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        password: password,
        username: username,
      }),
    })
      .then((a) => a.json())
      .then((e) => setUserInfo(e))
      .then(() => setIsLoggedIn(true))
      .catch((e) => {
        console.log(e);
        createAlert();
      });
  };

  return (
    <View style={styles.container}>
      <Text style={styles.welcome}>Welcome!</Text>
      <TextInput
        placeholder="Login"
        maxLength={15}
        textAlign="center"
        style={styles.textInput}
        value={username}
        onChangeText={(value) => setUsername(value)}
      />
      <TextInput
        placeholder="Password"
        maxLength={15}
        secureTextEntry={true}
        textAlign="center"
        style={styles.textInput}
        value={password}
        onChangeText={(value) => setPassword(value)}
      />
      <View>
        <TouchableOpacity style={styles.button} onPress={pressHandlerLogIn}>
          <Text style={styles.textColor}>Log in</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={pressHandlerRegister}>
          <Text style={styles.textColor}>Create Account</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}
