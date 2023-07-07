package nv.hieu.model;

import java.util.Collection;

public class Player {
    final PokerHand hand;

    public Player(PokerHand hand) {
        this.hand = hand;
    }
    public Player() {
        this.hand = new PokerHand();
    }

    public Card drawCard(CardDeck deck)
    {
        if (deck.remainSize() == 0 || hand.size() >= 5)
        {
            return null;
        }
        Card card = deck.draw();
        this.hand.addCard(card);
        return card;
    }

    public void reset()
    {
        this.hand.reset();
    }

    public void removeCards(Collection<Card> cards)
    {
        if (cards.size() > this.hand.size())
        {
            return;
        }
        this.hand.removeCards(cards);
    }
}
