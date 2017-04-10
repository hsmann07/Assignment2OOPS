/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MANN
 */
public class SelectCarController implements Initializable {
@FXML private TableView<Car> tableView;
private Car car;
  @FXML private TableColumn<Car, String>makeColumn;
  @FXML private TableColumn<Car, String>modelColumn;
  @FXML private TableColumn<Car, Integer>yearColumn;
  @FXML private TableColumn<Car, Integer>priceColumn;
  @FXML private TableColumn<Car, Integer>mileageColumn;
  @FXML private Button showCarDetailsButton;
  @FXML private Button newRegistrationButton;

    public TableView<Car> getTableView() {
        return tableView;
    }
  
  
   /*
    This method is used to register the car information into our database
    */
    public void showCarDetailsButtonPushed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CarView.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        //access the controller and call a method
        CarViewController controller = loader.getController();
        controller.initialize(tableView.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    public void initialize(Car car) {
        this.car = car;
        tableView.setItems(getCars());
    }
    
    
  /**
     * This method will enable the detailed view button once a row in the table is
     * selected
     */
    public void userClickedOnTable()
    {
        this.showCarDetailsButton.setDisable(false);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        makeColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("year"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("price"));
        mileageColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("mileage"));
        
        //load dummy data
        //tableView.setItems(getCars());
        //Disable the detailed person view button until a row is selected
        this.showCarDetailsButton.setDisable(true);
        
    }    
     
    /**
     * This method will return an ObservableList of People objects
     */
    public ObservableList<Car>  getCars()
    {
        ObservableList<Car> cars = FXCollections.observableArrayList();
        cars.add(new Car("Honda","civic",2009,6000,15, new Image("civic.jpg")));
        cars.add(new Car("Honda","Accord",2015,15000,18,new Image("accord.jpg")));
        cars.add(new Car("Nissan","GTR",2014,30000,8,new Image("gtr.jpg")));
        
        cars.add((new Car (car.getMake(), car.getModel(), car.getYear(), car.getPrice(), car.getMileage())));
        
        return cars;
    }
    /**
     * When this method is called, it will change the Scene to 
     * a TableView example
     */
    public void newRegistrationButtonPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("CarRegistration.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
}
