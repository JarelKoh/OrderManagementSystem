import java.util.ArrayList;
/**
 * The BranchApp class manages a list of Branch objects and provides methods
 * for saving and loading the branch data from a serialized file.
 */
public class BranchApp {
    private ArrayList<Branch> branchlist;
    private static String datfile = "main.dat";
    /**
     * Constructs a new BranchApp object and initializes the branchlist.
     * Attempts to load the branch data from the serialized file.
     */
    public BranchApp(){
        branchlist = new ArrayList<>();
        try	{
            branchlist = (ArrayList<Branch>) SerializeDB.readSerializedObject(datfile);

        }  catch ( Exception e ) {
                    System.out.println( "Exception >> " + e.getMessage() );
        }
    }

    public void setBranch(Branch b){
        int i = this.getBranchIndex(b);
        branchlist.remove(i);
        branchlist.add(i, b);;
        this.saveBranch();
    }
    /**
     * Saves the current branchlist to the serialized file.
     */
    public void saveBranch(){
        try	{
            SerializeDB.writeSerializedObject(datfile, branchlist);
        }catch ( Exception e ) {
            System.out.println( "Exception >> " + e.getMessage() );
        }
    }
    /**
     * Saves the provided list of Branch objects to the serialized file.
     *
     * @param bList the list of Branch objects to save
     */
    public static void saveBranch(ArrayList<Branch> bList){
        try	{
            SerializeDB.writeSerializedObject(datfile, bList);
        }catch ( Exception e ) {
            System.out.println( "Exception >> " + e.getMessage() );
        }
    }

    public ArrayList<Branch> getBranchlList(){
        return branchlist;
    }

    public int getBranchIndex(Branch br){
        int i;

        for (i=0; i<branchlist.size(); i++) {
            if (branchlist.get(i).getBranchname().equals(br.getBranchname())){
                return i;
            }
        }
        return -1;
    }
}