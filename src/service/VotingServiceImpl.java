package service;
import data.model.PoliticalParty;
import data.model.Vote;
import data.repository.VoteRepository;
import data.repository.VoteRepositoryImpl;
import dtos.Requests.CastVoteRequest;
import utils.Mapper;

public class VotingServiceImpl implements VotingService{

    VoteRepository voteRepository = new VoteRepositoryImpl();
    PoliticalPartyService partyService = new PoliticalPartyServiceImpl();

    @Override
    public Vote castVote(CastVoteRequest castVoteRequest) {
        if (voteExist(castVoteRequest.getUsername())) throw new IllegalArgumentException("vote declined (user have voted before now)");
        System.out.println("you have voted for "+ castVoteRequest.getPartyName() + " successfully");
        return voteRepository.saveVote(Mapper.map(castVoteRequest));
    }

    private boolean voteExist(String userName){
        Vote foundVote = voteRepository.findVoteByVotersUserName(userName);
        return foundVote != null;
    }

    @Override
    public String ShowGeneralVotingResult() {
        for (PoliticalParty party: partyService.findAllParty()){
            if (partyService.findAllParty().size() != 0)
                return partyService.showPartyNews(party.getName());
        }
        return partyService.showPartyNews("PDP");
    }
}
