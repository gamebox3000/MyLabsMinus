package users;

/**
 *
 * @author StephenAHyberger
 */
public class User {
    private String userName;
    private String lastName;
    private String firstName;
    private String eMail;
    public User() {
        userName = "";
        lastName = "";
        firstName = "";
        eMail = "";
    }
    public User(String userName, String lastName, String firstName, String eMail) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.eMail = eMail;
    }
    public void setUserName(String newUserName) {
        userName = newUserName;
    }
    public String getUserName() {
        return userName;
    }
    public void setLastName(String newLastName) {
        lastName = newLastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setEMail(String newEMail) {
        eMail = newEMail;
    }
    public String getEMail() {
        return eMail;
    }
}
