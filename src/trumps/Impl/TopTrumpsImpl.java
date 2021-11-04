package trumps.Impl;

import trumps.*;
import trumps.Exceptions.GameExceptions;

public class TopTrumpsImpl implements TopTrumps {

    private Player first_player;
    private Player second_player;

    public TopTrumpsImpl(){
        this.first_player = new Player("bob");
        this.second_player = new Player("Alice");
    }

    @Override
    public int chooseCategory(int bestCategory) throws GameExceptions {

       // Card C = new Card();
       // cardsPlayedList activCards = new cardsPlayedList();
       // activCards.addCardsPlayed(C);

        return 0;
    }

    @Override
    public int compareCategory(int CategoryAlice, int CategoryBob) throws GameExceptions {
            //  public void compareCategory(){
          //  if (ChooseCategoryImpl.activCards.Length >= 2) {
              /*  CategoryAlice = isBest;
                for (int i = 0, i <activCards.Length, i++){
                    if (CategoryBob > CategoryAlice) {
                        CategoryBob = isBest;
                    }
                    return isBest;
                }
            }*/
        return 0;
    }

    //public DistributeWonDeckImpl distributeWonDeck() throws GameExceptions {
            /*if(CompareCategoryImpl.isBest == AliceCategory){
                for(int i = 0; i < activCards.length; i ++){
                    aliceCards.add(acvtivCards[i]);
                }
            }
            else{
                for(int j = 0; j < activCards.length; j ++){
                    bobCards.add(acvtivCards[j]);
                }
            }*/
     //   return null;
   // }
}

