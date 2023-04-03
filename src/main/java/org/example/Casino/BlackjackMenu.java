package org.example.Casino;

import model.Output;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BlackjackMenu {

    private Scanner in;
    private PrintWriter out;
    private Output output;

    public BlackjackMenu (InputStream input, PrintStream output) {
        this.in = new Scanner(input);
        this.out = new PrintWriter(output);
    }

    public BlackjackMenu(){}

    public String GetChoiceFromOptions (String[] options) {

        String choice = null;
        while (choice == null) {
            DisplayMenu(options);
            choice = GetChoiceFromUser(options);
        }

        return choice;

    }

    public String GetChoiceFromUser (String[] options) {

        String choice = null;
        String userInput = in.nextLine();

        try {
            int selection = Integer.valueOf(userInput);
            if (selection > 0 && selection <= options.length) {
                choice = options[selection - 1];
            }
        } catch (Exception e) {
            System.out.println("***Please enter a valid choice***");
        }

        return choice;

    }

    public void DisplayMenu(String[] choices) {
        Output output = new Output();
        output.DisplayMenu(choices);
    }


}
