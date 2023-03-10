package Classes;

import java.util.ArrayList;
import java.util.Collections;
// import java.util.List;

// import Classes.BordSetupClasses.Board;
import Classes.CardClasses.DomCard;

public class CardStack {
    protected ArrayList<DomCard> cardsInStack;
    // protected Board activeBoard;

    public CardStack(ArrayList<DomCard> startingCards) {

        this.cardsInStack = new ArrayList<DomCard>();
        cardsInStack = startingCards;
    }

    public void removeAllCards() {
        this.cardsInStack.clear();
    }

    public void shuffle() {
        Collections.shuffle(cardsInStack);
    }

    public DomCard removeFromTop() {
        if (cardsInStack.isEmpty()) {
            // throw new RuntimeException("no fucking cards left in this stack");
            return null;
        }
        return cardsInStack.remove(0);
    }

    public void prettyPrint() {
        System.out.println("");
        for (int i = 0; i < cardsInStack.size(); i++) {
            System.out.print(" >==============================< ");
        }
        System.out.println("");
        for (DomCard card : cardsInStack) {
            System.out.print(card.getPrettyName());
        }
        System.out.println("");
        for (int i = 0; i < cardsInStack.size(); i++) {
            System.out.print(" |______________________________| ");
        }
        System.out.println("");
        for (DomCard card : cardsInStack) {
            System.out.print(card.getEffect_Line(1));
        }
        System.out.println("");
        for (DomCard card : cardsInStack) {
            System.out.print(card.getEffect_Line(2));
        }
        System.out.println("");
        for (DomCard card : cardsInStack) {
            System.out.print(card.getEffect_Line(3));
        }
        System.out.println("");
        for (DomCard card : cardsInStack) {
            System.out.print(card.getEffect_Line(4));
        }
        System.out.println("");
        for (int i = 0; i < cardsInStack.size(); i++) {
            System.out.print(" |______________________________| ");
        }
        System.out.println("");
        for (DomCard card : cardsInStack) {
            System.out.print(card.getPrettyCostType());
        }
        System.out.println("");
        for (int i = 0; i < cardsInStack.size(); i++) {
            System.out.print(" >==============================< ");
        }
    }

    // System.out.println("______________________________");
    // System.out.println("| Cost: (" + this.cost + ") |");
    // System.out.println("| Type: " + this.type + " |");
    // System.out.println("==============================\n");

    public int size() {
        return cardsInStack.size();
    }

    public void addCardtoBottom(DomCard card) {
        cardsInStack.add(card);
    }

    public void addCardToTop(DomCard card) {
        cardsInStack.add(0, card);
    }

    public void addStackToTop(ArrayList<DomCard> cardsToAdd) {
        cardsInStack.addAll(0, cardsToAdd);
    }

    public void addStackTobottom(ArrayList<DomCard> cardsToAdd) {
        cardsInStack.addAll(cardsToAdd);
    }

    public void addXCardsofTypeToTop(DomCard card, int amount) {
        for (int i = 0; i < amount; i++) {
            cardsInStack.add(0, card);
        }
    }

    public void removeCardofType(DomCard card) {
        cardsInStack.remove(card);
    }

    public ArrayList<DomCard> GetFullStack() {
        return cardsInStack;
    }

    public ArrayList<DomCard> scryThis(int depth) {
        if (cardsInStack.size() < depth) {
            depth = cardsInStack.size();
        }
        return new ArrayList<>(cardsInStack.subList(0, depth));
    }

}
