import java.util.HashMap;
import java.util.Scanner;

public class AdminManager {
    AdminList adminList;
    PatientTree patientTree;
    DoctorManager doctorManager;
    HashMap<String, Doctor> doctorList;
    DepartmentManager departmentManager;

    public AdminManager(Hospital hospital){
        this.patientTree = hospital.patientTree;
        this.doctorList = hospital.doctorList;
        this.doctorManager = hospital.doctorManager;
        this.departmentManager = hospital.departmentManager;
        this.adminList = new AdminList();
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
                    doctorFunctions();
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
        while (true){
        System.out.println("\t===== Patient Functions =====");
        System.out.println("1. Add Patients");
        System.out.println("2. Search Patient");
        System.out.println("3. View Patients");
        System.out.println("4. Delete Patient");
        System.out.println("5. Exit");

        int choice = myInput.nextInt();
        myInput.nextLine();
        switch (choice) {
            case 1:
                addPatient();
                break;
            case 2:
                searchPatient();
                break;
            case 3:
                viewPatients();
                break;
            case 4:
                deletePatient();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice");
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

    public void doctorFunctions(){
        System.out.println("Enter Department Name: ");
        String depName = myInput.nextLine();


        while (true) {
            System.out.println("==== DOCTOR FUNCTIONS ====");
            System.out.println("Choose Function you want to perform: ");
            System.out.println("1. Add Doctor");
            System.out.println("2. Delete Doctor");
            System.out.println("3. View Department Doctors: ");
            System.out.println("0. Exit");
            char choice = myInput.next().charAt(0);

            switch (choice){
                case '1':
                    departmentManager.addDoctor(IdGenerator.generateDoctorId(), depName);
                    break;
                case '2':
                    departmentManager.deleteDoctor(depName);
                    break;
                case '3':
                    departmentManager.viewDepartmentDoctors(depName);
                    break;
                case '0':
                    return;
            }
        }
    }

//    public void Doctor(){
//        System.out.println("Enter Department Name: ");
//        String depName = myInput.nextLine();
//
//
//        while (true) {
//            System.out.println("==== DOCTOR FUNCTIONS ====");
//            System.out.println("Choose Function you want to perform: ");
//            System.out.println("1. Add Doctor");
//            System.out.println("2. Delete Doctor");
//            System.out.println("3. View Department Doctors: ");
//            System.out.println("0. Exit");
//            char choice = myInput.next().charAt(0);
//
//            switch (choice){
//                case '1':
//                    departmentManager.addDoctor(IdGenerator.generateDoctorId(), depName);
//                    break;
//                case '2':
//                    departmentManager.deleteDoctor(depName);
//                    break;
//                case '3':
//                    departmentManager.viewDepartmentDoctors(depName);
//                    break;
//                case '0':
//                    return;
//            }
//        }
//    }


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
