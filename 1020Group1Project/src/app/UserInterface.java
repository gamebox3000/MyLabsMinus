/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Stephen Hyberger
 * @author mboyson
 */
public class UserInterface {
    //!!todo fix history storeing/navigation
    static ArrayList<String> history = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static boolean recordHistory = true;

    static String parseInput(String[] acceptableIns, String prompt,String needs) {
        while (true) {
            System.out.println(prompt);
            System.out.print("\n\n>>>");
            String input = in.nextLine();
            for (String acceptables : acceptableIns) {
                if (input.toLowerCase() == null ? acceptables == null : input.toLowerCase().equals(acceptables)) {
                    return input;
                }
            }
            if (input.startsWith("/")) {
                executeCommand(input);
                return null;
            }
            System.out.println(needs);
        }
    }
    
    static String parseInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            System.out.print("\n\n>>>");
            String input = in.nextLine();
            if (input.startsWith("/")) {
                executeCommand(input);
                return null;
            }
            return input;
        }
    }

    static void executeCommand(String input) {
        switch (input.toLowerCase()) {
            //Back command takes user to the previous message in the message history.
            case "/back":
                if (history.isEmpty()) {
                    System.out.println("Cannot run \back commmand: there is no menu to go back to");
                } else {
                    recordHistory = false;
                    history.remove(history.size()-1);
                    dialogTree(history.get(history.size() - 1));
                }
                break;
            //Help command prints list of valid commands to the user and reprints message.
            case "/help":
                System.out.println("List of commands:\n\n1. \\help - Prints out a list of all the available commands.\n\n2. \\back - returns to the last visted menu.\n\n3. \\exit - terminates program.\n\nPress enter to continue.");
                dialogTree(history.get(history.size()-1));
                break;
            //Exit command terminates program.    
            case "/exit":
                System.out.println("\nThank you for using MyLabMinus");
                System.exit(0);
                break;
            //Handles unrecognized commands and reprints message.
            default:
                System.out.println("Unrecognized command. Please consult the list of recognized commands with \\help");
                dialogTree(history.get(history.size()-1));
                break;
        }
    }

    static void dialogTree(String branch) {
        switch (branch){
            case "Open": open(); break;//0
            case "Login": login(); break;//1
            case "Type": type(); break;//2
            case "UserName": userName(); break; //3
            case "FirstName": firstName(); break;//4
            case "LastName": lastName(); break;//5
            case "Email": email(); break;//6
            case "GradeLevel": gradeLevel(); break;//7
            case "TeacherUserName": teacherUserName(); break;//8
            case "NumStudents": numStudents(); break;//9
            case "NumChildren": numChildren(); break;//10
            case "ChildUserName": childUserName(); break;//11
            case "ConfirmStudent": confirmStudent(); break;//12
            case "ConfirmTeacher": confirmTeacher(); break;//13
            case "ConfirmParent": confirmParent(); break; //14
            case "StudentMenu": studentMenu(); break; //15
            case "TeacherMenu": teacherMenu(); break;//16
            case "ParentMenu": parentMenu(); break;//17
            case "Quiz": quiz(); break;//18
            case "Search": search(); break;//19
            case "PrintReport": printReport(); break; //20
            default: throw new IllegalArgumentException();
        }
    }
    
    public static void open(){
        history.add("Open");
        String[] allowed = {"1","2"};
        String prompt = "Welcome to MyLabsMinus\nFrom here you can either login or create a new account.\nPlease indicate your choice by entering the corresponding number:\n1. Login\n2. New User";
        String need = "Please enter either a 1 or 2, indicating your choice.";
        String input = parseInput(allowed, prompt, need);
        switch (input){
            case "1": login(); break;
            case "2": type(); break;
            default: break;
        }
        
    }
    
    static void login(){
        history.add("Login");
        String[] allowed = {"student", "teacher", "parent"};
        String prompt = "Please enter your username to login !Temp enter student/teacher/parent!";
        String need = "student/teacher/parent";
        String input = parseInput(allowed, prompt, need);
        //todo: check against text file
        switch(input){
            case "student": studentMenu(); break;
            case "teacher": teacherMenu(); break;
            case "parent": parentMenu(); break;
            default: break;
        }
        
    }
    /**
     * !!Note: in the future change methods called within this one to return
     * strings so they can be written to the text file
     */
    static void type(){
        history.add("type");
        String[] allowed = {"1","2","3"};
        String prompt = "Are you a:\n1. Student\n2. Teacher\n3. Parent";
        String need = "Please enter a 1, 2, or 3, indicating your choice.";
        String input = parseInput(allowed, prompt, need);
        switch (input){
            case "1": 
                userName();
                firstName();
                lastName();
                email();
                gradeLevel();
                teacherUserName();
                break;
            case "2": 
                userName();
                firstName();
                lastName();
                email();
                numStudents();
                break;
            case "3": 
                userName();
                firstName();
                lastName();
                email();
                numChildren();
                childUserName();
                break;
            default: break;
        }
    }
    
    static void userName(){
        if(recordHistory)history.add("UserName");
        recordHistory = true;
        String prompt = "Please enter a unique username";
        String temp = parseInput(prompt);
    }
    
    static void firstName(){
        if(recordHistory)history.add("FirstName");
        recordHistory = true;
        String prompt = "Please enter your first name";
        String temp = parseInput(prompt);
    }
    
    static void lastName(){
        if(recordHistory)history.add("LastName");
        recordHistory = true;
        String prompt = "please enter your last name";
        String temp = parseInput(prompt);
    }
    
    static void email(){
        if(recordHistory)history.add("Email");
        recordHistory = true;
        String prompt = "Please enter your email";
        String temp = parseInput(prompt);
    }
    
    static void gradeLevel(){
        if(recordHistory)history.add("Grade Level");
        recordHistory = true;
        String prompt = "Please enter your grade level";
        String temp = parseInput(prompt);
    }
    //special prompt for this one
    static void teacherUserName(){
        if(recordHistory)history.add("TeacherUserName");
        recordHistory = true;
        String prompt = "Please enter an positive integer indicating your choice out of those presented below.";
        String temp = parseInput(prompt);
    }
    
    static void numStudents(){
        if(recordHistory)history.add("NumStudent");
        recordHistory = true;
        String prompt = "How many students are you going to supervise?";
        String temp = parseInput(prompt);
    }
    
    static void numChildren(){
        if(recordHistory)history.add("NumChildren");
        recordHistory = true;
        String prompt = "How many students are you registering or have registered to use this program?";
        String temp = parseInput(prompt);
    }
    
    static void childUserName(){
        if(recordHistory)history.add("ChildUserName");
        recordHistory = true;
        String prompt = "Enter your student's username.";
        String temp = parseInput(prompt);
    }
    //todo: integrate with file parser to get user data
    static void confirmStudent(){
        if(recordHistory)history.add("ConfirmStudent");
        recordHistory = true;
        String[] allowed = {"yes", "no"};
        String prompt = "Are the following details correct?!grab student details here!";
        String need= "Please enter a \'yes\' or a \'no\'.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "yes": type(); break;
            case "no": open(); break;
            default: break;
        }
    }
    //todo: integrate with file parser to get user data
    static void confirmTeacher(){
        if(recordHistory)history.add("ConfirmTeacher");
        recordHistory = true;
        String[] allowed = {"yes", "no"};
        String prompt = "Are the following details correct?!grab teacher details here!";
        String need= "Please enter a \'yes\' or a \'no\'.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "yes": type(); break;
            case "no": open(); break;
            default: break;
        }
    }
    //todo: integrate with file parser to get user data
    static void confirmParent(){
        if(recordHistory)history.add("confirmParent");
        recordHistory = true;
        String[] allowed = {"yes", "no"};
        String prompt = "Are the following details correct?!grab parent details here!";
        String need= "Please enter a \'yes\' or a \'no\'.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "yes": type(); break;
            case "no": open(); break;
            default: break;
        }
    }
    
    static void studentMenu(){
        if(recordHistory)history.add("StudentMenu");
        recordHistory = true;
        String[] allowed = {"1","2"};
        String prompt = "Please select one of the options below:\n1. Take Quiz\n2. Log out.";
        String need = "Please indicate your choice using either 1 or 2.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "1": quiz(); break;
            case "2": System.out.println("Thank you !insert name here! for using MyLabsMinus. Please come again.\n");open(); break;
            default: break;
        }
    }
    
    static void teacherMenu(){
        if(recordHistory)history.add("TeacherMenu");
        recordHistory = true;
        String[] allowed = {"1","2"};
        String prompt = "Please select one of the options below:\n1. Search Students\n2. Log out";
        String need = "Please indicate your choice using either 1 or 2.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "1": search(); break;
            case "2": System.out.println("Thank you !insert name here! for using MyLabsMinus. Please come again.\n");open(); break;
            default: break;
        }
    }
    
    static void parentMenu(){
        if(recordHistory)history.add("ParentMenu");
        recordHistory = true;
        String[] allowed = {"1","2"};
        String prompt = "Please select one of the options below:\n1. Print Report.\n2. Log out.";
        String need = "Please indicate your choice using either 1 or 2.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "1": printReport(); break;
            case "2": System.out.println("Thank you !insert name here! for using MyLabsMinus. Please come again.\n");open(); break;
            default: break;
        }
    }
    
    static void quiz(){
        if(recordHistory)history.add("Quiz");
        recordHistory = true;
    }
    
    static void search(){
        if(recordHistory)history.add("Search");
        recordHistory = true;
    }
    
    static void printReport(){
        if(recordHistory)history.add("PrintReport");
        recordHistory = true;
    }
}
