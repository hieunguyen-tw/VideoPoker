package nv.hieu.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class PlayerTest {

    private Player player;
    private CardDeck mockCardDeck;
    private PokerHand hand;

    @BeforeEach
    public void setup(){
        hand = spy(PokerHand.class);
        player = new Player(hand);
        mockCardDeck = spy(CardDeck.class);
        when(mockCardDeck.draw()).thenReturn(Card.ACE_OF_HEART, Card.TWO_OF_DIAMOND,
                Card.TEN_OF_CLUBS, Card.FOUR_OF_DIAMOND, Card.TEN_OF_SPADE, Card.NINE_OF_DIAMOND);
    }

    @Test
    public void drawCardTest_drawFromDeckHaveNoCards_False() {
        when(mockCardDeck.remainSize()).thenReturn(0);
        assertNull(player.drawCard(mockCardDeck));
    }

    @Test
    public void drawCardTest_handSizeGreaterOrEqual5_False()
    {
        when(hand.size()).thenReturn(5);
        assertNull(player.drawCard(mockCardDeck));
    }

    @Test
    public void drawCardTest_drawFromDeckHaveCards_CardShouldBeInTheHand() {
        assertFalse(player.hand.getCards().contains(Card.ACE_OF_HEART));
        player.drawCard(mockCardDeck);
        assertTrue(player.hand.getCards().contains(Card.ACE_OF_HEART));
    }



}