package controllers;

import dtos.Requests.CastVoteRequest;
import service.VotingService;
import service.VotingServiceImpl;

public class VoteController {
    VotingService votingService = new VotingServiceImpl();

    public Object castVote(CastVoteRequest voteRequest){
        try{
            return votingService.castVote(voteRequest);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }


}
