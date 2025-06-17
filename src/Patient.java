public class Patient {
    public String name;
    public String age;
    public String cnicNum;
    public String contactNum;
    public String userName;
    public String password;
    public String patientId;
    String bloodType;
    private MedicalRecordList medicalRecord;

    public void addMedicalRecord(Doctor doctor){
        medicalRecord.addMedicalRecord(doctor);
    }

//    public int compareTo(Patient p){
//        return Integer.compare(this.cnicNum, p.cnicNum);
//    }


    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", cnicNum='" + cnicNum + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }

}
