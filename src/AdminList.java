public class AdminList {
    AdminNode first;
    AdminNode last;

    public AdminList(){
        this.first = null;
        this.last = null;
    }

    public void addAdmin(String username, String password){
        AdminLogin tempAdmin = new AdminLogin(username, password);
        if(first == null && last == null){
            first = new AdminNode(tempAdmin);
            this.last = first;
        }
        else{
            last.next = new AdminNode(tempAdmin);
            last = last.next;
        }
    }

    public boolean checkAdmin(String username, String password){
        AdminNode tempPointer = first;
        if(first == null){
            System.out.println("--- No admins in the list---");
        }
        else {
            while(tempPointer != null){
                if(tempPointer.admin.validateAdmin(username, password))
                    return true;
                tempPointer = tempPointer.next;
            }
        }
        return false;
    }
}
