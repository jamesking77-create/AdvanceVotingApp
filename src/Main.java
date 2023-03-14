import controllers.PoliticalPartyController;
import controllers.PvcController;
import controllers.UserController;
import controllers.VoteController;
import dtos.Requests.LogInRequest;
import dtos.Requests.RegisterForPvcRequest;
import dtos.Requests.RegisterUserRequest;

import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
   private static final Scanner scanner = new Scanner(System.in);
   public static final VoteController voteController = new VoteController();
   public static final UserController userController = new UserController();
   public static final PvcController pvcController = new PvcController();
   public static final PoliticalPartyController partyController = new PoliticalPartyController();
   public static String firstName;
   public static  String  lastName;

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        String infoPage = input("""
                =============================
                ->>   DCR VOTING MACHINE  <<-
                =============================
                1 ->>       SIGN UP       <<-
                2 ->>       LOG IN        <<-
                =============================
                """);
        String userName;
        String  passWord;
        String loginUsername;
        String  loginPassword;
        switch (infoPage.charAt(0)){
            case '1' -> {
                try {
                    firstName = input("""
                            =============================
                            ->> Enter your first name <<-
                            ============================= 
                            """);
                    lastName = input("""
                            =============================
                            ->> Enter your last name  <<-
                            ============================= 
                            """);
                    userName = input("""
                            =============================
                            ->> Enter your username   <<-
                            ============================= 
                            """);

                    passWord = input("""
                            =============================
                            ->> Enter your  passWord  <<-
                            ============================= 
                            """);
                    RegisterUserRequest userRequest = new RegisterUserRequest();
                    userRequest.setFirstName(firstName);
                    userRequest.setLastName(lastName);
                    userRequest.setUsername(userName);
                    userRequest.setPassword(passWord);
                    userController.registerUser(userRequest);
                    LogInRequest firstLogInRequest = new LogInRequest();
                    firstLogInRequest.setUsername(userName);
                    firstLogInRequest.setPassword(passWord);
                    userController.LoginUser(firstLogInRequest);
                    display("""
                            ================================
                            ->>          WELCOME         <<-
                            ================================       
                             Exercise your democratic rights
                                        with us...
                            --------------------------------
                            """);
                    displayMainMenu();

                }catch (IllegalArgumentException e){
                   display( e.getMessage());
                }
            }
            case '2' ->{
                try {
                    loginUsername = input("""
                            =============================
                            ->> Enter your username   <<-
                            ============================= 
                            """);
                    loginPassword = input("""
                            =============================
                            ->> Enter your password   <<-
                            ============================= 
                            """);
                    LogInRequest logInRequest = new LogInRequest();
                    logInRequest.setUsername(loginUsername);
                    logInRequest.setPassword(loginPassword);
                    userController.LoginUser(logInRequest);
                }catch (IllegalArgumentException | NoSuchElementException e){
                    display(e.getMessage());
                }
            }
        }
    }

    private static void displayMainMenu() {
       String mainMenu = input("""
                            ==================================
                            1 ->>  PERSONAL VOTER'S CARD   <<-
                            2 ->>     POLITICAL PARTY      <<- 
                            3 ->>     VOTING EXERCISE      <<-
                            ==================================
                            """);
        if (mainMenu.charAt(0) == '1') {
            RegisterForPvcRequest pvcRequest = new RegisterForPvcRequest();
            pvcRequest.setFirstName(firstName);
            pvcRequest.setLastName(lastName);
        }
    }

    private static String input(String prompt){
        return JOptionPane.showInputDialog(prompt);
//		display(prompt);
//		return keyboardInputCollector.nextLine();
    }

    private static void display(String prompt){
        JOptionPane.showMessageDialog(null, prompt);
//		System.out.println(prompt);
    }
}
