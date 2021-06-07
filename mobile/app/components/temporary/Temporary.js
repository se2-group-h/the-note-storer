import { StatusBar } from "expo-status-bar";
import { Text, View } from "react-native";
import React from "react";
import { styles } from "./styles";

export default function Temporary() {
  return (
    <View style={styles.container}>
      <Text>This page is temporary unavailable</Text>
      <StatusBar style="auto" />
    </View>
  );
}
