import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Patient {
    public String patientId;
    public  String bloodType;
    private MedicalRecord medicalRecord;
    private MedicalRecordList medicalRecordList;
    public String name;
    public String cnicNum;
    public String password;
    public Date dateofbirth;
    public String reason;
    public List<String> allergies;
    public String location;
    Scanner scanner = new Scanner(System.in);
    public Patient() {
        this.allergies = new ArrayList<>();
        this.medicalRecord = new MedicalRecord();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = new MedicalRecord();
    }


    public MedicalRecordList getMedicalRecordList() {
        return medicalRecordList;
    }

    public void setMedicalRecordList(MedicalRecordList medicalRecordList) {
        this.medicalRecordList = medicalRecordList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnicNum() {
        return cnicNum;
    }

    public void setCnicNum(String cnicNum) {
        this.cnicNum = cnicNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addMedicalRecord(String reason){

        medicalRecord.addMedicalRecord();
    }
    private void patientDashboard(Patient patient) {
        while (true) {
            System.out.println("\n\t===== Patient Dashboard =====");
            System.out.println("1. View My Information");
            System.out.println("2. Update My Information");
            System.out.println("3. View Medical Records");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewPatientInfo(patient);
                    break;
                case 2:
                    updatePatientInfo(patient);
                    break;
                case 3:
                    viewMedicalRecords(patient);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void viewPatientInfo(Patient patient) {
        System.out.println("\n\t------- Your Information -------");
        System.out.println("Patient ID: " + patient.patientId);
        System.out.println("Name: " + patient.name);
        System.out.println("CNIC: " + patient.cnicNum);
        System.out.println("Date of Birth: " + patient.dateofbirth);
        System.out.println("Blood Type: " + patient.bloodType);
        System.out.println("Location: " + patient.location);
    }

    private void updatePatientInfo(Patient patient) {
        System.out.println("\n\t------- Update Information -------");
        System.out.println("Leave field blank to keep current value");

        System.out.println("Current name: " + patient.name);
        System.out.println("Enter new name:");
        String newName =  scanner.nextLine();
        if (!newName.isEmpty()) {
            patient.name = newName;
        }

        System.out.println("Current blood type: " + patient.bloodType);
        System.out.println("Enter new blood type:");
        String newBloodType = scanner.nextLine();
        if (!newBloodType.isEmpty()) {
            patient.bloodType = newBloodType;
        }

        System.out.println("Current location: " + patient.location);
        System.out.println("Enter new location:");
        String newLocation = scanner.nextLine();
        if (!newLocation.isEmpty()) {
            patient.location = newLocation;
        }

        System.out.println("Information updated successfully!");
    }


    private void viewMedicalRecords(Patient patient) {
        System.out.println("\n\t------- Medical Records -------");
        System.out.println("Patient: " + patient.getName() + " (" + patient.getPatientId() + ")");

        MedicalRecord record = patient.getMedicalRecord();

        if (record == null) {
            System.out.println("No medical record available.");
            return;
        }

        System.out.println("\nMedical Record Details:");
        System.out.println("1. Record ID: " + record.getRecordId());
        System.out.println("2. Initial Diagnosis: " + record.getInitialDiagnosis());
        System.out.println("3. Current Diagnosis: " + record.getDiagnosis());
        System.out.println("4. Severity: " + record.getSeverity());
        System.out.print("5. Admit Status: ");
        if (record.isAdmitStatus()) {
            System.out.println("Admitted");
        } else {
            System.out.println("Not Admitted");
        }

        if (record.getDoctor() != null) {
            System.out.println("6. Attending Doctor: " + record.getDoctor().getName());
        }

        System.out.print("7. Bed Number: ");
        if (record.getBedNumber() != null) {
            System.out.println(record.getBedNumber());
        } else {
            System.out.println("N/A");
        }
        System.out.println("8. Medications: " + record.getMedications());
        System.out.println("9. Last Check-up: " + record.getCheckUpDate());
        System.out.println("----------------------------------");
    }


}
