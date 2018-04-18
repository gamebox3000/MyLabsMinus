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
    private String maxStudents;
    private ArrayList<Student> arrayOfStudents = new ArrayList<>();
    public Teacher() {
        maxStudents = "0";
    }
    public Teacher(String userName, String lastName, String firstName, String eMail, String maxStudents) {
        super(userName, lastName, firstName, eMail);
        this.maxStudents = maxStudents;
    }
    public void setNumberOfStudents(String newNumberOfStudents) {
        maxStudents = newNumberOfStudents;
    }
    public String getNumberOfStudents() {
        return maxStudents;
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
