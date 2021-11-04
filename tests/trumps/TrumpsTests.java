package trumps;
import org.junit.Assert;
import org.junit.Test;
import trumps.Exceptions.GameExceptions;
import trumps.Exceptions.StatusException;
import trumps.Impl.Player;
import trumps.Impl.TopTrumpsImpl;

public class TrumpsTests {
    public static final String Alice = "ALice";
    public static final String Bob = "Bob";
    public static final String Clara = "Clara";

    @Test
    private TopTrumps getTopTrumps(){
        return new TopTrumpsImpl();
    }

    public void goodPickDeck1() throws StatusException, GameExceptions {
        TopTrumps tt = this.getTopTrumps();
        Player aliceDeck = tt.pick(Alice, Player.Deck1);

        Assert.assertEquals(Player.Deck1, aliceDeck);
    }

    public void goodPickDeck2() throws StatusException, GameExceptions {
        TopTrumps tt = this.getTopTrumps();
        Player aliceDeck = tt.pick(Alice, Player.Deck1);
        Player BobDeck = tt.pick(Bob, Player.Deck2);
        Assert.assertEquals(Player.Deck1, aliceDeck);
        Assert.assertEquals(Player.Deck2, BobDeck);
    }

    public void goodPickDeck3() throws StatusException, GameExceptions {
        TopTrumps tt = this.getTopTrumps();
        Player aliceDeck = tt.pick(Alice, Player.Deck1);
        Player BobDeck = tt.pick(Bob, Player.Deck1);
        Assert.assertEquals(Player.Deck1, aliceDeck);
        Assert.assertEquals(Player.Deck2, BobDeck);
    }

    public void goodPickDeck4() throws StatusException, GameExceptions {
        TopTrumps tt = this.getTopTrumps();
        Player BobDeck = tt.pick(Bob, Player.Deck1);
        Player aliceDeck = tt.pick(Alice, Player.Deck1);
        Assert.assertEquals(Player.Deck1, BobDeck);
        Assert.assertEquals(Player.Deck2, aliceDeck);
    }

    public void goodPickDeck5() throws StatusException, GameExceptions {
        TopTrumps tt = this.getTopTrumps();
        Player BobDeck = tt.pick(Bob, Player.Deck1);
        //reconsidered
        BobDeck = tt.pick(Bob, Player.Deck2);
        Player aliceDeck = tt.pick(Alice, Player.Deck1);
        Assert.assertEquals(Player.Deck2, BobDeck);
        Assert.assertEquals(Player.Deck1, aliceDeck);
    }

    @Test(expected=GameException.class)
    public void failurePickDeck3Times() Throws GameException, StatusException {
        TopTrumps tt = this.getTopTrumps();
        tt.pick(Alice, Player.Deck1);
        tt.pick(Bob, Player.Deck2);
        tt.pick(Clara, Player.Deck2);
    }

    /** test ChooseCategory
     * -kann man alle Kategorien wählen?
     * -Exception bei Category > 4.
     * -statusexception falls noch keine Decks gewählt.
     * -statusexception wenn jemand versucht pick aufzurufen nachdem decks vergeben wurden und bereits
     *  chooseCategory gespielt wird.
     */
}
