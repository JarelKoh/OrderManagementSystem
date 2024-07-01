import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PaymentDB {
	public static final String SEPARATOR = ",";

    // an example of reading
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
	

	public static void savePaymentItem(String filename, ArrayList<PaymentList> paymentlist) throws IOException {
		ArrayList<String> alw = new ArrayList<String>();

		for (PaymentList item : paymentlist) {
			String itemst = String.format("%d,%s\n", item.getItemId(),item.getType());
			alw.add(itemst) ;
		}
		write(filename,alw);
	}

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