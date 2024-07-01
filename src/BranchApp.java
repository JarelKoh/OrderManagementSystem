import java.util.ArrayList;

public class BranchApp {
    private ArrayList<Branch> branchlist;
    private static String datfile = "main.dat";
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

    public void saveBranch(){
        try	{
            SerializeDB.writeSerializedObject(datfile, branchlist);
        }catch ( Exception e ) {
            System.out.println( "Exception >> " + e.getMessage() );
        }
    }

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