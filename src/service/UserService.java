package service;

import data.model.User;
import dtos.Requests.LogInRequest;
import dtos.Requests.RegisterUserRequest;
import dtos.Responses.FindUserResponse;

public interface UserService {
    User register(RegisterUserRequest registerRequest);
    User logIn(LogInRequest logInRequest);
    FindUserResponse findUser(int id);
    String deleteUser(int id);
    FindUserResponse findUserByUserName(String  username);


}
