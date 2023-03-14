package dtos.Responses;

import data.model.User;
import dtos.Requests.CastVoteRequest;

public class FindPartyResponse {
    private String partyName;
    private User candidate;
    private String message;

    private CastVoteRequest vote;

    @Override
    public String toString() {
        return "FindPartyResponse{" +
                "partyName='" + partyName + '\'' +
                ", candidate=" + candidate +
                ", message='" + message + '\'' +
                ", vote=" + vote +
                '}';
    }

    public User getCandidate() {
        return candidate;
    }

    public void setCandidate(User candidate) {
        this.candidate = candidate;
    }

    public CastVoteRequest getVote() {
        return vote;
    }

    public void setVote(CastVoteRequest vote) {
        this.vote = vote;
    }
    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
