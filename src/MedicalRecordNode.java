public class MedicalRecordNode {
    MedicalRecord data;
    MedicalRecordNode next;

    public MedicalRecordNode(MedicalRecord record){
        this.data = record;
        this.next = null;
    }
}
