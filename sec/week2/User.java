package sec.week2;

public class User {
    private String firstNmae;
    private String lastName;
    private String email;
    private String password;
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstNmae() {
        return firstNmae;
    }
    public void setFirstNmae(String firstNmae) {
        this.firstNmae = firstNmae;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User [firstNmae=" + firstNmae + ", lastName=" + lastName + ", email=" + email + ", password=" + password
                + "]";
    }



}
