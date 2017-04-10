/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MANN
 */
public class CarRegistrationController implements Initializable {
  
    @FXML private TextField make ;
    @FXML private TextField model ;
    @FXML private TextField year ;
    @FXML private TextField price ;
    @FXML private TextField mileage ;
    @FXML private Button register;
    @FXML private Label warningLabel;
    
    @FXML private Button addCarButton;
    /**
     * Initializes the controller class.
     */
    /*
    This method is used to register the car information into our database
    */
    public void registerButtonPushed(ActionEvent event) throws IOException
    {
         Car car = addButtonPushed();
         
         FXMLLoader loader=  new FXMLLoader();
         loader.setLocation(getClass().getResource("SelectCar.fxml"));
         Scene tableViewScene = new Scene(loader.load());
         
         SelectCarController controller= loader.getController();
         controller.initialize(car);
         
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        this.warningLabel.setText("");
        
    }    
    
    /**
     * This method will create a new Car object and add it to the table
     */
    public Car addButtonPushed()
    {
        try {
        Car car =  new Car(make.getText(),
                                      model.getText(),
                                      Integer.parseInt(year.getText()),
                                        Integer.parseInt(price.getText()),
                Integer.parseInt(mileage.getText()));
   return car;
        } catch (IllegalArgumentException e) {
        warningLabel.setText(e.getMessage());
    }
        return null;
    }
}
