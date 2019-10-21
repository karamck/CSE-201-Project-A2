import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserNameDB {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File engWords = new File("Usernames_Passwords");
        try {
            Scanner dictReader = new Scanner(engWords);
            
            dictReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }

    }
}
