package entity;

import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail{

    private CardType cardType;
    private Integer expirationMoth;
    private Integer expirationYear;

    public CreditCard() {
    }

    @Enumerated(EnumType.STRING)
    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
    @Column(name = "expiration_date",nullable = false)
    public Integer getExpirationMoth() {
        return expirationMoth;
    }

    public void setExpirationMoth(Integer expirationMoth) {
        this.expirationMoth = expirationMoth;
    }

    @Column(name = "expiration_year",nullable = false)
    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }
}
