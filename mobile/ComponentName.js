import React from 'react';
import { StyleSheet, Text, TouchableOpacity, View, TextInput, Button  } from 'react-native';

export default function ComponentName({isPressed}) {
    return        <Text>{isPressed.toString()}: FROM COMPONENT</Text>;
}