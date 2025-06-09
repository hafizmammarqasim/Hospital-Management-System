import java.util.HashMap;
import java.util.Scanner;
public class DoctorManager {

    Hospital hospital;
    Scanner myInput = new Scanner(System.in);
    public DoctorManager (Hospital hospital){
        this.hospital = hospital;
    }

    public void addDoctor(){
        System.out.println("Enter the doctor Name: ");
        String name = myInput.nextLine();

        System.out.println("Enter id Card Number: ");
        String cnicNum = myInput.nextLine();

        System.out.println("Enter department: ");
        String department = myInput.nextLine();
    }

}
