import javax.print.Doc;
import java.time.LocalDate;
import java.util.*;

public class Department {
    protected String name;
    protected String depId;
    protected HashMap<String, Doctor> doctorList;
    ArrayList<Bed> emptyBeds = new ArrayList<>();
    DoctorManager doctorManager = new DoctorManager(this);
    ArrayList<Bed> occupiedBeds = new ArrayList<>();

    public Department(String name, String depId){
        this.name = name;
        this.depId = depId;
        this.doctorList = new HashMap<>();
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

    public HashMap<String, Doctor> getDoctorList() {
        return doctorList;
    }

//    public HashMap<String, DoctorLogin> getDoctorLoginList() {
//        return doctorLoginList;
//    }
//
//    public void setDoctorLoginList(HashMap<String, DoctorLogin> doctorLoginList) {
//        this.doctorLoginList = doctorLoginList;
//    }
}
