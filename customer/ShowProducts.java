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


            try {
                ConnectDB db = new ConnectDB();
                db.connectToDB();
                st = db.conn.createStatement();
                ResultSet categorySet = db.getCategory(st);

                System.out.println("select category from the list");
                int i=1;
                while (categorySet.next()){
                    System.out.print(i++ +". ");
                    System.out.print("Category id :" + categorySet.getInt("c_id")+" ");
                    System.out.println("Category name :" + categorySet.getString("c_name"));
                }
                System.out.println("select category from the list");
                int selectCategory = sc.nextInt();

                ResultSet productSet = db.getProductTable(selectCategory);

                int j=1;
                while (productSet.next()){
                    System.out.print(j++ +". ");
                    System.out.print("Product id :" + productSet.getInt("p_id")+" ");
                    System.out.print("Category id :" + productSet.getInt("c_id")+" ");
                    System.out.print("Product name :" + productSet.getString("p_name")+" ");
                    System.out.print("Product count :" + productSet.getInt("p_quantity")+" ");
                    System.out.print("Product price :" + productSet.getInt("p_price")+" ");
                    System.out.println("Product discount :" + productSet.getInt("p_discount"));
                }
                if(j==1){
                    System.out.println("Table is empty");
                }else{
                    System.out.println("select product id from the list");
                    int selectProduct = sc.nextInt();
                    System.out.println("Enter count for the product: ");
                    int productCount = sc.nextInt();
                    boolean result = db.updateProductInCart(uid, selectProduct , productCount);
                    System.out.println("product successfully added");
                }
            }catch(Exception e){
                System.out.println(e);
                System.out.println("Try again.");
                throw new Exception();
            }

    }
}
