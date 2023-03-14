package service;

import dtos.Requests.CastVoteRequest;
import dtos.Requests.LogInRequest;
import dtos.Requests.RegisterUserRequest;
import dtos.Responses.FindUserResponse;
import data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserService userService;
    private RegisterUserRequest registerUserRequest;
    private  LogInRequest logInRequest;
    private RegisterUserRequest registerUserRequest2;
    private CastVoteRequest voteRequest;

    @BeforeEach public void setUp(){
        voteRequest = new CastVoteRequest();
        logInRequest = new LogInRequest();
        logInRequest.setUsername("jamesKing77");
        logInRequest.setPassword("4567");
        userService = new UserServiceImpl();
        registerUserRequest = new RegisterUserRequest();
        registerUserRequest2 = new RegisterUserRequest();
        registerUserRequest.setFirstName("james");
        registerUserRequest.setLastName("king");
        registerUserRequest.setUsername("jamesKing77");
        registerUserRequest.setPassword("4567");
        voteRequest.setPartyName("APC");
        voteRequest.setUsername(registerUserRequest.getUsername() );
        registerUserRequest2.setFirstName("ope");
        registerUserRequest2.setLastName("ola");
        registerUserRequest2.setUsername("opizium");
        registerUserRequest2.setPassword("0987");
    }

    @Test public void registerOneUser_IdOfUserIsOneTest(){
        User saveUser = userService.register(registerUserRequest);
        assertEquals(1, saveUser.getUserId());
    }
    @Test public void logInOneUserAfterRegistration_IdOfUserIsOneTest(){
//        logInRequest.setUsername("jKings");
        User savedUser = userService.register(registerUserRequest);
        assertEquals(1, savedUser.getUserId());
        User User = userService.logIn(logInRequest);
        assertEquals(1, User.getUserId());
    }

    @Test public void registerOneUser_findUserByUserNameTest(){
        User savedUser =  userService.register(registerUserRequest);
        assertEquals(savedUser.getUserName(), savedUser.getUserName());
        FindUserResponse foundUser = userService.findUserByUserName(savedUser.getUserName());
        assertEquals(savedUser.getUserName(), foundUser.getUsername());
    }

    @Test public void logInOneUserWithWrongInfo_throwsExceptionTest(){
        User savedUser = userService.register(registerUserRequest);
        assertEquals(1, savedUser.getUserId());
        userService.logIn(logInRequest);
        logInRequest.setPassword("0000");
        assertThrows(IllegalArgumentException.class, ()-> userService.logIn(logInRequest));
    }

    @Test public void registerOneUser_deleteUserTest(){
        User savedUser =  userService.register(registerUserRequest);
        assertEquals(1, savedUser.getUserId());
        User secondUser = userService.register(registerUserRequest2);
        assertEquals(2, secondUser.getUserId());
        String deleteUser =  userService.deleteUser(2);
        assertEquals("User successfully deleted",deleteUser);
    }

    @Test public void registerTwoUser_findUserByIdTest(){
        User savedUser =  userService.register(registerUserRequest);
        assertEquals(1, savedUser.getUserId());
        User secondUser = userService.register(registerUserRequest2);
        assertEquals(2, secondUser.getUserId());
        FindUserResponse foundUser = userService.findUser(2);
        assertEquals(secondUser.getUserId(), foundUser.getUserId());
    }

    @Test public void registerTwoUserWithTheSameUsername_ThrowsExceptionTest(){
        userService.register(registerUserRequest);
        registerUserRequest2.setUsername(registerUserRequest.getUsername());
        assertThrows(IllegalArgumentException.class, ()-> userService.register(registerUserRequest2));
    }






}