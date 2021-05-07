import { StatusBar } from 'expo-status-bar';
import React, {useEffect, useState } from 'react';
import { StyleSheet, Text, TouchableOpacity, View, TextInput, Button  } from 'react-native';
import { styles } from '../styles/styles';

export default function LoginingIn({ navigation }) {

    const pressHandler = () => {
        navigation.navigate('Registration');
    }
  

    return (
        <View style={styles.container}>
            <Text>Here will be the main page</Text>
        </View>
)};