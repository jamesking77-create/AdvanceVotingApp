package service;

import data.model.PermanentVotersCard;
import data.repository.PermanentVotersCardRepository;
import data.repository.PermanentVotersCardRepositoryImpl;
import dtos.Requests.RegisterForPvcRequest;
import utils.Mapper;

public class PermanentVotersCardServiceImpl implements PermanentVotersCardService {
    private final PermanentVotersCardRepository  votersCardRepository = new PermanentVotersCardRepositoryImpl();
    @Override
    public PermanentVotersCard registerForPvc(RegisterForPvcRequest pvcRequest) {
            if (pvcExist(pvcRequest.getFirstName(), pvcRequest.getLastName())) throw new IllegalArgumentException("Registration failed");
            return votersCardRepository.saveVotersCard( Mapper.map(pvcRequest));
        }

    private boolean pvcExist(String firstName, String lastName) {
        PermanentVotersCard votersCard = votersCardRepository.findVotersCardByName(firstName + lastName);
        return votersCard != null;
    }
}

