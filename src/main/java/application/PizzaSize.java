package application;

public enum PizzaSize {
    SMALL("30 CM"), LARGE ("50 CM");

    private final String sizeDescription;

    PizzaSize(String sizeDescription) {
        this.sizeDescription = sizeDescription;
    }

}
