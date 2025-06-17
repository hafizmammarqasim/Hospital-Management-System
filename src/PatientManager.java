import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class PatientManager {
    AdminList adminList;
    PatientTree patientTree;


    public PatientManager(Hospital hospital) {
        this.adminList = new AdminList();
        this.patientTree = hospital.patientTree;


    }
    Scanner myInput = new Scanner(System.in);

    public void patientLogin() {
        System.out.println("\n\t------- Patient Login -------");
        System.out.println("Enter your CNIC number:");
        String cnic = myInput.nextLine();
        System.out.println("Enter your password:");
        String password = myInput.nextLine();

        PatientTreeNode patient = patientTree.searchPatient(cnic);

        if (patient != null && patient.pData.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome, " + patient.pData.name);
            patientDashboard(patient);
        } else {
            System.out.println("Invalid CNIC or password. Please try again.");
        }
    }

    // New method for patient registration
    public void registerPatient() {
        Patient newPatient = new Patient();

        System.out.println("\n\t------- Patient Registration -------");
        System.out.println("Enter your CNIC number:");
        newPatient.cnicNum = myInput.nextLine();

        // Check if patient already exists
        if (patientTree.searchPatient(newPatient.cnicNum) != null) {
            System.out.println("A patient with this CNIC is already registered.");
            return;
        }

        System.out.println("Create a password:");
        newPatient.setPassword(myInput.nextLine());

        System.out.println("Enter your full name:");
        newPatient.name = myInput.nextLine();

        System.out.println("Enter your date of birth (YYYY-MM-DD):");
        try {
            newPatient.dateofbirth = new SimpleDateFormat("yyyy-MM-dd").parse(myInput.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format. Using current date.");
            newPatient.dateofbirth = new Date();
        }

        System.out.println("Enter your blood type:");
        newPatient.bloodType = myInput.nextLine();

        System.out.println("Enter your location:");
        newPatient.location = myInput.nextLine();


        patientTree.addPatient(newPatient);
        System.out.println("Registration successful! Your patient ID is: " + newPatient.patientId);
    }



    public void patientFunctionsMenu() {
        while (true) {
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
   /* public void addPatient() {
        Patient tempPatient = new Patient();

        System.out.println("\n\t-------Add Patient------");
        System.out.println("Enter patient Name:");
        tempPatient.name = myInput.nextLine();

        System.out.println("Enter ID card #: ");
        tempPatient.cnicNum = myInput.nextLine();

        System.out.println("Enter patient's blood type:");
        tempPatient.bloodType = myInput.nextLine();

        patientTree.addPatient(tempPatient);
    }*/

    public void addPatient() {
        Patient tempPatient = new Patient();
        Scanner myInput = new Scanner(System.in);

        System.out.println("\n\t------- Add Patient -------");

        // Personal Information
        System.out.println("Enter patient ID:");
        tempPatient.patientId = myInput.nextLine();

        System.out.println("Enter patient Name:");
        tempPatient.name = myInput.nextLine();

        System.out.println("Enter ID card # (CNIC):");
        tempPatient.cnicNum = myInput.nextLine();

        System.out.println("Enter date of birth (YYYY-MM-DD):");
        try {
            tempPatient.dateofbirth = new SimpleDateFormat("yyyy-MM-dd").parse(myInput.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format.");
          //  tempPatient.dateofbirth = new Date();
        }

        System.out.println("Enter blood type:");
        tempPatient.bloodType = myInput.nextLine();

        System.out.println("Enter location:");
        tempPatient.location = myInput.nextLine();

        // Medical Information
        System.out.println("Enter reason for visit:");
        tempPatient.reason = myInput.nextLine();

        System.out.println("Enter allergies (comma separated):");
        List<String>  allergies = new ArrayList<>();
        while(true){
            String allergy = myInput.nextLine();
            if(allergy.isEmpty()){
                break;
            }
            allergies.add((allergy));
        }

        // Add to patient tree
        patientTree.addPatient(tempPatient);
        System.out.println("Patient added successfully!");

    }
    public void searchPatient() {
        System.out.println("Enter patient's id card number: ");
        String cnicNum = myInput.nextLine();
        patientTree.searchPatient(cnicNum);
    }

    public void viewPatients() {
        patientTree.viewPatients();
    }


    public void deletePatient() {
        System.out.println("Enter the patient's id Card Number: ");
        String idCardNum = myInput.nextLine();
        patientTree.deletePatients(idCardNum);
    }


}
