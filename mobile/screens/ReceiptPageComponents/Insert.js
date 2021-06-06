import React, { useState } from "react";
import { Button, StyleSheet, TextInput, View } from "react-native";

const Insert = ({ onAdd }) => {
  const [newItem, setNewItem] = useState("");

  const InputHandler = (item) => {
    setNewItem(item);
  };

  const addHandler = () => {
    onAdd(newItem);
    setNewItem("");
  };

  return (
    <View style={styles.inputContainer}>
      <TextInput
        style={styles.input}
        placeholder="Add a receipt!"
        placeholderTextColor={"#999"}
        autoCorrect={false}
        value={newItem}
        onChangeText={InputHandler}
      />
      <View style={styles.button}>
        <Button title={"ADD"} onPress={addHandler} />
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  inputContainer: {
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
  },
  input: {
    flex: 1,
    padding: 20,
    borderBottomColor: "#bbb",
    borderBottomWidth: 1,
    fontSize: 24,
    marginLeft: 20,
  },
  button: {
    marginRight: 10,
  },
});

export default Insert;
