public class IdGenerator {
    private static int counter = 1;
    private static String doctorId;

    public static String generateDoctorId(){
        doctorId = String.format("%3d",counter++);
        return doctorId;
    }
}
