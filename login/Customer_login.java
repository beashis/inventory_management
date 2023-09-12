package login;

import java.sql.ResultSet;
import java.util.*;

import common.ConnectDB;
import common.UserVariables;
import customer.*;

class Customer{
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
public class Customer_login {
    Scanner scn = new Scanner(System.in);
    public void customer_login(){

        try{
            Customer customer = new Customer();
            ConnectDB db = new ConnectDB();
            db.connectToDB();
            String username;
            String password;


            ResultSet res ;

            while(true){

                System.out.println("Enter username: ");
                username = scn.next();
                customer.setUsername(username);
                System.out.println("Enter Password: ");
                password = scn.next();
                customer.setPassword(password);
                ResultSet set = db.getCustomerData();
                Boolean flag = false;
                while (set.next()){
                    if(customer.username.equals(set.getString("username"))){
                        if(customer.password.equals(set.getString("c_password"))){
                            flag = true;
                            System.out.println("Login successful");
                            ResultSet rs = db.getCustomerUid(username);
                            rs.next();
                            UserVariables.setUid( rs.getInt("USER_ID"));
                            MainMenu mn = new MainMenu();
                            mn.displayMainMenu();
                            break;
                        }
                    }
                }
                if (!flag){
                    System.out.println("Wrong credentials!! Enter again");
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
