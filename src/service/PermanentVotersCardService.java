package service;

import data.model.PermanentVotersCard;
import dtos.Requests.RegisterForPvcRequest;

public interface PermanentVotersCardService {
    PermanentVotersCard registerForPvc(RegisterForPvcRequest pvcRequest);


}
