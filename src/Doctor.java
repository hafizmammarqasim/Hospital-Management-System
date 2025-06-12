public class Doctor extends Person{
    public String doctorId;
    public PatientQueue patientQueue = new PatientQueue();
    

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
