package service;

import data.model.PoliticalParty;
import data.repository.PoliticalPartyRepository;
import data.repository.PoliticalPartyRepositoryImpl;
import dtos.Requests.RegisterPartyRequest;
import dtos.Responses.FindPartyResponse;
import utils.Mapper;

import java.util.List;
import java.util.NoSuchElementException;

public class PoliticalPartyServiceImpl implements PoliticalPartyService{
    PoliticalPartyRepository partyRepository = new PoliticalPartyRepositoryImpl();
    @Override
    public PoliticalParty registerParty(RegisterPartyRequest partyRequest){
        if (partyExist(partyRequest.getPartyName())) alertUser();
        return partyRepository.savePoliticalParty(Mapper.map(partyRequest));
    }

    private static void alertUser() {
       throw new IllegalArgumentException("party already exist");
    }

    private boolean partyExist(String partyName) {
        PoliticalParty foundParty = partyRepository.findPartyByPartyName(partyName);
        return foundParty != null;
    }

    @Override
    public FindPartyResponse findParty(int partyId) {
        FindPartyResponse partyResponse = new FindPartyResponse();
        PoliticalParty foundParty = partyRepository.findPartyById(partyId);
        if (foundParty == null) throw new NoSuchElementException("Party doesn't exist");
        Mapper.map(foundParty, partyResponse);
        return partyResponse;
    }

    @Override
    public FindPartyResponse findParty(String partyName) {
        FindPartyResponse partyResponse = new FindPartyResponse();
        PoliticalParty foundParty = partyRepository.findPartyByPartyName(partyName);
        if (foundParty == null) throw new NoSuchElementException("Party doesn't exist");
        Mapper.map(foundParty, partyResponse);
        return partyResponse;
    }

    @Override
    public String showPartyNews(String partyName) {
        FindPartyResponse partyResponse = new FindPartyResponse();
        PoliticalParty foundParty = partyRepository.findPartyByPartyName(partyName);
        if (foundParty == null) throw new NoSuchElementException("Party doesn't exist");
        Mapper.map(foundParty, partyResponse);
        return String.format("""
                ========================
                %s NEWS BOARD.
                VOTE COUNT ->> %s
                CANDIDATE ->> %S
                ========================
                """, partyResponse.getPartyName(), partyResponse.getVote(), partyResponse.getCandidate().getUserName());
    }

    @Override
    public List<PoliticalParty> findAllParty() {
        return partyRepository.findAllParty();
    }
}
