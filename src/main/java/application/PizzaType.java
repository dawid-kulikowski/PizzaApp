package application;

public enum PizzaType {
    MARGHERITA("Sauce, cheese",20,40),
    HAWAII("sauce, cheese, ham, pineapple",30,50),
    BOLOGNESE("sauce, cheese, meat",40,60);

    public final String ingredients;
    private final double smallPrice;
    private final double largePrice;

    private PizzaType(String ingredients, double smallPrice, double largePrice){
        this.ingredients = ingredients;
        this.smallPrice=smallPrice;
        this.largePrice=largePrice;
    }

    public String getIngredients() {
        return ingredients;
    }

    public double getSmallPrice() {
        return smallPrice;
    }

    public double getLargePrice() {
        return largePrice;
    }
}

