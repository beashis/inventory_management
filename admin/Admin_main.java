package admin;

import common.ConnectDB;
import common.MenuFormat;
import common.UserVariables;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Admin_main {

    Scanner sc = UserVariables.scanner;
    public void displayAdminMenu(){
        String[] adminOptions = {"createProduct" , "deleteProduct", "logout"};
        Scanner sc = new Scanner(System.in);
        while(true) {

            try {
                int input = 0;
                input = MenuFormat.menuFormat(adminOptions);

                if (input == 4) {
                    break;
                }

                switch (input) {
                    case 1:

//                        try{
//                            ConnectDB db = new ConnectDB();
//                            db.connectToDB();
//                            Statement st = db.conn.createStatement();
//                            boolean categorySuccess = db.insertCategory();
//                            System.out.println(categorySuccess );
//                            ResultSet set =null;
//                            set = db.getCategory(st);
//                                while (set.next()){
//                                    System.out.println(set.getInt("c_id"));
//                                    System.out.println(set.getString("c_name"));
//                                }
//                            db.closedB();
//                            set.close();
//                        }catch (Exception e){
//                            System.out.println("this ex"+e);
//                        }



                        System.out.println("select category from the list");
                        ConnectDB db = new ConnectDB();
                        db.connectToDB();
                        Statement st = db.conn.createStatement();
                        ResultSet categorySet = db.getCategory(st);
                        int i=1;
                        while (categorySet.next()){
                            System.out.print(i++ +". ");
                            System.out.print("Category id :" + categorySet.getInt("c_id")+" ");
                            System.out.println("Category name :" + categorySet.getString("c_name"));
                        }
                        System.out.println("Enter 0 to add new category");
                        int selectCategory = sc.nextInt();
                        if (selectCategory==0){
                            System.out.println("Enter category name: ");
                            String category = sc.next();
                            boolean categorySuccess = db.insertCategory(category.toString());
                            if (!categorySuccess){
                                System.out.println("successfully added");
                            }else{
                                System.out.println("Failed to added");
                            }
                        }else{
                            /**
                             * products
                             */
                            //
                        ResultSet productSet = db.getProductTable(selectCategory);

                            System.out.println("select product from the list");
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


                        System.out.println();
                        System.out.println("Enter 0 to add new product");
                        System.out.println("Enter u update quantity of the product");


                        String selectProduct = sc.next();
                        boolean flag = Character.isDigit(selectProduct.charAt(0));
                        if (flag){
                            System.out.println("Enter product name: ");
                            String productName = sc.next();
                            System.out.println("Enter product quantity: ");
                            int p_quantity = sc.nextInt();
                            System.out.println("Enter product price: ");
                            int p_price = sc.nextInt();
                            System.out.println("Enter product discount: ");
                            int p_discount = sc.nextInt();
                            boolean productSuccess = db.insertNewProduct(productName , selectCategory , p_quantity , p_price , p_discount);
                            if(!productSuccess){
                                System.out.println("product added successfully");
                            }
                            // TODO: 11-Sep-23 put product in db
                        }else if (selectProduct.equals("u")){
                            System.out.println("Enter category id: ");
                            int c_id = sc.nextInt();
                            System.out.println("Enter product id: ");
                            int p_id = sc.nextInt();
                            System.out.println("Enter quantity for the product: ");
                            int count = sc.nextInt();
                            db.updateProduct(count , p_id , c_id);
                         }
                        }


                        // TODO: 09-Sep-23 get validation from dp and print accordingly.

                        break;
                    case 2:

                        // TODO: 09-Sep-23 get validation from dp and print accordingly.
//                        addProduct(pId , pCount);
                        break;
                    default:
                        System.out.println("Please select a valid option.");
                        break;
                }
            }catch(Exception e){
                System.out.println(e);
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

    private void show_category_product(){

    }
}
