package nv.hieu.model.hand;


import nv.hieu.model.card.Card;
import nv.hieu.model.hand.PokerHand;
import nv.hieu.model.hand.PokerHandWinType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerHandTest {
    PokerHand hand;

    private static final Card[] CARDS = new Card[]{Card.TEN_OF_HEART, Card.TEN_OF_SPADE, Card.TEN_OF_DIAMOND, Card.TWO_OF_CLUBS, Card.JACK_OF_DIAMOND};
    @BeforeEach
    public void setup()
    {
        hand = new PokerHand();
        for (Card card : CARDS)
        {
            hand.addCard(card);
        }
    }

    private static Stream<Arguments> handEvaluateTestParams()
    {
        return Stream.of(
            Arguments.of(PokerHandWinType.NONE, new Card[]{Card.ACE_OF_DIAMOND}),
            Arguments.of(PokerHandWinType.NONE, new Card[]{Card.ACE_OF_DIAMOND, Card.ACE_OF_CLUBS}),
            Arguments.of(PokerHandWinType.JACKS_OR_BETTER, new Card[]{Card.JACK_OF_HEART, Card.JACK_OF_DIAMOND, Card.TEN_OF_CLUBS, Card.SEVEN_OF_CLUBS, Card.NINE_OF_SPADE}),
            Arguments.of(PokerHandWinType.NONE, new Card[]{Card.JACK_OF_HEART, Card.SEVEN_OF_HEART, Card.TEN_OF_CLUBS, Card.SEVEN_OF_CLUBS, Card.NINE_OF_SPADE}),
            Arguments.of(PokerHandWinType.TWO_PAIRS, new Card[]{Card.JACK_OF_HEART, Card.JACK_OF_DIAMOND, Card.TEN_OF_DIAMOND, Card.TEN_OF_HEART, Card.NINE_OF_SPADE}),
            Arguments.of(PokerHandWinType.TWO_PAIRS, new Card[]{Card.TWO_OF_SPADE, Card.TWO_OF_DIAMOND, Card.TEN_OF_DIAMOND, Card.TEN_OF_HEART, Card.NINE_OF_SPADE}),
            Arguments.of(PokerHandWinType.THREE_OF_A_KIND, new Card[]{Card.JACK_OF_HEART, Card.TEN_OF_CLUBS, Card.TEN_OF_DIAMOND, Card.TEN_OF_HEART, Card.NINE_OF_SPADE}),
            Arguments.of(PokerHandWinType.FLUSH, new Card[]{Card.JACK_OF_HEART, Card.TEN_OF_HEART, Card.FIVE_OF_HEART, Card.SIX_OF_HEART, Card.ACE_OF_HEART}),
            Arguments.of(PokerHandWinType.FULL_HOUSE, new Card[]{Card.JACK_OF_HEART, Card.TEN_OF_CLUBS, Card.TEN_OF_DIAMOND, Card.TEN_OF_HEART, Card.JACK_OF_SPADE}),
            Arguments.of(PokerHandWinType.FOUR_OF_A_KIND, new Card[]{Card.TEN_OF_SPADE, Card.TEN_OF_CLUBS, Card.TEN_OF_DIAMOND, Card.TEN_OF_HEART, Card.JACK_OF_SPADE}),
            Arguments.of(PokerHandWinType.NONE, new Card[]{Card.TEN_OF_SPADE, Card.TEN_OF_CLUBS, Card.TEN_OF_DIAMOND, Card.TEN_OF_HEART, Card.TEN_OF_HEART}),
            Arguments.of(PokerHandWinType.STRAIGHT, new Card[]{Card.NINE_OF_DIAMOND, Card.JACK_OF_CLUBS, Card.QUEEN_OF_SPADE, Card.KING_OF_CLUBS, Card.TEN_OF_DIAMOND}),
            Arguments.of(PokerHandWinType.STRAIGHT, new Card[]{Card.TEN_OF_SPADE, Card.JACK_OF_CLUBS, Card.QUEEN_OF_SPADE, Card.KING_OF_CLUBS, Card.ACE_OF_SPADES}),
            Arguments.of(PokerHandWinType.NONE, new Card[]{Card.TEN_OF_SPADE, Card.JACK_OF_CLUBS, Card.QUEEN_OF_SPADE, Card.NINE_OF_CLUBS, Card.ACE_OF_SPADES}),
            Arguments.of(PokerHandWinType.STRAIGHT, new Card[]{Card.ACE_OF_HEART, Card.TWO_OF_DIAMOND, Card.THREE_OF_DIAMOND, Card.FOUR_OF_DIAMOND, Card.FIVE_OF_SPADE}),
            Arguments.of(PokerHandWinType.NONE, new Card[]{Card.SIX_OF_DIAMOND, Card.THREE_OF_HEART, Card.THREE_OF_DIAMOND, Card.FOUR_OF_DIAMOND, Card.FIVE_OF_SPADE}),
            Arguments.of(PokerHandWinType.NONE, new Card[]{Card.ACE_OF_HEART, Card.SIX_OF_HEART, Card.THREE_OF_DIAMOND, Card.FOUR_OF_DIAMOND, Card.FIVE_OF_SPADE}),
            Arguments.of(PokerHandWinType.STRAIGHT_FLUSH, new Card[]{Card.TWO_OF_DIAMOND, Card.FIVE_OF_DIAMOND, Card.THREE_OF_DIAMOND, Card.FOUR_OF_DIAMOND, Card.SIX_OF_DIAMOND}),
            Arguments.of(PokerHandWinType.STRAIGHT_FLUSH, new Card[]{Card.TWO_OF_DIAMOND, Card.FIVE_OF_DIAMOND, Card.THREE_OF_DIAMOND, Card.FOUR_OF_DIAMOND, Card.ACE_OF_DIAMOND}),
            Arguments.of(PokerHandWinType.ROYAL_FLUSH, new Card[]{Card.TEN_OF_DIAMOND, Card.JACK_OF_DIAMOND, Card.QUEEN_OF_DIAMOND, Card.KING_OF_DIAMOND, Card.ACE_OF_DIAMOND}),
            Arguments.of(PokerHandWinType.STRAIGHT_FLUSH, new Card[]{Card.TEN_OF_DIAMOND, Card.JACK_OF_DIAMOND, Card.QUEEN_OF_DIAMOND, Card.KING_OF_DIAMOND, Card.NINE_OF_DIAMOND})
        );
    }

    @ParameterizedTest
    @MethodSource("handEvaluateTestParams")
    public void handEvaluateTest(PokerHandWinType expectedWinType, Card[] cards)
    {
        PokerHand pokerHand = new PokerHand();
        for (Card card : cards) {
            pokerHand.addCard(card);
        }
        assertEquals(expectedWinType, pokerHand.getWinType());
    }
}