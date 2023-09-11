package admin;

import common.ConnectDB;
import common.MenuFormat;

import java.sql.ResultSet;
import java.util.Scanner;

public class Admin_main {

    public void displayAdminMenu(){
        Scanner sc = new Scanner(System.in);
        String[] adminOptions = {"createProduct" , "addProduct" , "deleteProduct"};

        while(true) {

            try {
                int input = 0;
                input = MenuFormat.menuFormat(adminOptions);

                if (input >= 4) {
                    break;
                }

                switch (input) {
                    case 1:
                        ConnectDB db = new ConnectDB();
                        db.connectToDB();
                        ResultSet categorySet = db.getCategory();

                        System.out.println("select category from the list");
                        int i=1;
                        while (categorySet.next()){
                            System.out.println(i++ +". ");
                            System.out.print("Category id :" + categorySet.getInt("id"));
                            System.out.println("Category name :" + categorySet.getString("name"));
                        }
                        System.out.println("Enter 0 to add new category");
                        int selectCategory = sc.nextInt();
                        if (selectCategory==0){

                        }else{

                        }

                        ResultSet productSet = db.getProductTable();
                        System.out.println("select product from the list");
                        int j=1;
                        while (productSet.next()){
                            System.out.println(j++ +". ");
                            System.out.print("Product id :" + categorySet.getInt("id"));
                            System.out.println("Product name :" + categorySet.getString("name"));
                            System.out.println("Product count :" + categorySet.getString("count"));
                        }
                        System.out.println("Enter 0 to add new product");
                        int selectProduct = sc.nextInt();
                        if (selectProduct==0){
                            System.out.println("Enter product name: ");
                            String productName = sc.next();
                            ResultSet product_id = db.insertNewProduct(productName);
                            selectProduct = product_id.getInt("id");
                            // TODO: 11-Sep-23 put product in db
                        }

                        System.out.println("Enter count for the product: ");
                        int productCount = sc.nextInt();
                        db.updateProduct(productCount);






                        System.out.println("Enter product id :");
                        int id = sc.nextInt();
                        System.out.println("Enter product name :");
                        String pName = sc.next();
                        System.out.println("Enter product count:");
                        int count = sc.nextInt();
                        // TODO: 09-Sep-23 get validation from dp and print accordingly.
                        createProduct(id , pName , count);
                        break;
                    case 2:
                        System.out.println("Enter product id :");
                        int pId = sc.nextInt();
                        System.out.println("Enter product count:");
                        int pCount = sc.nextInt();
                        // TODO: 09-Sep-23 get validation from dp and print accordingly.
                        addProduct(pId , pCount);
                        break;
                    case 3:
                        System.out.println("Enter product id :");
                        int ppId = sc.nextInt();
                        // TODO: 09-Sep-23 get validation from dp and print accordingly.
                        deleteProduct(ppId);
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
    public void createProduct(int id, String name, int count)
    {
        /**
         * will be edited after DB creation.
         */
        System.out.println("product successfully created");
        String query="insert into inventory(id,name,count) values ("+id+","+name+","+count+")";
    }
    public void  addProduct(int id,int amount)
    {
        String query = "update inventory set count="+amount+"where id ="+id;
    }
    public void deleteProduct(int id)
    {
        String query ="delete from inventory where id="+id;
    }
}
