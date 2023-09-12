package login;

import admin.*;
import common.ConnectDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin_login {

    public void adminLogin() throws SQLException, ClassNotFoundException {


        try(Scanner sc = new Scanner(System.in)){
            ConnectDB db = new ConnectDB();
            db.connectToDB();
            String username;
            String password;



            // TODO: 9/11/2023 Fetch data from db WHERE username = 'username' & password = 'password';
            ResultSet res ;

            while(true){
                System.out.println("Enter ADMIN username: ");
                username = sc.nextLine();
                System.out.println("Enter Password: ");
                password = sc.nextLine();
                ResultSet set = db.getAdminData();
                boolean flag = false;
                while (set.next()){
                    if(username.equals(set.getString("a_name"))){
                        if(password.equals(set.getString("a_password"))){
                            flag = true;
                            System.out.println("Login successful");
                            Admin_main ad = new Admin_main();
                            ad.displayAdminMenu();
                            break;
                        }

                    }
                }

                if (!flag){
                    System.out.println("Wrong credentials!! Enter again");
                }


            }


        }catch (Exception e){
            System.out.println(e);
        }
    }
}
