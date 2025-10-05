import java.util.Scanner;

public class PizzaFactoryDemo {
    static abstract class Pizza {
        String name;

        public void prepare() {
            System.out.println("Preparing " + name);
        }

        public void bake() {
            System.out.println("Baking " + name);
        }

        public void cut() {
            System.out.println("Cutting " + name);
        }

        public void box() {
            System.out.println("Boxing " + name);
        }

        public String getName() {
            return name;
        }
    }

    static class NYStyleCheesePizza extends Pizza {
        public NYStyleCheesePizza() {
            name = "NY Style Cheese Pizza";
        }
    }


    static class ChicagoStyleCheesePizza extends Pizza {
        public ChicagoStyleCheesePizza() {
            name = "Chicago Style Cheese Pizza";
        }

        @Override
        public void cut() {
            System.out.println("Cutting " + name + " into square slices");
        }
    }

    static class NYStylePepperoniPizza extends Pizza {
        public NYStylePepperoniPizza() {
            name = "NY Style Pepperoni Pizza";
        }
    }

    static class ChicagoStylePepperoniPizza extends Pizza {
        public ChicagoStylePepperoniPizza() {
            name = "Chicago Style Pepperoni Pizza";
        }

        @Override
        public void cut() {
            System.out.println("Cutting " + name + " into square slices");
        }
    }

    static abstract class PizzaStore {
        public Pizza orderPizza(String type) {
            Pizza pizza = createPizza(type);

            if (pizza == null) {
                System.out.println("Sorry, that type of pizza is unavailable.");
                return null;
            }

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

            return pizza;
        }

        protected abstract Pizza createPizza(String type);
    }

    static class NYPizzaStore extends PizzaStore {
        @Override
        protected Pizza createPizza(String type) {
            if (type.equalsIgnoreCase("cheese")) {
                return new NYStyleCheesePizza();
            } else if (type.equalsIgnoreCase("pepperoni")) {
                return new NYStylePepperoniPizza();
            }
            return null;
        }
    }

    static class ChicagoPizzaStore extends PizzaStore {
        @Override
        protected Pizza createPizza(String type) {
            if (type.equalsIgnoreCase("cheese")) {
                return new ChicagoStyleCheesePizza();
            } else if (type.equalsIgnoreCase("pepperoni")) {
                return new ChicagoStylePepperoniPizza();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Pizza Store!");
        System.out.println("Available Store Locations: NY, Chicago");
        System.out.print("Enter the store location: ");
        String storeLocation = scanner.nextLine();

        PizzaStore store = null;
        if (storeLocation.equalsIgnoreCase("NY")) {
            store = new NYPizzaStore();
        } else if (storeLocation.equalsIgnoreCase("Chicago")) {
            store = new ChicagoPizzaStore();
        } else {
            System.out.println("Sorry, we do not have a store at that location.");
            scanner.close();
            return;
        }

        System.out.println("Available Pizza Types: Cheese, Pepperoni");
        System.out.print("Enter pizza type: ");
        String pizzaType = scanner.nextLine();

        System.out.println("\nProcessing your order...\n");
        Pizza pizza = store.orderPizza(pizzaType);

        if (pizza != null) {
            System.out.println("\nYour " + pizza.getName() + " is ready for delivery!");
            System.out.println("Thank you for your order.");
        }

        scanner.close();
    }
}

