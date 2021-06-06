import React, { useEffect, useState } from "react";
import { SafeAreaView, StyleSheet, TextInput, View, Text, ScrollView } from "react-native";
import Insert from "./ReceiptPageComponents/Insert";
import ListCustom from "./ReceiptPageComponents/ListCustom";

export default function ReceiptPage({ navigation }) {
  const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: "#3143e8",
    },
    appTitle: {
      color: "#fff",
      fontSize: 36,
      marginTop: 30,
      marginBottom: 30,
      fontWeight: "300",
      textAlign: "center",
      backgroundColor: "#3143e8",
    },
    card: {
      backgroundColor: "#fff",
      flex: 1,
      borderTopLeftRadius: 10,
      borderTopRightRadius: 10,
      marginLeft: 10,
      marginRight: 10,
    },
    input: {
      padding: 20,
      borderBottomColor: "#bbb",
      borderBottomWidth: 1,
      fontSize: 24,
      marginLeft: 20,
    },
  });

  const [todos, setTodos] = useState([{ id: 1, textValue: "Test" }]);
  const addTodo = (text) => {
    if (text) {
      setTodos([...todos, { id: Math.random().toString(), textValue: text }]);
    }
  };

  const onRemove = (id) => (e) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  };

  return (
    <View style={styles.card}>
      <Insert onAdd={addTodo} />
      <ListCustom todos={todos} onRemove={onRemove} />
    </View>
  );
}
