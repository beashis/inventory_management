package customer;

import common.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowCart {

    static int uid = UserVariables.getUid();
    public static void displayCart() throws SQLException {
            ResultSet rs = ConnectDB.queryExecute("p_show_cart(" + uid + ")");

            //TODO: display cart in a table
    }

    public static void showCart(){

        String [] menuOptions = {
                "Buy Now",
                "Remove items",
                "Prev Menu"
        };

        while(true) {

            try {
                System.out.println("This is your cart.");

                displayCart();
                int input = 0;
                input = MenuFormat.menuFormat(menuOptions);

                if (input == 2) {
                    break;
                }

                switch(input) {

                    case 1:
                        System.out.println("Option 1 selected");
                        BuyNow.showMenu();
                        break;
                    case 2:
                        System.out.println("Option 2 selected");
                        BuyNow.showMenu();
                        break;
                    default:
                        System.out.println("Please select a valid option.");
                        break;
                }
            }catch(SQLException e){
                System.out.println(e);
            }catch(Exception e){
                System.out.println("Try again.");
            }
        }
    }

}
