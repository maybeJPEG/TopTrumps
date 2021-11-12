package trumps.Impl;

import trumps.*;
import trumps.Exceptions.*;

import java.util.ArrayList;
import java.util.Random;

public class TopTrumpsImpl implements TopTrumps {

    private Player first_player;
    private Player second_player;
    public Player active_player;
    private ArrayList<Card> activeCards = new ArrayList<Card>();

    public TopTrumpsImpl() throws NotExistentValueException {
        this.first_player = new Player("alice");
        this.second_player = new Player("bob");
    }

    @Override
    public int start() throws GameExceptions, StatusException, tooManyPlayersException, WrongNameException, NotExistentPlayerException {
        determine_active_player();
        if(determine_active_player()==1){
            active_player = first_player;
            return 1;
        }
        else{
            active_player = second_player;
            return 2;
        }
    }

    private int determine_active_player() throws NotExistentPlayerException {
        int random = 1;
        Random r = new Random();
        random = r.nextInt(2);
        if(random>2 || random <0){
            throw new NotExistentPlayerException("Must return number 1 for first_player or number 2 for second_player");
        }
        return random;
    }

    @Override
    public int[] getFirstCard(int player) throws GameExceptions, StatusException, MatchException, NotYourTurnException, NotExistentPlayerException {
        Player playerOBJ = get_player_from_integer(player);
        Card actual_card = playerOBJ.getActual_card();
        return actual_card.get_secure_list();
    }

    private Player get_player_from_integer(int player) throws NotExistentPlayerException{
        if(player == 1){
            return first_player;
        }
        if(player == 2){
            return second_player;
        }
        else {
            throw new NotExistentPlayerException("This Player does not exist");
        }
    }

    @Override
    public int compareCategory(int category, int player) throws GameExceptions, StatusException, NotExistentPlayerException, NotYourTurnException, CategoryDoesNotExistException {
       validate_actual_player(player);
       validate_category(category);
       compare_cards(category);
        return 0;
    }

    private void validate_actual_player(int player) throws NotExistentPlayerException, NotYourTurnException {
        Player playerOBJ = get_player_from_integer(player);
        if(playerOBJ != this.active_player){
            throw new NotYourTurnException();
        }
    }

    private void validate_category(int category) throws CategoryDoesNotExistException {
        int categoryOBJ = category;
        if(categoryOBJ > 5 || categoryOBJ < 1){
            throw new CategoryDoesNotExistException();
        }
    }

    private int compare_cards(int category) throws CategoryDoesNotExistException {

        if(this.first_player.getActual_card().getCategory(category) > this.second_player.getActual_card().getCategory(category)){
            first_player = active_player;
            return 1;
        }
        if(this.second_player.getActual_card().getCategory(category) > this.first_player.getActual_card().getCategory(category)){
            second_player = active_player;
            return 2;
        }

        //if equal. return -> 3
        return 0;
    }

    @Override
    public Player giveUp(int player) {
        return null;
    }

}

