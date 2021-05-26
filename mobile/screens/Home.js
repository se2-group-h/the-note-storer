import { StatusBar } from "expo-status-bar";
import React, { useEffect, useState } from "react";
import {
  SafeAreaView,
  FlatList,
  Modal,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
  TextInput,
  Button,
  ScrollView,
} from "react-native";
import { styles } from "../styles/styles";
import ReceiptPage from "./ReceiptPage";
import ReactPage from "./ReceiptPage";

export default function LoginingIn({ navigation }) {
  const pressHandlerUserProfile = () => {
    navigation.navigate("UserProfilePage");
  };

  const pressHandlerReceiptPage = () => {
    navigation.navigate("ReceiptPage");
  };

  const styles = StyleSheet.create({
    container: {
      flex: 1,
    },
    item: {
      borderBottomWidth: 1,
      borderBottomColor: "grey",
      alignItems: "flex-start",
    },
    text: {
      marginVertical: 30,
      fontSize: 25,
      fontWeight: "bold",
      marginLeft: 10,
    },
    textInput: {
      width: "90",
      height: 70,
      borderColor: "grey",
      borderWidth: 1,
      fontSize: 25,
    },
    modalView: {
      flex: 1,
      alignItems: "center",
      justifyContent: "center",
    },
    touchableSave: {
      backgroundColor: "orange",
      paddingHorizontal: 100,
      alignItems: "center",
      marginTop: 20,
    },
    textColor: {
      color: "#fdfffc",
    },
    button: {
      alignItems: "center",
      backgroundColor: "#011627",
      padding: 10,
      width: 175,
      marginBottom: 15,
    },
    container1: {
      flex: 1,
      backgroundColor: "#fdfffc",
      alignItems: "center",
      justifyContent: "center",
    },
  });

  const Data = [
    { id: 1, text: "Add receipt 1" },
    { id: 2, text: "Add receipt 2" },
    { id: 3, text: "Add receipt 3" },
    { id: 4, text: "Add receipt 4" },
  ];

  const [data, setdata] = useState(Data);
  const [isRender, setisRender] = useState(false);
  const [isModalVisible, setisModelVisible] = useState(false);
  const [inputText, setinputText] = useState();
  const [editItem, seteditItem] = useState();

  const onPressItem = (item) => {
    setisModelVisible(true);
    setinputText(item.text);
    seteditItem(item.id);
  };

  const renderItem = ({ item, index }) => {
    return (
      <TouchableOpacity style={styles.item} onPress={() => onPressItem(item)}>
        <Text style={styles.text}>{item.text}</Text>
      </TouchableOpacity>
    );
  };

  const handleEditItem = (editItem) => {
    const newData = data.map((item) => {
      if (item.id == editItem) {
        item.text = inputText;
        return item;
      }
      return item;
    });
    setdata(newData);
    setisRender(!isRender);
  };

  const onPressSaveEdit = () => {
    handleEditItem(editItem);
    setisModelVisible(false);
  };

  return (
    <SafeAreaView style={styles.container}>
      <ReceiptPage />
      <View style={styles.container1}>
        <TouchableOpacity style={styles.button} onPress={() => pressHandlerUserProfile()}>
          <Text style={styles.textColor}>User Profile</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={() => pressHandlerReceiptPage()}>
          <Text style={styles.textColor}>My Receipts</Text>
        </TouchableOpacity>
      </View>
    </SafeAreaView>
  );
}
