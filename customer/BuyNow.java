package customer;

import common.ConnectDB;
import common.UserVariables;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import common.models.*;

public class BuyNow {

    static int uid = UserVariables.getUid();
    public static void displayData() throws SQLException{
        ResultSet rs = ConnectDB.queryExecute("p_buy_now(" + uid + ")");
        //TODO: display total amount
    }

    public static void updateInventory(){

    }

    public static List<List<String>> checkOrder() throws SQLException{
        ResultSet rs = ConnectDB.queryExecute("p_check_order(" + uid + ")");
        List arr = new ArrayList<String>();

        //TODO: return output as list of products
        return arr;
    }
    public static void showMenu(){

        try {
            displayData();
            List<List<String>> arr = checkOrder();
            if(!arr.isEmpty()){
                System.out.println("Following items in order are not available in Inventory. Please reduce the count or remove the product.");
                for(List<String> i: arr){
                    System.out.println(i.get(0) + ": " + i.get(1));
                }
                return;
            }

            System.out.println("Confirm order(y/n)?");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("y")){

                updateInventory();
                System.out.println();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
