public class Doctor extends Person{
    public String doctorId;
    public PatientQueue patientQueue = new PatientQueue();
    DoctorManager doctorManager = new DoctorManager(this);
    Department dep;

    public Doctor(Department dep){
        this.dep = dep;
    }

    public void checkNextPatient(){
        Patient patient = patientQueue.dequeuePatient();

    }

    public void viewTodayPatient(){
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
