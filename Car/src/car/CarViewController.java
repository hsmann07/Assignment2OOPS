/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Formatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MANN
 */
public class CarViewController implements Initializable {
    private Car car;
@FXML private Label makeLabel;
    @FXML private Label modelLabel;    
    @FXML private Label yearLabel;
    @FXML private Label priceLabel;
    @FXML private ImageView photo;
    @FXML private Button checkAnotherCarButton;
    @FXML private Button fileInformation;
 
    public void initialize(Car car) {
        this.car = car;
        makeLabel.setText(car.getMake());
        modelLabel.setText(car.getModel());
        yearLabel.setText(Integer.toString(car.getYear()));
        priceLabel.setText(Integer.toString(car.getPrice()));
        photo.setImage(car.getPhoto());
    }
    
    
        /**
     * When this method is called, it will change the Scene to 
     * a TableView example
     */
    public void checkAnotherCarButtonPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SelectCar.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    public void sendToFileInformationButton(){
        try {
            Formatter formatter = new Formatter (new File("assign.txt"));
          
            formatter.format(String.format("%s", car.toString()));
            formatter.close();
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(CarViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
