package controllers;

import dtos.Requests.LogInRequest;
import dtos.Requests.RegisterUserRequest;
import service.UserService;
import service.UserServiceImpl;

import java.util.NoSuchElementException;

public class UserController {
    UserService userService = new UserServiceImpl();

    public Object registerUser(RegisterUserRequest registerUserRequest){
        try{
            return userService.register(registerUserRequest);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    public Object LoginUser(LogInRequest logInRequest){
        try{
            return userService.logIn(logInRequest);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    public  Object findUserById(int id){
        try {
            return userService.findUser(id);
        }catch (NoSuchElementException e){
            return e.getMessage();
        }
    }

    public  Object findUserByName(String userName){
        try {
            return userService.findUserByUserName(userName);
        }catch (NoSuchElementException e){
            return e.getMessage();
        }
    }
}
