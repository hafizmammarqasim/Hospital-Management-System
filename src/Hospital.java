import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Hospital {
//    private String hName;
    HashMap<String, Department> departmentList;
    AdminManager adminManager;
    DepartmentManager departmentManager;
    PatientTree patientTree;
    ArrayList<Bed> bedList;
    HashMap<String, Doctor> doctorList;
    PatientManager patientManager;
    public Emergency e;
    public AmbulanceList availableAmbulances;
    public AmbulanceList unavailableAmbulances;

    public Hospital(){
        patientTree = new PatientTree();
        this.departmentList = new HashMap<>();
        this.doctorList = new HashMap<>();
        this.departmentManager = new DepartmentManager(this);
        bedList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            bedList.add(new Bed(i));
        }
        this.patientManager = new PatientManager(this);
        this.adminManager = new AdminManager(this);
        e=new Emergency(this);
        adminManager.addAdmin();
        availableAmbulances = new AmbulanceList();
        unavailableAmbulances = new AmbulanceList();

        // Load sample ambulances
        availableAmbulances.addAmbulance(new Ambulance("Ali", "REG001", "Toyota"));
        availableAmbulances.addAmbulance(new Ambulance("Bilal", "REG002", "Honda"));
        availableAmbulances.addAmbulance(new Ambulance("Usman", "REG003", "Suzuki"));
        availableAmbulances.addAmbulance(new Ambulance("Zain", "REG004", "Ford"));
        availableAmbulances.addAmbulance(new Ambulance("Ahsan", "REG005", "Hyundai"));

    }

}
