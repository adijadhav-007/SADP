import java.util.ArrayList;
import java.util.Iterator;

class MenuItem {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;
    
    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public boolean isVegetarian() {
        return vegetarian;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return (name + ", $" + price + " -- " + description + (vegetarian ? " (Vegetarian)" : ""));
    }
}

interface Menu {
    Iterator<MenuItem> createIterator();
}

class BreakfastMenu implements Menu {
    private ArrayList<MenuItem> menuItems;
    
    public BreakfastMenu() {
        menuItems = new ArrayList<>();
        addItem("Pancakes", "Fluffy pancakes with syrup", true, 3.99);
        addItem("Waffles", "Waffles with blueberries", true, 4.99);
        addItem("Bacon and Eggs", "Bacon with scrambled eggs", false, 5.99);
    }
    
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        menuItems.add(item);
    }
    
    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}

class LunchMenu implements Menu {
    private ArrayList<MenuItem> menuItems;
    
    public LunchMenu() {
        menuItems = new ArrayList<>();
        addItem("Veggie Burger", "Burger with lettuce, tomato, and fries", true, 7.99);
        addItem("Chicken Sandwich", "Grilled chicken sandwich", false, 8.99);
        addItem("Soup of the day", "Daily soup special", true, 4.99);
    }
    
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        menuItems.add(item);
    }
    
    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}

class DinnerMenu implements Menu {
    private ArrayList<MenuItem> menuItems;
    
    public DinnerMenu() {
        menuItems = new ArrayList<>();
        addItem("Spaghetti", "Spaghetti with marinara sauce", true, 8.99);
        addItem("Steak", "Grilled sirloin steak", false, 14.99);
        addItem("Salad", "Mixed greens with vinaigrette", true, 6.99);
    }
    
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        menuItems.add(item);
    }
    
    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}

class Waitress {
    private Menu breakfastMenu;
    private Menu lunchMenu;
    private Menu dinnerMenu;
    
    public Waitress(Menu breakfastMenu, Menu lunchMenu, Menu dinnerMenu) {
        this.breakfastMenu = breakfastMenu;
        this.lunchMenu = lunchMenu;
        this.dinnerMenu = dinnerMenu;
    }
    
    public void printMenu() {
        System.out.println("BREAKFAST MENU");
        printMenu(breakfastMenu.createIterator());
        System.out.println("\nLUNCH MENU");
        printMenu(lunchMenu.createIterator());
        System.out.println("\nDINNER MENU");
        printMenu(dinnerMenu.createIterator());
    }
    
    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.println(item);
        }
    }
}

public class MenuTest {
    public static void main(String[] args) {
        Menu breakfastMenu = new BreakfastMenu();
        Menu lunchMenu = new LunchMenu();
        Menu dinnerMenu = new DinnerMenu();
        
        Waitress waitress = new Waitress(breakfastMenu, lunchMenu, dinnerMenu);
        waitress.printMenu();
    }
}
