package web.service;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car() {
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public static List<Car> getNewCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("kia", "rio", 108));
        carList.add(new Car("bmw", "x5", 205));
        carList.add(new Car("lada", "granta", 74));
        carList.add(new Car("audi", "q5", 230));
        carList.add(new Car("chevrolet", "cruze", 107));
        return carList;
    }

}
