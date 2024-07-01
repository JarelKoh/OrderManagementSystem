import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class TextDB {
    // an example of reading
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