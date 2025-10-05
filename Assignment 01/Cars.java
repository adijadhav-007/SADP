interface Car {
    void assemble();
}

interface CarSpecification {
    void showSpecs();
}

class NA_Car implements Car {
    public void assemble() {
        System.out.println("Assembling car for North America.");
    }
}

class NA_Specification implements CarSpecification {
    public void showSpecs() {
        System.out.println("Specs: Left-hand drive, imperial units, emissions compliant with EPA.");
    }
}

class EU_Car implements Car {
    public void assemble() {
        System.out.println("Assembling car for Europe.");
    }
}

class EU_Specification implements CarSpecification {
    public void showSpecs() {
        System.out.println("Specs: Right-hand drive, metric units, EU emissions standard.");
    }
}

interface CarFactory {
    Car createCar();
    CarSpecification createSpecification();
}

class NorthAmericaFactory implements CarFactory {
    public Car createCar() {
        return new NA_Car();
    }

    public CarSpecification createSpecification() {
        return new NA_Specification();
    }
}

class EuropeFactory implements CarFactory {
    public Car createCar() {
        return new EU_Car();
    }

    public CarSpecification createSpecification() {
        return new EU_Specification();
    }
}

public class Cars {
    public static void main(String[] args) {
        CarFactory factory;

        factory = new NorthAmericaFactory();

        Car car = factory.createCar();
        CarSpecification spec = factory.createSpecification();

        car.assemble();
        spec.showSpecs();
    }
}

