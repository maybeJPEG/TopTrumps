package trumps;

import trumps.Exceptions.GameExceptions;
import trumps.Exceptions.StatusException;
import trumps.Impl.Card;
import trumps.Impl.Player;

/**
 * Rules:
 * Each card contains a list of numerical data, and the aim of the gme is to compare
 * these values to try to trump and win an opponents cards.
 * The starting player selects a category from their topmost card reads out its value. The other player
 * then reads out the value of the same category from their card. The best value wins the trick,
 * and the winner takes all the cards of the trick and places them at the botoom of their pile.
 * The winner then looks at their new topmost card, and chooses the category for the next round.
 *
 * In the event of a draw the cards are placed in the center and a new category is chosen from the next
 * card by the same person as in the previous round. The winner gets all the cards, including the once
 * placed in the center.
 *
 * The winner is the player who obtains the whole pack.
 */



public interface TopTrumps {

    Player start();
    Card getFirstCard(Player player);
    int compareCategory(int category, Player player) throws GameExceptions;
    void giveUp();

}
