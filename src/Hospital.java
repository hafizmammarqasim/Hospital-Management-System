import java.util.HashMap;
import java.util.Scanner;
public class Hospital {
    private String hName;
    Department department;
    AdminManager adminManager;
    DoctorManager doctorManager;
    PatientTree patientTree;
    HashMap<String, Doctor> doctorList;
    private static final Hospital INSTANCE = new  Hospital();

    public Hospital(){
        patientTree = new PatientTree();
        this.doctorList = new HashMap<>();
        this.adminManager = new AdminManager(this);
        this.doctorManager = new DoctorManager(this);
        adminManager.addAdmin();
    }

    public static Hospital getInstance(){
        return INSTANCE;
    }

}
