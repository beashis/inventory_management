package login;

import java.sql.ResultSet;
import java.util.*;

class Regtr {
    private String name;
    private String username;
    private String password;

    

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


    public void Register() {
        Regtr rgt = new Regtr();
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter name: ");
            String name = sc.nextLine();
            rgt.setName(name);

            System.out.println("Enter Username: ");
            String username = sc.nextLine();
        // TODO: 9/11/2023  Create a check that username already existed in database or not
            ResultSet check = null;
//            while(check.){
//                username = sc.nextLine();
//            }
            rgt.setUsername(username);

            System.out.println("Enter Password: ");
            String password = sc.nextLine();

            while(true){
                System.out.println("Confirm Password: ");
                String confirm = sc.nextLine();
                if(confirm.equals(password)){
                    System.out.println("Account Created");
                    rgt.setPassword(password);
                    break;
                }else {
                    System.out.println(" Password Mismatch enter again!!");
                }
            }

            // TODO: 9/11/2023 Update the details to the database

            sc.close();
        }

    }
}