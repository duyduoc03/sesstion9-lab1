package sesstion9.lab1;

import javafx.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Listcontroller implements Initializable {
    public TableView<Phone> tbView;
    public TableColumn<Phone, String> cTen;
    public TableColumn<Phone, String>  cSdt;
    public TableColumn<Phone, Button>  cEdit;
    public TableColumn<Phone, Button>  cDelete;
    public TextField txtSearch;
    public void Search(){
        String s = txtSearch.getText();
        List<Phone> kq = Main.PhoneList.stream()
                .filter(p -> p.getTen().startsWith(s) || p.getSDT().startsWith(s))
                .collect(Collectors.toList());
        ObservableList result = FXCollections.observableArrayList();
        result.addAll(kq);
        tbView.setItems(result);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cTen.setCellValueFactory(new PropertyValueFactory<Phone,String>("Ten"));
        cSdt.setCellValueFactory(new PropertyValueFactory<Phone,String>("SDT"));
        cEdit.setCellValueFactory(new PropertyValueFactory<Phone,Button>("edit"));
        cDelete.setCellValueFactory(new PropertyValueFactory<Phone,Button>("delete"));
        tbView.setItems(Main.PhoneList);
    }
    public void formScreen() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
        sesstion9.lab1.Main.rootStage.setScene(new Scene(root,800,600));
    }
}

