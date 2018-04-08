/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1020group1project;

/**
 *
 * @author mboyson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProblemGenerator gen = new ProblemGenerator("add", 12);
        System.out.println(gen.get_Problem()+"="+gen.get_answer());
        
    }
    
}
