import java.util.HashMap;
import java.util.Scanner;

public class AdminManager {
    AdminList adminList;
    PatientTree patientTree;
    DoctorManager doctorManager;
    HashMap<String, Doctor> doctorList;
    PatientManager patientManager;

    public AdminManager(Hospital hospital){
        this.patientTree = hospital.patientTree;
        this.doctorList = hospital.doctorList;
        this.doctorManager = hospital.doctorManager;
        this.adminList = new AdminList();
        this.patientManager = hospital.patientManager;
        addAdmin();
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
        System.out.println("2. Patient Functions");
        System.out.println("3. Have Checkup");
        System.out.println("4. View Patients");
        System.out.println("5. Exit ");

        int choice = myInput.nextInt();
        myInput.nextLine();
            switch (choice){
                case 1:
                    addDoctor();
                    break;
                case 2:
                    patientFunctions();
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

    public void patientFunctions(){
       patientManager.patientFunctionsMenu();

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
     //   doctorManager.addDoctor();
    }

    public void haveCheckup(){

    }

    public void searchPatient(){
        System.out.println("Enter patient's id card number: ");
        String idCardNum = myInput.nextLine();
        patientTree.searchPatient(idCardNum);
    }

    public void viewPatients(){
        patientTree.viewPatients();
    }

    public void deletePatient(){
        System.out.println("Enter the patient's id Card Number: ");
        String idCardNum = myInput.nextLine();

        patientTree.deletePatients(idCardNum);
    }


}
