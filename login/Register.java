package login;

import common.ConnectDB;
import common.UserVariables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

class Regtr {
    private String name;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters//
    public void setName(String name){
        this.name = name;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    // getters//

//    public String getname(){
//        return this.name;
//    }
//
//    public String getUsername(){
//        return this.username;
//
//    }
//
//    public String getPassword(){
//        return this.password;
//
//    }
}

public class Register{


    public void register() throws SQLException, ClassNotFoundException {
        ConnectDB db = new ConnectDB();
        db.connectToDB();
        Regtr rgt = new Regtr();
        try(Scanner sc = new Scanner(System.in)){

            System.out.println("Enter Username: ");
            String username = sc.next();
        // TODO: 9/11/2023  Create a check that username already existed in database or not
            ResultSet check = null;
//            while(check.){
//                username = sc.nextLine();
//            }
            rgt.setUsername(username);

            System.out.println("Enter Password: ");
            String password = sc.next();
            boolean flag = false;

            while(true){
                System.out.println("Confirm Password: ");
                String confirm = sc.next();
                if(confirm.equals(password)){
                    System.out.println("Account Created");
                    rgt.setPassword(password);
                    db.insertCustomerDb(rgt.getUsername() , rgt.getPassword());
                    flag =true;
                    login.First_step.main();
                    break;
                }else {
                    System.out.println(" Password Mismatch enter again!!");
                }
            }


            if(!flag){
                System.out.println("failed register");
            }

            // TODO: 9/11/2023 Update the details to the database


        }

    }
}