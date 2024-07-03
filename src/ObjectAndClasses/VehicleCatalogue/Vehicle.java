package ObjectAndClasses.VehicleCatalogue;

import java.util.List;
import java.util.ArrayList;

public class Vehicle {

    private String type, model, color;
    private short horsePower;

    public Vehicle(String type, String model, String color, short horsePower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public short getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(short horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {

        String vehicleType = this.type.equals("car") ? "Car" : "Truck";
        return "Type: " + vehicleType + "\n" +
                "Model: " + model + "\n" +
                "Color: " + color + "\n" +
                "Horsepower: " + horsePower;
    }
}
