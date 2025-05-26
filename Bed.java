public class Bed {
    private String bedId;
    private BedStatus status;
    private Patient patient;

    public Bed(int i){
        this.bedId = String.valueOf("%3d"+i);
        status = BedStatus.AVAILABLE;
        patient = null;
    }

    public void assignPatient(Patient patient){
        this.patient = patient;
        System.out.println("Bed id is: "+bedId);
        System.out.println("===Bed assigned to "+patient.name+"===");
    }
}
