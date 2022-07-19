package application;

import java.util.*;

public class Order {
    Pizza pizza;
    int quantity;
    double price;
    double totalPrice = 0;
    List<Order> orders = new ArrayList<>();


    static Scanner scanner = new Scanner(System.in);

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addToOrder() {
        Order order = new Order();
        pizza = new Pizza();
        int choice;


        System.out.println("CHOOSE YOUR PIZZA");
        System.out.println("1. Margherita");
        System.out.println("2. Hawaii");
        System.out.println("3. Bolognese");

        switch (choice = scanner.nextInt()) {
            case 1:
                pizza.setPizzaType(PizzaType.MARGHERITA);
                break;
            case 2:
                pizza.setPizzaType(PizzaType.HAWAII);
                break;
            case 3:
                pizza.setPizzaType(PizzaType.BOLOGNESE);
                break;
            default:
                return;
        }

        System.out.println("CHOOSE SIZE");
        System.out.println("1. Small");
        System.out.println("2. Large");

        switch (choice = scanner.nextInt()) {
            case 1:
                pizza.setPizzaSize(PizzaSize.SMALL);
                pizza.setPizzaPrice(pizza.getPizzaSize(), pizza.getPizzaType());
                break;
            case 2:
                pizza.setPizzaSize(PizzaSize.LARGE);
                pizza.setPizzaPrice(pizza.getPizzaSize(), pizza.getPizzaType());
                break;
            default:
                return;
        }

        System.out.println("QUANTITY:");
        order.setQuantity(scanner.nextInt());
        order.setPizza(pizza);
        order.setPrice(pizza.getPizzaPrice() * order.getQuantity());
        System.out.println(order.toString());
        orders.add(order);
        totalPrice += order.getPrice();

        System.out.println("ORDER MORE?");
        System.out.println("1. YES");
        System.out.println("2. NO");

        switch (choice = scanner.nextInt()) {
            case 1:
                addToOrder();
                break;
            case 2:
                orders.forEach((n) -> System.out.println(n.toString()));
                System.out.println("Total order price is: " + totalPrice);


            default:
                return;
        }

    }


    @Override
    public String toString() {
        return "Order: | " + pizza.toString() +" | Quantity: " + getQuantity()+
                " | Order Price: " + price;
    }
}
