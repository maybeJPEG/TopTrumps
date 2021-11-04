package trumps.Impl;

import trumps.GameExceptions;
import trumps.StatusException;
import trumps.TopTrumps;
import trumps.TopTrumpsClients;

public class TopTrumpsImpl implements TopTrumps {

    @Override
    public TopTrumpsClients pick(String userName, TopTrumpsClients wantedDeck) throws GameExceptions, StatusException {
        return null;
    }

    @Override
    public ChooseCategoryImpl chooseCategory(int bestCategory) throws GameExceptions {
        return null;
    }

    @Override
    public CompareCategoryImpl compareCategory(int CategoryAlice, int CategoryBob) throws GameExceptions {
        return null;
    }

    @Override
    public DistributeWonDeckImpl distributeWonDeck() throws GameExceptions {
        return null;
    }
}

