import { Text, TouchableOpacity, View, TextInput } from "react-native";
import { StyleSheet } from "react-native";
import React from "react";
import { styles } from "./styles";

export default function EditUserAccount() {
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
