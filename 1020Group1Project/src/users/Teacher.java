package users;
import java.util.ArrayList;
/**
 * Class Teacher is a subclass of User that implements the temporary data storage for the teacher users.
 * @author Stephen Hybeger
 */
public class Teacher extends User{
    private String maxStudents;
    private ArrayList<Student> arrayOfStudents = new ArrayList<>();
    /**
     * An empty constructor for Teacher that sets default values.
     */
    public Teacher() {
        maxStudents = "0";
    }
    /**
     * A constructor for Teacher that sets values based on parameters
     * @param userName The username for the teacher
     * @param lastName The last name of the teacher
     * @param firstName The first name of the teacher
     * @param eMail The email of the teacher
     * @param maxStudents The max number of students that the teacher will accept.
     */
    public Teacher(String userName, String lastName, String firstName, String eMail, String maxStudents) {
        super(userName, lastName, firstName, eMail);
        this.maxStudents = maxStudents;
    }
    /**
     * Sets the max number of students that the teacher will accept.
     * @param newNumberOfStudents The new number of students that the teacher will accept.
     */
    public void setNumberOfStudents(String newNumberOfStudents) {
        maxStudents = newNumberOfStudents;
    }
    /**
     * Returns the max number of students that the teacher will accept.
     * @return The max number of students that the teacher will accept.
     */
    public String getNumberOfStudents() {
        return maxStudents;
    }
    /**
     * Adds a student to the teacher's array of Students.
     * @param newStudent Student to be added to the array of Students.
     */
    public void addStudent(Student newStudent) {
        arrayOfStudents.add(newStudent);
    }
    /**
     * Returns a Student at a specified index in the array of Students.
     * @param index The index of the Student in the array of Students.
     * @return The Student at index.
     */
    public Student getStudent(int index) {
        return arrayOfStudents.get(index);
    }
    /**
     * Returns the array of Students itself.
     * @return The array of Students.
     */
    public ArrayList<Student> getArrayOfStudents() {
        return arrayOfStudents;
    }
}
