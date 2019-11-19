import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AddRequestDB {

    public static boolean addStock(String symbol, String name, String currency, String sExchange) throws IOException {
        
        File unDB = new File("Add_Requests.txt");
        try {
            FileWriter fw = new FileWriter(unDB, true);
            BufferedWriter br = new BufferedWriter(fw);
            br.write("\n" + name + " " + name + " " + currency + " " + sExchange);
            br.close();
            fw.close();
            return true;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        System.out.println("Can't add stock");
        return false;
    }
}
