/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1020group1project;

import java.util.Random;

/**
 *
 * @author gamebox3000
 */
public class ProblemGenerator {
    Random rand = new Random();
    double answer;
    String problem = "Please solve for x:\n";
    /**
     * Verifies if an attempt is correct
     * @param attempt double value to check if an answer is correct
     * @return true if attempt is the same as answer
     */
    public boolean verrifyAnswer(double attempt){
        return Math.round(attempt*100)/100 == Math.round(answer*100)/100;     
    }
    /**
     * Gets the answer
     * @return the answer
     */
    public double get_answer(){
        return Math.round(answer*100)/100;
    }
    /**
     * Gets the problem string
     * @return the problem string
     */
    public String get_Problem(){
        return problem;
    }
    
    /**
     * Constructs a problem with a random type and grade level
     */
    public ProblemGenerator(){
        int level = 1+rand.nextInt(12);
        switch (rand.nextInt(4)){
        case 0:
                devi(level);
                break;
            case 1:
                multi(level);
                break;
            case 2:
                sub(level);
                break;
            case 3:
                add(level);
                break;
            default: 
                System.out.println("Type used is not recognized");
                answer = Math.PI;
                problem = "undefined problem";
        }         
    }
    /**
     * Constructs a problem with a specified grade level and a random type
     * @param level specified grade level
     */
    public ProblemGenerator(double level){
        level = Math.abs(level);
        switch (rand.nextInt(4)){
        case 0:
                devi(level);
                break;
            case 1:
                multi(level);
                break;
            case 2:
                sub(level);
                break;
            case 3:
                add(level);
                break;
            default: 
                System.out.println("Type used is not recognized");
                answer = Math.PI;
                problem = "undefined problem";
        }         
    }
    /**
     * Constructs a problem with a specified type but a random grade level
     * @param type specifies either div, multi, sub, or add to control problem type
     */
    public ProblemGenerator(String type){
        int level = 1+rand.nextInt(12);
        switch (type){
        case "div":
                devi(level);
                break;
            case "multi":
                multi(level);
                break;
            case "sub":
                sub(level);
                break;
            case "add":
                add(level);
                break;
            default: 
                System.out.println("Type used is not recognized");
                answer = Math.PI;
                problem = "undefined problem";
        }         
    }
    
    /**
     * This constructor specifies the type of math problem to create as well as what the grade level for the problem should be
     * @param type specifies either div, multi, sub, or add to control problem type
     * @param level specifies grade level
     */
    public ProblemGenerator(String type, double level){
        level = Math.abs(level);
        switch (type){
            case "div":
                devi(level);
                break;
            case "multi":
                multi(level);
                break;
            case "sub":
                sub(level);
                break;
            case "add":
                add(level);
                break;
            default: 
                System.out.println("Type used is not recognized");
                answer = Math.PI;
                problem = "undefined problem";
        }         
    }
    /**
     * creates a devision problem basses on a grade level by setting problem
     * to the problem string and answer
     * @param level grade level of the problem
     */
    private void devi(double level){
        int solution = (int)(rand.nextDouble()*Math.pow(10, Math.ceil(level/3)));
        int term2 = (int)(rand.nextDouble()*Math.pow(10, Math.ceil(level/3)));
        int term1 = solution*term2;
        problem = term1+" / "+term2+" = ";
        answer = solution;
    }
    /**
     * creates a multiplication problem basses on a grade level by setting problem
     * to the problem string and answer
     * @param level grade level of the problem
     */
    private void multi(double level){
        int numTerms = 1+(int)Math.ceil(level*rand.nextDouble());
        int[] terms = new int[numTerms];
        answer = 1;
        for(int n = 0; n < terms.length; n++){
            terms[n] = (int)(rand.nextDouble()*Math.pow(10, Math.ceil(level/3)));
            answer = answer * terms[n];
            if(n == terms.length-1){
                problem += terms[n]+" = x";
            } else{
                problem += terms[n] +" * ";
            }
        }
    }
    /**
     * creates a subtraction problem basses on a grade level by setting problem
     * to the problem string and answer
     * @param level grade level of the problem
     */
    private void sub(double level){
        int solution = (int)(rand.nextDouble()*Math.pow(10, Math.ceil(level/3)));
        int term2 = (int)(rand.nextDouble()*Math.pow(10, Math.ceil(level/3)));
        int term1 = solution+term2;
        problem = term1+" - "+term2+" = ";
        answer = solution; 
        
    }
    /**
     * creates an addition problem basses on a grade level by setting problem
     * to the problem string and answer
     * @param level grade level of the problem
     */
    private void add(double level){
        int numTerms = 1+(int)Math.ceil(level*rand.nextDouble());
        int[] terms = new int[numTerms];
        for(int n = 0; n < terms.length; n++){
            terms[n] = (int)(rand.nextDouble()*Math.pow(10, Math.ceil(level/3)));
            answer += terms[n];
            if(n == terms.length-1){
                problem += terms[n]+" = x";
            } else{
                problem += terms[n] +" + ";
            }
        }
        
    }
}
