package nv.hieu.model.hand;

import nv.hieu.constant.CardConstant;
import nv.hieu.model.card.Card;

import java.util.*;

public class PokerHand {
    public static final int HAND_SIZE = 5;
    private final Set<Card> cards = new HashSet<>();


    public void removeCards(Collection<Card> cards) {
        this.cards.removeAll(cards);
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int size() {
        return this.cards.size();
    }

    public PokerHandWinType getWinType() {
        if (size() != HAND_SIZE) return PokerHandWinType.NONE;
        Map<Integer, Integer> cardRankFrequency = new HashMap<>();
        for (Card card : this.cards) {
            cardRankFrequency.put(card.getRank(), cardRankFrequency.getOrDefault(card.getRank(), 0) + 1);
        }
        int pairsCount = 0;
        boolean haveJackOrGreaterPair = false;
        boolean haveThreeOfAKind = false;
        for (Map.Entry<Integer, Integer> entry : cardRankFrequency.entrySet()) {
            int rank = entry.getKey();
            int freq = entry.getValue();
            if (freq == 2) {
                if (rank >= CardConstant.JACK_RANK || rank == CardConstant.ACE_RANK)
                    haveJackOrGreaterPair = true;
                pairsCount++;
            }
            if (freq == 3) haveThreeOfAKind = true;
            if (freq == 4) return PokerHandWinType.FOUR_OF_A_KIND;
        }
        if (pairsCount == 1 && haveThreeOfAKind) {
            return PokerHandWinType.FULL_HOUSE;
        } else if (haveThreeOfAKind) {
            return PokerHandWinType.THREE_OF_A_KIND;
        }
        if (pairsCount == 1 && haveJackOrGreaterPair) {
            return PokerHandWinType.JACKS_OR_BETTER;
        }
        if (pairsCount == 2) {
            return PokerHandWinType.TWO_PAIRS;
        }

        boolean isFlush = this.isFlush();
        //Check flush

        TreeSet<Card> cardTreeSet = new TreeSet<>(Comparator.comparingInt(Card::getRank));
        cardTreeSet.addAll(cards);
        int currentRank = -1;
        boolean isStraight = pairsCount == 0;
        boolean isHaveAce = false;
        for (Card card : cardTreeSet) {
            if (currentRank < 0) {
                if (card.getRank() == CardConstant.ACE_RANK) {
                    isHaveAce = true;
                } else {
                    currentRank = card.getRank();
                }
                continue;
            }
            if (card.getRank() - currentRank != 1) {
                isStraight = false;
                break;
            }
            currentRank = card.getRank();
        }
        if (isStraight) {
            if (isHaveAce) {
                if (cardTreeSet.last().getRank() != CardConstant.FIVE_RANK && cardTreeSet.last().getRank() != CardConstant.KING_RANK) {
                    isStraight = false;
                }
            }
        }
        if (isStraight && isFlush) {
            if (isHaveAce && cardTreeSet.last().getRank() == CardConstant.KING_RANK)
            {
                return PokerHandWinType.ROYAL_FLUSH;
            }
            return PokerHandWinType.STRAIGHT_FLUSH;
        } else if (isStraight) {
            return PokerHandWinType.STRAIGHT;
        } else if (isFlush) {
            return PokerHandWinType.FLUSH;
        }


        return PokerHandWinType.NONE;
    }

    private boolean isFlush() {
        Map<Integer, Integer> suitFrequency = new HashMap<>();
        for (Card card : cards) {
            suitFrequency.put(card.getSuit(), suitFrequency.getOrDefault(card.getSuit(), 0) + 1);
        }
        return suitFrequency.size() == 1;
    }

    public void reset()
    {
        this.cards.clear();
    }
}
