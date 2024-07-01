import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

// Note : When structure of the Object type (the class file) in the list changed
// the Serialized file may fail.
/**
 * The SerializeDB class provides utility methods to serialize and deserialize lists
 * of objects to and from files. This class handles the low-level input and output operations
 * associated with object serialization.
 *
 * Note: Changes in the structure of the object types (the class files) within the list may
 * cause serialization to fail or produce unpredictable results when deserializing.
 */
public class SerializeDB
{
	/**
     * Reads a serialized object list from a specified file and deserializes it.
     * This method opens the file, reads the serialized data, and converts it back
     * into a List object. If the file does not exist, the method prompts the user
     * for initialization.
     *
     * @param filename the name of the file from which to read the serialized object list.
     * @return a {@code List} containing the deserialized objects from the file.
     *         Returns {@code null} if an error occurs during deserialization.
     */
	public static List readSerializedObject(String filename) {
		List pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList) in.readObject();
			in.close();
		} catch (FileNotFoundException fnf){
			System.out.println("Do you want to intialise the system?\n1.Yes\n2.No");
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}
	/**
     * Writes a list of objects to a specified file as serialized data.
     * This method opens or creates the file, then writes the serialized form of the
     * list to the file. It is the caller's responsibility to ensure that all objects
     * in the list are serializable.
     *
     * @param filename the name of the file to which the object list will be serialized.
     * @param list the {@code List} of objects to be serialized.
     */
	public static void writeSerializedObject(String filename, List list) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
		//	System.out.println("Object Persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}