package dtos.Requests;

import data.model.User;

public class CastVoteRequest {
    private int voteId;
    private int partyId;
    private User voter;
    private String partyName;
    private String username;

    @Override
    public String toString() {
        return "CastVoteRequest{" +
                "voteId=" + voteId +
                ", partyId=" + partyId +
                ", voter=" + voter +
                ", partyName='" + partyName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
        this.voter = voter;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }
    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
}
