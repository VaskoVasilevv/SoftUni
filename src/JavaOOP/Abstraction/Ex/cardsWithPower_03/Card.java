package JavaOOP.Abstraction.Ex.cardsWithPower_03;

public class Card {
    private CardRank number;
    private CardSuits color;
    private int power;

    public Card(CardRank number,CardSuits color){
        this.number = number;
        this.color = color;
        this.power = number.getPower() + color.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",number,color,power);
    }
}
