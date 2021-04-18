package JavaOOP.Polymorphism.Lab.animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favoriteFood) {
        this.name = name;
        this.favouriteFood = favoriteFood;
    }

    protected String getName() {
        return name;
    }

    protected String getFavouriteFood() {
        return this.favouriteFood;
    }

    public String explainSelf(){
        return "I am "+ getName() +" and my favorite food is "+ getFavouriteFood();
    }

}
