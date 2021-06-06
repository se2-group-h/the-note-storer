import React, { useEffect, useState } from "react";
import { Text, TouchableOpacity, View, TextInput } from "react-native";
import { styles } from "../styles/styles";

export default function UserProfileView({ navigation }) {
  const pressHandlerUserSettings = () => {
    navigation.navigate("UserSettingsPage");
  };

  return (
    <View style={styles.container}>
      <Text style={styles.userprofile}>Username: </Text>
      <Text style={styles.userprofile}>Name: </Text>
      <Text style={styles.userprofile}>Surname: </Text>
      <Text style={styles.userprofile}>Email: </Text>

      <TouchableOpacity style={styles.button} onPress={() => pressHandlerUserSettings()}>
        <Text style={styles.textColor}>User Settings</Text>
      </TouchableOpacity>
    </View>
  );
}
