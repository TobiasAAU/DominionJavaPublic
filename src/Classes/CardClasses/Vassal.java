package Classes.CardClasses;
// import java.util.List;

import Classes.Player;
import Classes.globalMethods;
// import Classes.BordSetupClasses.Board;

public class Vassal extends DomCard {

    public Vassal() {
        super("Vassal", "Action", 3, 0, 2, 0, 0, 0,
                "+(2)coins\nDiscard the top card of\n your deck.If its an action\n card, you may play it");

    }

    @Override
    public void play(Player activePlayer) {
        activePlayer.addCoins(2);
        DomCard DiscardedCard = globalMethods.activeBoard.getActivePlayer().DiscardFromTopDeck();
        System.out.println("Discarded: ");
        DiscardedCard.prettyPrint();
        if (DiscardedCard.getType().contains("Action")) {
            System.out.println("Play this card: type 1\n  to skip: type n");
            // promt the player to choose to play the card (1) or not (n)
            String choice = (globalMethods.inputControl(1, false));
            if (choice == "1") { // player chose to play the card
                activePlayer.removeTopDiscard().play(activePlayer);
            }
        }
    }
}