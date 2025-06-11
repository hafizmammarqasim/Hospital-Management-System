import java.util.Scanner;
public class DepartmentManager {
    // dkh lou department kay functions kam hain, ham is class k baghair
    //bhi department k functions use kr skty hain, laikin agar manage krna ha tou phir ye use kr lou
    Scanner myInput = new Scanner(System.in);

    public void addDoctor(){
        System.out.println("Enter the doctor Name: ");
        String name = myInput.nextLine();

        System.out.println("Enter id Card Number: ");
        String cnicNum = myInput.nextLine();

        System.out.println("Enter department: ");
        String department = myInput.nextLine();



    }
}
