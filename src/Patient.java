
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Patient {
    public String patientId;
    public  String bloodType;
    public String name;
    public String cnicNum;
    public String password;
    public LocalDate dateofbirth;
    public String reason;
    public List<String> allergies;
    public String location;
    private MedicalRecordList medicalRecordList;
    public DepartmentManager departmentManager;
    Scanner scanner = new Scanner(System.in);
    public Patient(DepartmentManager departmentManager) {
        this.allergies = new ArrayList<>();
        this.departmentManager = departmentManager;
        this.medicalRecordList = new MedicalRecordList();
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

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
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

    public void patientDashboard() {
        while (true) {
            System.out.println("\n\t===== Patient Dashboard =====");
            System.out.println("1. View My Information");
            System.out.println("2. Update My Information");
            System.out.println("3. View Medical Records");
            System.out.println("4. Last Checkup Record");
            System.out.println("5. Book New Appointment");
            System.out.println("0. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                   this.viewPatientInfo();
                    break;
                case 2:
                    this.updatePatientInfo();
                    break;
                case 3:
                    this.viewMedicalRecords();
                    break;
                case 4:
                    this.medicalRecordList.viewLastRecord();
                    break;
                case 5:
                    this.bookAppointments();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void viewPatientInfo() {
        System.out.println("\n\t------- Your Information -------");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("CNIC: " + cnicNum);
        System.out.println("Date of Birth: " + dateofbirth);
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Location: " + location);
    }

    private void updatePatientInfo() {
        System.out.println("\n\t------- Update Information -------");
        System.out.println("(Leave field blank to keep current value)");

        System.out.println("Current name: " + this.name);
        System.out.println("Enter new name:");
        String newName =  scanner.nextLine();
        if (newName.isEmpty()) {
            return;
        }

        this.name = newName;

        System.out.println("Current blood type: " + this.bloodType);
        System.out.println("Enter new blood type:");
        String newBloodType = scanner.nextLine();
        if (!newBloodType.isEmpty()) {
            this.bloodType = newBloodType;
        }

        System.out.println("Current location: " + location);
        System.out.println("Enter new location:");
        String newLocation = scanner.nextLine();
        if (!newLocation.isEmpty()) {
            this.location = newLocation;
        }

        System.out.println("Information updated successfully!");
    }

    public void bookAppointments(){
        System.out.println("Enter appointment date (DD-MM-YYYY): ");
        String dateInput = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate appointmentDate = LocalDate.parse(dateInput, formatter);

        System.out.println("Enter department name: ");
        String depName = scanner.nextLine();


        Department department = departmentManager.departmentList.get(depName);

        if (department == null) {
            System.out.println("Error: Department '" + depName + "' not found!");
            return;
        }

        if (department.doctorManager == null) {
            System.out.println("Error: No doctor manager available for this department");
            return;
        }

        department.doctorManager.manageAppointment(appointmentDate, this);

    }

    private void viewMedicalRecords() {
        medicalRecordList.displayAllRecords();
    }


}
