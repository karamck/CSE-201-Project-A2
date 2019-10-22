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

    /**
     * If the userName is present and the password is correct
     * @return true if successful, false otherwise
     */
    public static boolean checkUser(String userName, String password) {
        File unDB = new File("Usernames_Passwords.txt");
        try {
            Scanner dbReader = new Scanner(unDB);
            
            while(dbReader.hasNextLine()) {
                String line = dbReader.nextLine();
                String[] splitLine = line.split(" ");
                String lineUserName = splitLine[0];
                String linePassword = splitLine[1];
                if (userName.equals(lineUserName)) {
                    if (password.equals(linePassword)) {
                        System.out.println("Successful login");
                        return true;
                    }
                    else {
                        System.out.println("Wrong password");
                        return false;
                    }
                }
            }
            dbReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        System.out.println("User Not Found");
        return false;
    }
}
