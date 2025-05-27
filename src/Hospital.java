import java.util.Scanner;
public class Hospital {
    private String hName;
    Department department;
    AdminList adminList;
    AdminManager adminManager;

    Scanner myInput = new Scanner(System.in);

    public Hospital(){
        this.adminList =  new AdminList();
        this.adminManager = new AdminManager();
        addAdmin();
    }

    public void askPassword(){
        System.out.println("Enter username");
        String userName = myInput.nextLine();

        System.out.println("Enter password");
        String pass = myInput.nextLine();

        validateAdmin(userName,pass);
    }
    public void addAdmin(){
        adminList.addAdmin("mateen","002");
        adminList.addAdmin("ammar","029");
        adminList.addAdmin("sara","110");
    }

    public void validateAdmin(String username, String password){
        if(adminList.checkAdmin(username, password)){
            adminManager.adminMenu();
        }
        else{
            System.out.println("Invalid");
        }
    }


}
