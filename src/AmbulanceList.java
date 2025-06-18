public class AmbulanceList {
//
//    private static class Node {
//        Ambulance data;
//        Node next;
//
//        public Node(Ambulance data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    private Node head;
//    private Node tail;
//
//    public AmbulanceList() {
//        head = tail = null;
//    }
//
//
//    public void addAmbulance(Ambulance ambulance) {
//        Node newNode = new Node(ambulance);
//
//        if (head == null) {
//            head = tail = newNode;
//        } else {
//            tail.next = newNode;
//            tail = newNode;
//        }
//    }
//
//    public Ambulance dispatchAmbulance() {
//        if (head == null) {
//            System.out.println("No ambulances in the queue.");
//            return null;
//        }
//
//        Ambulance dispatched = head.data;
//        head = head.next;
//
//        if (head == null) {
//            tail = null;
//        }
//
//        return dispatched;
//    }
//
//    public boolean isEmpty() {
//        return head == null;
//    }
//
//    public void viewAmbulances() {
//        Node current = head;
//
//        if (current == null) {
//            System.out.println("Ambulance queue is empty.");
//            return;
//        }
//
//        while (current != null) {
//            System.out.println(current.data);
//            current = current.next;
//        }
//    }
//}
//

        private static class Node {
            Ambulance data;
            Node next;

            public Node(Ambulance data) {
                this.data = data;
            }
        }

        private Node head, tail;

        public void addAmbulance(Ambulance amb) {
            Node newNode = new Node(amb);
            if (head == null) head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public Ambulance dispatchAmbulance() {
            if (head == null) return null;
            Ambulance amb = head.data;
            head = head.next;
            if (head == null) tail = null;
            return amb;
        }

        public void viewAmbulances() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            Node current = head;
            int i = 1;
            while (current != null) {
                System.out.println(i + ". " + current.data);
                current = current.next;
                i++;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public Ambulance getAmbulanceAt(int index) {
            Node current = head;
            int count = 1;
            while (current != null) {
                if (count == index) return current.data;
                current = current.next;
                count++;
            }
            return null;
        }

        public void removeAmbulanceAt(int index) {
            if (head == null || index <= 0) return;

            if (index == 1) {
                head = head.next;
                if (head == null) tail = null;
                return;
            }

            Node current = head;
            int count = 1;
            while (current != null && current.next != null) {
                if (count == index - 1) {
                    current.next = current.next.next;
                    if (current.next == null) tail = current;
                    return;
                }
                current = current.next;
                count++;
            }
        }

        public int size() {
            Node current = head;
            int count = 0;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

}
