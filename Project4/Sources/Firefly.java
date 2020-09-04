/**
 *
 * @author JuneYeob Lee(24629603)
 * * \date 5/17/2019
 * Contact:Leej @cwu.edu
 * Created on: 5/17/2019
 *
 * 
 * 
 *
 */
package optimazation.pkg1;

import java.util.Arrays;
/**
 *This class is FireFly algorithm class.
 *  This class to implement FireFlies algorithm
 *FA is a new swarm intelligence algorithm which is developed by Yamg in 2010. It is inspired by the social behavior of fireflies is cohesioning to brighter light.
 * 
 */

public class Firefly {
    
    double[][] fireflies;
    double[] nfireflies;
    // fitness for fireflies
    double [] fitness;
    // distance array
    double[][] distance;
    //attractiveness array
    double[][] attractiveness;
    int NP;
    int DIM;
    int fNUM;
    double newVal;
    //best firefky found
    double gbest;
   double worst;
    //upper bound
    double upper;
    // lower bound
    double lower;
    double alpha =0.5;
    double Beta = 0.2;
    double g = 1;
    Algorithm a ;
    MTRandom m = new MTRandom();
    Functioning f = new Functioning();
    /**
     * constructor which parameters are function number and number of population and size of vector.
     * @param functionNum  implement function number
     * @param NP            number of fireflies
     * @param DIM           size of input dimension
     */
    public Firefly(int functionNum, int NP, int DIM){
        
        this.NP = NP;
        this.DIM = DIM;
        fNUM =functionNum;
        //create Algorithm object
        a = new Algorithm(NP,DIM, functionNum);
        // set the upper bound
        this.upper = a.upper;
        // set the lower bound
        this.lower = a.lower;
        //initialize the fireflies
        fireflies = a.population;
        nfireflies = new double[DIM];
        fitness = f.cal(functionNum, NP, DIM, fireflies);
        distance = new double[NP][NP];
        attractiveness = new double[NP][NP];
       
    }

    
    /** 
     * caldistance method is to calculate the distance between two fireflies.
     * @param i 
     * @param j 
     */
    public void caldistance(int i , int j){
    double sum=0;
        //calculate distance
        for( int k=0;k<DIM;k++){
            sum+= Math.pow(fireflies[i][k]-fireflies[j][k],2);
        }
        distance[i][j]=Math.sqrt(sum);
      
      
    } 
    /**
     * Calattract method to calculate attractivness 
     * @param i index number of row
     * @param j index number of colum
     */
    public void calattract(int i , int j){
        double sum=0;
        attractiveness[i][j]= Beta * Math.pow(Math.E,(-g)*Math.pow(distance[i][j], 2));
      
    }
    
    /**
     * equation4 to implement equation4 
     * @param i index number of row
     * @param j index number of colum
     */
    public void equation4(int i , int j ){
        double[][] copy = fireflies;
        //update fireflies
        for( int k =0;k<DIM;k++){
            nfireflies[k] = fireflies[i][k] + attractiveness[i][j]*(fireflies[j][k]-fireflies[i][k])+alpha*(m.nextDouble()-0.5)*(this.upper-this.lower);   
            
            // check particle swarm boundary
            if(nfireflies[k]<this.lower){
                nfireflies[k] = this.lower;
            }
            else if (nfireflies[k]>this.upper){
                nfireflies[k]=this.upper;
            }
        }
   
    }
 /**
  * evalute method.
  * evalute and update the worst firefly in populations
  */   
    public void evaluate(){
        double [][] temp = new double [1][DIM];
temp[0] = nfireflies;
double[] resultHM = f.cal(fNUM, NP, DIM, temp);
 newVal = resultHM[0];
 // worst firefly's place
 int worstIndex=0;
if(worst>resultHM[0]){
    for( int i =0;i<NP;i++){
    if( fitness[i]==worst){
        worstIndex =i;
        i=NP;
    }
}
            System.arraycopy(nfireflies, 0, fireflies[worstIndex], 0, DIM);
}

    }
    /**
     *  calc method to calculate the updated fireflies and update new gbest value.
     */
    public void calc(){
        //calculate update fire flies
 
        double[] copy = f.cal(fNUM, NP, DIM, fireflies);
        Arrays.sort(copy);
        gbest = copy[0];
        worst = copy[NP-1];

       
        }

    
}
