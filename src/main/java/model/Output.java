package model;

import static java.lang.System.out;

public class Output {

    public String NumberFormat (int number) {
        String betterNumber = String.format("%.2f", number);
        return betterNumber;
    }

    public void CardOutput(String name, String suit) {
        out.println(name + " of " + suit);
    }

    public void UserBalance (int number) {
        out.println("\n*****Your balance is $" + NumberFormat(number) + "*****");
    }

    public void WinningMessage(int number) {
        out.println("Congratulations! Your winnings are $" + NumberFormat(number) + "!");
    }

    public void BlackjackMessage (int number) {
        out.println("BLACKJACK! You win $" + NumberFormat(number) + "!");
    }

    public void WinHand (int number) {
        out.println("Nice job! You won $" + NumberFormat(number) + " this hand!");
    }

    public void LoseHand (int number) {
        out.println("Sorry! You lost $" + NumberFormat(number) + " this hand!");
    }

    public void DisplayMenu (String[] options) {

        out.print("\n");
        for (int i = 0; i < options.length; i++) {
            int optionNum = i + 1;
            out.println(optionNum + ") " + options[i]);
        }

        out.println("\nPlease choose an option -->");
        out.flush();
    }

    public void DisplayRules (String line) {
        out.println(line);
    }

    public void EnterMoney () {
        out.println("Please enter $ amount of chips --> ");
    }

    public void ChipMessage (int tenChips, int twentyChips, int fiftyChips) {
        out.println("You have " + tenChips + " $10 chips, " + twentyChips + " $20 chips, and " + fiftyChips + " $50 chips");
    }

}
