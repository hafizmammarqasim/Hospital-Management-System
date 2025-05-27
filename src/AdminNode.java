public class AdminNode {
    public AdminLogin admin;
    public AdminNode next;

    public AdminNode(AdminLogin admin){
        this.admin = admin;
        this.next = null;
    }
}
