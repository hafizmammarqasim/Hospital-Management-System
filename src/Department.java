import java.util.ArrayList;
import java.util.LinkedList;

public class Department {
    private String name;
    private String depId;

//    LinkedList<Bed> emptyBeds = new LinkedList<>();
    ArrayList<Bed> emptyBeds = new ArrayList<>();
    ArrayList<Bed> occupiedBeds = new ArrayList<>();

    public Department(){
        addBeds();
    }
    public void addBeds(){
        for (int i=1; i<=10; i++) {
            Bed tempBed = new Bed(i);
            emptyBeds.add(tempBed);
        }
    }

}
