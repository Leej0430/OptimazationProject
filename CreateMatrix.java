
package optimazation.pkg1;



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
     * @param length length of input matrix
     * @param size  size of input matrix
    */ 
    public void create(int length, int size){

        input= new double[length][size];
        siz = size;
    }
       /** A add method
     //!this method will fill out input with random numbers( this method will create 7 files which
     * @param min lower bound for input
     * @param max   upper bound for input
    */ 
    public void add(double min, double max) {


        for (double[] input1 : input) {
            for (int j = 0; j < siz; j++) {
                // generate random number which is between min and max
                input1[j] = min+rnd.nextDouble()*(max-min);
            }
        }
        
       
    }




   

    
}
