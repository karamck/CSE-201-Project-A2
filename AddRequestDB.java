import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddRequestDB {

    public static boolean addStock(String symbol, String name, String currency, String sExchange) throws IOException {

        File unDB = new File("Add_Requests.txt");
        try {
            FileWriter fw = new FileWriter(unDB, true);
            BufferedWriter br = new BufferedWriter(fw);
            Scanner checker = new Scanner(unDB);
            if (!checker.hasNext()) {
                br.write(symbol + " " + name + " " + currency + " " + sExchange);
            } else {
                br.write("\n" + symbol + " " + name + " " + currency + " " + sExchange);
            }
            br.close();
            fw.close();
            return true;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        System.out.println("Can't add stock");
        return false;
    }

    public static String[] getRequests() throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        File unDB = new File("Add_Requests.txt");
        try {
            Scanner dbReader = new Scanner(unDB);

            while (dbReader.hasNextLine()) {
                String line = dbReader.nextLine();
                String line2 = "";
                String[] splitLine = line.split(" ");
                line2 += "Symbol:  " + splitLine[0] + "\n";
                line2 += " Name:  " + splitLine[1] + "\n";
                line2 += " Currency:  " + splitLine[2] + "\n";
                line2 += " Exhange:  " + splitLine[3] + "\n\n\n";
                list.add(line2);

            }
            dbReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        String[] arrayOfStrings = list.toArray(new String[list.size()]);
        return arrayOfStrings;
    }
    
    //this is in progress
    public static boolean removeRequest(String symbol) throws IOException {
        File unDB = new File("Add_Requests.txt");
        try {
            Scanner dbReader = new Scanner(unDB);
            FileWriter fw = new FileWriter(unDB, true);
            //BufferedWriter br = new BufferedWriter(fw);
            while (dbReader.hasNextLine()) {
                String line = dbReader.nextLine();
                String[] splitLine = line.split(" ");
                if (splitLine[0].equals(symbol)) {
                }
                else {
                    fw.write(line);
                }
            }
            
            fw.close();
            //br.close();
            dbReader.close();
            return true;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        return false;
    }

}
