import admin.Admin_main;
import common.ConnectDB;
import customer.*;

import java.sql.SQLException;

public class Inventory_mang_root {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        MainMenu customerMainMenu = new customer.MainMenu();
//        customerMainMenu.displayMainMenu();

        ConnectDB db = new ConnectDB();
        db.connectToDB();
//        Admin_main admin = new Admin_main();
//        admin.displayAdminMenu();
    }
}
