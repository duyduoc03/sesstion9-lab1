package sesstion9.lab1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public final class Phone {
    public String Ten;
    public String SDT;
    public Button edit;
    public Button delete;

    public Phone(String Ten, String SDT){
        this.Ten = Ten;
        this.SDT = SDT;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("form.fxml"));
                Parent root = loader.load();
                Controller d = loader.getController();
                d.setData(this);
                sesstion9.lab1.Main.rootStage.setScene(new Scene(root,800,600));
            }
            catch (Exception e){

            }
        });
        this.delete = new Button("Delete");
        this.delete.setOnAction(event -> {
            Main.PhoneList.remove(this);
        });
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public String toString(){
        String s = "\n---------------------";
        s += "\n" + Ten;
        s += "\n" + SDT;
        return s;
    }
}

