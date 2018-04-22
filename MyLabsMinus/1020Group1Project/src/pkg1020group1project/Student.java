package pkg1020group1project;

import java.util.ArrayList;

/**
 * Class Student is a subclass of User that implements the temporary data storage for the student users.
 * @author Stephen Hybeger
 */
public class Student extends User {
    private Teacher teacher;
    private ArrayList<Parent> parents = new ArrayList<>();
    /**
     * An empty constructor for Student that sets default values.
     */
    public Student() {
        teacher = null;
    }
    /**
     * A constructor for Student that sets values based on parameters
     * @param userName The username for the student
     * @param lastName The last name of the student
     * @param firstName The first name of the student
     * @param eMail The email of the student
     * @param teacher The teacher of the student
     */
    public Student(String userName, String lastName, String firstName, String eMail, Teacher teacher) {
        super (userName, lastName, firstName, eMail);
        this.teacher = teacher;
    }
    /**
     * Sets the username of the teacher of the student.
     * @param newTeacher The Teacher to which the teacher field is to be set
     */
    public void setTeacherUserName(Teacher newTeacher) {
        teacher = newTeacher;
    }
    /**
     * Returns the username of the teacher of the student.
     * @return The username of the teacher of the student.
     */
    public Teacher getTeacherUserName() {
        return teacher;
    }
    /**
     * Returns a String representation of the Object.
     * @return A String representation of the Object.
     */
    @Override
    public String toString() {
        return super.toString() + "\nTeacher: " + teacher.getFirstName() + " " + teacher.getLastName() + " (" + teacher.getUserName() + ")";
    }
}