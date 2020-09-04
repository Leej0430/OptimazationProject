/** @author JuneYeob Lee(24629603)
 * \class Optimization1
 * \ingroup optimization
 * 
 * \main
 * 
 * This class is for main method.
 * 
 * 
 * 
 * @date 5/2/2019
 * Contact:Leej @cwu.edu
 * Created on: 4/26/2019
 *
 */
package optimazation.pkg1;
    /**
     * Algorithm class has 11 methods for Genetic Algorithm and Differential Evolution Algorithm.
     * * 
     */

public class Algorithm {

   // Internal state
    int best;
    //Create mers
    MTRandom mr = new MTRandom();
    // input 2d Matrix
    double[][] population;
    //result after implement function
    double[] result;
    // number of populations
    int populations;
    // size of vector
    int chromazoms;
    // upper bound
    double upper;
    // lower bound
    double lower;
   // Constant values.
    //0.85
    double crmin =0.85;
    //0.95
    double crmax=0.95;
    //0.005
    double mutationRate =0.005;
    //0.1
    double mutationRange =0.1;
    Functions f;
/**
 *  * The constructor for Genetic Algorithm and Differential Algorithm.
     *  Create initialize populations. and calculate by function which has been chosen.
 * @param rows number of populations
 * @param colums    size of Dimension
 * @param functNum  implement function number
 */
    
    public Algorithm(int rows, int colums,int functNum) {
       //Create Functions Object
        f = new Functions(rows,colums);
        // set the number of populations
        populations = rows;
        // set the size of vector
        chromazoms = colums;
// Create CreateMatrix object.
      CreateMatrix c = new CreateMatrix(populations,chromazoms);
      //create input matrix
      c.create(populations,chromazoms);
      
      // switch statement to implement functions
               switch(functNum){
                   case 0: 
                       upper=512;
                       lower=-512;
                       c.add(lower,upper);
                       population=c.input;
                       result =f.Schwefel(population);
                       
                       break;
                         case 1: 
                       upper=100;
                       lower=-100;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.DeJong(population);
                       
                       break;
                         case 2: 
                          upper=100;
                       lower=-100;
                       c.add(lower,upper);
                       population=c.input;
                       result =f.Rosenbrock(population);
                       
                       break;
                         case 3: 
                          upper=30;
                       lower=-30;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Rastrigin(population);
                       
                       break;
                         case 4: 
                          upper=500;
                       lower=-500;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Griewangk(population);

                       break;
                         case 5: 
                          upper=30;
                       lower=-30;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.SineEnvelope(population);

                       break;
                         case 6: 
                          upper=30;
                       lower=-30;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.StretchedV(population);

                       break;
                         case 7: 
                                                upper=32;
                       lower=-32;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Ackley1(population);
                        
                       break;
                         case 8: 
                         upper=32;
                       lower=-32;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Ackely2(population);
                        
                       break;
                         case 9: 
                        upper=500;
                       lower=-500;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.EggHolder(population);
                         
                       break;
                         case 10: 
                       upper=500;
                       lower=-500;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Rana(population);  
                      
                       break;
                         case 11: 
                              upper=100;
                       lower=-100;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Pathological(population);

                       break;
                         case 12: 
                          upper=Math.PI;
                       lower=0;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Michalewicz(population);

                       break;
                         case 13: 
                       upper=30;
                       lower=-30;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Masters(population);
                          
                       break;
                         case 14: 
                       upper=100;
                       lower=-100;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Quartic(population);
                          
                       break;
                         case 15: 
                        upper=10;
                       lower=-10;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Levy(population);
                         
                       break;
                         case 16: 
                         upper=100;
                       lower=-100;
                             c.add(lower,upper );
                       population=c.input;
                       result =f.Step(population);
                        
                       break;
                         case 17: 
                         upper=100;
                       lower=-100;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Alpine(population);
                        
                       break; 
         }

    }
 }


       
     
   

  

   

