import javax.print.Doc;
import java.time.LocalDate;
import java.util.*;

public class Department {
    protected String name;
    protected String depId;
    ArrayList<Bed> emptyBeds = new ArrayList<>();
    protected ArrayList<Bed> bedList = new ArrayList<>();
    protected HashMap<String, Doctor> doctorList;
    ArrayList<Bed> occupiedBeds = new ArrayList<>();
    DoctorManager doctorManager;

    public Department(String name, String depId){
        this.name = name;
        this.depId = depId;
        this.doctorList = new HashMap<>();
        //Pass list of doctors to add in the other list which is managed by date
        this.doctorManager = new DoctorManager(this.doctorList);
        addBeds();
    }

    public Department(){

    }
    public void addBeds(){
        for (int i=1; i<=10; i++) {
            Bed tempBed = new Bed(i);
            emptyBeds.add(tempBed);
        }
    }

    public Bed getAvailableBed() {
        for (Bed bed : bedList) {
            if (bed.isAvailable()) {
                return bed;
            }
        }
        return null;
    }

    public void showAllBeds() {
        for (Bed bed : bedList) {
            System.out.println(bed.getBedId() + " - " + bed.getStatus());
        }
    }

    public HashMap<String, Doctor> getDoctorList() {
        return doctorList;
    }

    public void assignBed(){
        this.occupiedBeds.add(emptyBeds.getFirst());
    }

//    public HashMap<String, DoctorLogin> getDoctorLoginList() {
//        return doctorLoginList;
//    }
//
//    public void setDoctorLoginList(HashMap<String, DoctorLogin> doctorLoginList) {
//        this.doctorLoginList = doctorLoginList;
//    }
}
