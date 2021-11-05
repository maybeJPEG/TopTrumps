package trumps;

import trumps.Exceptions.DrawException;
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
    /**
     * Method start: Each Player picks a Number ( 1 or 2). The main Deck gets divided in two Decks and the
     * Cards will be distributed to the two Players. Player with number one starts the game and will be set
     * to active_player by the program.
     * @return active_player
     * @throws GameExceptions if a third player wants to join.
     * @throws StatusException if the Cards are already distributed.
     */
    Player start() throws GameExceptions, StatusException;

    /**
     * The active_player, which is the player that is allowed to make a move in the game, gets the first
     * Card on their Deck.
     * @param player
     * @return Card
     * @throws GameExceptions if no Cards in players Deck.
     * @throws StatusException the Players didn't pick their numbers yet.
     */
    Card getFirstCard(Player player) throws GameExceptions, StatusException;

    /**
     * the active_player picks a Category from their Card. The Category will be compared to the same Category
     * on the other Players Card. The Category with the higher value wins the round. This method will
     * determine the higher value. In case of a draw the method getFirstCard will be called and the still
     * active_player will again choose the Category they want to play from the new Card. This will be repeated
     * until one Category can be determined as higher than the other players Category. All Cards which
     * Category's have been compared get added to a List called active_Cards and will be added to the end
     * of the players Deck who had the higher Category.
     * @param category
     * @param player
     * @return player with best Category
     * @throws GameExceptions
     * @throws StatusException
     * @throws DrawException
     */
    int compareCategory(int category, int player) throws GameExceptions, StatusException;

    /**
     *  In Case one Player decides to give up all their Cards will be added at the end of the other players
     *  deck and the other Player will be determined as winner of the game.
     * @param player which wants to end the game
     * @return player that won the game
     */
    Player giveUp(int player);

}
