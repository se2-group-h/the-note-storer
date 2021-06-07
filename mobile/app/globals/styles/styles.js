import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fdfffc",
    alignItems: "center",
    justifyContent: "center",
  },
  button: {
    alignItems: "center",
    backgroundColor: "#011627",
    padding: 10,
    width: 175,
    marginBottom: 15,
  },
  invalidButton: {
    backgroundColor: "red",
  },
  textColor: {
    color: "#fdfffc",
  },
  textInput: {
    height: 40,
    borderColor: "grey",
    borderBottomWidth: StyleSheet.hairlineWidth,
    marginBottom: 15,
    width: 175,
    textAlign: "center",
  },
  button: {
    alignItems: "center",
    backgroundColor: "#011627",
    padding: 10,
    width: 175,
    marginBottom: 15,
  },
  textColor: {
    color: "#fdfffc",
  },
  welcome: {
    fontSize: 25,
    marginBottom: 25,
  },
  item: {
    padding: 10,
    fontSize: 18,
    height: 44,
  },
  users: {
    fontSize: 30,
    borderWidth: 1,
    borderColor: "#cecece",
    padding: 10,
    marginBottom: 20,
  },
  userprofile: {
    fontSize: 25,
    borderWidth: 1,
    borderColor: "#cecece",
    padding: 30,
    marginBottom: 20,
  },
});

export { styles };
