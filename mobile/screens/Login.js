import React, {useEffect, useState } from 'react';
import { Text, TouchableOpacity, View, TextInput  } from 'react-native';
import { styles } from '../styles/styles';

export default function LoginingIn({ navigation }) {

    const pressHandlerRegister = () => {
        navigation.navigate('CreateAccount');
    }
  
    const pressHandlerLogIn = () => {
        navigation.navigate('Home');
    }
  

    return (
        <View style={styles.container}>
          <Text style={styles.welcome}>Welcome!</Text>
          <TextInput placeholder="Login"
                     maxLength={15}
                     textAlign='center'
                     style={styles.textInput}
                     />
          <TextInput placeholder="Password"
                     maxLength={15}
                     secureTextEntry={true}
                     textAlign='center'
                     style={styles.textInput}
                     />
          <View>
            <TouchableOpacity style={styles.button}
                              onPress={pressHandlerLogIn}>
              <Text style={styles.textColor}>Log in</Text>
            </TouchableOpacity>
            <TouchableOpacity style={styles.button} 
                              onPress={pressHandlerRegister}>
              <Text style={styles.textColor}>Create Account</Text>
            </TouchableOpacity>
          </View>
        </View>
)};