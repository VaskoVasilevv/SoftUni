package Inheritance.Ex.resturant;

import java.math.BigDecimal;

public class Salmon extends MainDish{

    private static final double SALOMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, SALOMON_GRAMS);

    }
}
