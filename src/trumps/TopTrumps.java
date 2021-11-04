package trumps;

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
     * Pick a Deck
     * @param userName user name
     * @param wantedDeck user asks for one of the Decks
     * @return selected Deck
     * @throws GameExceptions if all Decks are taken
     * @throws StatusException will be called if games hasn't started yet
     */
    TopTrumpsClients pick(String userName, TopTrumpsClients wantedDeck)
            throws GameExceptions, StatusException;

    /**
     * Chooses best Category from DeckOfCards index 0
     * returns Category
     * @throws GameExceptions if no Category isBest
     */
    ChooseCategoryImpl chooseCategory(int bestCategory)
            throws GameExceptions;

    /**
     * Compares Category with other players DeckOfCards index 0
     * returns winner of round
     * @throws GameExceptions if draw
     */
    CompareCategoryImpl compareCategory(int CategoryAlice, int CategoryBob)
            throws GameExceptions;

    /**
     * the played Cards will be put at the end of the players Deck who won this round
     * @throws GameExceptions if no Cards in cardsPlayedList
     */
    DistributeWonDeckImpl distributeWonDeck()
            throws GameExceptions;
}
