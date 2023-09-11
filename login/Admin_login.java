package login;

import admin.*;

import java.sql.ResultSet;
import java.util.Scanner;

public class Admin_login {

    public void adminLogin() {


        try(Scanner sc = new Scanner(System.in)){
            String username;
            String password;



            // TODO: 9/11/2023 Fetch data from db WHERE username = 'username' & password = 'password';
            ResultSet res ;

            while(true){
                System.out.println("Enter ADMIN username: ");
                username = sc.nextLine();

                System.out.println("Enter Password: ");
                password = sc.nextLine();
                if(username.equals(username)){
                    if(password.equals(password)){
                        System.out.println("Login successful");
                        Admin_main ad = new Admin_main();
                        ad.displayAdminMenu();
                        break;
                    }

                }else{
                    System.out.println("Wrong credentials!! Enter again");
                }

            }


        }
    }
}
