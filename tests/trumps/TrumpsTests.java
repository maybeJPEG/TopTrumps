package trumps;
import org.junit.Assert;
import org.junit.Test;
import trumps.Exceptions.*;
import trumps.Impl.Card;
import trumps.Impl.Player;
import trumps.Impl.TopTrumpsImpl;

public class TrumpsTests {
  /*  public static final String first_player = "Bob";
    public static final String second_player = "Alice";
    public static final String third_player = "Clara";*/

    public TopTrumpsImpl getTopTrumps() throws NotExistentValueException {
        return new TopTrumpsImpl();
    }

   /* @Test(expected = tooManyPlayersException.class)
    public void tooManyPlayers() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException {
        TopTrumps Game = getTopTrumps();
        for(int i = 3; i < 1000; i++){
            Game.start(i);
        }
    }*/

    /*@Test(expected = tooManyPlayersException.class)
    public void wrongAmountOfPlayers() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException {
        TopTrumps Game = getTopTrumps();
        for(int i = -3; i > -1000; i++){
            Game.start(i);
        }
    }*/

    @Test()
    public void goodstart1() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException, NotExistentPlayerException, NotExistentValueException {
        TopTrumps Game = getTopTrumps();
        int player = Game.start();
        Assert.assertTrue(if_1_or_2(player)); ;
    }

    private boolean if_1_or_2(int player) {
        return player==1||player==2;
    }

  /*  public void goodstart2() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException {
        TopTrumps tt = this.getTopTrumps();
        int first_player = tt.start(1);
        int second_player = tt.start(2);
       // Assert.assertEquals(TopTrumpsImpl.active_player, first_player);
     //   Assert.assertEquals(TopTrumpsImpl.second_player, second_player);
    }*/

   /* public void goodstart3() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException {
        TopTrumps tt = this.getTopTrumps();
        int first_player = tt.start(1);
        int second_player = tt.start(2);
       // Assert.assertEquals(TopTrumpsImpl.active_player, first_player);
       // Assert.assertEquals(TopTrumpsImpl.second_player, second_player);
    }*/

    /*public void goodstart4() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException {
        TopTrumps tt = this.getTopTrumps();
        int second_player = tt.start(1);
        int first_player = tt.start(2);
       // Assert.assertEquals(TopTrumpsImpl.active_player, second_player);
       // Assert.assertEquals(TopTrumpsImpl.first_player, first_player);
    }*/

   /* public void goodstart5() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException {
        TopTrumps tt = this.getTopTrumps();
        int second_player = tt.start(1);
        //reconsiders
        second_player = tt.start(2);
        int first_player = tt.start(1);
     //   Assert.assertEquals(TopTrumpsImpl.active_player, first_player);
        // Assert.assertEquals(TopTrumpsImpl.second_player, second_player);
    }

    @Test(expected=tooManyPlayersException.class)
    public void failureStart3Times() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException {
        TopTrumps tt = this.getTopTrumps();
        tt.start(1);
        tt.start(2);
        tt.start(2);
    }*/

    /**
     * test getFirstCard()
     * -statusException, falls die player noch keine cards Listen haben
     * -MatchException, falls keine Karten mehr in der cards Liste eines der player ist
     */
    @Test
    public void if_card_list_has_4_categories() throws StatusException, GameExceptions, MatchException, NotYourTurnException, NotExistentPlayerException, NotExistentValueException {
        TopTrumps tt = this.getTopTrumps();
        int[] actual_card_list = tt.getFirstCard(1);
        Assert.assertEquals(4, actual_card_list.length);
    }

  /*  @Test
    public void goodGetFirstCard2() throws StatusException, GameExceptions, MatchException, NotYourTurnException {
        TopTrumps tt = this.getTopTrumps();
        Card actual = tt.getFirstCard();
        Assert.assertEquals(Player.cards[0].getOwner, actual.getOwner());
    }*/

  /*  @Test
    void goodGetFirstCard3() throws StatusException, GameExceptions, MatchException, NotYourTurnException {
        TopTrumps tt = this.getTopTrumps();
        Player actual = tt.getFirstCard().getOwner();
        Assert.assertEquals(TopTrumpsImpl.active_player, actual);
    }*/

    /*@Test(expected=NotYourTurnException.class)
    void failureGetFirstCard1() throws StatusException, GameExceptions, MatchException, NotYourTurnException {
        TopTrumps tt = this.getTopTrumps();
        Player actual = tt.getFirstCard().getOwner();
        Assert.assertNotEquals(TopTrumpsImpl.active_player, actual);
    }*/

   /* @Test(expected = MatchException.class)
    void failureGetfirstCard2() throws StatusException, GameExceptions, MatchException, NotYourTurnException {
        TopTrumps tt = this.getTopTrumps();
        tt.getFirstCard();
        // No more cards in players Deck, other Player has won
    }*/


    /** test CompareCategory()
     * -kann man alle Kategorien wählen?
     * -Exception bei ausgewählter Category > 4.
     * -statusexception falls noch keine Decks gewählt.
     * -statusexception, wenn jemand versucht start() aufzurufen, nachdem decks vergeben wurden und bereits
     *  compareCategory gespielt wird.
     */
    @Test
    public void goodCompareCategory1() throws StatusException, GameExceptions, CategoryDoesNotExistException, NotExistentValueException, NotExistentPlayerException, NotYourTurnException, DrawException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.compareCategory(1,1);
       // int actual = tt.getCategory1();
        //Assert.assertEquals(1, actual);
    }

    @Test
    public void goodCompareCategory2() throws StatusException, GameExceptions, CategoryDoesNotExistException, NotExistentValueException, NotExistentPlayerException, NotYourTurnException, DrawException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.compareCategory(2,1);
      //  int actual = tt.getCategory2();
       // Assert.assertEquals(2, actual);
    }

    @Test
    public void goodCompareCategory3() throws StatusException, GameExceptions, CategoryDoesNotExistException, NotExistentValueException, NotExistentPlayerException, NotYourTurnException, DrawException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.compareCategory(3,1);
     //   int actual = tt.getCategory3();
       // Assert.assertEquals(3, actual);
    }

    @Test
    public void goodCompareCategory4() throws StatusException, GameExceptions, CategoryDoesNotExistException, NotExistentValueException, NotExistentPlayerException, NotYourTurnException, DrawException {
        TopTrumps tt = new TopTrumpsImpl();
        int actual = tt.compareCategory(4,1);
        Assert.assertEquals(4, actual);
    }

    @Test(expected = CategoryDoesNotExistException.class)
    public void failureInvalidCategory() throws StatusException, GameExceptions, CategoryDoesNotExistException, NotExistentValueException, NotExistentPlayerException, NotYourTurnException, DrawException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.compareCategory(5,1);
    }

    @Test(expected = StartNotAllowedException.class)
    public void failureWrongStatusTest() throws StatusException, GameExceptions, WrongNameException, tooManyPlayersException, NotYourTurnException, MatchException, NotExistentValueException, NotExistentPlayerException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.start();
        tt.getFirstCard(1);
        tt.start();
    }

    @Test(expected = StartNotAllowedException.class)
    public void failureWrongStatusTest2() throws StatusException, GameExceptions, WrongNameException, tooManyPlayersException, NotYourTurnException, MatchException, CategoryDoesNotExistException, NotExistentValueException, NotExistentPlayerException, DrawException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.start();
        tt.getFirstCard(1);
        tt.compareCategory(3,1);
        tt.start();
    }

    @Test(expected = StartNotAllowedException.class)
    public void failureWrongStatusTest3() throws StatusException, GameExceptions, WrongNameException, tooManyPlayersException, NotYourTurnException, MatchException, CategoryDoesNotExistException, NotExistentValueException, NotExistentPlayerException, DrawException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.compareCategory(3,1);
        // start() hasn't been called yet, no players found or decks not distributed yet
    }
}

