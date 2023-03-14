package service;

import dtos.Requests.RegisterPartyRequest;
import dtos.Responses.FindPartyResponse;
import data.model.PoliticalParty;
import data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoliticalPartyServiceImplTest {
    private PoliticalPartyService partyService;
    private RegisterPartyRequest partyRequest;
    private RegisterPartyRequest partyRequest2;



    @BeforeEach public void setUp(){
        partyService = new PoliticalPartyServiceImpl();
        partyRequest = new RegisterPartyRequest();
        partyRequest2 = new RegisterPartyRequest();
        partyRequest.setPartyName("APC");
        partyRequest.setPassword("1234");
        partyRequest.setAdmin(new User());
        partyRequest.setCandidate(new User());
        partyRequest.setUser(new User());
        partyRequest2.setPartyName("ALC");
        partyRequest2.setPassword("1234");
        partyRequest2.setAdmin(new User());
        partyRequest2.setCandidate(new User());
        partyRequest2.setUser(new User());
    }
    @Test public void registerParty_IdOfPartyIsOne(){
       PoliticalParty registerParty = partyService.registerParty(partyRequest);
       assertEquals(1, registerParty.getId());
       PoliticalParty secondParty = partyService.registerParty(partyRequest2);
       assertEquals(2, secondParty.getId());

    }
    @Test public void registerTwoPartyWithSameName_throwsException(){
        partyService.registerParty(partyRequest);
        partyRequest2.setPartyName("APC");
        assertThrows(IllegalArgumentException.class, ()-> partyService.registerParty(partyRequest2));
    }
    @Test public void registerTwoParties_findPartyByNameTest(){
        PoliticalParty registerParty = partyService.registerParty(partyRequest);
        assertEquals(1, registerParty.getId());
        PoliticalParty secondParty = partyService.registerParty(partyRequest2);
        assertEquals(2, secondParty.getId());
        FindPartyResponse foundParty = partyService.findParty(partyRequest.getPartyName());
        assertEquals(registerParty.getCandidate(), foundParty.getCandidate());

    }
    @Test public void registerTwoParties_findPartyByIdTest(){
        PoliticalParty registerParty = partyService.registerParty(partyRequest);
        assertEquals(1, registerParty.getId());
        PoliticalParty secondParty = partyService.registerParty(partyRequest2);
        assertEquals(2, secondParty.getId());
        FindPartyResponse foundParty = partyService.findParty(secondParty.getId());
        assertEquals(secondParty.getName(), foundParty.getPartyName());

    }
    @Test public void findPartyByName_ViewPartyNewsTest(){
        PoliticalParty registerParty = partyService.registerParty(partyRequest);
        assertEquals(1, registerParty.getId());
        FindPartyResponse foundParty = partyService.findParty(partyRequest.getPartyName());
        assertEquals(registerParty.getCandidate(), foundParty.getCandidate());
        String partyNews = partyService.showPartyNews(registerParty.getName());
        assertEquals("""
                ========================
                APC NEWS BOARD.
                VOTE COUNT ->> null
                CANDIDATE ->> NULL
                ========================
                """, partyNews);
    }

}