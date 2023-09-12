package customer;

import common.ConnectDB;
import common.MenuFormat;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ShowProducts {

    public static int uid =  common.UserVariables.getUid();
    public static void displayProducts() throws Exception{

        Scanner sc = new Scanner(System.in);
        Statement st = null;

        while(true) {
            try {
                ConnectDB db = new ConnectDB();
                db.connectToDB();
                st = db.conn.createStatement();
                ResultSet categorySet = db.getCategory(st);

                System.out.println("select category from the list");
                int i=1;
                while (categorySet.next()){
                    System.out.println(i++ +". ");
                    System.out.print("Category id :" + categorySet.getInt("id"));
                    System.out.println("Category name :" + categorySet.getString("name"));
                }
                int selectCategory = sc.nextInt();

                ResultSet productSet = db.getProductTable(selectCategory);
                System.out.println("select product from the list");
                int j=1;
                while (productSet.next()){
                    System.out.println(j++ +". ");
                    System.out.print("Product id :" + categorySet.getInt("id"));
                    System.out.println("Product name :" + categorySet.getString("name"));
                    System.out.println("Product count :" + categorySet.getString("count"));
                }

                int selectProduct = sc.nextInt();
                System.out.println("Enter count for the product: ");
                int productCount = sc.nextInt();
                db.updateProductInCart(uid, selectProduct);

            }catch(Exception e){
                System.out.println(e);
                System.out.println("Try again.");
                throw new Exception();
            }
        }
    }
}
