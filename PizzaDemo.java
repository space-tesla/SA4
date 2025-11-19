// Base Pizza class
abstract class Pizza {
    String name;

    void prepare() {
        System.out.println("Preparing " + name);
    }

    void bake() {
        System.out.println("Baking " + name);
    }

    void cut() {
        System.out.println("Cutting " + name);
    }

    void box() {
        System.out.println("Boxing " + name);
    }

    public String getName() {
        return name;
    }
}

// Concrete Pizza Types
class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Cheese Pizza";
    }
}

class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
    }
}

// Creator Class with Factory Method
abstract class PizzaStore {

    // Factory Method
    abstract Pizza createPizza(String type);

    // Ordering process
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

// Concrete Creator Classes
class NYStylePizzaStore extends PizzaStore {
    Pizza createPizza(String type) {
        if (type.equalsIgnoreCase("cheese")) {
            return new NYStyleCheesePizza();
        }
        return null;
    }
}

class ChicagoStylePizzaStore extends PizzaStore {
    Pizza createPizza(String type) {
        if (type.equalsIgnoreCase("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}

// Demo
public class PizzaDemo {
    public static void main(String[] args) {

        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        System.out.println("---- Ordering NY Style Pizza ----");
        nyStore.orderPizza("cheese");

        System.out.println("\n---- Ordering Chicago Style Pizza ----");
        chicagoStore.orderPizza("cheese");
    }
}
