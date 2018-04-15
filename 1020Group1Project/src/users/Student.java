/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author StephenAHyberger
 */
public class Student extends User {
    private int gradeLevel;
    private String teacherUserName;
    public Student() {
        gradeLevel = 0;
        teacherUserName = "";
    }
    public Student(String userName, String lastName, String firstName, String eMail, int gradeLevel, String teacherUserName) {
        super (userName, lastName, firstName, eMail);
        this.gradeLevel = gradeLevel;
        this.teacherUserName = teacherUserName;
    }
    public void setGradeLevel(int newGradeLevel) {
        this.gradeLevel = newGradeLevel;
    }
    public int getGradeLevel() {
        return gradeLevel;
    }
    public void setTeacherUserName(String newTeacherUserName) {
        this.teacherUserName = newTeacherUserName;
    }
    public String getTeacherUserName() {
        return teacherUserName;
    }
}