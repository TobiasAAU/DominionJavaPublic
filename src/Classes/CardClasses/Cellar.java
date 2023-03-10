package Classes.CardClasses;

import java.util.ArrayList;
import Classes.Player;

public class Cellar extends DomCard {

    public Cellar() {
        super("Cellar", "Action", 2, 0, 0, 0, 1, 0,
                "+1 action\nDiscard any number of cards\nfrom your hand, then\ndraw that many cards");

    }

    @Override
    public void play(Player activePlayer) {
        activePlayer.addActions(1);
        ArrayList<DomCard> discardedCards = new ArrayList<DomCard>();
        while (true) {
            DomCard selectedCard = activePlayer
                    .chooseCardFromHand("Select a card to discard, or type 'n' to stop discarding:", false);
            if (selectedCard == null) {
                break;
            }
            activePlayer.removeCardFrom_Hand(selectedCard);
            discardedCards.add(selectedCard);
        }

        activePlayer.drawXcardsFrom_Deck(discardedCards.size());
        System.out
                .println("Discarded " + discardedCards.size() + " cards and drew " + discardedCards.size() + " cards.");

    }
}
