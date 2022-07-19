package application;

import java.util.*;

public class Order {
    private Pizza pizza;
    private int quantity;
    private double price;
    private boolean delivery;
    private double deliveryPrice;
    private double totalPrice = 0;
    private List<Order> orders = new ArrayList<>();


    static Scanner scanner = new Scanner(System.in);

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
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

        System.out.println("CHOOSE YOUR PIZZA");
        System.out.println("1. Margherita");
        System.out.println("2. Hawaii");
        System.out.println("3. Bolognese");

        switch (scanner.nextInt()) {
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

        switch (scanner.nextInt()) {
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

        switch (scanner.nextInt()) {
            case 1:
                addToOrder();
                break;
            case 2:

                System.out.println("DELIVERY?");
                System.out.println("1. YES");
                System.out.println("2. NO");

                switch (scanner.nextInt()) {
                    case 1:
                        order.setDelivery(true);
                        order.setDeliveryPrice(20);
                        totalPrice += order.getDeliveryPrice();
                        break;
                    case 2:
                        order.setDelivery(false);
                        order.setDeliveryPrice(0);
                        totalPrice += order.getDeliveryPrice();
                        break;
                    default:
                        return;
                }
                orders.forEach((n) -> System.out.println(n.toString()));
                System.out.println( "Delivery Price: " + order.getDeliveryPrice() + " | Total order price is: " + totalPrice);
                break;
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
