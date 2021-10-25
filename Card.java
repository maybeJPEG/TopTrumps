package trumps;

public class Card {
    private int Category1;
    private int Category2;
    private int Category3;
    private int Category4;

    public Card(int Category1, int Category2, int Category3, int Category4 ){
        this.Category1 = Category1;
        this.Category2 = Category2;
        this.Category3 = Category3;
        this.Category4 = Category4;
    }

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
