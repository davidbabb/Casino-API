package model;

import java.util.List;

//this is only a class because we need to be able to
//access the dealer's hand

public class Dealer extends Player {

    public Dealer (String playerName, Hand hand) {
        super("The Dealer", hand);
    }

}
