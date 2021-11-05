package trumps;
import org.junit.Assert;
import org.junit.Test;
import trumps.Exceptions.GameExceptions;
import trumps.Exceptions.StatusException;
import trumps.Exceptions.tooManyPlayersException;
import trumps.Impl.Card;
import trumps.Impl.Player;
import trumps.Impl.TopTrumpsImpl;

public class TrumpsTests {
    public static final String first_player = "*";
    public static final String second_player = "~";
    public static final String third_player = "#";

    @Test
    private TopTrumps getTopTrumps(){
        return new TopTrumpsImpl();
    }

    public void goodstart1() throws StatusException, GameExceptions, tooManyPlayersException {
        TopTrumps tt = this.getTopTrumps();
        Player first_player = tt.start("*");

        Assert.assertEquals(TopTrumpsImpl.active_player, first_player);
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
    public void failureStart3Times() throws StatusException, GameExceptions, tooManyPlayersException {
        TopTrumps tt = this.getTopTrumps();
        tt.start("*");
        tt.start("~");
        tt.start("~");
    }
    /**
     * test getFirstCard()
     *- ist die Karte die erste Karte von der cards Liste des players
     * -gameException, wenn auf die Karten des anderen players zugegriffen wird
     * -statusException, falls die player noch keine cards Listen haben
     * -statusException, falls keine Karten mehr in der cards Liste eines der player ist
     */
    @Test void goodGetFirstCard1() throws StatusException, GameExceptions{
        TopTrumps tt = this.getTopTrumps();
        Card actual = tt.getFirstCard();
        Assert.assertEquals(Player.cards[0], actual);
    }

    @Test void goodGetFirstCard2() throws StatusException, GameExceptions{
        TopTrumps tt = this.getTopTrumps();
        Card actual = tt.getFirstCard();
        Assert.assertEquals(Player.cards[0].getOwner, actual.getOwner());
    }

    /** test CompareCategory()
     * -kann man alle Kategorien wählen?
     * -Exception bei ausgewählter Category > 4.
     * -statusexception falls noch keine Decks gewählt.
     * -statusexception wenn jemand versucht start() aufzurufen nachdem decks vergeben wurden und bereits
     *  compareCategory gespielt wird.
     */
    @Test
    public void goodCompareCategory1() throws StatusException, GameExceptions {
        TopTrumps ttÜberprüfung = new TopTrumpsImpl();
        ttÜberprüfung.compareCategory(1,1);
        int actual = ttÜberprüfung.getCategory1();
        Assert.assertEquals(1, actual);
    }
}
