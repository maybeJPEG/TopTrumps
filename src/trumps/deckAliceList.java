package trumps;

import java.sql.Array;
import java.util.ArrayList;

public class deckAliceList {
    ArrayList<Card>deckAliceList;

    public deckAliceList(String filepath) {
        deckAliceList = new ArrayList<Card>();
    }
    public void addCard(Card C){
        deckAliceList.add(C);
    }
    /**
     * List of Cards Alice plays with
     */
}
