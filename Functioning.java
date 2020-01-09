
package optimazation.pkg1;


/**
 *
 * @author JuneYeob Lee(24629603)
 * \This Functioning class has made to implement  all 18 functions by ranges.
 * * \date 4/5/2019
 * Contact:Leej @cwu.edu
 * Created on: 3/28/2019
 */
//! Functioning class
public class Functioning  {
           
/**
 * Cal method for calculate 18 functions about 2D Matrix
 * @param functionNum Function number
 * @param length    number of populations
 * @param size      size of dimension
 * @param a         input 2d Matrix
 * @return  Return result array for specific function.
 */
 public double[] cal(int functionNum,int length,int size,double[][] a) {
           //Create Functions object
   Functions f = new Functions(length,size);
   double[] re = new double[length] ;
   
   // switch statement to implement 18 functions
     switch(functionNum){
                   case 0: 
                    
                       re =f.Schwefel(a);
                       
                       break;
                         case 1: 
                        
                       re =f.DeJong(a);
                       break;
                         case 2: 
                        
                       re =f.Rosenbrock(a);
                       break;
                         case 3: 
                   

                       re =f.Rastrigin(a);

                       break;
                         case 4: 
                             
               
                       re =f.Griewangk(a);
      
                       break;
                         case 5:     
                    
                      re =f.SineEnvelope(a);
                 
                       break;
                         case 6:      
                 
                       re =f.StretchedV(a);
                   
                       break;
                         case 7: 
                  
                       re =f.Ackley1(a);
                       
                       break;
                         case 8: 
                 
                       re =f.Ackely2(a);
                    
                       break;
                         case 9:  
                      re =f.EggHolder(a);
                     
                       break;
                         case 10:  

                       re =f.Rana(a);  
          
                       break;
                         case 11:  
     
                       re =f.Pathological(a);
                  
                       break;
                         case 12: 
             
                      re =f.Michalewicz(a);
                  
                       break;
                         case 13: 
                     
                     re =f.Masters(a);
                   
                       break;
                         case 14:  
                       re =f.Quartic(a);
                    
                       break;
                         case 15: 
   
                       
                       re =f.Levy(a);
                
                       break;
                         case 16:  
                       re =f.Step(a);
                      
                       break;
                         case 17:  

                       re =f.Alpine(a);
                       break;
         }
     
     // return result
     return re;
    }
    }
       

    
     

