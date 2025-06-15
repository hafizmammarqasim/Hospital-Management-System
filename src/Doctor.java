public class Doctor extends Person{
    public String doctorId;
    public PatientQueue patientQueue = new PatientQueue();
    Department dep;

    public Doctor(Department dep){
        this.dep = dep;
    }

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
