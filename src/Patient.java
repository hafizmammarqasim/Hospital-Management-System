public class Patient extends Person {
    public String patientId;
    String bloodType;
    private MedicalRecordList medicalRecord;

    public void addMedicalRecord(String reason){
        medicalRecord.addMedicalRecord();
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
