import admin.Admin_main;
import common.ConnectDB;
import customer.*;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory_management_root {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        MainMenu customerMainMenu = new customer.MainMenu();
//        customerMainMenu.displayMainMenu();
//
        ConnectDB db = new ConnectDB();
        db.connectToDB();
//        Admin_main admin = new Admin_main();
//        admin.displayAdminMenu();


        login.First_step.main();
    }

}
