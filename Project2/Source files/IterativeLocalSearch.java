
package optimazation.pkg1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
/**
 *
 * @author JuneYeob Lee(24629603)
 * IterativLocalSearch is that find best solution of local search with iteration.
 * This class should deal with FileNot FoundException, IOException and Unsupported Encoding 
 * Exception 
 * 
 * 
 */


public class IterativeLocalSearch {
    /**
     * IterativeLocal search method to find best solution of the x times iterated local search
     *@param l (Local search object) 
     * @param itr (number of iteration
   * @param length (number of input rows)
     * @param size   (number of input colums)
     * @param f     (functioning object)
     * @return Best solution for Local Search
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException 
     */
        
    public double[][] IterativeLocalSearch( LocalSearch l,int itr,int length, int size, Functioning f) throws FileNotFoundException, UnsupportedEncodingException, IOException{

         // initialize the bestvalue with best solution from local search
        double [][] bestglobalitr=l.LocalSearch( length, size, f);
                                   System.out.println("Local Search");
                   for(int k=0;k<18;k++){
                       System.out.println(bestglobalitr[k][0]);
                   }
                   System.out.println("********************");
         MTRandom r = new MTRandom();
        int i =1;
    
        //itr local search n times
        while(i<itr+1){
            double[][] n =l.LocalSearch(length, size, f);
            for(int j=0;j<18;j++){
                if(bestglobalitr[j][0]>n[j][0]){
                    bestglobalitr[j][0]=n[j][0];
                }
                
            }

                             i++;    
            }

                    System.out.println("ITRLocal");
                   for(int k=0;k<18;k++){
                       System.out.println(bestglobalitr[k][0]);
                   }
                   return  bestglobalitr;              
        }
       
                            
    

    }
