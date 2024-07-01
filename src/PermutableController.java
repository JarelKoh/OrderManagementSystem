public class PermutableController {
    public PermutableController(){};
    public void execute(Permutable perm){
        perm.request();
    }

    public void execute(PermutableBranch perm, Branch b){
        perm.request(b);
    }
}
