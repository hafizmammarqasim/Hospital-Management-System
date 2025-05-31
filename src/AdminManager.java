import java.util.Scanner;

public class AdminManager {
    AdminList adminList;
    PatientTree patientTree;

    public AdminManager(PatientTree patient){
        this.patientTree = patient;
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
        while (true){
        System.out.println("\t==============================");
        System.out.println("\t   *** Admin ka menu ***  ");
        System.out.println("\t==============================");

        System.out.println("1. Register Doctor");
        System.out.println("2. Register Patient");
        System.out.println("4. View Patients");
        System.out.println("5. Checkup ");

        int choice = myInput.nextInt();
        myInput.nextLine();
            switch (choice){
                case 1:
                    addDoctor();
                    break;
                case 2:
                    addPatient();
                    break;
                case 3:
                    haveCheckup();
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    return;
            }
        }


    }

    public void addPatient(){
        Patient tempPatient = new Patient();
        System.out.println("\n\t-------Add Patient------");
        System.out.println("Enter patient Name:");
        tempPatient.name = myInput.nextLine();
        System.out.println("Enter ID card #: ");
        tempPatient.cnicNum = myInput.nextLine();

        System.out.println("Enter patient's blood type:");
        tempPatient.bloodType = myInput.nextLine();

        patientTree.addPatient(tempPatient);

    }

    public void addDoctor(){

    }

    public void haveCheckup(){

    }

    public void searchPatient(){

    }

    public void viewPatients(){
        patientTree.viewPatients();
    }

}
