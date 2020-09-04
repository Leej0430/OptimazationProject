
package optimazation.pkg1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 
 * @author JuneYeob Lee
 * Local Search Algorithm class 
 * This class should deal with FileNot FoundException, IOException and Unsupported Encoding 
 * Exception
 * 
 */


public class LocalSearch {
    /**
     * This method is made for local search algorithm.
     *  First set the initial solutions for 18 functions but it's not best because it's picked randomly
     *  this method will find the local minimum solution or global minimum.(in the neighbor area.)
     *  it will iterate until the standing point is smaller that left or right.
     * @param length (number of input rows)
     * @param size   (number of input colums)
     * @param f     (functioning object)
     * @return Best solution for Local Search
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws IOException 
     */
    public double[][] LocalSearch(int length,int size,Functioning f) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        //create MerssenTwister.
        MTRandom r = new MTRandom();
        // create 2d array for the return value
        double[][] bestSolution=new double[18][1];
        double[][] re=new double[18][length];
        // generate result 2d array to 
        for( int i =0;i<18;i++){   
         re[i] = f.funct(i,length, size);
        }//pick the random number for solution    
               int rand = r.nextInt(length);             
                
               // set the default best Solution. 
                            for( int i=0;i<18;i++){
                                    bestSolution[i][0]=re[i][rand];
                                    
                                }

// for 18 functions 0~17
for(int j =0;j<18;j++){
                    // generate random number for each functions solution
                     rand = r.nextInt(length);
                     
    boolean t= true;
    //until there is no minum value in neighbor area.
    while(t==true){                             
    t= false;
                                      // check if randomly pick right most solution
                                       if(rand==length-1){
                                           
                                           if(re[j][rand]>re[j][rand-1]){
                                               if(bestSolution[j][0]>re[j][rand-1]){ 
                                               bestSolution[j][0]=re[j][rand-1];}
                                           }
                                           

                                       }
                                       else if(rand==0){
                                           if(re[j][rand]>re[j][rand+1]){
                                               
                                               if(bestSolution[j][0]>re[j][rand+1]){
                                                bestSolution[j][0]=re[j][rand+1];}
                                       
                                           }
                                       }
                                       else 
                                           { if(re[j][rand-1]<bestSolution[j][0]){
                                            bestSolution[j][0]=re[j][rand-1];
                                       }
                                       if(re[j][rand+1]<bestSolution[j][0]){
                                           bestSolution[j][0]=re[j][rand+1];
                                       }
                                                
                                       }
            }

         
}
   return bestSolution;      
}
    
 

}