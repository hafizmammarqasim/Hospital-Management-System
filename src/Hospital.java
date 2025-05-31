import java.util.Scanner;
public class Hospital {
    private String hName;
    Department department;
    AdminManager adminManager;
    PatientTree patientTree;

    private static final Hospital INSTANCE = new  Hospital();

    public Hospital(){
        patientTree = new PatientTree();
        this.adminManager = new AdminManager(this.patientTree);
        adminManager.addAdmin();
    }

    public static Hospital getInstance(){
        return INSTANCE;
    }

}
