import React, { useEffect, useState } from "react";
import { SafeAreaView, FlatList, StyleSheet, Dimensions, Text, TouchableOpacity, View, Animated } from "react-native";
import AntDesignIcons from "react-native-vector-icons/AntDesign";
import Swipeable from "react-native-gesture-handler/Swipeable";
import AddNewReceiptScreen from "./addNewReceipt/AddNewReceipt";
import { styles } from "./styles";

export default function ReceiptList({ userInfo }) {
  const [receipts, setReceipts] = useState([
    {
      recipeId: 1,
      creatorId: 1,
      name: "Delicious homemade cookies",
      description: "Directions. Preheat oven to 350 degrees F (175 degrees C)...",
      tag: "homemade",
      rating: 4.4,
      ingredients: [
        {
          ingredientId: 1,
          name: "Cheese",
        },
        {
          ingredientId: 2,
          name: "Cucumber",
        },
      ],
    },
    {
      recipeId: 2,
      creatorId: 2,
      name: "Steak",
      description: "Kill one cow",
      tag: "fast",
      rating: 5,
      ingredients: [
        {
          ingredientId: 1,
          name: "Cheese",
        },
        {
          ingredientId: 2,
          name: "Cucumber",
        },
      ],
    },
  ]);
  const [receiptIdToBeEdited, setReceiptIdToBeEdited] = useState(-1);

  const [isAddReceiptPressed, setIsAddReceiptPressed] = useState(false);

  const deleteItem = (recipeId) => {
    const arr = [...receipts];
    arr.splice(recipeId - 1, 1);
    setReceipts(arr);
  };

  const renderItem = (item, deleteItem) => {
    const leftSwipe = (_, dragX) => {
      const scale = dragX.interpolate({
        inputRange: [0, 100],
        outputRange: [0, 1],
        extrapolate: "clamp",
      });
      return (
        <View style={{ flexDirection: "row" }}>
          <TouchableOpacity style={styles.deleteBox} onPress={() => deleteItem(item.recipeId)}>
            <Animated.Text style={{ transform: [{ scale: scale }] }}>
              <AntDesignIcons name="delete" size={35} color="black" />
            </Animated.Text>
          </TouchableOpacity>
          <TouchableOpacity
            style={styles.editBox}
            onPress={() => {
              setReceiptIdToBeEdited(item.recipeId);
              setIsAddReceiptPressed(true);
            }}
          >
            <Animated.Text style={{ transform: [{ scale: scale }] }}>
              <AntDesignIcons name="edit" size={35} />
            </Animated.Text>
          </TouchableOpacity>
        </View>
      );
    };

    return (
      <Swipeable renderLeftActions={leftSwipe}>
        <View style={styles.container}>
          <Text style={styles.title}>{item.name}</Text>
        </View>
      </Swipeable>
    );
  };

  return isAddReceiptPressed == false ? (
    <SafeAreaView style={{ marginTop: 30 }}>
      <FlatList
        data={receipts}
        keyExtractor={({ recipeId }) => recipeId.toString()}
        renderItem={({ item }) => renderItem(item, deleteItem)}
        ItemSeparatorComponent={() => <View style={{ height: 2, backgroundColor: "black" }} />}
        style={{ borderTopWidth: 2, borderBottomWidth: 2, borderTopColor: "black", borderBottomColor: "black" }}
      />
      <TouchableOpacity style={styles.addReceipt} onPress={() => setIsAddReceiptPressed(true)}>
        <AntDesignIcons name="plus" size={50} color="black" />
      </TouchableOpacity>
    </SafeAreaView>
  ) : (
    <AddNewReceiptScreen
      setIsAddReceiptPressed={setIsAddReceiptPressed}
      setReceipts={setReceipts}
      receipts={receipts}
      loggedUserId={userInfo.Id}
      receiptIdToBeEdited={receiptIdToBeEdited}
      setReceiptIdToBeEdited={setReceiptIdToBeEdited}
    />
  );
}
