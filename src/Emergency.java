import java.util.Scanner;
public class Emergency {
    Scanner sc = new Scanner(System.in);
    TemporaryPatient tempPatient = new TemporaryPatient();
    DijkstraSimple pathFinder = new DijkstraSimple();
    AdminManager adminManager;
    Hospital hospital;

    Scanner myInput = new Scanner(System.in);
    public Emergency(Hospital hospital) {
        this.hospital = hospital;
        this.adminManager = hospital.adminManager;
    }

    public void enterDetails() {
        String choice;
        do {
            Patient p = new Patient(hospital.departmentManager);
            System.out.println("\t==============================");
            System.out.println("\t     * Emergency *  ");
            System.out.print("\t==============================");
            System.out.println("\nEnter Emergency Patient Details:");
            System.out.print("Name: ");
            p.name = sc.nextLine();

            System.out.print("CNIC: ");
            p.cnicNum = sc.nextLine();

            System.out.print("Reason: ");
            String reason = sc.nextLine();

            System.out.println("\nChoose your current location:");
            pathFinder.displayLocationMenu();

            int locationIndex;
            while (true) {
                System.out.print("Enter location number: ");
                locationIndex = sc.nextInt();
                sc.nextLine();
                if (locationIndex >= 1 && locationIndex < pathFinder.getNumNodes()) break;
                System.out.println("Invalid choice. Try again.");
            }

            String patientLocation = pathFinder.getLocationName(locationIndex);

            p.setLocation(locationIndex);
            p.addEmergencyMedicalRecord(reason);
            tempPatient.addPatient(p);
            Ambulance amb = hospital.availableAmbulances.dispatchAmbulance();
            if (amb != null) {
                System.out.println("🚑 Ambulance dispatched: " + amb.shortInfo());
                hospital.unavailableAmbulances.addAmbulance(amb); // Move to unavailable
            } else {
                System.out.println("❌ No ambulance available.");
            }


            pathFinder.dijkstra("Hospital", patientLocation);
            pathFinder.dijkstra(patientLocation, "Hospital");

            System.out.println("\n Patient " + p.name + " successfully registered.");


            Bed availableBed = getAvailableBedFromHospital();
            if (availableBed != null) {
                availableBed.assignPatient(p); // marks bed OCCUPIED
            } else {
                System.out.println("❌ No available beds!");
            }

            System.out.println("Do you want to continue:(yes/no) ");
            choice = myInput.nextLine();
        }while (choice.equals("yes"));
        adminManager.moveUnavailableAmbulances();
    }

    private Bed getAvailableBedFromHospital() {
        for (Bed bed : hospital.bedList) {
            if (bed.isAvailable()) {
                return bed;
            }
        }
        return null;
    }


}
