import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    private String recordId;
    private String initialDiagnosis;
    private String diagnosis;
    private String severity;
    private boolean admitStatus;
    private Doctor doctor;
    private String bedNumber;
    private List<String> medications;
    private DateTimeFormatter checkUpDate;

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public void setInitialDiagnosis(String initialDiagnosis) {
        this.initialDiagnosis = initialDiagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setAdmitStatus(boolean admitStatus) {
        this.admitStatus = admitStatus;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;

    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;

    }

    public void setCheckUpDate(DateTimeFormatter checkUpDate) {
        this.checkUpDate = checkUpDate;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getInitialDiagnosis() {
        return initialDiagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getSeverity() {
        return severity;
    }

    public boolean isAdmitStatus() {
        return admitStatus;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public List<String> getMedications() {
        return medications;
    }

    public DateTimeFormatter getCheckUpDate() {
        return checkUpDate;
    }

    public MedicalRecord() {
    }

    public MedicalRecord(String medicalDiagnosis){
        this.initialDiagnosis = medicalDiagnosis;
    }

    public void addMedicalRecord() {

    }


}

