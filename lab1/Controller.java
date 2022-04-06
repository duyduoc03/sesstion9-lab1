package sesstion9.lab1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    public Text result;
    public Text errMsg;
    public TextField Ten;
    public TextField SDT;
    public Phone phone;

    public void setData(Phone phone) {
        this.phone = phone;

        Ten.setText(phone.getTen());
        SDT.setText(phone.getSDT().toString());
    }
    public void submit(){
        try {
            Phone p = new Phone(Ten.getText(),SDT.getText());
            result.setText(result.getText()+p.toString());
            if (this.phone == null){
                sesstion9.lab1.Main.PhoneList.add(p);
            }
            else {
                int i = sesstion9.lab1.Main.PhoneList.indexOf(this.phone);
                sesstion9.lab1.Main.PhoneList.set(i,p);
            }
            renderList();
            errMsg.setVisible(false);
            Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
            sesstion9.lab1.Main.rootStage.setScene(new Scene(root,650,520));
        }
        catch (Exception e){
            errMsg.setText(e.getMessage());
            errMsg.setVisible(true);
        }
    }
    public void renderList(){
        Ten.setText("");
        SDT.setText("");;
    }
}

