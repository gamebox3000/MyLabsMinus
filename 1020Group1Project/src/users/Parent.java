package users;
import java.util.ArrayList;
/**
 * Class Parent is a subclass of User that implements the temporary data storage for the parent users.
 * @author Stephen Hybeger
 */
public class Parent extends User{
    private String numberOfChildren;
    private ArrayList<Student> arrayOfChildren = new ArrayList<Student>();
    /**
     * An empty constructor for Parent that sets default values.
     */
    public Parent() {
        numberOfChildren = "0";
    }
    /**
     * A constructor for Parent that sets values based on parameters
     * @param userName The username for the parent
     * @param lastName The last name of the parent
     * @param firstName The first name of the parent
     * @param eMail The email of the parent
     * @param numberOfChildren The number of children the parent has registered in the program
     */
    public Parent(String userName, String lastName, String firstName, String eMail, String numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }
    /**
     * adds the username specified to the Array.
     * @param newChildUserName the String username of the child specified
     */
    public void addChild(Student newChildUserName) {
        arrayOfChildren.add(newChildUserName);
    }
    /**
     * Returns the child at the specified index from the childArray.
     * @param index the index of the Student to be returned from the array.
     * @return Child at index.
     */
    public Student getChild(int index) {
        return arrayOfChildren.get(index);
    }
    /**
     * Returns childArray itself.
     * @return The childArray.
     */
    public ArrayList<Student> getArrayOfChildren() {
        return arrayOfChildren;
    }
    /**
     * Returns the number of children of the parent that are enrolled.
     * @return Number of enrolled students of the parent.
     */
    public String getNumberOfChildren() {
        return numberOfChildren;
    }
    /**
     * sets the number of children of the parent that are enrolled.
     * @param newNumberOfChildren The number to which the number of children that are enrolled is set.
     */
    public void setNumberOfChildren(String newNumberOfChildren) {
        numberOfChildren = newNumberOfChildren;
    }
}
