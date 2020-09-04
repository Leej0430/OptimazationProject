
package optimazation.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author JuneYeob Lee(24629603)
 * \This Functioning class has made to implemente  all 18 functions by ranges.
 * * \date 4/5/2019
 * Contact:Leej @cwu.edu
 * Created on: 3/28/2019
 */
//! Functioning class
public class Functioning  {
           
    /** A funct method
    /*@param int length for first parameter
      @param int size for second parameter
      @return result of 18 functions from x(number of rows of 2dmatrix) vectors
*/ 
      double[][] a;
    double[]newresult;   
    public double[] funct(int functionNum,int length,int size) throws FileNotFoundException, UnsupportedEncodingException{
       CreateMatrix m = new CreateMatrix(length,size);
      

   Functions f = new Functions(length);
     switch(functionNum){
                   case 0: 
                       m.add(-512, 512);
                       a=m.input;
                       newresult =f.Schwefel(a);
                       break;
                         case 1: 
                            m.add(-100, 100);
                            a=m.input;
                       newresult =f.DeJong(a);
                       break;
                         case 2: 
                         m.add(-100, 100);
                            a=m.input;
                       newresult =f.Rosenbrock(a);
                       break;
                         case 3: 
                             m.add(-30,30);
                       a=m.input;

                       newresult =f.Rastrigin(a);

                       break;
                         case 4: 
                              m.add(-500, 500);
                       a=m.input;
 
               
                       newresult =f.Griewangk(a);
      
                       break;
                         case 5:      m.add(-30,30);
                       a=m.input;
                 
                    
                      newresult =f.SineEnvelope(a);
                 
                       break;
                         case 6:      m.add(-30,30);
                       a=m.input;
                 
                       newresult =f.StretchedV(a);
                   
                       break;
                         case 7:   m.add(-32, 32);
                       a=m.input;
                  
                       newresult =f.Ackley1(a);
                       
                       break;
                         case 8:  m.add(-32, 32);
                       a=m.input;
                 
                       newresult =f.Ackely2(a);
                    
                       break;
                         case 9:  m.add(-500, 500);
                       a=m.input;
                      newresult =f.EggHolder(a);
                     
                       break;
                         case 10:  m.add(-500, 500);
                       a=m.input;

                       newresult =f.Rana(a);  
          
                       break;
                         case 11:   m.add(-100, 100);
                            a=m.input;
     
                       newresult =f.Pathological(a);
                  
                       break;
                         case 12:  m.add(0, Math.PI);
                       a=m.input;
             
                      newresult =f.Michalewicz(a);
                  
                       break;
                         case 13: 
                     m.add(-30,30);
                       a=m.input;
                     newresult =f.Masters(a);
                   
                       break;
                         case 14:  m.add(-100, 100);
                            a=m.input;
                       newresult =f.Quartic(a);
                    
                       break;
                         case 15: m.add(-10,100);
                       a=m.input;
   
                       
                       newresult =f.Levy(a);
                
                       break;
                         case 16:   m.add(-100, 100);
                            a=m.input;
                       newresult =f.Step(a);
                      
                       break;
                         case 17:  m.add(-512, 512);
                       a=m.input;

                       newresult =f.Alpine(a);
                       break;
         }
     return newresult;
    }
    }
       

    
     

