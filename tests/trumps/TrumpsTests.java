package trumps;
import org.junit.Assert;
import org.junit.Test;
import trumps.Exceptions.*;
import trumps.Impl.Card;
import trumps.Impl.Player;
import trumps.Impl.TopTrumpsImpl;

public class TrumpsTests {
    public static final String first_player = "*";
    public static final String second_player = "~";
    public static final String third_player = "#";

    public TopTrumpsImpl getGameInstance(){
        return new TopTrumpsImpl();
    }

    @Test(expected = WrongNameException.class)
    private void test_wrong_name() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException {
        TopTrumps Game = getGameInstance();
        Game.start("g");
    }

    @Test()
    public void goodstart1() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException {
        TopTrumps Game = getGameInstance();
        int player = Game.start("bob");
        Assert.assertTrue(if_1_or_2(player)); ;
    }

    private boolean if_1_or_2(int player) {
        return player==1||player==2;
    }

    public void goodstart2() throws StatusException, GameExceptions, tooManyPlayersException {
        TopTrumps tt = this.getTopTrumps();
        Player first_player = tt.start("*");
        Player second_player = tt.start("~");
        Assert.assertEquals(TopTrumpsImpl.active_player, first_player);
        Assert.assertEquals(TopTrumpsImpl.second_player, second_player);
    }

    public void goodstart3() throws StatusException, GameExceptions, tooManyPlayersException {
        TopTrumps tt = this.getTopTrumps();
        Player first_player = tt.start("*");
        Player second_player = tt.start("*");
        Assert.assertEquals(TopTrumpsImpl.active_player, first_player);
        Assert.assertEquals(TopTrumpsImpl.second_player, second_player);
    }

    public void goodstart4() throws StatusException, GameExceptions, tooManyPlayersException {
        TopTrumps tt = this.getTopTrumps();
        Player second_player = tt.start("*");
        Player first_player = tt.start("*");
        Assert.assertEquals(TopTrumpsImpl.active_player, second_player);
        Assert.assertEquals(TopTrumpsImpl.first_player, first_player);
    }

    public void goodstart5() throws StatusException, GameExceptions, tooManyPlayersException {
        TopTrumps tt = this.getTopTrumps();
        Player second_player = tt.start("*");
        //reconsiders
        second_player = tt.start("~");
        Player first_player = tt.start("*");
        Assert.assertEquals(TopTrumpsImpl.active_player, first_player);
        Assert.assertEquals(TopTrumpsImpl.second_player, second_player);
    }

    @Test(expected=tooManyPlayersException.class)
    public void failureStart3Times() throws StatusException, GameExceptions, tooManyPlayersException, WrongNameException {
        TopTrumps tt = this.getTopTrumps();
        tt.start("*");
        tt.start("~");
        tt.start("~");
    }
    /**
     * test getFirstCard()
     * -statusException, falls die player noch keine cards Listen haben
     * -MatchException, falls keine Karten mehr in der cards Liste eines der player ist
     */
    @Test
    void goodGetFirstCard1() throws StatusException, GameExceptions, MatchException, NotYourTurnException {
        TopTrumps tt = this.getTopTrumps();
        Card actual = tt.getFirstCard();
        Assert.assertEquals(Player.getCards[0], actual);
    }

    @Test
    void goodGetFirstCard2() throws StatusException, GameExceptions, MatchException, NotYourTurnException {
        TopTrumps tt = this.getTopTrumps();
        Card actual = tt.getFirstCard();
        Assert.assertEquals(Player.cards[0].getOwner, actual.getOwner());
    }

    @Test
    void goodGetFirstCard3() throws StatusException, GameExceptions, MatchException, NotYourTurnException {
        TopTrumps tt = this.getTopTrumps();
        Player actual = tt.getFirstCard().getOwner();
        Assert.assertEquals(TopTrumpsImpl.active_player, actual);
    }

    @Test(expected=NotYourTurnException.class)
    void failureGetFirstCard1() throws StatusException, GameExceptions, MatchException, NotYourTurnException {
        TopTrumps tt = this.getTopTrumps();
        Player actual = tt.getFirstCard().getOwner();
        Assert.assertNotEquals(TopTrumpsImpl.active_player, actual);
    }

    @Test(expected = MatchException.class)
    void failureGetfirstCard2() throws StatusException, GameExceptions, MatchException, NotYourTurnException {
        TopTrumps tt = this.getTopTrumps();
        tt.getFirstCard();
        // No more cards in players Deck
    }


    /** test CompareCategory()
     * -kann man alle Kategorien wählen?
     * -Exception bei ausgewählter Category > 4.
     * -statusexception falls noch keine Decks gewählt.
     * -statusexception wenn jemand versucht start() aufzurufen nachdem decks vergeben wurden und bereits
     *  compareCategory gespielt wird.
     */
    @Test
    public void goodCompareCategory1() throws StatusException, GameExceptions, CategoryDoesNotExistException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.compareCategory(1,1);
        int actual = tt.getCategory1();
        Assert.assertEquals(1, actual);
    }

    @Test
    public void goodCompareCategory2() throws StatusException, GameExceptions, CategoryDoesNotExistException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.compareCategory(2,1);
        int actual = tt.getCategory2();
        Assert.assertEquals(2, actual);
    }

    @Test
    public void goodCompareCategory3() throws StatusException, GameExceptions, CategoryDoesNotExistException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.compareCategory(3,1);
        int actual = tt.getCategory3();
        Assert.assertEquals(3, actual);
    }

    @Test
    public void goodCompareCategory4() throws StatusException, GameExceptions, CategoryDoesNotExistException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.compareCategory(4,1);
        int actual = tt.getCategory4();
        Assert.assertEquals(4, actual);
    }

    @Test(expected = CategoryDoesNotExistExceptions.class)
    public void failureInvalidCategory() throws StatusException, GameExceptions, CategoryDoesNotExistException {
        TopTrumps tt = new TopTrumpsImpl();
        tt.compareCategory(5,1);
    }
}
