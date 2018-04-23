/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1020group1project;

import java.util.ArrayList;
/**
 * The UserData class manages the temporary data and its flow to and from permanent storage.
 * @author Jonathan Babb
 * @author Stephen Hyberger
 */
public class UserData {
    private static ArrayList<Parent> parents = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    /**
     * Adds user to the corresponding arrayList.
     * @param user The User to add to the arrayLists
     * @throws IllegalArgumentException when a generic User is the parameter.
     */
    public static void addUser(User user){
        if (user instanceof Student) {
            students.add((Student) user);
        } else if (user instanceof Parent) {
            parents.add((Parent) user);
        } else if (user instanceof Teacher) {
            teachers.add((Teacher) user);
        } else {
            throw new IllegalArgumentException("Tried to add generic User");
        }
    }
    /**
     * The contains method checks for a match between the username parameter and all the usernames in the arrayLists.
     * @param userName The user name to check for.
     * @return True if match is found and false if there is no match.
     */
    public static boolean contains(String userName) {
        boolean doesContain = false;
        for (Parent parent : parents) {
            if (parent.getUserName().equals(userName)) {
                doesContain = true;
            }
        }
        for (Student student : students) {
            if (student.getUserName().equals(userName)) {
                doesContain = true;
            }
        }
        for (Teacher teacher : teachers) {
            if (teacher.getUserName().equals(userName)) {
                doesContain = true;
            }
        }
        return doesContain;
    }
    /**
     * Returns the User with the specified username.
     * @param userName The username of the User to return
     * @return The User with the matching user name to the parameter.
     * @throws IllegalArgumentException if the User is not found.
     */
    public static User getUser(String userName) {
        if (contains(userName)) {
            for (Parent parent : parents) {
                if (parent.getUserName().equals(userName)) {
                    return parent;
                }
            }
            for (Student student : students) {
                if (student.getUserName().equals(userName)) {
                    return student;
                }
            }
            for (Teacher teacher : teachers) {
                if (teacher.getUserName().equals(userName)) {
                    return teacher;
                }
            }
        } else {
            throw new IllegalArgumentException("User not found");
        }
        return null;
    }
    /**
     * Prints all the details of the User with the user name matching the parameter.
     * @param userName The username of the User.
     * @throws IllegalArgumentException if the user is not found.
     */
    public static void printDetails(String userName) {
        if (contains(userName)) {
            for (Parent parent : parents) {
                if (parent.getUserName().equals(userName)) {
                    System.out.println(parent);
                }
            }
            for (Student student : students) {
                if (student.getUserName().equals(userName)) {
                    System.out.println(student);
                }
            }
            for (Teacher teacher : teachers) {
                if (teacher.getUserName().equals(userName)) {
                    System.out.println(teacher);
                }
            }
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
}