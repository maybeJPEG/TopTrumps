package trumps.Impl;

import trumps.*;
import trumps.Exceptions.*;

import java.util.ArrayList;

public class TopTrumpsImpl implements TopTrumps {

    private Player first_player;
    private Player second_player;
    public Player active_player;
    private ArrayList<Card> activeCards = new ArrayList<Card>();

    public TopTrumpsImpl(){
        this.first_player = new Player("alice");
        this.second_player = new Player("bob");
    }

    @Override
    public int start(int player) throws GameExceptions, StatusException, tooManyPlayersException, WrongNameException {
        return 0;
    }

    @Override
    public int[] getFirstCard(int player) throws GameExceptions, StatusException, MatchException, NotYourTurnException {
        Player playerOBJ = get_player_from_integer(player);
        Card actual_card = playerOBJ.getActual_card();
        return actual_card.get_secure_list();
    }

    private Player get_player_from_integer(int player) {
        //if 1 return first object
        //if 2 return second object
        return null;
    }

    @Override
    public int compareCategory(int category, int player) throws GameExceptions, StatusException {
       validate_actual_player(player);
       validate_category();
       compare_cards(category);
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

    private int compare_cards(int category) {
        //TODO
        //this.first_player.get_active_card.get_category(category)
        //compare to
        //this.second_player.get_active_card.get_category(category)

        //if 1 won. actual_player = first_player. return -> 1
        //if 2 won. actual_player = second_player. return -> 2
        //if equal. return -> 3
        return 0;
    }

    private void validate_category() {
        //TODO
        //throw exception if category incorrect
    }

    private void validate_actual_player(int player) {
        //TODO
        //check with get_player_from_integer() if playerOBJ equals active_player otherwise throw exception
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

