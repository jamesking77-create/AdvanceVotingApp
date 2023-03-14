package data.model;

import java.util.List;

public class Vote {
    private String voterName;
    private int voteId;
    private int thumbPrint;
    private int userId;
    List <PoliticalParty>politicalParties;

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public List<PoliticalParty> getPoliticalParty() {
        return politicalParties;
    }

    public void setPoliticalParty(List<PoliticalParty> politicalParties) {
        this.politicalParties = politicalParties;
    }




    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }





    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getThumbPrint() {
        return thumbPrint;
    }

    public void setThumbPrint(int politicalPartyId) {
        this.thumbPrint = politicalPartyId;
    }
}
