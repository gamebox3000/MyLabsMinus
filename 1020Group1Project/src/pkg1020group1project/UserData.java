/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1020group1project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * The UserData class manages the temporary data and its flow to and from permanent storage.
 * @author Jonathan Babb
 * @author Stephen Hyberger
 */
public class UserData {
    public static ArrayList<Parent> parents = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Teacher> teachers = new ArrayList<>();
    static File studentFile = new File("Student.txt");
    static File parentFile = new File("Parent.txt");
    static File teacherFile = new File("Teacher.txt");
    /**
     * Adds user to the corresponding arrayList.
     * @param user The User to add to the arrayLists
     * @throws IllegalArgumentException when a generic User is the parameter.
     */
    public static void addUser(User user) throws IOException{
        if (user instanceof Student) {
            students.add((Student) user);
        } else if (user instanceof Parent) {
            parents.add((Parent) user);
        } else if (user instanceof Teacher) {
            teachers.add((Teacher) user);
        } else {
            throw new IllegalArgumentException("Tried to add generic User");
        }
        save();
    }
    public static void update() throws FileNotFoundException, IOException{
        if(!studentFile.exists()) studentFile.createNewFile();
        if(!parentFile.exists()) parentFile.createNewFile();
        if(!teacherFile.exists()) teacherFile.createNewFile();
        Scanner sIn = new Scanner(studentFile);
        Scanner pIn = new Scanner(parentFile);
        Scanner tIn = new Scanner(teacherFile);
        String[] sStrings = sIn.next().split(";");
        for(int n = 0; n < sStrings.length; n++){
            String temp[] = sStrings[n].split(",");
            String userName = temp[0];
            String lastName = temp[1];
            String firstName = temp[2];
            String email = temp[3];
            String teacherUN = temp[4];
            Student s = new Student(userName, firstName, lastName, email, teacherUN);
            students.add(s);
        }
        String[] pStrings = pIn.next().split(";");
        for(int n = 0; n < pStrings.length; n++){
            String temp[] = pStrings[n].split(",");
            String userName = temp[0];
            String lastName = temp[1];
            String firstName = temp[2];
            String email = temp[3];
            String studentNum = temp[4];
            Parent p = new Parent(userName, firstName, lastName, email, studentNum);
            parents.add(p);
        }
        String[] tStrings = tIn.next().split(";");
        for(int n = 0; n < tStrings.length; n++){
            String temp[] = tStrings[n].split(",");
            String userName = temp[0];
            String lastName = temp[1];
            String firstName = temp[2];
            String email = temp[3];
            String studentNum = temp[4];
            Teacher t = new Teacher(userName, firstName, lastName, email, studentNum);
            teachers.add(t);
        }
    }
    /**
     * 
     * @throws IOException 
     */
    public static void save() throws IOException{
        if(!studentFile.exists()) studentFile.createNewFile();
        if(!parentFile.exists()) parentFile.createNewFile();
        if(!teacherFile.exists()) teacherFile.createNewFile();
        PrintWriter sOut = new PrintWriter(studentFile);
        PrintWriter pOut = new PrintWriter(parentFile);
        PrintWriter tOut = new PrintWriter(teacherFile);
        for(Teacher t: teachers){
            tOut.print(t.getUserName()+","+t.getFirstName()+","+t.getLastName()+","+t.getEMail()+","+t.getNumberOfStudents()+"; \n");
        }
        tOut.close();
        for(Parent p: parents){
            pOut.print(p.getUserName()+","+p.getFirstName()+","+p.getLastName()+","+p.getEMail()+","+p.getNumberOfChildren()+";\n");
        }
        pOut.close();
        for(Student s: students){
            sOut.print(s.getUserName()+","+s.getFirstName()+","+s.getLastName()+","+s.getEMail()+","+s.getTeacherUserName()+";\n");
        }
        sOut.close();
    }
    /**
     * returns list of users
     * @param includeParents include parents in list
     * @param includeStudents include students in list
     * @param includeTeachers include teachers in list
     * @return list of users
     */
    public static String listUser(boolean includeParents, boolean includeStudents, boolean includeTeachers){
        String userList = "";
        int count = 1;
        if(includeParents){
            for(Parent parent: parents){
                userList += "\n"+count+". "+parent.getUserName();
                count++;
            }
        }
        if (includeStudents){
            for(Student student: students){
                userList += "\n"+count+". "+student.getUserName();
                count++;
            }
        }
        if (includeTeachers){
            for(Teacher teacher: teachers){
                userList += "\n"+count+". "+teacher.getUserName();
                count++;
            }
        }
        return userList;
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
    public static String getDetails(String userName) {
        if (contains(userName)) {
            for (Parent parent : parents) {
                if (parent.getUserName().equals(userName)) {
                    return parent.toString();
                }
            }
            for (Student student : students) {
                if (student.getUserName().equals(userName)) {
                    return student.toString();
                }
            }
            for (Teacher teacher : teachers) {
                if (teacher.getUserName().equals(userName)) {
                    return teacher.toString();
                }
            }
        } 
        return null;
    }
}