interface Workshop {
    void work();
}

class Produce implements Workshop {
    public void work() {
        System.out.print("Produced");
    }
}

class Assemble implements Workshop {
    public void work() {
        System.out.println(" and Assembled.");
    }
}

abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    protected Vehicle(Workshop w1, Workshop w2) {
        this.workshop1 = w1;
        this.workshop2 = w2;
    }

    abstract void manufacture();
}

class Car extends Vehicle {
    public Car(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    public void manufacture() {
        System.out.print("Car ");
        workshop1.work();
        System.out.print(" ");
        workshop2.work();
    }
}

class Bike extends Vehicle {
    public Bike(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    public void manufacture() {
        System.out.print("Bike ");
        workshop1.work();
        System.out.print(" ");
        workshop2.work();
    }
}

public class BridgePatternDemo {
    public static void main(String[] args) {
        Vehicle car = new Car(new Produce(), new Assemble());
        car.manufacture();

        Vehicle bike = new Bike(new Produce(), new Assemble());
        bike.manufacture();
    }
}

