public class MenuDisplay implements NonPermutableBranch{
    public MenuDisplay(){}
    public void request(Branch br) {
        Menu menu = br.getMenu();
        System.out.println("Menu:");
        for (MenuItem item : menu.getMenuItems()) {
            System.out.println(item);
        }
    }
}