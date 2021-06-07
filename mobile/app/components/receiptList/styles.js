import { SCREEN_HEIGHT, SCREEN_WIDTH } from "../../globals/constants/screenDimensions";
import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
  container: {
    height: 80,
    width: SCREEN_WIDTH,
    backgroundColor: "white",
    justifyContent: "center",
    padding: 16,
  },
  item: {
    backgroundColor: "#999999",
    padding: 20,
    marginVertical: 5,
    marginHorizontal: 15,
    borderRadius: 7,
  },
  title: {
    fontSize: 18,
    alignSelf: "center",
  },
  deleteBox: {
    backgroundColor: "#f05646",
    justifyContent: "center",
    width: 100,
    paddingLeft: 30,
  },
  editBox: {
    backgroundColor: "#3498db",
    justifyContent: "center",
    width: 100,
    paddingLeft: 30,
  },
  addReceipt: {
    position: "absolute",
    top: SCREEN_HEIGHT - 115,
    left: 25,
    backgroundColor: "#8abd24",
    borderRadius: 50,
    width: 55,
    height: 55,
    alignItems: "center",
    justifyContent: "center",
  },
});

export { styles };
