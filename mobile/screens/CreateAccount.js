import React, {useEffect, useState } from 'react';
import { Text, TouchableOpacity, View, TextInput  } from 'react-native';
import { styles } from '../styles/styles';

export default function LoginingIn({ navigation }) {  

    return (
        <View style={styles.container}>
            <TextInput placeholder='Name'
                       style={styles.textInput}/>
            <TextInput placeholder='Surname'
                       style={styles.textInput}/>
            <TextInput placeholder='Username'
                       style={styles.textInput}/>
            <TextInput placeholder='E-mail'
                       style={styles.textInput}/>
            <TextInput placeholder='Repeat E-mail'
                       style={styles.textInput}/>
            <TextInput placeholder='Password'
                       secureTextEntry={true}
                       style={styles.textInput}/>
            <TextInput placeholder='Repeat Password'
                       secureTextEntry={true}
                       style={styles.textInput}/>
            <TouchableOpacity style={styles.button}>
              <Text style={styles.textColor}>
                Create Account
              </Text>
            </TouchableOpacity>
        </View>
)};


