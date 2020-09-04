 
package optimazation.pkg1;


//import FileNotFoundException,IOException.and unsupportedEncodingExceiption
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
/**
 * 
 * @author JuneYeob Lee
 * RandomWalk calss which generated the best fitness for 18 solutions. 
 * randomly pick the solution, iterate 30 times for 18 functions.
 */




public class RandomWalk  {
   
/** This method is used for blind search. minumum iterate 30 times each time it generate random 
 * integer from Mersenne Twister. 
 * 
 * @param itr iteration time.
 * @param length numbers of input vectors(at least 30).
 * @param size size of input it should be 10 or 20 or 30.
 * @param f functioning object which has funct method to get the result of 18 functions.
 * @return This method return the bestfitness for 18 functions at least 30 times iterations. 
 * @throws FileNotFoundException
 * @throws UnsupportedEncodingException
 * @throws IOException 
 */
     
    public double[][] randomWalk(int itr,int length,int size,Functioning f) throws FileNotFoundException, UnsupportedEncodingException, IOException  {
        
//Create  Mersenne Twister object
           MTRandom r = new MTRandom();
// return 2d array for return value           
        double[][] bestSolution=new double[18][1];
//count to default value of best Solution
        int count=0;
double[][] re = new double[18][length];
        //for loop for iteration( from user input)
        for(int i =0;i<itr;i++){
            
//generate result value for every iteration.            
for(int k =0;k<18;k++){        
 re[k] = f.funct(k,length, size);
}
        // set the random number for each iteration
           int rand = r.nextInt(length);
        // set the boolean value is true until cannot find better value.   
           boolean t=true;
            while(t==true){
                            for( int j=0;j<18;j++){

                                 if(count==0){
                                  
                                    bestSolution[j][0]=re[j][rand];

                                   t=false;
                                     
                                }
                                else{

                                 if(bestSolution[j][0]>=re[j][rand]){
                                        bestSolution[j][0]=re[j][rand];   
                                              t=false;
                                    }
                               t=false;
                                }
                    
            }
                            //increment count after set the default value for bestSolution array
                                      count++;
            }
       }

        return bestSolution;
    }


    
}


