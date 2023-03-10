package Classes.CardClasses;

import Classes.Player;

public class DomCard {
    private String name;
    private int cost;
    private int victoryPoints = 0;
    private int treasureValue = 0;
    private int buys = 0;
    private String effect = "";
    private String art = "";
    private String type;
    private int drawammount = 0;
    private int additionalActions = 0;
    private int villagers = 0;
    private int coffers = 0;

    // generic card
    public DomCard(String name, String type, int cost) {
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.art = setDefaultArt();
    }

    // VP card: dont give them a type to avoid dublicate methods. defaults to
    // type=VP
    public DomCard(String name, int cost, int victoryPoints) {
        this.name = name;
        this.cost = cost;
        this.victoryPoints = victoryPoints;
        this.type = "Victory";
        this.art = setDefaultArt();
        this.effect = (" |                              | \n |            " + victoryPoints + " VP              | ");
    }

    // basic Action card
    public DomCard(String name, String type, int cost, String effect) {
        this.name = name;
        this.cost = cost;
        this.effect = effect;
        this.type = type;
        this.art = setDefaultArt();
    }

    // treasure card
    public DomCard(String name, String type, int cost, int treasureValue) {
        this.name = name;
        this.cost = cost;
        this.treasureValue = treasureValue;
        this.type = type;
        this.art = setDefaultArt();
        this.effect = (" |                              | \n |          +(" + treasureValue + ")coins           | ");
    }

    // hybridconstructor
    public DomCard(String name, String type, int cost, int victoryPoints, int treasureValue, String effect) {
        this.name = name;
        this.cost = cost;
        this.victoryPoints = victoryPoints;
        this.treasureValue = treasureValue;
        this.effect = effect;
        this.type = type;
        this.art = setDefaultArt();
    }

    // masterconstructor(basegame)
    public DomCard(String name, String type, int cost, int victoryPoints, int treasureValue, int draws, int addActions,
            int buys,
            String effect) {
        this.name = name;
        this.cost = cost;
        this.victoryPoints = victoryPoints;
        this.treasureValue = treasureValue;
        this.effect = effect;
        this.type = type;
        this.drawammount = draws;
        this.additionalActions = addActions;
        this.art = setDefaultArt();
    }

    // masterconstructor(+vills and coffers)
    public DomCard(String name, String type, int cost, int victoryPoints, int treasureValue, int draws, int addActions,
            int buys,
            int coffers, int villagers, String effect) {
        this.name = name;
        this.cost = cost;
        this.victoryPoints = victoryPoints;
        this.treasureValue = treasureValue;
        this.effect = effect;
        this.type = type;
        this.drawammount = draws;
        this.additionalActions = addActions;
        this.coffers = coffers;
        this.villagers = villagers;
        this.art = setDefaultArt();
    }

    // masterconstructor with art
    public DomCard(String name, String type, int cost, int victoryPoints, int treasureValue, int draws, int addActions,
            int coffers, int villagers, String effect, String art) {
        this.name = name;
        this.cost = cost;
        this.victoryPoints = victoryPoints;
        this.treasureValue = treasureValue;
        this.effect = effect;
        this.type = type;
        this.drawammount = draws;
        this.additionalActions = addActions;
        this.coffers = coffers;
        this.villagers = villagers;
        this.art = art;
    }

    public void play(Player activPlayer) {
        activPlayer.addActions(this.additionalActions);
        activPlayer.addCoins(this.treasureValue);
        activPlayer.addCoffers(this.coffers);
        activPlayer.addVillagers(this.villagers);
        activPlayer.addBuys(this.buys);
        for (int i = 0; i < drawammount; i++) {
            activPlayer.drawFromDeck();
        }
    }

    public void purchace(Player activPlayer) {
        activPlayer.setCoins(-cost);
    }

    public String getName() {
        return this.name;
    }

    public String getPrettyName() {
        String template = " |                              | ";
        int start = (template.length() - this.name.length()) / 2;
        int end = start + this.name.length();
        return template.substring(0, start) + this.name + template.substring(end);
    }

    public String getPrettyCostType() {
        String template = " |(" + this.cost + ")                           | ";
        int start = (template.length() - this.type.length()) / 2;
        int end = start + this.type.length();
        return template.substring(0, start) + this.type + template.substring(end);
    }

    public int getCost() {
        return this.cost;
    }

    public int getVictoryPoints() {
        return this.victoryPoints;
    }

    public int getTreasureValue() {
        return this.treasureValue;
    }

    public String getEffect() {
        return this.effect;
    }

    public String getEffect_Line(int linenum) {
        String[] lines = this.effect.split("\\r?\\n");
        if (lines.length < linenum) {
            return " |  .                        .  | "; // filler line
        } else {
            return lines[linenum - 1];
        }
    }

    public String getArt() {
        return this.art;
    }

    public String getType() {
        return this.type;
    }

    private String setDefaultArt() {
        String DefArt = "";
        DefArt += "\n|  _______________________  |";
        DefArt += "\n| |                       | |";
        DefArt += "\n| |           Art         | |";
        DefArt += "\n| |_______________________| |";
        return DefArt;
    }

    public void prettyPrint() {
        System.out.println("\n ============================== ");
        System.out.println("|     " + this.name + "   |");
        System.out.println(this.art);
        // System.out.println("______________________________");
        if (this.victoryPoints != 0) {
            System.out.println("|     " + this.victoryPoints + " VP  |");
        }
        if (!this.effect.isEmpty()) {
            System.out.println(this.effect);

        }
        System.out.println(" ____________________________ ");
        System.out.println("|            Cost: (" + this.cost + ") |");
        System.out.println("|    Type: " + this.type + "    |");
        System.out.println("==============================\n");
    }

}