public class PatientQueue {
    Patient[] queue = new Patient[5];
    int front = -1;
    int rear = -1;
    int size = 0;

    public void enqueuePatient(Patient patient, Doctor doctor){
        if(rear == 4){
            System.out.println("No vacant spot for today");
            return;
        }

            queue[++rear] = patient;
            size++; //This size variable would be used to check how much patients are there in the queue,
                    //so we can check which doctor has less patients

        System.out.println("Your appointment is booked at Doctor :"+ patient.name);

    }

    public Patient dequeuePatient(){
        if (front == -1 && rear == -1 ){
            System.out.println("You do not have any patients waiting");
            return null;
        }

        return queue[++front];
    }

}
