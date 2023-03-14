package utils;


import data.model.PermanentVotersCard;
import data.model.PoliticalParty;
import data.model.User;
import data.model.Vote;
import dtos.Requests.*;
import dtos.Responses.*;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterUserRequest registerRequest) {
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUserName(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return user;
    }
    public static void map(User foundUser, FindUserResponse response){
        response.setFullName(foundUser.getFirstName()+ " " + foundUser.getLastName());
        response.setUserId(foundUser.getUserId());
        response.setUsername(foundUser.getUserName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateRegistered()));
    }
    public static User map(LogInRequest logInRequest){
        User user = new User();
        user.setUserName(logInRequest.getUsername());
        return user;
    }

    public static void map(User foundUser, LogInResponse response){
        response.setUserName(foundUser.getUserName());
        response.setMessage("WELCOME TO PVM");
    }

    public static void map(CastVoteRequest vote, FindVoteResponse voteResponse) {
        voteResponse.setPartyName(vote.getPartyName());
        voteResponse.setPartyId(vote.getPartyId());
        voteResponse.setMessage(vote.getUsername() + " you have successfully voted for " + vote.getPartyName());
    }
    public static PoliticalParty map(RegisterPartyRequest partyRequest) {
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setName(partyRequest.getPartyName());
        politicalParty.setCandidate(partyRequest.getCandidate());
        politicalParty.setAdmin(partyRequest.getAdmin());
        politicalParty.setUser(partyRequest.getUser());
        return politicalParty;
    }
    public static void map(PoliticalParty foundParty, FindPartyResponse partyResponse) {
        partyResponse.setPartyName(foundParty.getName());
        partyResponse.setCandidate(foundParty.getCandidate());
        partyResponse.setMessage(foundParty.getName()+ " has been registered successfully");
    }
    public static void map(RegisterForPvcRequest pvcRequest, FindPvcResponse pvcResponse) {
        pvcResponse.setFullName(pvcRequest.getFirstName() + pvcRequest.getLastName());
        pvcResponse.setMessage(pvcRequest.getLastName() + " you have registered successfully please go to your local district to collect your card");
    }

    public static PermanentVotersCard map(RegisterForPvcRequest pvcRequest) {
        PermanentVotersCard votersCard = new PermanentVotersCard();
        votersCard.setFullName(pvcRequest.getFirstName() + pvcRequest.getLastName());
        votersCard.setGender(pvcRequest.getGender());
        votersCard.setOccupation(pvcRequest.getOccupation());
        votersCard.setState(pvcRequest.getState());
        votersCard.setDateOfBirth(pvcRequest.getDateOfBirth());
        return votersCard;
    }

    public static Vote map(CastVoteRequest castVoteRequest) {
        Vote vote = new Vote();
        vote.setVoteId(castVoteRequest.getVoteId());
        vote.setThumbPrint(castVoteRequest.getPartyId());
        vote.setVoterName(castVoteRequest.getUsername());
        return vote;
    }
}
