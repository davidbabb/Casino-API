package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//user implements money class, dealer does not because dealer
//obviously has no balance

public class User extends Player implements Money {

    private Hand splitHand;
    private Hand hand;
    private final List <Chip> chips = new ArrayList<>();
    private int totalWinnings;

    public User (String playerName, int balance, Hand hand) {
        super(playerName, balance, hand);
    }

    public User (String playerName, int balance, Hand hand, Hand splitHand) {
        super(playerName, balance, hand);
        this.splitHand = splitHand;
    }

    public void setSplitHand(Hand splitHand) {
        this.splitHand = splitHand;
    }

    public Hand getSplitHand() {
        return splitHand;
    }

    public List<Chip> getChips() {
        return chips;
    }
    
    public int getTotalWinnings() {
        return totalWinnings;
    }
    
    public void setTotalWinnings(int totalWinnings) {
        this.totalWinnings = totalWinnings;
    }

    //convert chips to $$$$
    @Override
    public int ChipsToMoney (List <Chip> chips) {
        int notBalance = 0;

        int i = 0;
        for (Chip chip: chips) {
            notBalance += chip.getChipValue();
            i++;
        }

        return notBalance;
    }

    //chip id or value??? need to figure this out
    @Override
    public List <Chip> BuyChips (int cash) {

        int begBalance = cash;
        int tenChips = 0;
        int twentyChips = 0;
        int fiftyChips = 0;
        Chip fiftyChip = new Chip(50, 50);
        Chip twentyChip = new Chip(20, 20 );
        Chip tenChip = new Chip(10, 10);
        setBalance(cash);

        if (cash > fiftyChip.getChipValue()*3) {
            cash -= fiftyChip.getChipValue();
            chips.add(fiftyChip);
            fiftyChips++;
        } else if (cash > twentyChip.getChipValue()*3) {
            cash -= twentyChip.getChipValue();
            chips.add(twentyChip);
            twentyChips++;
        } else {
            cash -= tenChip.getChipValue();
            chips.add(tenChip);
            tenChips++;
        }

        return chips;

    }

    //handle user win
    @Override
    public int WinMoney (List <Chip> handChips, boolean isBlackjack) {

        int winnings = 0;
        
        if (isBlackjack) {
            winnings = (ChipsToMoney(handChips) * 3) / 2;
        } else {
            winnings = ChipsToMoney(handChips);
            for (Chip handChip : handChips) {
                getChips().add(handChip);
            }
        }

        AddToBalance(winnings);

        return winnings;

    }

    //handle user loss
    @Override
    public int LoseMoney (List <Chip> handChips) {

        int losses = ChipsToMoney(handChips);
        for (Chip handChip: handChips) {
            chips.remove(handChip);
        }
        SubtractFromBalance(losses);
        return losses;

    }

    //user cash out, return earnings
    @Override
    public int CashOut (List <Chip> chips) {

        int winnings = ChipsToMoney(chips);
        return winnings;

    }

    @Override
    public void AddToBalance(int gain) {

        int balance = getBalance();
        setBalance(balance + gain);
        setTotalWinnings(getTotalWinnings() + gain);

    }

    @Override
    public void SubtractFromBalance(int loss) {

        int balance = getBalance();
        setBalance(balance - loss);
        setTotalWinnings(getTotalWinnings() - loss);

    }
}
