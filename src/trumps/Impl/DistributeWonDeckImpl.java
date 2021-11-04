package trumps.Impl;

import trumps.deckAliceList;
import trumps.deckBobList;

public class DistributeWonDeckImpl {

    void distributeWonDeck(){
        if(CompareCategoryImpl.isBest == AliceCategory){
            for(int i = 0; i < activCards.length; i ++){
                deckAliceList.add(acvtivCards[i]);
            }
        }
        else{
            for(int j = 0; j < activCards.length; j ++){
                deckBobList.add(acvtivCards[j]);
            }
        }
    }
}
