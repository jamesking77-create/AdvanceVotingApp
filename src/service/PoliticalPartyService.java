package service;

import data.model.PoliticalParty;
import dtos.Requests.RegisterPartyRequest;
import dtos.Responses.FindPartyResponse;

import java.util.List;

public interface PoliticalPartyService {
 PoliticalParty registerParty(RegisterPartyRequest partyRequest);
 FindPartyResponse findParty(int partyId);
 FindPartyResponse findParty(String partyName);
 String  showPartyNews(String partyName);
 List<PoliticalParty> findAllParty();

}
