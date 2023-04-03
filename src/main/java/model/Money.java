package model;

import java.math.BigDecimal;
import java.util.List;

public interface Money {

    public List<Chip> BuyChips (int cash);
    public int ChipsToMoney (List <Chip> chips);
    public int WinMoney (List <Chip> chips, boolean isBlackjack);
    public int LoseMoney (List <Chip> chips);
    public int CashOut (List <Chip> chips);
    public void AddToBalance (int winnings);
    public void SubtractFromBalance (int losses);

}
