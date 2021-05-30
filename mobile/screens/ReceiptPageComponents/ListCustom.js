import React from "react";
import { StyleSheet, ScrollView, Text } from "react-native";
import ListItemCustom from "./ListItemCustom";

const ListCustom = ({ todos, onRemove }) => {
  return (
    <ScrollView contentContainerStyle={styles.listContainer}>
      {todos.map((todo) => (
        <ListItemCustom key={todo.id} {...todo} onRemove={onRemove} />
      ))}
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  listContainer: {
    alignItems: "center",
  },
});

export default ListCustom;
