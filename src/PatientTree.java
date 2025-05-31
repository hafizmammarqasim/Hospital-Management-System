public class PatientTree {
    PatientTreeNode root;


    public void addPatient(Patient patient){
       root = addPatient(root, patient);
    }
    //Patient would be inserted in the tree
    public PatientTreeNode addPatient(PatientTreeNode patientNode,Patient patient ){
        if(patientNode == null){
            return new PatientTreeNode(patient);
        }
        else{
            //String class has its own built-in compareTo function
            //so it compares the string character by character based on UNI code
            //And we do not need comparable
            int result = patientNode.pData.cnicNum.compareTo(patient.cnicNum);
            if(result < 0){
                patientNode.left = addPatient(patientNode.left, patient);
            } else if(result > 0){
                patientNode.right = addPatient(patientNode.right, patient);
            }
        }
        if(patientNode.left != null && patientNode.right != null)
            patientNode.height = Math.max(patientNode.left.height, patientNode.right.height)+1;

        return patientNode;
    }

    public void viewPatients(){
        viewPatients(root);
    }

    public void viewPatients(PatientTreeNode patient){
        if(patient == null)
            return;

        viewPatients(patient.left);
        System.out.println(patient.pData.toString());
        viewPatients(patient.right);
    }

    public void deletePatients(){

    }

}
