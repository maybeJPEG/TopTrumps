package trumps.Impl;

import trumps.*;
import trumps.Exceptions.GameExceptions;

import java.util.ArrayList;

public class TopTrumpsImpl implements TopTrumps {

    private Player first_player;
    private Player second_player;
    private Player actual_player;
    private ArrayList<Card> activeCards = new ArrayList<Card>();

    public TopTrumpsImpl(){
        this.first_player = new Player("bob");
        this.second_player = new Player("Alice");
    }


    @Override
    public Player start() {
        //TODO wird gewürfelt, wer als Erster dran ist
        return null;
    }

    @Override
    public Card getFirstCard(Player player) {
        return null;
    }

    @Override
    public int compareCategory(int category, Player player) throws GameExceptions {
        //TODO
        //public void compareCategory(){
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

    @Override
    public void giveUp() {

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

