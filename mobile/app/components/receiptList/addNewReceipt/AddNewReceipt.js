import React, { useState } from "react";
import { Text, TouchableOpacity, View, TextInput, Alert } from "react-native";
import { styles } from "../../../globals/styles/styles";
import { BASE_URL, CREATE_ACCOUNT } from "../../../globals/constants/url";

export default function AddNewReceipt({
  setIsAddReceiptPressed,
  setReceipts,
  receipts,
  loggedUserId,
  receiptIdToBeEdited,
  setReceiptIdToBeEdited,
}) {
  const [newReceipt, setNewReceipt] = useState(
    receiptIdToBeEdited == -1
      ? {
          recipeId: receipts.length + 1,
          creatorId: loggedUserId,
          name: "",
          description: "",
          tag: "",
          rating: 0,
          ingredients: [],
        }
      : receipts.find((element) => element.recipeId == receiptIdToBeEdited)
  );

  const createAlert = (message) => Alert.alert(message, "Please try again", [{ text: "OK" }]);

  const pressHandlerCancel = () => {
    setReceiptIdToBeEdited(-1);
    setIsAddReceiptPressed(false);
  };

  const pressHandlerEditReceipt = () => {
    if (newReceipt.name.length != 0) {
      receipts.find((e) => e.recipeId === receiptIdToBeEdited).name = newReceipt.name;
      receipts.find((e) => e.recipeId === receiptIdToBeEdited).description = newReceipt.description;
      receipts.find((e) => e.recipeId === receiptIdToBeEdited).tag = newReceipt.tag;
      receipts.find((e) => e.recipeId === receiptIdToBeEdited).rating = newReceipt.rating;
      setReceipts([...receipts]);
      setIsAddReceiptPressed(false);
    } else {
      createAlert("Receipt must have a name");
    }
    setReceiptIdToBeEdited(-1);
  };

  const pressHandlerAddReceipt = () => {
    if (newReceipt.name.length != 0) {
      receipts = [...receipts, newReceipt];
      setReceipts(receipts);
      setIsAddReceiptPressed(false);
    } else {
      createAlert("Receipt must have a name");
    }
    setReceiptIdToBeEdited(-1);
    /*fetch(BAS_EURL + CREATE_ACCOUNT, {
      method: "POST", // *GET, POST, PUT, DELETE, etc.
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newUser),
    })
      .then((e) => {
        if (e.status != 201) {
          e.text().then((e) => createAlert(e));
        } else {
          setCreateAccountPressed(false);
        }
      })
      .catch((e) => {
        console.log(e.status);
        createAlert("Something went wrong");
      });*/
  };
  return (
    <View style={styles.container}>
      <TextInput
        placeholder="Name"
        style={styles.textInput}
        value={newReceipt.name}
        onChangeText={(val) => setNewReceipt({ ...newReceipt, name: val })}
      />
      <TextInput
        placeholder="Description"
        style={styles.textInput}
        value={newReceipt.description}
        onChangeText={(val) => setNewReceipt({ ...newReceipt, description: val })}
      />
      <TextInput
        placeholder="Tag"
        style={styles.textInput}
        value={newReceipt.tag}
        onChangeText={(val) => setNewReceipt({ ...newReceipt, tag: val })}
      />
      <TextInput
        placeholder="Rating"
        style={styles.textInput}
        value={newReceipt.rating.toString()}
        onChangeText={(val) => setNewReceipt({ ...newReceipt, rating: val })}
      />
      <TextInput placeholder="Ingredients" style={styles.textInput} editable={false} value="disabled" />
      {receiptIdToBeEdited == -1 ? (
        <TouchableOpacity style={styles.button} onPress={pressHandlerAddReceipt}>
          <Text style={styles.textColor}>Add Receipt</Text>
        </TouchableOpacity>
      ) : (
        <TouchableOpacity style={styles.button} onPress={pressHandlerEditReceipt}>
          <Text style={styles.textColor}>Edit Receipt</Text>
        </TouchableOpacity>
      )}
      <TouchableOpacity style={styles.button} onPress={pressHandlerCancel}>
        <Text style={styles.textColor}>Cancel</Text>
      </TouchableOpacity>
    </View>
  );
}
