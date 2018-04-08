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
    
    public boolean verrifyAnswer(double attempt){
        return attempt == answer;     
    }
    
    public double get_answer(){
        return answer;
    }
    
    public String get_Problem(){
        return problem;
    }
    
    /**
     * 
     * @param type specifies either devi, multi, sub, or add
     * @param level specifies grade level
     */
    public ProblemGenerator(String type, double level){
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
    
    private void devi(double level){
        
    }
    
    private void multi(double level){
        
    }
    
    private void sub(double level){
        
    }
    /**
     * creates an addition problem basses on a grade level
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
