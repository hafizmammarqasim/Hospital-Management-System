import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Department {
    protected String name;
    protected String depId;
    protected HashMap<String, Doctor> doctorList;
    DoctorManager doctorManager = new DoctorManager(this);
    ArrayList<Bed> emptyBeds = new ArrayList<>();
    ArrayList<Bed> occupiedBeds = new ArrayList<>();

    public Department(String name, String depId){
        this.name = name;
        this.depId = depId;
        this.doctorList = new HashMap<>();
        addBeds();
    }
    public void addBeds(){
        for (int i=1; i<=10; i++) {
            Bed tempBed = new Bed(i);
            emptyBeds.add(tempBed);
        }
    }

}
