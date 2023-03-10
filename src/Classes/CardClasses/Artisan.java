package Classes.CardClasses;

import Classes.Player;
import Classes.globalMethods;

public class Artisan extends DomCard {

    public Artisan() {
        super("Artisan", "Action", 6,
                "gain a card to your hand\ncosting up to (5), then\nput a card from your hand\n on to your deck");

    }

    @Override
    public void play(Player activePlayer) {
        // prompt the player to gain a card costing up to 5 coins
        DomCard gainedCard = globalMethods.activeBoard.promptToGainFromSupply(0, 5, true);

        // add the gained card to the player's hand
        globalMethods.activeBoard.getActivePlayer().gainToHand(gainedCard);

        // prompt the player to put a card from their hand on top of their deck
        DomCard cardToPutOnDeck = globalMethods.activeBoard.getActivePlayer()
                .chooseCardFromHand("Choose a card to put on top of your deck", true);
        globalMethods.activeBoard.getActivePlayer().removeCardFrom_Hand(cardToPutOnDeck);
        globalMethods.activeBoard.getActivePlayer().gainToDeck(cardToPutOnDeck);
    }
}