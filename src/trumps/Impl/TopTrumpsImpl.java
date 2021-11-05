package trumps.Impl;

import trumps.*;
import trumps.Exceptions.GameExceptions;
import trumps.Exceptions.StatusException;

import java.util.ArrayList;

public class TopTrumpsImpl implements TopTrumps {

    private Player first_player;
    private Player second_player;
    public Player active_player;
    private ArrayList<Card> activeCards = new ArrayList<Card>();

    public TopTrumpsImpl(){
        this.first_player = new Player("bob");
        this.second_player = new Player("Alice");
    }


    @Override
    public Player start(String symbol) throws GameExceptions, StatusException {
        return null;
    }

    @Override
    public Card getFirstCard() throws GameExceptions, StatusException {
        return null;
    }

    @Override
    public int compareCategory(int category, int player) throws GameExceptions, StatusException {
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
            }if(category == 2){
                activeCards[0].getCategory2();
        }
        switch(category){
            case 1: activeCards.getCategory2[0];
            case 2
        }*/


        return 0;
    }

    @Override
    public Player giveUp(int player) {
        return null;
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

