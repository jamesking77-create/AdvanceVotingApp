package service;

import data.model.Vote;
import dtos.Requests.CastVoteRequest;
public interface VotingService {
    Vote castVote(CastVoteRequest castVoteRequest);
    String ShowGeneralVotingResult();
}
