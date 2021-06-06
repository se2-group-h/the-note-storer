import React, { useState } from "react";
import { Text, TouchableOpacity, View, TextInput, Alert } from "react-native";
import { styles } from "../styles/styles";
import { BASEURL, CREATEACCOUNT } from "../url/url";

export default function CreateAccount({ setCreateAccountPressed }) {
  const [newUser, setNewUser] = useState({
    admin: false,
    email: "",
    login: "",
    savedRecipes: [],
    name: "",
    password: "",
    surname: "",
    userId: 0,
    verified: false,
  });

  const createAlert = (message) => Alert.alert(message, "Please try again", [{ text: "OK" }]);

  const pressHandlerCancel = () => setCreateAccountPressed(false);

  const pressHandlerCreateAccount = () => {
    fetch(BASEURL + CREATEACCOUNT, {
      method: "POST", // *GET, POST, PUT, DELETE, etc.
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newUser),
    })
      .then((e) => {
        if (e.status != 201) {
          e.text().then((e) => createAlert(e));
        } else {
          setCreateAccountPressed(false);
        }
      })
      .catch((e) => {
        console.log(e.status);
        createAlert("Something went wrong");
      });
  };
  return (
    <View style={styles.container}>
      <TextInput
        placeholder="Name"
        style={styles.textInput}
        onChangeText={(val) => setNewUser({ ...newUser, name: val })}
      />
      <TextInput
        placeholder="Surname"
        style={styles.textInput}
        onChangeText={(val) => setNewUser({ ...newUser, surname: val })}
      />
      <TextInput
        placeholder="Login"
        style={styles.textInput}
        onChangeText={(val) => setNewUser({ ...newUser, login: val })}
      />
      <TextInput
        placeholder="E-mail"
        style={styles.textInput}
        onChangeText={(val) => setNewUser({ ...newUser, email: val })}
      />
      <TextInput
        placeholder="Password"
        secureTextEntry={true}
        style={styles.textInput}
        onChangeText={(val) => setNewUser({ ...newUser, password: val })}
      />
      <TouchableOpacity style={styles.button} onPress={pressHandlerCreateAccount}>
        <Text style={styles.textColor}>Create Account</Text>
      </TouchableOpacity>
      <TouchableOpacity style={styles.button} onPress={pressHandlerCancel}>
        <Text style={styles.textColor}>Cancel</Text>
      </TouchableOpacity>
    </View>
  );
}
