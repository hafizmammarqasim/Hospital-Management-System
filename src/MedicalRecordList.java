import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordList {
    private MedicalRecordNode head;
    private MedicalRecordNode tail;
    private int size;

    public MedicalRecordList() {
        head = null;
        tail = null;
        size = 0;
    }

    public MedicalRecordNode getTail() {
        return tail;
    }

    // Add a medical record with MedicalRecord object
    public void addMedicalRecord(MedicalRecord record) {
        MedicalRecordNode newNode = new MedicalRecordNode(record);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addMedicalRecord(Doctor doctor) {
        Scanner scanner = new Scanner(System.in);
        MedicalRecord newRecord = new MedicalRecord();

        System.out.println("\n=== Add New Medical Record ===");

        System.out.print("Enter record ID: ");
        newRecord.setRecordId(scanner.nextLine());

        System.out.print("Enter initial diagnosis: ");
        newRecord.setInitialDiagnosis(scanner.nextLine());

        System.out.print("Enter current diagnosis: ");
        newRecord.setDiagnosis(scanner.nextLine());

        System.out.print("Enter severity: ");
        newRecord.setSeverity(scanner.nextLine());

        System.out.print("Admit status (true/false): ");
        newRecord.setAdmitStatus(scanner.nextBoolean());
        scanner.nextLine();

        newRecord.setDoctor(doctor);

        System.out.print("Enter bed number (if admitted): ");
        newRecord.setBedNumber(scanner.nextLine());


        System.out.println("Enter medications [onlk-one per line, blank line to finish:");
        List<String> medications = new ArrayList<>();
        while (true) {
            String med = scanner.nextLine();
            if (med.isEmpty()) {
                break;
            }
            medications.add(med);
        }
        newRecord.setMedications(medications);

        newRecord.setCheckUpDate(DateTimeFormatter.ISO_LOCAL_DATE);

        this.addMedicalRecord(newRecord);
        System.out.println("Medical record added successfully!");
    }

    public MedicalRecord searchMedicalRecord(String recordId) {
        MedicalRecordNode current = head;
        while (current != null) {
            if (current.data.getRecordId().equals(recordId)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void searchAndDisplayRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Record ID to search: ");
        String recordId = scanner.nextLine();

        MedicalRecord record = searchMedicalRecord(recordId);
        if (record != null) {
            System.out.println("\n=== Found Medical Record ===");
            System.out.println("Record ID: " + record.getRecordId());
            System.out.println("Diagnosis: " + record.getDiagnosis());
            System.out.println("Severity: " + record.getSeverity());
            System.out.println("Admit Status: " + record.isAdmitStatus());
            System.out.print("Attending Doctor: ");
            if (record.getDoctor() != null) {
                System.out.println(record.getDoctor().getName());
            } else {
                System.out.println("N/A");
            }
            System.out.println("Medications: " + record.getMedications());
        } else {
            System.out.println("No record found with ID: " + recordId);
        }
    }

    public boolean removeMedicalRecordByRecordId(String recordId) {
        if (head == null) return false;

        // Case 1: Remove head node
        if (head.data.getRecordId().equals(recordId)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }


        // Case 2: Find and remove non-head node
        MedicalRecordNode current = head;
        while (current.next != null) {
            if (current.next.data.getRecordId().equals(recordId)) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void removeRecordInteractive() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Record ID to remove: ");
        String recordId = scanner.nextLine();

        if (removeMedicalRecordByRecordId(recordId)) {
            System.out.println("Record " + recordId + " removed successfully");
        } else {
            System.out.println("Failed to remove record. ID not found: " + recordId);
        }
    }
    // Get the size of the list
    public int size() {
        return size;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Display all medical records
    public void displayAllRecords() {
        if (isEmpty()) {
            System.out.println("No medical records available.");
            return;
        }

        System.out.println("\n=== Medical Records ===");
        MedicalRecordNode current = head;
        int counter = 1;

        while (current != null) {
            MedicalRecord record = current.data;
            System.out.println("Record #" + counter);
            System.out.println("  Diagnosis: " + record.getDiagnosis());
            System.out.println("  Severity: " + record.getSeverity());
            System.out.println("  Admit Status: " + record.isAdmitStatus());
            System.out.println("  Medications: " + record.getMedications());
            System.out.println("----------------------------------");

            current = current.next;
            counter++;
        }
    }
}