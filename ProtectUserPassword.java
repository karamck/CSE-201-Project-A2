/*	Source Code by  Sergey Kargopolov 
 *  http://www.appsdeveloperblog.com/encrypt-user-password-example-java/
 */
public class ProtectUserPassword {
    public static void main(String[] args)
    {
        String myPassword = "myPassword123";
        
        // Generate Salt. The generated value can be stored in DB. 
        String salt = PasswordUtils.getSalt(30);
        
        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
        
        // Print out protected password 
        System.out.println("My secure password = " + mySecurePassword);
        System.out.println("Salt value = " + salt);
    }
}
