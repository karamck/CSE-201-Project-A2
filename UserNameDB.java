import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserNameDB {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File unDB = new File("Usernames_Passwords");
        try {
            Scanner dictReader = new Scanner(unDB);
            
            dictReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }

    }
}
