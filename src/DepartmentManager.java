import java.util.HashMap;
import java.util.Map;
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

    public void addDoctor(String doctorId, String depName){
        Department department = departmentList.get(depName);

        Doctor tempDoctor = new Doctor();
        tempDoctor.doctorId = doctorId;

        System.out.println("Enter the doctor Name: ");
        tempDoctor.name = myInput.nextLine();

        System.out.println("Enter id Card Number: ");
        tempDoctor.cnicNum = myInput.nextLine();


        //we are keeping doctor id as key in doctor hashmap
        department.doctorList.put(doctorId,tempDoctor);

    }

    public void deleteDoctor(String depName){
        System.out.println("==== Delete Doctor ====");

        System.out.println("Enter the doctor Id");
        String id = myInput.nextLine();

        departmentList.get(depName).doctorList.remove(id);

    }

    public void viewDepartmentDoctors(String depName){

        for (Map.Entry<String, Doctor> doctor : departmentList.get(depName).doctorList.entrySet()){
            System.out.println(doctor.getValue());
        }
    }
}
