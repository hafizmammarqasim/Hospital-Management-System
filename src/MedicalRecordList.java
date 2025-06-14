public class MedicalRecordList {
    private MedicalRecordNode head;
    private MedicalRecordNode tail;

    //    public void addMedicalRecord(){
//        System.out.println("Enter diagnosis: ");
//        System.out.println("severity: ");
//
//    }

    public void addRecord(MedicalRecord medicalRecord){
        if(head == null && tail == null){
            head = new MedicalRecordNode(medicalRecord);
            tail = head;
            return;
        }

        tail.next = new MedicalRecordNode(medicalRecord);
        tail = tail.next;
    }

    public void viewLastRecord(){
        if(tail == null){
            System.out.println("No record available");
            return;
        }
        System.out.println(tail.data.toString());
    }

    public MedicalRecord searchMedicalRecord(String recId){
        if(head == null && tail == null){
            System.out.println("No medical record");
            return null;
        }

        MedicalRecordNode temp = head;

        while (temp!=null){
            if(temp.data.recordId.equals(recId))
                return temp.data;

            temp = temp.next;
        }
        System.out.println("No record found against Id: "+recId);
        return null;
    }

}
