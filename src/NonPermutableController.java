public class NonPermutableController {
    public NonPermutableController(){}
    public void execute(NonPermutableNull requester){
        requester.request();
    }

    public void execute(NonPermutableBranch requester, Branch b){
        requester.request(b);
    }
}
