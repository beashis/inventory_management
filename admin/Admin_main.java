package admin;

import common.MenuFormat;

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
