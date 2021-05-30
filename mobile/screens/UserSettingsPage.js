import React, { useEffect, useState } from "react";
import { Text, TouchableOpacity, View, TextInput } from "react-native";
import { styles } from "../styles/styles";

export default function UserSettingsView({ navigation }) {
  const pressHandlerUserProfile = () => {
    navigation.navigate("UserProfilePage");
  };

  return (
    <View style={styles.container}>
      <TextInput placeholder="Name" style={styles.textInput} />
      <TextInput placeholder="Surname" style={styles.textInput} />
      <TextInput placeholder="Username" style={styles.textInput} />
      <TextInput placeholder="E-mail" style={styles.textInput} />
      <TextInput placeholder="Old Password" secureTextEntry={true} style={styles.textInput} />
      <TextInput placeholder="New Password" secureTextEntry={true} style={styles.textInput} />
      <TextInput placeholder="Repeat New Password" secureTextEntry={true} style={styles.textInput} />
      <TouchableOpacity style={styles.button} onPress={() => pressHandlerUserProfile()}>
        <Text style={styles.textColor}>Confirm changes</Text>
      </TouchableOpacity>
    </View>
  );
}
