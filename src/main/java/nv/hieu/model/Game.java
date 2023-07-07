package nv.hieu.model;

import java.io.IOException;
import java.util.*;

public class Game {
    private final CardDeck deck;

    private final Player player;
    private final List<Card> tempraryCardList = new ArrayList<>();
    private boolean isEnd = false;
    final Scanner scanner = new Scanner(System.in);

    public Game(CardDeck deck, Player player) {
        this.deck = deck;
        this.player = player;
    }

    private void reset() {
        this.deck.shuffle();
        this.player.reset();
        this.tempraryCardList.clear();
    }

    public void init() throws IOException {
        System.out.println("Press enter to start");
        System.in.read();
        while (!isEnd) {
            reset();
            start();
            System.out.println("Do u want to continue? (N to stop): ");
            String str = scanner.nextLine();
            str = str.trim();
            if ("n".equals(str) || "N".equals(str)) {
                isEnd = !isEnd;
            }
        }
    }

    private void start() {
        drawCardToPlayer(PokerHand.HAND_SIZE);
        tempraryCardList.addAll(player.hand.getCards());
        printHands();
        askForRemoveCards();
        List<Card> receivedCards = drawCardToPlayer(PokerHand.HAND_SIZE - player.hand.size());
        PokerHandWinType winType = player.hand.getWinType();
        System.out.println("Received cards: " + getCardStr(receivedCards) + "\n" +
                "Your cards: " + getCardStr(player.hand.getCards()) + "\n" +
                "Win type: " + winType);
    }

    private void askForRemoveCards() {
        System.out.println("Which cards u want to discard?");
        String str = scanner.nextLine();
        List<Integer> indexList = convertStringToListIndex(str, ' ');
        Set<Card> removedCards = removeCardByIndex(indexList);
        System.out.println("Removed cards: " + getCardStr(removedCards));
    }

    private void printHands() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= player.hand.size(); i++) {
            sb.append(i).append("\t");
        }
        sb.append("\n").append(getCardStr(this.tempraryCardList));
        System.out.println(sb);
    }

    private static String getCardStr(Collection<Card> cards) {
        StringBuilder sb = new StringBuilder();
        Iterator<Card> it = cards.iterator();
        while (it.hasNext()) {
            Card card = it.next();
            sb.append(card.getName());
            if (it.hasNext()) {
                sb.append("\t");
            }
        }
        return sb.toString();
    }

    private List<Card> drawCardToPlayer(int cards) {
        List<Card> receivedCards = new LinkedList<>();
        for (int i = 0; i < cards; i++) {
            Card receivedCard = this.player.drawCard(this.deck);
            receivedCards.add(receivedCard);
        }
        return receivedCards;
    }

    /**
     * @param indexes: list of indexes start from 1
     * @return true if valid removed, otherwise false
     */
    Set<Card> removeCardByIndex(List<Integer> indexes) {
        Set<Card> tobeRemovedCards = new HashSet<>();
        for (int index : indexes) {
            if (index > 0 && index <= this.tempraryCardList.size()) {
                tobeRemovedCards.add(tempraryCardList.get(index - 1));
            }
        }
        this.player.removeCards(tobeRemovedCards);
        return tobeRemovedCards;
    }

    static List<Integer> convertStringToListIndex(String str, char comma) {
        if (str == null || str.isBlank()) return Collections.emptyList();
        String[] tokens = str.split(Character.toString(comma));
        List<Integer> indexes = new LinkedList<>();
        for (String s : tokens) {
            s = s.trim();
            try {
                int index = Integer.parseInt(s);
                indexes.add(index);
            } catch (NumberFormatException ignored) {
            }
        }
        return indexes;
    }
}
