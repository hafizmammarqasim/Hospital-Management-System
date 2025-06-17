import java.time.LocalDate;
import java.util.*;

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
            HashMap<String, Doctor> copy = new HashMap<>();
            for (Map.Entry<String, Doctor> entry : depDoctors.entrySet()) {
                copy.put(entry.getKey(), new Doctor(entry.getValue())); // assuming copy constructor
            }
            doctorsList.put(date,copy);
            doctors = copy;
        }

        Doctor appointmentDoctor = selectDoctor(doctors, patient);

        if( appointmentDoctor != null)
            System.out.println("Your appointment has been scheduled for Dr. "+appointmentDoctor.name+ " at "+date.toString());

    }

    public Doctor selectDoctor(HashMap<String, Doctor> doctors, Patient patient){

        //Any random doctor would be saved, and we would use insertion Algorithm logic for comparison
        if (doctors.isEmpty()) throw new IllegalArgumentException("No doctors available");

        Doctor selectedDoctor = doctors.values()
                .stream()
                .min(Comparator.comparingInt(d -> d.getPatientQueue().size()))
                .orElse(getRandomDoctor(doctors)); // fallback

        selectedDoctor.getPatientQueue().enqueuePatient(patient,selectedDoctor);
        return selectedDoctor;
    }

    public static Doctor getRandomDoctor(HashMap<String, Doctor> doctors) {
        if (doctors == null || doctors.isEmpty()) {
            throw new IllegalArgumentException("Doctor map is empty or null.");
        }

        // Convert keys to a list so we can get random index
        List<String> keys = new ArrayList<>(doctors.keySet());
        String randomKey = keys.get(new Random().nextInt(keys.size()));

        return doctors.get(randomKey);
    }

//    public void checkPatient(){
//        Patient patient = q.dequeuePatient();
//
//       // patient.addMedicalRecord();
//    }

    


}
