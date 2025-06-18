class Node{
Patient data;
Node next;
Node(Patient data){
    this.data = data;
    this.next = null;
}
}
public class TemporaryPatient {
    Node head;
    Node tail;

    public void addPatient(Patient patient) {
        Node newNode = new Node(patient);
        if (head == null) {
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}
