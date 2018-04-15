/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.util.ArrayList;

/**
 *
 * @author StephenAHyberger
 */
public class Teacher extends User{
    private int numberOfStudents;
    private ArrayList<Student> arrayOfStudents = new ArrayList<>();
    public Teacher() {
        numberOfStudents = 0;
    }
    public Teacher(String userName, String lastName, String firstName, String eMail, int numberOfStudents) {
        super(userName, lastName, firstName, eMail);
        this.numberOfStudents = numberOfStudents;
    }
    public void setNumberOfStudents(int newNumberOfStudents) {
        numberOfStudents = newNumberOfStudents;
    }
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    public void addStudent(Student newStudent) {
        arrayOfStudents.add(newStudent);
    }
    public Student getStudent(int index) {
        return arrayOfStudents.get(index);
    }
    public ArrayList<Student> getArrayOfStudents() {
        return arrayOfStudents;
    }
}
