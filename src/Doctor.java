import javax.print.Doc;
import java.util.Scanner;

public class Doctor extends Person{
    public String doctorId;
    public PatientQueue patientQueue = new PatientQueue();
    Department dep;
    public Doctor(String id, String name, String password){
        this.doctorId = id;
        this.name = name;
        this.password = password;
    }

    public Doctor(){

    }
    Scanner myInput = new Scanner(System.in);

    public void checkNextPatient(){

        //Get patient object from queue
        Patient patient = patientQueue.dequeuePatient();

        patient.addMedicalRecord(this);
    }

    public String getName(){
        return this.name;
    }

    public void viewTodayPatients(){

        patientQueue.viewPatients();
    }

    public void performFunctions(){
        System.out.println("========================================");
        System.out.println("       "+this.name+"'s Profile ");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Please select an option: ");
        System.out.println("[1] View Today's Patients");
        System.out.println("[2] Check Next Patient");
        System.out.println("[0] Back");
        String choice = myInput.nextLine();

        switch (choice){
            case "1":
                viewTodayPatients();
                break;
            case "2":
                checkNextPatient();
                break;
            case "0":
                return;
            default:
                System.out.println("🚫Invalid Input");
        }
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", cnicNum='" + cnicNum + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
