import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class DoctorManager {
    Map<LocalDate, HashMap<String,Doctor>> doctorsList;  //Contains Doctors List Based on Dates
    HashMap<String, Doctor> depDoctors;
    Scanner myInput = new Scanner(System.in);

    public DoctorManager (HashMap<String, Doctor> depDoctors){
        this.depDoctors = depDoctors;
        this.doctorsList = new HashMap<>();
    }

    public void manageAppointment(LocalDate date, Patient patient){
        HashMap<String, Doctor> doctors = doctorsList.get(date);
        if( doctors == null){
            doctors = new HashMap<>(depDoctors);
            doctorsList.put(date,doctors);
        }

        Doctor appointmentDoctor = selectDoctor(doctors, patient);

        if( appointmentDoctor != null)
            System.out.println("Your appointment has been scheduled for Dr. "+appointmentDoctor.name+ " at "+date.toString());

    }

    public Doctor selectDoctor(HashMap<String, Doctor> doctors, Patient patient){

        //Any random doctor would be saved, and we would use insertion Algorithm logic for comparison
        Doctor minPatientDoc = (Doctor) doctors.entrySet().iterator().next();
        Doctor tempDoc = null; //

        for(String docName: doctors.keySet()) {
            tempDoc = doctors.get(docName);
            if (tempDoc != null && tempDoc.patientQueue.size < minPatientDoc.patientQueue.size)
                minPatientDoc = tempDoc;
        }

        minPatientDoc.patientQueue.enqueuePatient(patient,minPatientDoc);
            return minPatientDoc;
    }

//    public void checkPatient(){
//        Patient patient = q.dequeuePatient();
//
//       // patient.addMedicalRecord();
//    }

    


}
