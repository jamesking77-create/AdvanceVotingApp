package controllers;

import dtos.Requests.RegisterPartyRequest;
import service.PoliticalPartyService;
import service.PoliticalPartyServiceImpl;

public class PoliticalPartyController {
    PoliticalPartyService partyService = new PoliticalPartyServiceImpl();

    public Object registerPoliticalParty(RegisterPartyRequest registerPartyRequest){
        try{
            return partyService.registerParty(registerPartyRequest);
        }catch (IllegalArgumentException e){
           return e.getMessage();
        }
    }

    public Object findPartyByName(String partyName){
        try{
            return partyService.findParty(partyName);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    public Object findPartyById(int id){
        try{
            return partyService.findParty(id);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    public Object displayPartyNews(String partyName){
        try{
            return partyService.showPartyNews(partyName);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

}
