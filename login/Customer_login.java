package login;

import java.sql.ResultSet;
import java.util.*;
import customer.*;

public class Customer_login {
    public void customer_login() {


        try(Scanner sc = new Scanner(System.in)){
            String username;
            String password;



            // TODO: 9/11/2023 Fetch data from db WHERE username = 'username' & password = 'password';
            ResultSet res ;

            while(true){
                System.out.println("Enter username: ");
                username = sc.nextLine();

                System.out.println("Enter Password: ");
                password = sc.nextLine();
                if(username.equals(username)){
                    if(password.equals(password)){
                        System.out.println("Login successful");
                        MainMenu mn = new MainMenu();
                        mn.displayMainMenu();
                        break;
                    }

                }else{
                    System.out.println("Wrong credentials!! Enter again");
                }

            }


        }
    }
}
