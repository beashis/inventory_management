package login;

import common.*;

public class First_step {
    public static void main() {
        Customer_login customer_login = new Customer_login();
        Admin_login admin_login = new Admin_login();
        Register register = new Register();
        String [] loginOptions = {
                "User Login",
                "Admin Login",
                "User SignUp",
                "Exit App"
        };

        while(true) {

            try {
                //System.out.println("Welcome to the Inventory Management System!");
                int input = 0;
                input = MenuFormat.menuFormat(loginOptions);

                if (input == 4) {
                    break;
                }

                switch (input) {

                    case 1:
                        System.out.println("Option 1 selected");
                        customer_login.customer_login();
                        break;
                    case 2:
                        System.out.println("Option 2 selected");
                        admin_login.adminLogin();
                        break;
                    case 3:
                        System.out.println("Option 3 selected");
                        register.register();
                        break;
                    default:
                        System.out.println("Please select a valid option.");
                        break;
                }
            }catch(Exception e){
                System.out.println("Try again.");
            }
        }
    }
}
