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
    private int numberOfChildren;
    private ArrayList<Student> arrayOfChildren = new ArrayList<Student>();
    public Parent() {
        numberOfChildren = 0;
    }
    public Parent(String userName, String lastName, String firstName, String eMail, int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
        arrayOfChildren.ensureCapacity(numberOfChildren);
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
    public int getNumberOfChildren() {
        return numberOfChildren;
    }
    public void setNumberOfChildren(int newNumberOfChildren) {
        numberOfChildren = newNumberOfChildren;
    }
}
