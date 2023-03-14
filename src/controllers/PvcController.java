package controllers;

import dtos.Requests.RegisterForPvcRequest;
import service.PermanentVotersCardService;
import service.PermanentVotersCardServiceImpl;

public class PvcController {
    PermanentVotersCardService votersCardService = new PermanentVotersCardServiceImpl();

    public Object registerForVotersCard(RegisterForPvcRequest pvcRequest){
        try{
            return votersCardService.registerForPvc(pvcRequest);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
