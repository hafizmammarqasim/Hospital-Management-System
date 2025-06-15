import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class DoctorManager {

   Doctor doctor;
   PatientQueue q;
    Map<LocalDate, HashMap<String,Doctor>> doctorsList;
   HashMap<String, Doctor> depDoctors;
    static String id;
    Scanner myInput = new Scanner(System.in);

    public DoctorManager (Department department){
        this.depDoctors = department.doctorList;
        this.doctorsList = new HashMap<>();
    }


    public void manageAppointment(LocalDate date){
        HashMap<String, Doctor> doctors = doctorsList.get(date);
        if( doctors == null){
            doctors = new HashMap<>(depDoctors);
            doctorsList.put(date,doctors);
        }

        Doctor appointmentDoctor = selectDoctor(doctors);

        if( appointmentDoctor != null)
            System.out.println("Your appointment has been scheduled for Dr. "+appointmentDoctor.name+ " at "+date.toString());

    }

    public Doctor selectDoctor(HashMap<String, Doctor> doctors){
            return doctors.get("Abc");
    }

//    public void checkPatient(){
//        Patient patient = q.dequeuePatient();
//
//       // patient.addMedicalRecord();
//    }

    


}
