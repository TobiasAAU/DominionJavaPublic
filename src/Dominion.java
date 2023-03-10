
import java.util.ArrayList;

import Classes.Player;
import Classes.globalMethods;
import Classes.BordSetupClasses.Board;
import Classes.BordSetupClasses.Supply;
// import Classes.CardClasses.Artisan;
// import Classes.CardClasses.DomCard;
// import Classes.CardClasses.Smithy;
// import Classes.CardClasses.Vassal;
import Classes.CardClasses.*;

class Dominion {

    public static void main(String[] args) {

        // create the players
        System.out.println("Welcome to Dominion! to start a new game, input an amount of players");
        String input = globalMethods.inputControl(8, true);
        int numberOfPlayers = Integer.parseInt(input);
        ArrayList<Player> Players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String playerName = System.console().readLine();
            Players.add(new Player(playerName));
        }

        // setup the board:
        ArrayList<DomCard> myKingdomCards = new ArrayList<>(); // should be randomized
        myKingdomCards.add(new Smithy());
        myKingdomCards.add(new Artisan());
        myKingdomCards.add(new Village());
        myKingdomCards.add(new Vassal());
        myKingdomCards.add(new Market());

        Supply theSupply = new Supply(myKingdomCards, numberOfPlayers, true);

        Board gameboard = new Board(Players, theSupply);
        globalMethods.SetactiveBoard(gameboard);
        globalMethods.isGameOver = false;
        ////////////////////////////
        // run the game
        //////////////////////////////////

        while (!globalMethods.isGameOver) {
            // get the current player
            Player currentPlayer = gameboard.getActivePlayer();
            currentPlayer.begginningTurn();

            globalMethods.handleActionPhase(currentPlayer);// prints everything

            // after actions: treasures
            while (currentPlayer.getTreasureFromStack(currentPlayer.getHand()).size() != 0) {
                gameboard.printBoard();
                gameboard.getActivePlayer().prettyPrintAll();
                DomCard TreasureToPlay = currentPlayer.promptPlayTreasure();// choose an actioncard to play
                if (TreasureToPlay == null) {
                    break;
                }
                System.out.println("You played: " + TreasureToPlay.getName());
                currentPlayer.playCard(TreasureToPlay);// execute the treasure
            }

            // after treasuers: its a me: debuy phase
            while (currentPlayer.getNumBuys() != 0) {
                gameboard.printBoard();
                gameboard.getActivePlayer().prettyPrintAll();
                DomCard buyThis = gameboard.promptToBuyFromSupply(0, currentPlayer.getNumCoins(), false);
                if (buyThis == null) {
                    break;
                }
                currentPlayer.addBuys(-1);
                currentPlayer.gainCard(buyThis);
                currentPlayer.addCoins(-buyThis.getCost());
            }
            System.out.println("Turn finnished \nyou discard all cards from play and your hand, and draw 5 new cards");

            gameboard.finnishTurn();

            // check if the game is over
            if (gameOver(gameboard)) {
                System.out.println("The game is over!");
                break;
            }
            gameboard.nextPlayer();
            currentPlayer = gameboard.getActivePlayer();

        }

        // display the final scores
        // displayScores();

    }

    private static boolean gameOver(Board theBoard) {
        // if (theBoard.getNumCards_supply(new Province()) == 0) {
        // System.out.println("No more provinces!");
        // return true;
        // } else if (theBoard.getNumCards_supply(new Colony()) == 0) {
        // System.out.println("No more Colonies!");
        // return true;
        // } else
        return false;
    }
}