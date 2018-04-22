/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1020group1project;

import java.util.ArrayList;

/**
 *
 * @author Jonathan Babb
 */
public class UserData {
    static ArrayList parrents = new ArrayList<>();
    static ArrayList students = new ArrayList<>();
    static ArrayList teachers = new ArrayList<>();
    
    public static void addUser(String Usertype, User user){
        switch (Usertype){
            case "teacher": 
                teachers.add(user);
                break;
            case "student": 
                students.add(user);
                break;
            case "parrent": 
                parrents.add(user);
                break;
            default: break;
        }
    }
}
