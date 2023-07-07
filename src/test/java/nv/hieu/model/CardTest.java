package nv.hieu.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CardTest {

    public static Stream<Arguments> parameters()
    {
        return Stream.of(
                Arguments.of("A" + Card.DIAMOND_DISPLAY_NAME, Card.ACE_OF_DIAMOND),
                Arguments.of("K" + Card.CLUBS_DISPLAY_NAME, Card.KING_OF_CLUBS),
                Arguments.of("K" + Card.DIAMOND_DISPLAY_NAME, Card.KING_OF_DIAMOND),
                Arguments.of("10" + Card.CLUBS_DISPLAY_NAME,Card.TEN_OF_CLUBS),
                Arguments.of("10" + Card.HEART_DISPLAY_NAME,Card.TEN_OF_HEART),
                Arguments.of("2" + Card.SPADES_DISPLAY_NAME,Card.TWO_OF_SPADE),
                Arguments.of("J" + Card.HEART_DISPLAY_NAME,Card.JACK_OF_HEART),
                Arguments.of("Q" + Card.SPADES_DISPLAY_NAME,Card.QUEEN_OF_SPADE)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test_CardGetName(String cardNameExpected, Card cardInput)
    {
        assertEquals(cardNameExpected, cardInput.getName());
    }
}