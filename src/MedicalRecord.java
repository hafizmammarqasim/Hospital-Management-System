import java.time.format.DateTimeFormatter;
import java.util.List;

public class MedicalRecord {
    public String recordId;
    private String initialDiagnosis;
    private String diagnosis;
    private String severity;
    private boolean admitStatus;
    private Doctor doctor;
    private String bedNumber;
    private List<String> medications;
    private DateTimeFormatter checkUpDate;

    public MedicalRecord(String recordId, String diagnosis, String severity, boolean admitStatus, Doctor doctor, String bedNumber, List<String> medications, DateTimeFormatter checkUpDate) {
        this.recordId = recordId;
        this.diagnosis = diagnosis;
        this.severity = severity;
        this.admitStatus = admitStatus;
        this.doctor = doctor;
        this.bedNumber = bedNumber;
        this.medications = medications;
        this.checkUpDate = checkUpDate;
    }

    public MedicalRecord(String medicalDiagnosis){
        this.initialDiagnosis = medicalDiagnosis;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "recordId='" + recordId + '\'' +
                ", initialDiagnosis='" + initialDiagnosis + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", severity='" + severity + '\'' +
                ", doctor=" + doctor.name +
                ", medications=" + medications +
                ", checkUpDate=" + checkUpDate +
                '}';
    }
}
