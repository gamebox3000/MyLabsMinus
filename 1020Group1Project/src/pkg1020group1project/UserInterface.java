/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1020group1project;

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
    static Scanner uIn = new Scanner(System.in);
    static boolean recordHistory = true;
    static User currentUser = new User();
    /**
     * Loops through input until a valid input is given, or executes a command
     * @param acceptableIns takes an array of acceptable inputs
     * @param prompt the inital prompt for the input
     * @param needs prompt if invalid input is given
     * @return the users input if valid, or null if a command is given
     */
    static String parseInput(String[] acceptableIns, String prompt,String needs) {
        while (true) {
            System.out.println(prompt);
            System.out.print("\n\n>>>");
            String input = uIn.nextLine();
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
    /**
     * Prompts the user and returns valid input, or executes a command
     * @param prompt initial prompt for user input
     * @return the users input no matter what, or null if a command is given
     */
    static String parseInput(String prompt) {
            System.out.println(prompt);
            System.out.print("\n\n>>>");
            String input = uIn.nextLine();
            if (input.startsWith("/")) {
                executeCommand(input);
                return null;
            }
            return input;
    }
    /**
     * @param min the smallest integer allowed, inclusive
     * @param max the largest integer allowed, inclusive
     * @param prompt the prompt for a number
     * @return an integer value
     */
    static int parseIntInput(int min, int max, String prompt) throws NumberFormatException {
        while (true) {
            System.out.println(prompt);
            System.out.print("\n\n>>>");
            String input = uIn.nextLine();
            int intInput;
            if (input.startsWith("/")) {
                executeCommand(input);
                return 0;
            }
            boolean valid = true;
            while(valid){
                try {
                    intInput = Integer.parseInt(input);
                    if (intInput <= max && intInput >= min){
                        return intInput;
                    } else {
                        System.out.println("Please enter an interger between "+min+" and "+max);
                        valid = false;
                    }

                } catch(NumberFormatException ex){
                    System.out.println("Please input an intager");
                    valid = false;
                }
            }
        }
    }
    /**
     * executes special commands if typed in
     * @param input the command to execute
     */
    static void executeCommand(String input) {
        switch (input.toLowerCase()) {
            //Back command takes user to the previous message in the message history.
            case "/back":
                if (history.isEmpty()) {
                    System.out.println("Cannot run /back commmand: there is no menu to go back to");
                    open();
                } else {
                    
                    
                    if(history.size() <= 2){
                        System.out.println("Cannot run /back commmand: there is no menu to go back to");
                        dialogTree(history.get(history.size() - 1));
                    } else {
                        try {
                            recordHistory = false;
                            history.remove(history.size()-1);
                            dialogTree(history.get(history.size() - 1));
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            System.out.println("Cannot run /back command: here is no menu to go back to");
                            dialogTree(history.get(history.size() - 1));
                        }  
                    }
                }
                break;
            //Help command prints list of valid commands to the user and reprints message.
            case "/help":
                System.out.println("List of commands:\n\n1. /help - Prints out a list of all the available commands.\n\n2. /back - returns to the last visted menu.\n\n3. /exit - terminates program.\n\nPress enter to continue.");
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
    /**
     * used to associate the history saved in recordHistroy into their respective dialogs
     * @param branch the associated dialog to be called
     */
    static void dialogTree(String branch) {
        switch (branch){
            case "Open": open(); break;//0
            case "Login": login(); break;//1
            case "Type": type(); break;//2
            case "UserName": userName(); break; //3
            case "FirstName": firstName(); break;//4
            case "LastName": lastName(); break;//5
            case "Email": email(); break;//6
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
    /**
     * into dialog
     */
    public static void open(){
        if(recordHistory)history.add("Open");
        recordHistory = true;
        String[] allowed = {"1","2"};
        String prompt = "Welcome to MyLabsMinus\nType /help for a list of commands\nFrom here you can either login or create a new account.\nPlease indicate your choice by entering the corresponding number:\n1. Login\n2. New User";
        String need = "Please enter either a 1 or 2, indicating your choice.";
        String input = parseInput(allowed, prompt, need);
        switch (input){
            case "1": login(); break;
            case "2": type(); break;
            default: break;
        }
        
    }
    /**
     * user login dialog
     */
    static void login(){
        if(recordHistory)history.add("Login");
        recordHistory = true;
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
     * user creation type selection
     * !!Note: in the future change methods called within this one to return
     * strings so they can be written to the text file
     */
    static void type(){
        if(recordHistory)history.add("Type");
        recordHistory = true;
        String[] allowed = {"1","2","3"};
        String prompt = "Are you a:\n1. Student\n2. Teacher\n3. Parent";
        String need = "Please enter a 1, 2, or 3, indicating your choice.";
        String input = parseInput(allowed, prompt, need);
        String userName;
        String firstName;
        String lastName;
        String email;
        switch (input){
            case "1": 
                userName = userName();
                firstName = firstName();
                lastName = lastName();
                email = email();
                String teacherUsername = teacherUserName();
                currentUser = new Student(userName, firstName, lastName, email, teacherUsername);
                confirmStudent();
                break;
            case "2": 
                userName = userName();
                firstName = firstName();
                lastName = lastName();
                email = email();
                String numStudents = numStudents();
                currentUser = new Teacher(userName, firstName, lastName, email, numStudents);
                confirmTeacher();
                break;
            case "3": 
                userName = userName();
                firstName = firstName();
                lastName = lastName();
                email = email();
                String numChildren = numChildren();
                currentUser = new Parent(userName, firstName, lastName, email, numChildren);
                confirmParent();
                break;
            default: break;
        }
    }
    /**
     * username input
     */
    static String userName(){
        if(recordHistory)history.add("UserName");
        recordHistory = true;
        String prompt = "Please enter a unique username";
        return parseInput(prompt);
    }
    /**
     * first name input
     */
    static String firstName(){
        if(recordHistory)history.add("FirstName");
        recordHistory = true;
        String prompt = "Please enter your first name";
        return parseInput(prompt);
    }
    /**
     * last name input
     */
    static String lastName(){
        if(recordHistory)history.add("LastName");
        recordHistory = true;
        String prompt = "please enter your last name";
        return parseInput(prompt);
    }
    /**
     * email input
     */
    static String email(){
        if(recordHistory)history.add("Email");
        recordHistory = true;
        String prompt = "Please enter your email";
        return parseInput(prompt);
    }
    //special prompt for this one needs integration with file parser
    /**
     * let students select teacher
     */
    static String teacherUserName(){
        if(recordHistory)history.add("TeacherUserName");
        recordHistory = true;
        String prompt = "Please enter an positive integer indicating your choice out of those presented below."+UserData.listUser(false, false, true);
        int input = parseIntInput(1, UserData.teachers.size(), prompt)-1;
        return UserData.teachers.get(input).getUserName();
    }
    /**
     * let teacher select number of students
     */
    static String numStudents(){
        if(recordHistory)history.add("NumStudent");
        recordHistory = true;
        String prompt = "How many students are you going to supervise?";
        return parseInput(prompt);
    }
    /**
     * let parent select number of children
     */
    static String numChildren(){
        if(recordHistory)history.add("NumChildren");
        recordHistory = true;
        String prompt = "How many students are you registering or have registered to use this program?";
        return parseInput(prompt);
    }
    /**
     * let parents select child to associate with
     */
    static String childUserName(){
        if(recordHistory)history.add("ChildUserName");
        recordHistory = true;
        String prompt = "Enter your student's username.";
        return parseInput(prompt);
    }
    //todo: integrate with file parser to get user data
    /**
     * confirms user creation for student
     */
    static void confirmStudent(){
        if(recordHistory)history.add("ConfirmStudent");
        recordHistory = true;
        String[] allowed = {"yes", "no"};
        String prompt = "Are the following details correct?\n"+currentUser.toString();
        String need= "Please enter a \'yes\' or a \'no\'.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "yes": 
                UserData.addUser(currentUser);
                open(); 
                break;
            case "no": type(); break;
            default: break;
        }
        
    }
    //todo: integrate with file parser to get user data
    /**
     * confirm user creation for teacher
     */
    static void confirmTeacher(){
        if(recordHistory)history.add("ConfirmTeacher");
        recordHistory = true;
        String[] allowed = {"yes", "no"};
        String prompt = "Are the following details correct?\n"+currentUser.toString();
        String need= "Please enter a \'yes\' or a \'no\'.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "yes": 
                UserData.addUser(currentUser);
                open(); 
                break;
            case "no": type(); break;
            default: break;
        }
        
    }
    //todo: integrate with file parser to get user data
    /**
     * confirm user creation for parent
     */
    static void confirmParent(){
        if(recordHistory)history.add("confirmParent");
        recordHistory = true;
        String[] allowed = {"yes", "no"};
        String prompt = "Are the following details correct?\n"+currentUser.toString();
        String need= "Please enter a \'yes\' or a \'no\'.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "yes": 
                UserData.addUser(currentUser);
                open(); 
                break;
            case "no": type(); break;
            default: break;
        }
    }
    /**
     * student menu after logging in
     */
    static void studentMenu(){
        if(recordHistory)history.add("StudentMenu");
        recordHistory = true;
        String[] allowed = {"1","2"};
        String prompt = "Hello "+currentUser.getUserName()+" ,Please select one of the options below:\n1. Take Quiz\n2. Log out.";
        String need = "Please indicate your choice using either 1 or 2.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "1": quiz(); break;
            case "2": System.out.println("\nThank you "+currentUser.getUserName()+" for using MyLabsMinus. Please come again.\n");open(); break;
            default: break;
        }
    }
    /**
     * teacher menu after logging in
     */
    static void teacherMenu(){
        if(recordHistory)history.add("TeacherMenu");
        recordHistory = true;
        String[] allowed = {"1","2","3"};
        String prompt = "Hello, "+currentUser.getUserName()+", Please select one of the options below:\n1. Search Students\n2. Print Report.\n3. Log out";
        String need = "Please indicate your choice using either 1 or 2.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "1": search(); break;
            case "2": printReport(); break;
            case "3": System.out.println("\nThank you "+currentUser.getUserName()+" for using MyLabsMinus. Please come again.\n");open(); break;
            default: break;
        }
    }
    /**
     * parent menu after logging in
     */
    static void parentMenu(){
        if(recordHistory)history.add("ParentMenu");
        recordHistory = true;
        String[] allowed = {"1","2"};
        String prompt = "Hello, "+currentUser.getUserName()+", Please select one of the options below:\n1. Print Report.\n2. Log out.";
        String need = "Please indicate your choice using either 1 or 2.";
        String input = parseInput(allowed, prompt, need);
        switch(input){
            case "1": printReport(); break;
            case "2": System.out.println("\nThank you "+currentUser.getUserName()+" for using MyLabsMinus. Please come again.\n");open(); break;
            default: break;
        }
    }
    /**
     * quiz for student
     */
    static void quiz(){
        if(recordHistory)history.add("Quiz");
        recordHistory = true;
        String[] allowed = {"1","2","3","4","5"};
        String prompt = "Plase select your problem type:\n1. addition.\n2. subtraction.\n3. multiplication.\n4. devition.\n5. random mixture.";
        String need = "Plase indicate your choice using a number from 1 to 5.";
        String input = parseInput(allowed, prompt, need);
        int length = parseIntInput(1,100,"Please enter the length of your quiz.");
        int level = parseIntInput(0,12,"Please enter the grade level you would like to take this test at.");
        ProblemGenerator[] quiz = new ProblemGenerator[length];
        switch(input){
            case "1":
                for(int n = 0; n < quiz.length; n++){
                    quiz[n] = new ProblemGenerator("add", level);
                }
                break;
            case "2": 
                for(int n = 0; n < quiz.length; n++){
                    quiz[n] = new ProblemGenerator("sub", level);
                }
                break;
            case "3": 
                for(int n = 0; n < quiz.length; n++){
                    quiz[n] = new ProblemGenerator("multi", level);
                }
                break;
            case "4": 
                for(int n = 0; n < quiz.length; n++){
                    quiz[n] = new ProblemGenerator("dev", level);
                }
                break;
            case "5": 
                for(int n = 0; n < quiz.length; n++){
                    quiz[n] = new ProblemGenerator(level);
                }
                break;
            default: break;
        }
        for (ProblemGenerator problems: quiz){
            double answer = AnswerParser.toreader(parseInput(problems.get_Problem()));
            if (problems.verrifyAnswer(answer)){
                System.out.println("Correct!");
            } else System.out.println("Incorrect!!");
        }
        studentMenu();
    }
    /**
     * search students for teacher
     */
    static void search(){
        if(recordHistory)history.add("Search");
        recordHistory = true;
    }
    /**
     * print report for children
     */
    static void printReport(){
        if(recordHistory)history.add("PrintReport");
        recordHistory = true;
        String prompt = "Please enter in a username to see report";
        String userData;
        do {
            String input = parseInput(prompt);
            userData = UserData.getDetails(input);
            if (userData == null) System.out.println("User "+input+" was not found");
        } while (userData == null);
        System.out.println(userData);
        printReport();
    }
}
