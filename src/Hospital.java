import java.util.HashMap;
import java.util.Scanner;
public class Hospital {
    private String hName;
    HashMap<String, Department> departmentList;
    AdminManager adminManager;
    DoctorManager doctorManager;
    DepartmentManager departmentManager;
    PatientTree patientTree;
    HashMap<String, Doctor> doctorList;
    private static final Hospital INSTANCE = new  Hospital();

    public Hospital(){
        patientTree = new PatientTree();
        this.departmentList = new HashMap<>();
        this.doctorList = new HashMap<>();
        this.doctorManager = new DoctorManager(this);
        this.departmentManager = new DepartmentManager(this);
        this.adminManager = new AdminManager(this);
        adminManager.addAdmin();
    }

    public static Hospital getInstance(){
        return INSTANCE;
    }

}
