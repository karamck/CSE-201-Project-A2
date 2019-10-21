import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserNameDB {

//    public static void main(String[] args) {
//        File unDB = new File("Usernames_Passwords.txt");
//        try {
//            Scanner dbReader = new Scanner(unDB);
//
//            dbReader.close();
//        } catch (FileNotFoundException exception) {
//            System.out.println("File not found");
//        }
//
//    }

    public static boolean checkPW(String userName, String pw) {
        File unDB = new File("Usernames_Passwords.txt");
        try {
            Scanner dbReader = new Scanner(unDB);
            
            dbReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        return false;
    }
}
