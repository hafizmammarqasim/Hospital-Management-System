import java.util.HashMap;
import java.util.Scanner;
public class Hospital {
//    private String hName;
    HashMap<String, Department> departmentList;
    AdminManager adminManager;
    DepartmentManager departmentManager;
    PatientTree patientTree;
    HashMap<String, Doctor> doctorList;

    public Hospital(){
        patientTree = new PatientTree();
        this.departmentList = new HashMap<>();
        this.doctorList = new HashMap<>();
        this.departmentManager = new DepartmentManager(this);
        this.adminManager = new AdminManager(this);
        adminManager.addAdmin();
    }

}
