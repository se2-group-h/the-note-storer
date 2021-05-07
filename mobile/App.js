import { StatusBar } from 'expo-status-bar';
import React, {useEffect, useState } from 'react';
import { StyleSheet, Text, TouchableOpacity, View, TextInput, Button  } from 'react-native';
import { createAppContainer } from "react-navigation";
import Navigator from './routes/HomeStack';

export default function App() {


  return (
    <Navigator/>
)};
