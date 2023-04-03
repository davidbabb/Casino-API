package org.example.Casino;

import dao.JdbcBlackjackDao;
import model.Card;
import model.Dealer;
import model.Output;
import model.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

//likely deleting this, originally thought about CLI, will do front-end instead
public class Runner {

    private Output output;
    private User user;
    private Dealer dealer;
    private JdbcBlackjackDao dao;

    public void DisplayPlayMenu (String[] options) {
        BlackjackMenu menu = new BlackjackMenu();
        menu.DisplayMenu(options);
        GameSetup();
    }

    public void GameSetup() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/CardDeck");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dao = new JdbcBlackjackDao(dataSource);
        dao.getCardsForDeck();
    }

    public void RuleReader() {

        File dataFile = new File("C:\\Users\\Student\\workspace\\side projects\\Blackjack\\target\\Rules.txt");
        Output output = new Output();

        out.print("\n");
        try (Scanner reader = new Scanner(dataFile)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                output.DisplayRules(line);
            }
        } catch (FileNotFoundException e) {
            out.println("System error occurred");
        }

    }

    public Card DealCard() {

        List<Card> deck = dao.getDeck();
        Card card = deck.get(0);
        deck.remove(0);
        return card;

    }

    public void Game () {



    }

}
