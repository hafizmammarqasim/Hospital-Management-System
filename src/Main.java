//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Main {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        Hospital hospital = new Hospital();

while (true) {
    System.out.println("===============================================");
    System.out.println("         🏥 Hospital Management System 🏥 ");
    System.out.println("===============================================");
    System.out.println();
    System.out.println();
    System.out.println("Please Select an Option:");
    System.out.println("[1] Admin Portal");
    System.out.println("[2] Doctor Portal");
    System.out.println("[3] Patient Portal");
    System.out.println("[4] Emergency Portal");
    System.out.println("[0] Exit");
    System.out.println();


    System.out.print("Enter your choice: ");
    String choice = myInput.nextLine();

    switch (choice) {
        case "1":
            hospital.adminManager.adminMenu();
            break;
        case "2":
            hospital.departmentManager.doctorLogin();
            break;
        case "3":
            hospital.patientManager.patientPortal();
        case "4":
            break;
        case "0":
            return;

        default:
            System.out.println("🚫Invalid credentials");
    }
}

    }

    public void mainChoiceMenu(){

    }

}