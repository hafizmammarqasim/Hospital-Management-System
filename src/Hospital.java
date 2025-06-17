import java.util.HashMap;
import java.util.Scanner;
public class Hospital {
//    private String hName;
    HashMap<String, Department> departmentList;
    AdminManager adminManager;
<<<<<<< HEAD
    DepartmentManager departmentManager;
=======
    DoctorManager doctorManager;
    PatientManager patientManager;
>>>>>>> 23b485f0238dd5c535b3b5036066c3b125b46fde
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
