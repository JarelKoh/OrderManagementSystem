import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * The {@code MenuDB} class provides utility methods for reading and writing menu item data
 * to and from files.
 */
public class MenuDB {
    /**
     * The separator used to delimit fields in the file format.
     */
	public static final String SEPARATOR = ",";

	/**
     * Reads menu item data from the specified file and returns a {@code Menu} object.
     *
     * @param filename The name of the file to read from.
     * @return A {@code Menu} object containing the menu items read from the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
	public static Menu readMenu(String filename) throws IOException {
		// read String from text file
		ArrayList<String>stringArray = (ArrayList<String>)read(filename);
		ArrayList<MenuItem> menulist = new ArrayList<MenuItem>() ;

        for (int i = 0 ; i < stringArray.size() ; i++) {
			String st = (String)stringArray.get(i);
			// get individual 'fields' of the string separated by SEPARATOR
			StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

			int itemID = Integer.parseInt(star.nextToken().trim());
			String  name = star.nextToken().trim();
			float  price = Float.parseFloat(star.nextToken().trim());
			String  description = star.nextToken().trim();
			String  category = star.nextToken().trim();
			String  available = star.nextToken().trim();

			menulist.add(new MenuItem(itemID, name, price, description, category, available));
		}
		Menu menu = new Menu(menulist);
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
     * Saves the provided list of menu items to the specified file.
     *
     * @param filename The name of the file to write to.
     * @param menulist The list of {@code MenuItem} objects to be saved.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
	public static void saveMenuItem(String filename, ArrayList<MenuItem> menulist) throws IOException {
		ArrayList<String> alw = new ArrayList<String>();

		for (MenuItem item : menulist) {
			String itemst = String.format("%d,%s,%.2f,%s,%s,%s\n", item.getItemId(),item.getName(),item.getPrice(),item.getDescription(), item.getCategory(), item.getAvailability());
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
