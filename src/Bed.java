public class Bed {
    private String bedId;
    private BedStatus status;
    private Patient patient;

    public Bed(int i){
        this.bedId = String.format("B%03d",i);
        status = BedStatus.AVAILABLE;
        patient = null;
    }

//    public void assignPatient(Patient patient) {
//        this.patient = patient;
//        System.out.println("Bed id is: " + bedId);
//        System.out.println("===Bed assigned to " + patient.name + "===");
//    }

        public boolean isAvailable() {
            return status == BedStatus.AVAILABLE;
        }

        public void assignPatient(Patient patient) {
            if (status == BedStatus.OCCUPIED) {
                System.out.println("⚠ Bed already occupied.");
                return;
            }
            this.patient = patient;
            this.status = BedStatus.OCCUPIED;
            System.out.println("✅ Bed ID: " + bedId + " assigned to " + patient.name);
        }

        public void releaseBed() {
            this.patient = null;
            this.status = BedStatus.AVAILABLE;
            System.out.println("🔄 Bed " + bedId + " is now available.");
        }

        public String getBedId() {
            return bedId;
        }

        public Patient getPatient() {
            return patient;
        }

        public BedStatus getStatus() {
            return status;
        }
    }


