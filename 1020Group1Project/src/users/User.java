package users;
/**
 * Class User implements the temporary data storage for users in general (for the fields the subclasses of User share).
 * @author Stephen Hybeger
 */
public class User {
    private String userName;
    private String lastName;
    private String firstName;
    private String eMail;
    /**
     * An empty constructor for User that sets default values.
     */
    public User() {
        userName = "";
        lastName = "";
        firstName = "";
        eMail = "";
    }
    /**
     * A constructor for User that sets values based on parameters
     * @param userName The username for the user
     * @param lastName The last name of the user
     * @param firstName The first name of the user
     * @param eMail The email of the user
     */
    public User(String userName, String lastName, String firstName, String eMail) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.eMail = eMail;
    }
    /**
     * Sets the userName field of the User.
     * @param newUserName The String to which to set userName.
     */
    public void setUserName(String newUserName) {
        userName = newUserName;
    }
    /**
     * Returns the userName field.
     * @return userName field.
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Sets the lastName field of the User.
     * @param newLastName The String to which to set lastName.
     */
    public void setLastName(String newLastName) {
        lastName = newLastName;
    }
    /**
     * Returns the lastName field.
     * @return lastName field.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the firstName field of the User.
     * @param newFirstName The String to which to set firstName.
     */
    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }
    /**
     * Returns the firstName field.
     * @return firstName field.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the eMail field of the User.
     * @param newEMail The String to which to set eMail.
     */
    public void setEMail(String newEMail) {
        eMail = newEMail;
    }
    /**
     * Returns the eMail field.
     * @return eMail field.
     */
    public String getEMail() {
        return eMail;
    }
}
