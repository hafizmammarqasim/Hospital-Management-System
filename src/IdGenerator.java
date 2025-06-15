public class IdGenerator {
    private static int doctorCounter = 1;
    private static int patientCounter =1;
    private static String doctorId;

    public static String generateDoctorId(){
        return String.format("%03d",doctorCounter++);
    }

    public static String generatePatientId(){
        return String.format("%03d",patientCounter++);
    }

}
