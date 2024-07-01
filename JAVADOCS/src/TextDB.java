import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * The {@code TextDB} class provides utility methods for reading user data from a text file.
 */
public class TextDB {
    /**
     * Reads user data from the specified file and updates the provided list of branches.
     *
     * @param filename    The name of the file to read from.
     * @param branchlist  The list of branches to be updated with the read user data.
     * @return The updated list of branches.
     * @throws IOException If an I/O error occurs while reading the file.
     */

	public static ArrayList<Branch> readUsers(String filename, ArrayList<Branch> branchlist) throws IOException {
		// read String from text file
		try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            int age;
            String username, password, branch, role , gender, userID;

            String[] userdata;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                userdata = data.split(",");
				username = userdata[0];
				password = userdata[1];
				branch = userdata[2];
				role = userdata[3];
				gender = userdata[4];
				age = Integer.parseInt(userdata[5]);
				userID = userdata[6];
				User user = null;
				int found = 0;
				if (branchlist.size() == 0){
					branchlist.add(new Branch(branch));
				} else{
					for (Branch br : branchlist){
						if (br.getBranchname().equals(branch)){
							user = new User(username, PasswordHide.encrypt(password), br, role, gender, age, userID);
							found = 1;
							br.addUser(user);
							break;
						}
					}
					if (found == 0){
						Branch b = new Branch(branch);
						user = new User(username, PasswordHide.encrypt(password), b, role, gender, age, userID);
						b.addUser(user);
						branchlist.add(b);

					}
				}
			}
			myReader.close();
        } catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
        }
		return branchlist;
	}
}