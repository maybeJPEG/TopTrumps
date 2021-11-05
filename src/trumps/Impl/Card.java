package trumps.Impl;

public class Card {

    private int id;
    private Player owner;
    private int Category1;
    private int Category2;
    private int Category3;
    private int Category4;

    public Card(int id, Player owner){
        this.id = id;
        this.owner = owner;
        this.Category1 = random_number();
        this.Category2 = random_number();
        this.Category3 = random_number();
        this.Category4 = random_number();
    }

    private int random_number() {
        //TODO soll zufällige Zahlen zurückgeben
        return 0;
    }

    public Player getOwner() {return owner;}

    public int getCategory1() {
        return Category1;
    }

    public int getCategory2() {
        return Category2;
    }

    public int getCategory3() {
        return Category3;
    }

    public int getCategory4() {
        return Category4;
    }


}
