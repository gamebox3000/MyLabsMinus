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
        return attempt == answer;     
    }
    /**
     * Gets the answer
     * @return the answer
     */
    public double get_answer(){
        return answer;
    }
    /**
     * Gets the problem string
     * @return the problem string
     */
    public String get_Problem(){
        return problem;
    }
    
    /**
     * This constructor specifies the type of math problem to create as well as what the grade level for the problem should be
     * @param type specifies either devi, multi, sub, or add to control problem type
     * @param level specifies grade level
     */
    public ProblemGenerator(String type, double level){
        level = Math.abs(level);
        switch (type){
            case "devi":
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
