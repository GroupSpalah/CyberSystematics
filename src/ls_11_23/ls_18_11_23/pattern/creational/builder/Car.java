package ls_11_23.ls_18_11_23.pattern.creational.builder;

public class Car {
    private String model;
    private int age;
    private String transmission;
    private String manufacturer;

    public Car() {
    }

  /*  public Car(String model, int age) {
        this.model = model;
        this.age = age;
    }

    public Car(int age, String transmission) {
        this.age = age;
        this.transmission = transmission;
    }

    public Car(String model, String transmission) {
        this.model = model;
        this.transmission = transmission;
    }*/

    public void setModel(String model) {
        this.model = model;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", age=" + age +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}

class CarBuilder {
    private Car car;

    public CarBuilder() {
        car = new Car();
    }

    public CarBuilder buildModel(String model) {
        car.setModel(model);
        return this;
    }

    public CarBuilder buildAge(int age) {
        car.setAge(age);
        return this;
    }

    public CarBuilder buildTransmission(String transmission) {
        car.setTransmission(transmission);
        return this;
    }

    public Car build() {
        return car;
    }
}

class TestBuilder {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildAge(30)
                .buildModel("BMW")
                .buildTransmission("AUTO")
                .build();

        Car car1 = new CarBuilder()
                .buildAge(30)
                .buildTransmission("AUTO")
                .build();

        Car car2 = new CarBuilder()
                .buildAge(30)
                .buildModel("BMW")
                .build();
    }
}

