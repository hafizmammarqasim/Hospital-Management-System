import java.util.Scanner;
public class Hospital {
    private String hName;
    Department department;
    AdminManager adminManager;
    PatientTree patientTree;



    public Hospital(){
        this.adminManager = new AdminManager();
        patientTree = new PatientTree();
        adminManager.addAdmin();
    }

}
