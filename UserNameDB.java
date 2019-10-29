import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public static int addUser(String userName, String password) throws IOException {
    	/* return of 0 is succesful
    	 * return of 1 is invailid username or password
    	 * return of 2 is username already taken
    	 * default return is 3
    	 */
    	if (!validate(userName)||!validate(password)) return 1;
    	if (checkUsername(userName)) return 2;
        File unDB = new File("Usernames_Passwords.txt");
        try {
            FileWriter fw = new FileWriter(unDB, true);
            BufferedWriter br = new BufferedWriter(fw);
            br.write("\n" + userName + " " + password);
            br.close();
            fw.close();
            return 0;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        System.out.println("Cant Create User");
        return 3;
    }
    
    private static boolean validate(String string) {
    	if (string.contains(" ")) return false;
    	return true;
    }
    
    private static boolean checkUsername(String userName) {
    	File unDB = new File("Usernames_Passwords.txt");
        try {
            Scanner dbReader = new Scanner(unDB);
            
            while(dbReader.hasNextLine()) {
                String line = dbReader.nextLine();
                String[] splitLine = line.split(" ");
                String lineUserName = splitLine[0];
                String linePassword = splitLine[1];
                if (userName.equals(lineUserName)) {
                    return true;
                }
            }
            dbReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        return false;
    }
}
