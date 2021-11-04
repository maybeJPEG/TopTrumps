package trumps;
import org.junit.Assert;
import org.junit.Test;

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
        TopTrumpsClients aliceDeck = tt.pick(Alice, TopTrumpsClients.Deck1);

        Assert.assertEquals(TopTrumpsClients.Deck1, aliceDeck);
    }

    public void goodPickDeck2() throws StatusException, GameExceptions {
        TopTrumps tt = this.getTopTrumps();
        TopTrumpsClients aliceDeck = tt.pick(Alice, TopTrumpsClients.Deck1);
        TopTrumpsClients BobDeck = tt.pick(Bob, TopTrumpsClients.Deck2);
        Assert.assertEquals(TopTrumpsClients.Deck1, aliceDeck);
        Assert.assertEquals(TopTrumpsClients.Deck2, BobDeck);
    }

    public void goodPickDeck3() throws StatusException, GameExceptions {
        TopTrumps tt = this.getTopTrumps();
        TopTrumpsClients aliceDeck = tt.pick(Alice, TopTrumpsClients.Deck1);
        TopTrumpsClients BobDeck = tt.pick(Bob, TopTrumpsClients.Deck1);
        Assert.assertEquals(TopTrumpsClients.Deck1, aliceDeck);
        Assert.assertEquals(TopTrumpsClients.Deck2, BobDeck);
    }

    public void goodPickDeck4() throws StatusException, GameExceptions {
        TopTrumps tt = this.getTopTrumps();
        TopTrumpsClients BobDeck = tt.pick(Bob, TopTrumpsClients.Deck1);
        TopTrumpsClients aliceDeck = tt.pick(Alice, TopTrumpsClients.Deck1);
        Assert.assertEquals(TopTrumpsClients.Deck1, BobDeck);
        Assert.assertEquals(TopTrumpsClients.Deck2, aliceDeck);
    }

    public void goodPickDeck5() throws StatusException, GameExceptions {
        TopTrumps tt = this.getTopTrumps();
        TopTrumpsClients BobDeck = tt.pick(Bob, TopTrumpsClients.Deck1);
        //reconsidered
        BobDeck = tt.pick(Bob, TopTrumpsClients.Deck2);
        TopTrumpsClients aliceDeck = tt.pick(Alice, TopTrumpsClients.Deck1);
        Assert.assertEquals(TopTrumpsClients.Deck2, BobDeck);
        Assert.assertEquals(TopTrumpsClients.Deck1, aliceDeck);
    }

    @Test(expected=GameException.class)
    public void failurePickDeck3Times() Throws GameException, StatusException {
        TopTrumps tt = this.getTopTrumps();
        tt.pick(Alice, TopTrumpsClients.Deck1);
        tt.pick(Bob, TopTrumpsClients.Deck2);
        tt.pick(Clara, TopTrumpsClients.Deck2);
    }

    /** test ChooseCategory
     * -kann man alle Kategorien wählen?
     * -Exception bei Category > 4.
     * -statusexception falls noch keine Decks gewählt.
     * -statusexception wenn jemand versucht pick aufzurufen nachdem decks vergeben wurden und bereits
     *  chooseCategory gespielt wird.
     */
}
