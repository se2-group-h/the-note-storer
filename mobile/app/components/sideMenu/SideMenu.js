import React from "react";
import { View, StyleSheet } from "react-native";
import { useTheme, Avatar, Title, Caption, Paragraph, Drawer, Text, TouchableRipple, Switch } from "react-native-paper";
import { DrawerContentScrollView, DrawerItem } from "@react-navigation/drawer";

import Icon from "react-native-vector-icons/MaterialCommunityIcons";
import IconSettings from "react-native-vector-icons/Ionicons";
import { styles } from "./styles";

export default function SideMenu(props) {
  const paperTheme = useTheme();

  return (
    <View style={{ flex: 1 }}>
      <DrawerContentScrollView {...props}>
        <View style={styles.drawerContent}>
          <View style={styles.userInfoSection}>
            <View style={{ flexDirection: "row", marginTop: 15 }}>
              <Avatar.Image
                source={{
                  uri: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMuKfDVNswR-qDTGIJgrd46dZdcSNfZ5p-Yg&usqp=CAU",
                }}
                size={50}
              />
              <View style={{ marginLeft: 15, flexDirection: "column" }}>
                <Title style={styles.title}>{props.username}</Title>
              </View>
            </View>

            <View style={styles.row}>
              <View style={styles.section}>
                <Paragraph style={[styles.paragraph, styles.caption]}>0</Paragraph>
                <Caption style={styles.caption}>Following</Caption>
              </View>
              <View style={styles.section}>
                <Paragraph style={[styles.paragraph, styles.caption]}>0</Paragraph>
                <Caption style={styles.caption}>Followers</Caption>
              </View>
            </View>
          </View>

          <Drawer.Section style={styles.drawerSection}>
            <DrawerItem
              icon={({ color, size }) => <Icon name="home" color={color} size={size} />}
              label="Home"
              onPress={() => {
                props.navigation.navigate("Temporary");
              }}
            />
            <DrawerItem
              icon={({ color, size }) => <Icon name="receipt" color={color} size={size} />}
              label="Receipts"
              onPress={() => {
                props.navigation.navigate("Receipts", { userInfo: props.userInfo });
              }}
            />
            <DrawerItem
              icon={({ color, size }) => <Icon name="bookmark" color={color} size={size} />}
              label="Bookmarks"
              onPress={() => {
                props.navigation.navigate("Temporary");
              }}
            />
            <DrawerItem
              icon={({ color, size }) => <IconSettings name="settings" color={color} size={size} />}
              label="Settings"
              onPress={() => {
                props.navigation.navigate("Edit Profile");
              }}
            />
            <DrawerItem
              icon={({ color, size }) => <Icon name="account-check" color={color} size={size} />}
              label="Support"
              onPress={() => {
                props.navigation.navigate("Temporary");
              }}
            />
          </Drawer.Section>
          <Drawer.Section title="Preferences">
            <TouchableRipple>
              <View style={styles.preference}>
                <Text>Dark Theme</Text>
                <View pointerEvents="none">
                  <Switch value={paperTheme.dark} />
                </View>
              </View>
            </TouchableRipple>
          </Drawer.Section>
        </View>
      </DrawerContentScrollView>
      <Drawer.Section style={styles.bottomDrawerSection}>
        <DrawerItem
          icon={({ color, size }) => <Icon name="exit-to-app" color={color} size={size} />}
          label="Sign Out"
          onPress={() => {
            props.setIsLoggedIn(false);
            props.setUsername("");
            props.setPassword("");
          }}
        />
      </Drawer.Section>
    </View>
  );
}
