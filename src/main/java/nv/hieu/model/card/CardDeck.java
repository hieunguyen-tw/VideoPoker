package nv.hieu.model.card;

import java.util.*;

public class CardDeck {
    final List<Card> cards = new ArrayList<>();
    int index;
    public CardDeck() {
        this.cards.addAll(Arrays.asList(Card.values()));
        index = 0;
    }

    public int remainSize() {
        return cards.size() - index;
    }

    public Card draw(){
        if (index >= cards.size())
        {
            return null;
        }
        return cards.get(index++);
    }

    public void shuffle()
    {
        Collections.shuffle(this.cards);
        this.index = 0;
    }

    public void shuffle(int seed)
    {
        Random random = new Random(seed);
        Collections.shuffle(this.cards,random);
        this.index = 0;
    }
}
