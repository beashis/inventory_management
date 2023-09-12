package common;

import java.util.Scanner;

public class UserVariables {
    static int uid;
    public static Scanner scanner = new Scanner(System.in);
    public static int getUid(){
      return uid;
    }
    public static void setUid(int uid1){
        uid = uid1;
    }
}
