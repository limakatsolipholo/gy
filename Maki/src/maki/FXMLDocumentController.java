
package maki;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
     ObservableList<String> Car = FXCollections.observableArrayList("BMW", "D4D", "BENNS", "MINI COOPER", "HONDA FIT");
    @FXML
    private TextField NumPlate;
    @FXML
    private TextField EngNum;
    @FXML
    private TextField YearOfManu;
    @FXML
    private TextField OdNum;
    @FXML
    private TextArea NumPlateArea;
    @FXML
    private TextArea CarMod;
    @FXML
    private TextArea EngNumArea;
    @FXML
    private TextArea YearOfManuArea;
    @FXML
    private TextArea  OdNumArea;
    @FXML
    private Button Insert;
    @FXML
    private ComboBox<String> CarsList;
    @FXML
    private Button EXIT;
    @FXML
    private void Insertion(ActionEvent event) throws IOException{
      File myFile= new File("Lipholo.txt"); 
      myFile.createNewFile();
      try
          (FileWriter write = new FileWriter("Lipholo.txt",true)){
      try{
       String num = NumPlate.getText();
       String num1 = EngNum.getText();
       String num2 = OdNum.getText();
       
       int num3 = Integer.parseInt(YearOfManu.getText());
       if(NumPlate.getText().isEmpty()&& EngNum.getText().isEmpty()&&
        YearOfManu.getText().isEmpty()&& OdNum.getText().isEmpty()){ 
           System.out.println("BBBBBBBBBBBB");
       }
       else {
           NumPlateArea.appendText("" +num+"\n");
           EngNumArea.appendText("" +num1+"\n");
           YearOfManuArea.appendText("" +num3+"\n");
           OdNumArea.appendText("" +num2+"\n");
           Cars();
       }
       NumPlate.setText(null);
       YearOfManu.setText(null);
       EngNum.setText(null);
       OdNum.setText(null);
       CarsList.setValue(null);
       
       write.write("NumPlate is "+num+"\n");
       write.write("EngNumArea is "+num1+"\n");
       write.write("YearOfManu "+num3+"\n");
       write.write("OdoMeter Num "+num2+"\n");
    }
      catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("PLEASE ENTER INTERGERS ONLY!!");
        if(alert.showAndWait().get()==ButtonType.OK);
    }
    }
    }
    public void Cars(){
        if("BMW".equals(CarsList.getValue())){
          CarMod.appendText("BMW"+"\n"); 
        }
        else if("D4D".equals(CarsList.getValue())){
          CarMod.appendText("D4D"+"\n");  
        }
        else if("BENNS".equals(CarsList.getValue())){
          CarMod.appendText("BENNS"+"\n");  
        }
        else if("MINI COOPER".equals(CarsList.getValue())){
          CarMod.appendText("MINI COOPER"+"\n");  
        }
        else if("HONDA FIT".equals(CarsList.getValue())){
          CarMod.appendText("HONDA FIT"+"\n");  
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         CarsList.setItems(Car);
    }    

    @FXML
    private void EXITT(ActionEvent event) {
         System.exit(0); 
    }
    
}
