import { StatusBar } from 'expo-status-bar';
import React, {useEffect, useState } from 'react';
import { StyleSheet, Text, TouchableOpacity, View, TextInput, Button  } from 'react-native';
import ComponentName from './ComponentName';

export default function App() {

  const [isPressed, setIdPressed] = useState(false);
  const [text, setText] = useState('');

  useEffect(() => {
      fetch('https://jsonplaceholder.typicode.com/todos/1')
      .then(resp => resp.json())
      .then(json => setText(JSON.stringify(json)));
  });

  return (
    <View style={styles.container}>
      <TextInput placeholder="Login" maxLength={15}/>
      <TextInput placeholder="Password" maxLength={15}/>
      <View style={{backgroundColor:"yellow", width:15}}>
        <Button title="Log in"/>
      </View>
      <Button title="Register"/>
      <Text backgroundColor="green">Zdarova!</Text>
      <StatusBar style="auto" />
      <TouchableOpacity onPress={() => setIdPressed(!isPressed)}> 
      <Text>Press me</Text>
      </TouchableOpacity>
      {/* {
        isPressed && <Text>{text ?? "null"}</Text>
      } */}
      {/* <Text>{text}</Text> */}
      <Text>{isPressed.toString()}</Text>
      <ComponentName isPressed={isPressed}/>
    </View>
  )};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
