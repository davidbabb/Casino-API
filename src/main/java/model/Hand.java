package model;

import java.util.ArrayList;
import java.util.List;

//keeps track of both cards and chips for a user's hand
//no chips required in constructor because of dealer

public class Hand {

    private List <Card> cards = new ArrayList<>();
    private List <Chip> handChips = new ArrayList<>();

    public Hand (List <Card> cards) {
        this.cards = cards;
    }

    public List <Card> getCards() {
        return cards;
    }

    public void setCards(List <Card> cards) {
        this.cards = cards;
    }

    public List<Chip> getHandChips() {
        return handChips;
    }

    public void setHandChips(List<Chip> handChips) {
        this.handChips = handChips;
    }

    public void addCardToHand (Card card) {
        List <Card> list = getCards();
        list.add(card);
        setCards(list);
    }

}
