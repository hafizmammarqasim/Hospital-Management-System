import java.math.BigInteger;

public class PatientTree {
    PatientTreeNode root;


    //===================================================
    //               Add Patient Functions
    public void addPatient(Patient patient){
       root = addPatient(root, patient);
    }


    //Patient would be inserted in the tree
    private PatientTreeNode addPatient(PatientTreeNode patientNode,Patient patient ){
        if(patientNode == null){
            //----Mistake:  returned new PatientTreeNode(patient) Node directly rather than saving it to patientNode
            patientNode = new PatientTreeNode(patient);
        }
        else {
            //String class has its own built-in compareTo function
            //so it compares the string character by character based on UNI code
            //And we do not need comparable

            //length of CNIC Numbers must be same, otherwise tree would be compromised
            int result = patient.cnicNum.compareTo(patientNode.pData.cnicNum);
//
//            BigInteger num1 = new BigInteger(patient.cnicNum);
//            BigInteger num2 = new BigInteger(patientNode.pData.cnicNum);
//            int result = num1.compareTo(num2);
            System.out.println("Patient comparison with previous node: "+result);
            if (result < 0) {
                patientNode.left = addPatient(patientNode.left, patient);
            } else if (result > 0) {
                patientNode.right = addPatient(patientNode.right, patient);
            }

        }
        //calculating or updating height at every node
        patientNode.height = Math.max(height(patientNode.left), height(patientNode.right)) + 1;
        return rotate(patientNode);
    }

    //===============================================================

    public void viewPatients(){
        viewPatients(root);
    }

    private void viewInfix(PatientTreeNode patient){
        if (patient == null)
            return;

        System.out.println(patient.pData.toString());
        viewInfix(patient.left);
        viewInfix(patient.right);
    }

    public void viewPatients(PatientTreeNode patient){
        if(patient == null)
            return;

        viewPatients(patient.left);
        System.out.println(patient.pData.toString());
        viewPatients(patient.right);
    }

    public int height(PatientTreeNode node){
        if (node == null)
            return -1;

        return node.height;

    }

    //=============================================
    //         Delete Patients functions
    public void deletePatients(String nicNum){
        System.out.println("Root Patient called in delete Patient:  ");
        System.out.println(root.pData.toString());
        root = deletePatient(root, nicNum);
    }

    //search node to be deleted
    private PatientTreeNode deletePatient(PatientTreeNode node, String idNumber){
        if(node == null){
            return null;
        }
        String tempId = node.pData.cnicNum;
        if(idNumber.compareTo(tempId) < 0){
            node.left = deletePatient(node.left,idNumber);
        } else if(idNumber.compareTo(tempId) > 0){
            node.right = deletePatient(node.right,idNumber);
        } else {
            node = delete(node);
        }

        return node;
    }

    //deletePatientLogic
    private PatientTreeNode delete(PatientTreeNode node){
        //if patient Node has no child node
        if(height(node.left) == -1 && height(node.right) == -1)
            return null;
        //if patient node has just left child
        else if(height(node.right) == -1)
            return node.left;
        //if patient node has just right child
        else{

            //----Mistake: passed node instead of node.right
            PatientTreeNode tempNode = findMin(node.right);
            node.pData = tempNode.pData;
            node.right = deletePatient(node.right, node.pData.cnicNum);
            System.out.println(node.pData.toString());
            return node;
        }
    }

    public PatientTreeNode findMin(PatientTreeNode root){
        if(root == null){
            return null;
        }
        root.left = findMin(root.left);
        if(root.left!= null){
            return root.left;
        } else{
            return root;
        }
    }

    //=================================================

    //=================================================
    //         Rotation function to make tree AVL
    private PatientTreeNode rotate(PatientTreeNode node){

        if(height(node.left)-height(node.right)>1){
            //left-left case
            //-----Mistake: let difference of children > 1 / -1 instead of > or < 0
            if(height(node.left.left)-height(node.left.right)>0){
                node = rightRotate(node);
            }
            //left-right case
            else if(height(node.left.left)-height(node.left.right)<0){
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        }
        else if(height(node.left) - height(node.right)<-1){
            //right-right case
            if(height(node.right.left)-height(node.right.right)<0){
                node = leftRotate(node);
            }
            //right-left case
            else if(height(node.right.left)-height(node.right.right)>0){
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
        return node;
    }

    private PatientTreeNode rightRotate(PatientTreeNode node){
        PatientTreeNode tempNode = node;
        node = node.left;

        tempNode.left = node.right;
        node.right = tempNode;

        tempNode.height = Math.max(height(tempNode.left),height(tempNode.right))+1;
        node.height = Math.max(height(node.left), height(node.right))+1;

        return node;
    }

    private PatientTreeNode leftRotate(PatientTreeNode node){
        PatientTreeNode tempNode = node;
        node = node.right;
        tempNode.right = node.left;
        node.left = tempNode;

        tempNode.height = Math.max(height(tempNode.left),height(tempNode.right))+1;
        node.height = Math.max(height(node.left), height(node.right))+1;

        return node;
    }

    //===========================================

    public void searchPatient(String idCardNum){
        PatientTreeNode patient;
        patient = searchPatient(root, idCardNum);

        if (patient!= null){
            System.out.println(patient.pData.toString());
        }else {
            System.out.println("No such patient exist");
        }
    }

    private PatientTreeNode searchPatient(PatientTreeNode patient, String idCardNum){
        if(patient == null){
            System.out.println("No Patient in the data base");
            return null;
        }

        int result = idCardNum.compareTo(patient.pData.cnicNum);

        if(result<0){
            return searchPatient(patient.left,idCardNum);
        } else if(result>0){
            return searchPatient(patient.right, idCardNum);
        }else{
            return patient;
        }
    }

}
