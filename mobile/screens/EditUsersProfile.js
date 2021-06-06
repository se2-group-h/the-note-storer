import { Text, TouchableOpacity, View, TextInput } from "react-native";
import { StyleSheet } from "react-native";
import React from "react";

export default function UserSettingsView({ navigation }) {
  return (
    <View style={styles.container}>
      <TextInput placeholder="Name" style={styles.textInput} />
      <TextInput placeholder="Surname" style={styles.textInput} />
      <TextInput placeholder="Username" style={styles.textInput} />
      <TextInput placeholder="E-mail" style={styles.textInput} />
      <TextInput placeholder="Old Password" secureTextEntry={true} style={styles.textInput} />
      <TextInput placeholder="New Password" secureTextEntry={true} style={styles.textInput} />
      <TextInput placeholder="Repeat New Password" secureTextEntry={true} style={styles.textInput} />
    </View>
  );
}

export const styles = StyleSheet.create({
  textInput: {
    height: 40,
    borderColor: "grey",
    borderBottomWidth: StyleSheet.hairlineWidth,
    marginBottom: 15,
    width: 175,
    textAlign: "center",
  },
  container: {
    flex: 1,
    backgroundColor: "#fdfffc",
    alignItems: "center",
    justifyContent: "center",
  },
});
