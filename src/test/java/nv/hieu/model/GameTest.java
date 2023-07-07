package nv.hieu.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {



    private static Stream<Arguments> convertStringToListIndexInput()
    {
        return Stream.of(
                Arguments.of(Collections.emptyList(), "", '-'),
                Arguments.of(Arrays.asList(1,3,4,5), "1-3-4-5", '-'),
                Arguments.of(Arrays.asList(1,3,4,5), "1   3 4 5", ' '),
                Arguments.of(Arrays.asList(1,3,4,5), "  1-3  -4-5 ", '-'),
                Arguments.of(Arrays.asList(1,4,5), "1-3,-4-5", '-')
        );
    }
    @ParameterizedTest
    @MethodSource("convertStringToListIndexInput")
    void convertStringToListIndex(List<Integer> expectedResult, String inputString, char inputDelimiter) {
        assertArrayEquals(expectedResult.toArray(new Integer[0]), Game.convertStringToListIndex(inputString, inputDelimiter).toArray(new Integer[0]));
    }
}