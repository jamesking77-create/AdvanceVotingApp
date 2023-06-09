package data.repository;

import data.model.Vote;

import java.util.ArrayList;
import java.util.List;

public class VoteRepositoryImpl implements VoteRepository{
    private int count;
    private final List<Vote> votes = new ArrayList<>();
    @Override
    public Vote saveVote(Vote vote) {
        boolean voteIsNotSaved = vote.getVoteId() == 0;
        if (voteIsNotSaved){
            saveNewVote(vote);
            votes.add(vote);
            count++;
        }
        return vote;
    }

    private void saveNewVote(Vote vote) {
        vote.setVoteId(generateVoteId());
    }

    private int generateVoteId() {
        return count + 1;
    }

    @Override
    public Vote findVoteById(int id) {
        for (Vote vote: votes) {
           if (id == vote.getVoteId()) return vote;
        }
        return null;
    }

    @Override
    public List<Vote> findAllVote() {
        return votes;
    }

    @Override
    public void deleteVoteById(int id) {
        for (Vote vote: votes) {
            if (id == vote.getVoteId()) {
                votes.remove(vote);
                count--;
                break;
            }
        }
    }

    @Override
    public void deleteAllVote() {
        votes.clear();
        count = 0;


    }

    @Override
    public long countVote() {
        return count;
    }

    @Override
    public Vote findVoteByVotersUserName(String userName) {
        for (Vote vote: votes) {
            if (userName.equals(vote.getVoterName())) return vote;
        }
        return null;
    }
}
