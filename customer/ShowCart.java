package customer;

import common.*;
import common.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class ShowCart {

    static int uid = UserVariables.getUid();
    static List<Product> prodList = new ArrayList<Product>();

    public static void displayCart() throws SQLException {
            ResultSet rs = ConnectDB.queryExecute("p_show_cart(" + uid + ")");

            //TODO: display cart in a table and update prodList
    }

    public static void removeItems() throws SQLException{


        System.out.println("Select product to remove: ");
        String[] menuOptions = new String[prodList.size() + 1];

        for(int i = 0; i<prodList.size(); i++){
            menuOptions[i] = prodList.get(i).getName();
        }

        menuOptions[prodList.size()] = "exit menu";

        while(true) {

            try {
                int input = 0;
                input = MenuFormat.menuFormat(menuOptions);

                if (input == menuOptions.length) {
                    break;
                }

                input--;

                int productID = prodList.get(input).getId();
                ResultSet rs = ConnectDB.queryExecute("p_show_cart(" + uid + ")");
                //TODO: remove product from cart

            }catch(Exception e){
                System.out.println("Try again.");
            }
        }


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

                if (input == 3) {
                    break;
                }

                switch(input) {

                    case 1:
                        System.out.println("Option 1 selected");
                        BuyNow.showMenu();
                        break;
                    case 2:
                        System.out.println("Option 2 selected");
                        removeItems();
                        break;
                    default:
                        System.out.println("Please select a valid option.");
                        break;
                }
            }catch(SQLException e){
                System.out.println(e);
                break;
            }catch(Exception e){
                System.out.println("Try again.");
                break;
            }
        }
    }
}
