import React from "react";
import { View, Text, StyleSheet, TouchableOpacity } from "react-native";
import Icon from "react-native-vector-icons/AntDesign";

const ListItemCustom = ({ textValue, id, onRemove }) => {
  return (
    <View style={styles.container}>
      <Text style={styles.text}>{textValue} </Text>
      <TouchableOpacity style={styles.buttonContainer}>
        <Icon name="edit" size={30} color="black" />
      </TouchableOpacity>
      <TouchableOpacity style={styles.buttonContainer}>
        <Icon name="delete" size={30} color="#e33057" onPress={onRemove(id)} />
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    borderBottomColor: "#bbb",
    borderBottomWidth: StyleSheet.hairlineWidth,
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
  },
  text: {
    flex: 5,
    fontWeight: "500",
    fontSize: 18,
    marginVertical: 20,
    width: 100,
    textAlign: "center",
  },
  circle: {
    width: 30,
    height: 30,
    borderRadius: 15,
    borderColor: "blue",
    borderWidth: 2,
    marginRight: 20,
    marginLeft: 20,
  },
});

export default ListItemCustom;
