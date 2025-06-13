import java.util.HashMap;
import java.util.Scanner;
public class DoctorManager {

   Doctor doctor;
   PatientQueue q;
    static String id;
    Scanner myInput = new Scanner(System.in);

    public DoctorManager (Doctor doctor){
        this.doctor = doctor;
        this.q = doctor.patientQueue;
    }

//    public void checkPatient(){
//        Patient patient = q.dequeuePatient();
//
//       // patient.addMedicalRecord();
//    }

    


}
