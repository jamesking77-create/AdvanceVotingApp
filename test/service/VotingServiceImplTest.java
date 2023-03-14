package service;
import data.model.PoliticalParty;
import data.model.User;
import data.model.Vote;
import dtos.Requests.CastVoteRequest;
import dtos.Requests.RegisterPartyRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VotingServiceImplTest {
    private VotingService votingService;
    private PoliticalPartyService partyService;
    private CastVoteRequest voteRequest;

    private CastVoteRequest voteRequest2;

    RegisterPartyRequest partyRequest;
        RegisterPartyRequest partyRequest2;

    User candidate;
    @BeforeEach public void setUp(){
        partyService = new PoliticalPartyServiceImpl();
        partyRequest = new RegisterPartyRequest();
        partyRequest2 = new RegisterPartyRequest();
        votingService = new VotingServiceImpl();
        voteRequest  = new CastVoteRequest();
        voteRequest.setPartyName("APC");
        voteRequest.setUsername("jamesKing");
        partyRequest.setPartyName("APC");
        partyRequest.setCandidate(candidate = new User());
        candidate.setUserName("tinubu");
        voteRequest2 = new CastVoteRequest();
        voteRequest2.setPartyName("APC");
        voteRequest2.setUsername("jamesKing");
        partyRequest2.setPartyName("PDP");
        partyRequest2.setCandidate(new User());

    }

    @Test public void  registerParty_partyIdIsOneTest(){
        PoliticalParty myParty = partyService.registerParty(partyRequest);
        assertEquals(1, myParty.getId());
    }

    @Test public void castVote_voteIdIsOneTest(){
      Vote myVote =  votingService.castVote(voteRequest);
      assertEquals(1, myVote.getVoteId());
    }

    @Test public void VoteShowsGeneralElectionNewsTest() {
        PoliticalParty myParty = partyService.registerParty(partyRequest);
        assertEquals(1, myParty.getId());
        PoliticalParty my2Party =partyService.registerParty(partyRequest2);
        assertEquals(2, my2Party.getId());
        String news = votingService.ShowGeneralVotingResult();
        assertEquals("""
                ============================
                ->> ELECTION NEWS UPDATE <<-
                ============================       
                %s ->> %d votes                            
                ============================ 
                """, news);
    }

@Test public void castVoteTwice_throwsExceptionTest(){
        Vote myVote =  votingService.castVote(voteRequest);
        assertEquals(1, myVote.getVoteId());
        assertThrows(IllegalArgumentException.class, ()-> votingService.castVote(voteRequest2));
    }
}

