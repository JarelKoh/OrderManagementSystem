import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * The {@code PaymentDB} class provides utility methods for reading and writing payment item data
 * to and from files.
 */
public class PaymentDB {
	/**
     * The separator used to delimit fields in the file format.
     */
	public static final String SEPARATOR = ",";

    /**
     * Reads payment item data from the specified file and returns an ArrayList of {@code PaymentList} objects.
     *
     * @param filename The name of the file to read from.
     * @return An ArrayList of {@code PaymentList} objects representing the payment items read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
	public static ArrayList<PaymentList> readPaymentItem(String filename) throws IOException {
		ArrayList<String> stringArray = read(filename);
		ArrayList<PaymentList> menu = new ArrayList<PaymentList>();
	
		for (String st : stringArray) {
			StringTokenizer star = new StringTokenizer(st, SEPARATOR);
	
			int itemID = Integer.parseInt(star.nextToken().trim());
			String typeStr = star.nextToken().trim();
	
			// Convert string to enum
			PaymentList.PaymentType type = PaymentList.PaymentType.valueOf(typeStr.toUpperCase());
	
			// Create new PaymentList object with the enum
			menu.add(new PaymentList(itemID, type));
		}
		return menu;
	}

    /**
     * Reads the contents of the specified file and returns an ArrayList of strings, where each string
     * represents a line from the file.
     *
     * @param fileName The name of the file to read from.
     * @return An ArrayList of strings representing the lines read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static ArrayList<String> read(String fileName) throws IOException {
        ArrayList<String> data = new ArrayList<String>() ;
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        try {
          	while (scanner.hasNextLine()){
            	data.add(scanner.nextLine());
          	}
        }
        finally{
          	scanner.close();
        }
        return data;
    }
	
    /**
     * Saves the provided list of payment items to the specified file.
     *
     * @param filename    The name of the file to write to.
     * @param paymentlist The list of {@code PaymentList} objects to be saved.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
	public static void savePaymentItem(String filename, ArrayList<PaymentList> paymentlist) throws IOException {
		ArrayList<String> alw = new ArrayList<String>();

		for (PaymentList item : paymentlist) {
			String itemst = String.format("%d,%s\n", item.getItemId(),item.getType());
			alw.add(itemst) ;
		}
		write(filename,alw);
	}

    /**
     * Writes the provided list of strings to the specified file.
     *
     * @param fileName The name of the file to write to.
     * @param data     The list of strings to be written to the file.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
	public static void write(String fileName, ArrayList<String> data) throws IOException  {
		PrintWriter out = new PrintWriter(new FileWriter(fileName));
	
		try {
			for (int i =0; i < data.size() ; i++) {
				out.print((String)data.get(i));
			}
		}
		finally {
		  	out.close();
		}
	}

}