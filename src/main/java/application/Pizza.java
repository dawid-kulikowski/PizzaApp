package application;

public class Pizza {
    PizzaType pizzaType;
    PizzaSize pizzaSize;
    double pizzaPrice;

    public void setPizzaPrice(PizzaSize pizzaSize, PizzaType pizzaType) {
        if (pizzaSize == PizzaSize.SMALL) {
            this.pizzaPrice = pizzaType.getSmallPrice();
        } else {
            this.pizzaPrice = pizzaType.getLargePrice();
        }
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }


    @Override
    public String toString() {
        return "Pizza Type: " + pizzaType + " | Size: " + pizzaSize +
                " | Price: " + pizzaPrice;
    }
}










