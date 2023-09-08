package common;

import java.util.InputMismatchException;
import java.util.Scanner;

class InputOutOfBoundsException extends Exception{}


public class MenuFormat {

    private static void displayMenu(String [] menu){


        for(int i = 0; i<menu.length; i++){
            System.out.println(i+1 +". " + menu[i]);
        }
    }

    private static int input(String [] menu) throws Exception{

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your selection: ");

        int input = 0;
        try{
            input = sc.nextInt();
            if(input<1 || input>menu.length){
                throw new InputOutOfBoundsException();
            }
        }catch(InputMismatchException e){
            System.out.println("Please enter correct form of input.");
            sc.next();
            throw new Exception();
        }catch(InputOutOfBoundsException e){
            System.out.println("Please enter the number in a valid range.");
            //sc.next();
            throw new Exception();
        }catch (Exception e) {
            System.out.println("An unexpected error happened. Please try again");
            sc.next();
            throw new Exception();
        }
        return input;
    }

    public static int menuFormat (String [] menu) throws Exception{

        int input = 0;
        try{
            displayMenu(menu);
            input = input(menu);
        }catch(Exception e){
            throw new Exception();
        }
        return input;
    }

}
