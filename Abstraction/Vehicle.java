abstract class Vehicle {
    String brand;
    int year;

    Vehicle(String b, int y) {
        brand = b;
        year = y;
    }

    abstract void start();

    abstract void stop();

    void display() {
        IO.println(brand + " (" + year + ")");
    }


}

class Car extends Vehicle {
    Car(String b, int y) {
        super(b, y);
    }

    void start() {
        IO.println(" Car starts with key.");
    }

    void stop() {
        IO.println(" Car stops with break. ");
    }

}

class ElectricCar extends Vehicle {
    ElectricCar(String b, int y) {
        super(b, y);
    }

    void start() {
        IO.println(" Electric car start silently");
    }

    void stop() {
        IO.println(" Electric car stops electronically");
    }
}
