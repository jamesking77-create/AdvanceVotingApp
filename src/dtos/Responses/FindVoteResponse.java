package dtos.Responses;

public class FindVoteResponse {
    private String partyName;
    private int partyId;
    private  String message;

    @Override
    public String toString() {
        return "FindVoteResponse{" +
                "partyName='" + partyName + '\'' +
                ", partyId=" + partyId +
                ", message='" + message + '\'' +
                '}';
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
