package dao;

import model.Card;
import model.Dealer;
import model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

//data pulls from SQL database, will handle most of the game here
public class JdbcBlackjackDao implements BlackjackDao{

    private JdbcTemplate jdbcTemplate;
    private List <Card> deck = new ArrayList<>();

    public JdbcBlackjackDao (DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List <Card> getDeck() {
        return deck;
    }

    @Override
    public List<Card> getCardsForDeck () {
        String sql = "SELECT c.card_number, card_value, card_name, alt_value, suit_name " +
        "FROM card_value cv " +
        "JOIN card c ON c.card_number = cv.card_number " +
        "JOIN suit s ON s.suit_id = c.suit_id;";
        SqlRowSet cardDeck = jdbcTemplate.queryForRowSet(sql);

        while (cardDeck.next()) {
            deck.add(mapRowToCard(cardDeck));
        }

        shuffle(deck);

        return deck;

    }

    public Card mapRowToCard (SqlRowSet rowSet) {
        Card card = new Card();
        card.setCardName(rowSet.getString("card_name"));
        card.setCardNumber(rowSet.getInt("card_number"));
        card.setCardValue(rowSet.getInt(("card_value")));
        card.setAltValue(rowSet.getInt("alt_value"));
        card.setCardSuit(rowSet.getString("suit_name"));
        return card;
    }


}
