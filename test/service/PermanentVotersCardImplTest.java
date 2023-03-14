package service;

import data.model.PermanentVotersCard;
import dtos.Requests.RegisterForPvcRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PermanentVotersCardImplTest {

    private PermanentVotersCardService votersCardService;
    RegisterForPvcRequest pvcRequest;
    RegisterForPvcRequest pvcRequest2;
    @BeforeEach public void setUp(){
        pvcRequest = new RegisterForPvcRequest();
        pvcRequest2 = new RegisterForPvcRequest();
        votersCardService = new PermanentVotersCardServiceImpl();
        pvcRequest.setFirstName("james");
        pvcRequest.setLastName("king");
        pvcRequest.setGender("male");
        pvcRequest.setOccupation("student");
        pvcRequest.setDateOfBirth("09876 ");
        pvcRequest.setState(" lagos");
        pvcRequest.setDateRegistered(String.valueOf(LocalDateTime.now()));
        pvcRequest.setLocalDistrictArea("yaba ");
        pvcRequest2.setFirstName("james");
        pvcRequest2.setLastName("king");
    }
    @Test public void registerForPvcTest(){
        PermanentVotersCard pvc = votersCardService.registerForPvc(pvcRequest);
        assertEquals(pvcRequest.getFirstName() + pvcRequest.getLastName(), pvc.getFullName());
        assertEquals(1, pvc.getPvcId());
    }
    @Test public void registerForPvcTwice_throwsException(){
        votersCardService.registerForPvc(pvcRequest);
        votersCardService.registerForPvc(pvcRequest2);
        assertThrows(IllegalArgumentException.class, ()-> votersCardService.registerForPvc(pvcRequest2));
    }
}