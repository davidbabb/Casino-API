package model;

public class Card {

    private String cardName;
    private String cardSuit;
    private int cardValue;
    private int altValue;
    private int cardNumber;

    public Card (String cardName, String cardSuit) {
        this.cardName = cardName;
        this.cardSuit = cardSuit;
    }

    public Card () {};

    public String getCardName () {
        return cardName;
    }

    public String getCardSuit () {
        return cardSuit;
    }

    public void setCardName (String cardName) {
        this.cardName = cardName;
    }

    public void setCardSuit (String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getAltValue() {
        return altValue;
    }

    public void setAltValue(int altValue) {
        this.altValue = altValue;
    }

    public int getCardNumber() {
        return cardValue;
    }

    public void setCardNumber (int cardNumber) {
        this.cardNumber = cardNumber;
    }

    //may or may not keep these, deals with face card values

    private boolean IsFaceCard (Card card) {
        return card.getCardNumber() >= 11 && card.getCardNumber() < 14;
    }

    private boolean IsAce (Card card) {
        return card.getCardNumber() == 14;
    }


}
