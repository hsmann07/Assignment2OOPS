/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author MANN
 */
// initialize the instance variable
public class Car {
      private SimpleStringProperty make, model;
      private int year;
     private int price;
     private int mileage;
     private Image photo;
// constructor is called
    public Car(String make, String model, int year, int price, int mileage) {
        this.make = new SimpleStringProperty(make);
        this.model = new SimpleStringProperty(model);
        //this.year = year;
        setYear(year);
        setPrice(price);
        setMileage(mileage);
        photo = new Image("defaultImage.png");
    }
// 
    public Car(String make, String model, int year, int price, int mileage, Image photo) {
        this.make = new SimpleStringProperty(make);
        this.model = new SimpleStringProperty(model);
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.photo = photo;
    }

    public String getMake() {
        return make.get();
    }

    public void setMake(String make) {
      this.make = new SimpleStringProperty(make);
    }

    public String getModel() {
        return model.get();
    }

    public void setModel(String model) {
        this.model = new SimpleStringProperty(model);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
       if(year>1990) 
           this.year = year;
       else throw new IllegalArgumentException("Year must be greater than 1990.");
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price>0)
            this.price = price;
        else throw new IllegalArgumentException("Price must be greater than 0.");
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if(mileage>0)
            this.mileage = mileage;
        else throw new IllegalArgumentException("Mileage must be greater than 0.");
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
 public String toString()
    {
        return model.get() + " by "+ make.get() +" manufacruted in "+ year + ".Its price is "+ price+" Giving out the mileage of "+ mileage;
    }

     
}

