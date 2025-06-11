import java.util.HashMap;
import java.util.Scanner;
public class DepartmentManager {
    // dkh lou department kay functions kam hain, ham is class k baghair
    //bhi department k functions use kr skty hain, laikin agar manage krna ha tou phir ye use kr lou
    Scanner myInput = new Scanner(System.in);
    HashMap<String, Department> departmentList;
    public DepartmentManager(Hospital hospital){
        this.departmentList = hospital.departmentList;
        addDepartments();
    }

    public void addDepartments(){
        departmentList.put("Cardiology", new Department("Cardiology","001"));
        departmentList.put("Neurology",new Department("Neurology","002"));
        departmentList.put("Orthopedic",new Department("Orthopedic","003"));
        departmentList.put("Dermatology",new Department("Dermatology","004"));
        departmentList.put("Urology",new Department("Urology","005"));
    }

    public void addDoctor(String doctorId){
        Doctor tempDoctor = new Doctor();
        tempDoctor.doctorId = doctorId;

        System.out.println("Enter the doctor Name: ");
        tempDoctor.name = myInput.nextLine();

        System.out.println("Enter id Card Number: ");
        tempDoctor.cnicNum = myInput.nextLine();

        System.out.println("Enter department: ");
        String department = myInput.nextLine();


        //we are keeping doctor id as key in doctor hashmap
        departmentList.get(department).doctorList.put(doctorId,tempDoctor);

    }

    public void deleteDoctor(){
        
    }
}
