import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class DepartmentManager {
    HashMap<String, Department> departmentList;
    HashMap<String, DoctorLogin> doctorLogin;


    Scanner myInput = new Scanner(System.in);
    //Constructor
    public DepartmentManager(Hospital hospital){
        this.departmentList = hospital.departmentList;
        this.doctorLogin = new HashMap<>();
        addDepartments();
        addDoc("Zadif", "pass1");
        addDoc("Ammar","pass2");
        addDoc("Fareed","pass3");
    }

    //Ask for date and get doctor from the list of desired date
    public void selectDoctor(Department department, String docId){
        System.out.println("Enter today's date: ");
        String dateString = myInput.nextLine();

        //Object required to format date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        //Input 1 = Date in our format  Input2 = we are telling in which format date is being added
        LocalDate date = LocalDate.parse(dateString,formatter);

        //Now access the doctor object
        HashMap<String, Doctor> tempDocList = department.doctorManager.doctorsList.get(date);
        //Call doctor's functions which will be shown on login
        if(tempDocList!=null) {
            Doctor doctor = tempDocList.get(docId);
            doctor.performFunctions();
        } else{
            System.out.println("❌ No Appointments as of now");
            System.out.print("\033[H\033[2J");
        }
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

        System.out.println("Enter password: ");
        tempDoctor.password = myInput.nextLine();

        // keeping doctor id as key in doctor hashmap
        department.doctorList.put(doctorId,tempDoctor);
        DoctorLogin docLogin = new DoctorLogin(doctorId, tempDoctor.password, depName);
        doctorLogin.put(doctorId, docLogin);
    }

    public void deleteDoctor(String depName){
        System.out.println("====== ❗ Delete Doctor ======");

        System.out.println("Enter the doctor Id");
        String id = myInput.nextLine();

        departmentList.get(depName).doctorList.remove(id);

    }

    public void viewDepartmentDoctors(String depName){

        for (Map.Entry<String, Doctor> doctor : departmentList.get(depName).doctorList.entrySet()){
            System.out.println(doctor.getValue());
        }
    }

    public void doctorLogin(){
        System.out.println("==================================");
        System.out.println("            Doctor Login          ");
        System.out.println("==================================");
        System.out.println();
        System.out.print("Enter Doctor Id: ");
        String docId = myInput.nextLine();
        System.out.print("Enter password: ");
        String password = myInput.nextLine();

        DoctorLogin doctorLoginVariable = doctorLogin.get(docId);
        if(doctorLoginVariable!=null) {
            String depName = doctorLoginVariable.validateLogin(docId, password);

            if (depName != null) {
                System.out.println("✔ Logged in Successfully");
                Department department = departmentList.get(depName);
                selectDoctor(department, docId);
            } else {
                System.out.println("🚫Invalid credentials");
            }
        }else {
            System.out.println("❌Invalid Username");
        }

    }



    public void addDoc(String name, String pass){
        String id1 = IdGenerator.generateDoctorId();
        System.out.println(id1);
        Doctor doc1 = new Doctor(id1,name,pass);
        departmentList.get("Cardiology").doctorList.put(id1,doc1);
        DoctorLogin docLogin = new DoctorLogin(id1,pass,"Cardiology");
        doctorLogin.put(id1,docLogin);
    }
}
