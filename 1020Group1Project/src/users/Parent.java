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
public class Parent extends User{
    private String numberOfChildren;
    private ArrayList<Student> arrayOfChildren = new ArrayList<Student>();
    public Parent() {
        numberOfChildren = "0";
    }
    public Parent(String userName, String lastName, String firstName, String eMail, String numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }
    public void addChild(Student newChildUserName) {
        arrayOfChildren.add(newChildUserName);
    }
    public Student getChild(int index) {
        return arrayOfChildren.get(index);
    }
    public ArrayList<Student> getArrayOfChildren() {
        return arrayOfChildren;
    }
    public String getNumberOfChildren() {
        return numberOfChildren;
    }
    public void setNumberOfChildren(String newNumberOfChildren) {
        numberOfChildren = newNumberOfChildren;
    }
}
