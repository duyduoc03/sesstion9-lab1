package sesstion9.lab1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static ObservableList<Phone> PhoneList = FXCollections.observableArrayList();
    public static Stage rootStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
        primaryStage.setTitle("Quản lý danh bạ điện thoại");
        primaryStage.setScene(new Scene(root, 650, 520));
        primaryStage.show();
    }


    public static void main(String[] args) {
        PhoneList.add(new Phone("Duy Duoc","099999999"));
        PhoneList.add(new Phone("A B C","0142522852"));
        launch(args);
    }

}
