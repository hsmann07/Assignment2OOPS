/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import javafx.scene.image.Image;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author MANN
 */
public class CarTest {
    private Car car;
  
   
    
    public CarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         Car car = new Car("Honda", "civic",1998,5000,15);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMake method, of class Car.
     */
    @Test
    public void testGetMake() {
        System.out.println("getMake");
        assertEquals("Honda", car.getMake());
    }

    /**
     * Test of setMake method, of class Car.
     */
    @Test
    public void testSetMake() {
      
        String make = "Honda";
        String expResult = make;
        car.setMake(make);
        String result = car.getMake();
        assertEquals(expResult, result);
     /*enerated test code and remove the default call to fail.*/
       
    }

    /**
     * Test of getModel method, of class Car.
     */
    @Test
    public void testGetModel() {
       System.out.println("getMake");
        assertEquals("civic", car.getModel());System.out.println("getModel");
        assertEquals("civic", car.getModel());
    }

    /**
     * Test of setModel method, of class Car.
     */
    @Test
    public void testSetModel() {
       
        String model = "civic";
        String expResult = model;
        car.setModel(model);
        String result = car.getModel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Car.
     */
    @Test
    public void testGetYear() {
        assertEquals(1998, car.getYear());
    }

    /**
     * Test of setYear method, of class Car.
     */
    @Test
    public void testSetYear() {
        int year = 1998;
        try
        {
            car.setYear(year);
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("setYear  thrown an exception -> \"%d\"%n",e.getMessage());
        }
    }

    /**
     * Test of getPrice method, of class Car.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        assertEquals(5000, car.getPrice());
    }

    /**
     * Test of setPrice method, of class Car.
     */
    @Test
    public void testSetPrice() {
       int price = 5000;
        try
        {
            car.setPrice(price);
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("setPrice  thrown an exception -> \"%d\"%n",e.getMessage());
        }
    }

    /**
     * Test of getMileage method, of class Car.
     */
    @Test
    public void testGetMileage() {
       System.out.println("getMileage");
        assertEquals(15, car.getMileage());
    }

    /**
     * Test of setMileage method, of class Car.
     */
    @Test
    public void testSetMileage() {
       int mileage = 15;
        try
        {
            car.setMileage(mileage);
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("setMileage  thrown an exception -> \"%d\"%n",e.getMessage());
        }
    }

    /**
     * Test of toString method, of class Car.
     */
    @Test
    public void testToString() {
       System.out.println("toString");
        assertEquals("civic by Honda manufacruted in 1998.Its price is 5000 Giving out the mileage of 15", car.toString());
    }
    
}
