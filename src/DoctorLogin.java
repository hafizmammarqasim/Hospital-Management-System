public class DoctorLogin {
    private String doctorId;
    private String password;
    private String department;

    public DoctorLogin(String doctorId, String password, String department){
        this.doctorId = doctorId;
        this.password = password;
        this.department = department;
    }
    public String getDoctorId() {
        return doctorId;
    }

    public String getPassword() {
        return password;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String validateLogin(String id, String pass){
        System.out.println(doctorId+" "+" Pass: "+password+" "+" Department: "+department);
        if( this.doctorId.equals(id) && this.password.equals(pass))
            return department;
        else return null;
    }
}