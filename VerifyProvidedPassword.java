/*	Source Code by  Sergey Kargopolov 
 *  http://www.appsdeveloperblog.com/encrypt-user-password-example-java/
 */

public class VerifyProvidedPassword {
    public static void main(String[] args)
    {
        // User provided password to validate
        String providedPassword = "myPassword123";
                
        // Encrypted and Base64 encoded password read from database
        String securePassword = "HhaNvzTsVYwS/x/zbYXlLOE3ETMXQgllqrDaJY9PD/U=";
        
        // Salt value stored in database 
        String salt = "EqdmPh53c9x33EygXpTpcoJvc4VXLK";
        
        boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
        
        if(passwordMatch) 
        {
            System.out.println("Provided user password " + providedPassword + " is correct.");
        } else {
            System.out.println("Provided password is incorrect");
        }

    }
}
