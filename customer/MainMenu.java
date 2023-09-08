package customer;

import common.MenuFormat;
public class MainMenu {

    public void displayMainMenu(){

        String [] menuOptions = {
                "Show Cart",
                "Show Products",
                "Show Profile",
                "Exit App"
        };

        while(true) {

            try {
                System.out.println("Welcome to the Inventory Management System!");
                int input = 0;
                input = MenuFormat.menuFormat(menuOptions);

                if (input == 4) {
                    break;
                }

                switch (input) {

                    case 1:
                        System.out.println("Option 1 selected");
                        break;
                    case 2:
                        System.out.println("Option 2 selected");
                        break;
                    case 3:
                        System.out.println("Option 3 selected");
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
}