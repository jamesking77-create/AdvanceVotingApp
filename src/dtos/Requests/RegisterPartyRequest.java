package dtos.Requests;

import data.model.User;

public class RegisterPartyRequest {
    private String PartyName;
    private  String password;
    private User admin;
    private User candidate;
    private User user;

    @Override
    public String toString() {
        return "RegisterPartyRequest{" +
                ", PartyName='" + PartyName + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", candidate=" + candidate +
                ", user=" + user +
                '}';
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public User getCandidate() {
        return candidate;
    }

    public void setCandidate(User candidate) {
        this.candidate = candidate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPartyName() {
        return PartyName;
    }

    public void setPartyName(String partyName) {
        PartyName = partyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
