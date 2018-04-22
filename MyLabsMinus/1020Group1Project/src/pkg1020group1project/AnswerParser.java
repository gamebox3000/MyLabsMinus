/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1020group1project;

/**
 *@author thony
 * Final Project
 * 4/20/2018
 */
public class AnswerParser {
     /**
      * used so method can be called on all inputs
      * @param par problem answer
      * @return problem answer
      */
    static public double toreader(double par)
   {
     return par;
   }
    /**
     * used to format to double
     * @param par problem answer
     * @return problem answer as double
     */
    static public double toreader(int par)
   {
     return par;
   }
   /**
    * throws error if string contains non number characters
    * @param par problem answer
    * @return input as double
    */
   static public double toreader(String par)

   {

       for (int x = 0; x < par.length(); x++)
    
    {
      
    switch(par.charAt(x)) 
    {      
        case '1': break;
        case '2': break;
        case '3': break;
        case '4': break;
        case '5': break;
        case '6': break;
        case '7': break;
        case '8': break;
        case '9': break;
        case '0': break;
        case '.': break;
        default: throw new NumberFormatException();
        
    }
         
     }
      double reader = Double.parseDouble(par);
      return reader;
      
   }
}
