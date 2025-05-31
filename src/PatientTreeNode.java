public class PatientTreeNode {
    Patient pData;
    PatientTreeNode left;
    PatientTreeNode right;
    int height;

    public PatientTreeNode(Patient data){
        this.pData = data;
        left = null;
        right = null;
        this.height = -1;
    }
}
