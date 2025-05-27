public class AdminLogin {
    public String username;
    public String password;

    public AdminLogin(String username, String password){
        this.username = username;
        this.password = password;
    }

    public boolean validateAdmin(String username, String password){
            return this.username.equals(username) && this.password.equals(password);
    }
}
