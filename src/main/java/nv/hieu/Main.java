package nv.hieu;

import nv.hieu.model.CardDeck;
import nv.hieu.model.Game;
import nv.hieu.model.Player;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game(new CardDeck(), new Player());
        game.init();
    }
}