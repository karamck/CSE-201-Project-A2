import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

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
    	password = encrypt(password);
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
    
    public static boolean checkAdmin(String userName) {
        File unDB = new File("Usernames_Passwords.txt");
        try {
            Scanner dbReader = new Scanner(unDB);
            
            while(dbReader.hasNextLine()) {
                String line = dbReader.nextLine();
                String[] splitLine = line.split(" ");
                String lineUserName = splitLine[0];
                String lineAdmin = splitLine[2];
                if (userName.equals(lineUserName)) {
                    if (lineAdmin.equals("a")) {
                        System.out.println("Is Admin");
                        return true;
                    }
                    else {
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
    	/* return of 0 is successful
    	 * return of 1 is invalid username or password
    	 * return of 2 is username already taken
    	 * default return is 3
    	 */
    	password = encrypt(password);
    	if (!validate(userName)||!validate(password)) return 1;
    	if (checkUsername(userName)) return 2;
        File unDB = new File("Usernames_Passwords.txt");
        try {
            FileWriter fw = new FileWriter(unDB, true);
            BufferedWriter br = new BufferedWriter(fw);
            br.write("\n" + userName + " " + password + " x");
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
    
   private static String encrypt(String str) {
	   final String SALT = "Look at me im encryption";
	   String input = SALT + str;
	   StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}
		return hash.toString();
   }
   
}
