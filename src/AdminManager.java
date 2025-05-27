import java.util.Scanner;

public class AdminManager {
    AdminList adminList;

    public AdminManager(){
        this.adminList = new AdminList();
    }
    Scanner myInput = new Scanner(System.in);

    public void addAdmin(){
        adminList.addAdmin("mateen","002");
        adminList.addAdmin("ammar","029");
        adminList.addAdmin("sara","110");
    }

    public void askPassword(){
        System.out.println("Enter username");
        String userName = myInput.nextLine();

        System.out.println("Enter password");
        String pass = myInput.nextLine();

        validateAdmin(userName,pass);
    }

    public void validateAdmin(String username, String password){
        if(adminList.checkAdmin(username, password)){
            adminMenu();
        }
        else{
            System.out.println("Invalid");
        }
    }


    public void adminMenu(){
        System.out.println("==============================");
        System.out.println("   *** Khush Amadeed ***  ");
        System.out.println("==============================");

    }
}
