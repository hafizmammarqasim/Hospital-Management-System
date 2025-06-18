import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminManager {
    AdminList adminList;
    PatientTree patientTree;
    HashMap<String, Doctor> doctorList;
    DepartmentManager departmentManager;
    PatientManager patientManager;
    Hospital hospital;

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public AdminManager(Hospital hospital){
        this.patientTree = hospital.patientTree;
        this.doctorList = hospital.doctorList;
        this.departmentManager = hospital.departmentManager;
        this.hospital = hospital;
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

        System.out.println("[1] Register Doctor");
        System.out.println("[2] Patient Functions");
        System.out.println("[3] Have Checkup");
            System.out.println("[4]. Ambulance Details");
            System.out.println("[5]. Bed Details");
            System.out.println("0. ↩ Back");


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
                    ambulanceDetailsMenu();
                    break;
                case 5:
                    bedDetailsMenu();
                    break;
                case 0:
                    return;
            }
        }


    }

    public void patientFunctions() {
        while (true) {
            System.out.println("\t===== Patient Functions =====");
            System.out.println("1. Add Patients");
            System.out.println("2. Search Patient");
            System.out.println("3. View Patients");
            System.out.println("4. Delete Patient");
            System.out.println("0. ↩ Back");

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
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }

            patientManager.patientFunctionsMenu();


        }
    }

    public void addPatient(){
        Patient tempPatient = new Patient(departmentManager);

        System.out.println("\n\t-------Add Patient------");
        System.out.println("Enter CNIC #: ");
        tempPatient.cnicNum = myInput.nextLine();

        System.out.println("Enter patient Name:");
        tempPatient.name = myInput.nextLine();

        tempPatient.patientId = IdGenerator.generatePatientId();

        System.out.println("Enter patient's blood type:");
        tempPatient.bloodType = myInput.nextLine();

        System.out.println("Enter password: ");
        tempPatient.password = myInput.nextLine();

        System.out.println("Enter Address:");
        tempPatient.location = myInput.nextLine();

        System.out.println("Enter Date of Birth (dd-MM-YYYY)");
        String date = myInput.nextLine();
        tempPatient.dateofbirth = LocalDate.parse(date,dateFormatter);

        tempPatient.departmentManager = this.departmentManager;
        patientTree.addPatient(tempPatient);

    }

    public void doctorFunctions(){
        System.out.println("Enter Department Name: ");
        String depName = myInput.nextLine();

        if(departmentManager.departmentList.get(depName)!=null) {
            while (true) {
                System.out.println("======= DOCTOR FUNCTIONS ======");
                System.out.println("Please select and option: ");
                System.out.println("[1] Add Doctor");
                System.out.println("[2] Delete Doctor");
                System.out.println("[3] View Department Doctors: ");
                System.out.println("[0] Exit");
                char choice = myInput.next().charAt(0);

                switch (choice) {
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
        } else {
            System.out.println("❌Department Doesn't exist");
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

    public void ambulanceDetailsMenu() {
        while (true) {
            System.out.println("\n--- Ambulance Details ---");
            System.out.println("1. View Available Ambulances");
            System.out.println("2. View Unavailable Ambulances");
            System.out.println("0. Back to Admin Menu");

            int choice = myInput.nextInt();
            myInput.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("✅ Available Ambulances:");
                    hospital.availableAmbulances.viewAmbulances();
                    break;
                case 2:
                    System.out.println("🚫 Unavailable Ambulances:");
                    hospital.unavailableAmbulances.viewAmbulances();
                    break;

                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public void moveUnavailableAmbulances() {
        if (hospital.unavailableAmbulances.isEmpty()) {
            System.out.println("❌ No unavailable ambulances to move.");
            return;
        }

        AmbulanceList unavailableAmbulances= hospital.unavailableAmbulances;
        Ambulance ambulance = unavailableAmbulances.dispatchAmbulance();
        while (ambulance!= null) {
            hospital.availableAmbulances.addAmbulance(ambulance);
            ambulance = unavailableAmbulances.dispatchAmbulance();
        }
    }

    public void bedDetailsMenu() {
        while (true) {
            System.out.println("\n--- Bed Details ---");
            System.out.println("1. View All Beds");
            System.out.println("2. View Occupied Beds");
            System.out.println("3. View Available Beds");
            System.out.println("4. Back to Admin Menu");

            int choice = myInput.nextInt();
            myInput.nextLine();

            ArrayList<Bed> beds = hospital.bedList; // assumes public bedList in hospital

            switch (choice) {
                case 1:
                    for (Bed bed : beds) {
                        System.out.println(bed.getBedId() + " - " + bed.getStatus());
                    }
                    break;
                case 2:
                    for (Bed bed : beds) {
                        if (!bed.isAvailable()) {
                            System.out.println(bed.getBedId() + " - " + bed.getStatus() + " (" + bed.getPatient().name + ")");
                        }
                    }
                    break;
                case 3:
                    for (Bed bed : beds) {
                        if (bed.isAvailable()) {
                            System.out.println(bed.getBedId() + " - AVAILABLE");
                        }
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


}





