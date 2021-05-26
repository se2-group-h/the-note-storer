import React, {useEffect, useState } from 'react';
import { Text, TouchableOpacity, View, TextInput  } from 'react-native';
import { styles } from '../styles/styles';



export default function UserSettingsView({ navigation }){ 


const pressHandlerUserProfile = () => {
    navigation.navigate('UserProfilePage');
}
    
 
    return (
        <View style={styles.container}>
        <TextInput placeholder='Change Name'
                   style={styles.textInput}/>
        <TextInput placeholder='Change Surname'
                   style={styles.textInput}/>
        <TextInput placeholder='Change Username'
                   style={styles.textInput}/>
        <TextInput placeholder='Change E-mail'
                   style={styles.textInput}/>
       
        <TextInput placeholder='Change Password'
                   secureTextEntry={true}
                   style={styles.textInput}/>
        <TextInput placeholder='Confirm Password'
                   secureTextEntry={true}
                   style={styles.textInput}/>
        <TouchableOpacity style={styles.button} onPress={() => pressHandlerUserProfile()}>
   <Text style={styles.textColor}>
  Confirm changes
   </Text>
 </TouchableOpacity>
    </View>
    );
  
}

