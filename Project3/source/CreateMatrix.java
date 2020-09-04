
package optimazation.pkg1;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author JuneYeob Lee(24629603)
 * * \date 4/5/2019
 * \Contact:Leej @cwu.edu
 * \Created on: 3/28/2019
 */
//! CreateMatrix class
public class CreateMatrix  {
    int siz;
    //Mersen Twister Object creation
    MTRandom rnd = new MTRandom();
    double[][] input ;

    // A constructor(default)        
    public CreateMatrix(){
        
    }
    //! A constructor.
    /*!
      @param int a the first argument(rows) 
      @param int b the second argument(colums) 
    */
    public CreateMatrix(int a, int b){
    create(a,b);
    }
    /** A create method
   /*! this method will create input 2d arrays with all 0.0
    *@param int length for first parameter(length)
      *@param int size for second parameter(size)
    */ 
    public void create(int length, int size){

        input= new double[length][size];
        siz = size;
    }
       /** A add method
     //!this method will fill out input with random numbers( this method will create 7 files which 
    
    *@param double min for first parameter( minimum range for random number)
      !@param double max for second parameter(Maximum range for random number)
     
    */ 
    public void add(double min, double max) throws FileNotFoundException, UnsupportedEncodingException{

   
            for (double[] input1 : input) {
                for (int j = 0; j < input1.length; j++) {
                    // generate random number which is between min and max
                    double randf = min+rnd.nextDouble()*(max-min);
                    input1[j] = randf;
                    
                }
               
            }
        
       
    }




   

    
}
