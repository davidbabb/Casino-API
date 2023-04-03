package org.example.Casino;

import org.apache.commons.dbcp2.BasicDataSource;

//like the runner class, probably getting rid of this
//in favor of a CLI

public class BlackjackCLI {

    private static final String MAIN_MENU_OPTION_RULES = "Blackjack Rules";
    private static final String MAIN_MENU_OPTION_PLAY = "Play Blackjack";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit App";
    private static final String MAIN_MENU_OPTION_LEADERBOARD = "Leaderboard";

    private static final String PLAY_MENU_OPTION_BUY = "Buy Chips";
    private static final String PLAY_MENU_OPTION_PLAY = "Play Game";
    private static final String PLAY_MENU_OPTION_CASH = "Cash Out";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_RULES, MAIN_MENU_OPTION_PLAY, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_LEADERBOARD};
    private static final String[] PLAY_MENU_OPTIONS = {PLAY_MENU_OPTION_BUY, PLAY_MENU_OPTION_PLAY, PLAY_MENU_OPTION_CASH};

    private BlackjackMenu menu;
    private Runner runner = new Runner();

    public BlackjackCLI (BlackjackMenu menu) {
        this.menu = menu;
    }
    public static void main(String[] args) {
        BlackjackMenu menu = new BlackjackMenu(System.in, System.out);
        BlackjackCLI blackjackCLI = new BlackjackCLI(menu);
        blackjackCLI.run();
    }

    public void run() {
        boolean running = true;
        while (running) {

            String choice = (String) menu.GetChoiceFromOptions(MAIN_MENU_OPTIONS);

            switch (choice) {

                case MAIN_MENU_OPTION_RULES:

                    runner.RuleReader();
                    break;

                case MAIN_MENU_OPTION_PLAY:

                    while (running) {

                        String inputChoice = (String) menu.GetChoiceFromOptions(PLAY_MENU_OPTIONS);

                        if (inputChoice.equals(PLAY_MENU_OPTION_BUY)) {



                        }

                    }
                    break;

            }

        }



    }

}
