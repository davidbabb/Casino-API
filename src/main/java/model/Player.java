package model;

import java.util.List;
//abstract bc dealer and user are both players,
//but have distinctive differences
public abstract class Player {

    private String playerName;
    private int balance;
    private Hand hand;

    public Player (String playerName, int balance, Hand hand) {
        this.playerName = playerName;
        this.balance = balance;
        this.hand = hand;
    }

    public Player (String playerName, Hand hand) {
        this.playerName = playerName;
        this.hand = hand;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getBalance() {
        return balance;
    }

    public Hand getHand() {
        return hand;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }




}
