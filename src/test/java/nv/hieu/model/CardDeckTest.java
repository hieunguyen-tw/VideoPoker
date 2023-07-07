package nv.hieu.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class CardDeckTest {

    CardDeck deck;
    private final static int RANDOM_SEED = 420;
    @BeforeEach
    public void setup()
    {
        deck = new CardDeck();
    }
    @Test
    public void testCardDeck_init_Size()
    {
        assertEquals(Card.values().length, deck.remainSize());
    }

    @Test
    public void draw_newCardPerDraw()
    {
        Set<Card> cardsSet = new HashSet<>();
        Card card;
        do {
            card = deck.draw();
            assertFalse(cardsSet.contains(card));
            cardsSet.add(card);
        } while (card != null);
    }

    @Test
    public void shuffle_Test()
    {
        deck.shuffle(RANDOM_SEED);
        assertEquals(Card.values().length, deck.remainSize());
    }

}