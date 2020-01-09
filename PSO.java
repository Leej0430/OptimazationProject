/**
 *
 * @author JuneYeob Lee(24629603)
 * * \date 5/17/2019
 * Contact:Leej @cwu.edu
 * Created on: 5/17/2019
 */
package optimazation.pkg1;

import java.util.Arrays;
/**
 *  Particle Swarm Optimization class file.
 * This class for implementing PSO algorithm.
 * PSO is one of meta-heuristics. It is inspired by animal which is schooling or flocking.
 * PSO is invented by Russell Eberhart and James Kennedy in 1995
 * 
 */


public class PSO  {
    //particles 2Darray
    double[][] particles;
    // velocity 2Darray
    double[][] velocity;
   // array for personal best
    double[] pBest;
    double gBest;
    double best;
    int NP;
    int DIM;
    int fNum;
    //upper bound
    double upper;
    // lower bound
    double lowe;
    double c1=0.1;
    double c2=0.6;
    // constant value to control velocity
    double k =0.001;
    // create MTRandom object
    MTRandom m = new MTRandom();
    // create Functioning Object
    Functioning f = new Functioning();    
    Algorithm a;
    /**
     * POS constructor
     * @param functionNum function number 0~17
     * @param NP    number of vectors
     * @param DIM   size of dimension
     */
   public PSO (int functionNum, int NP, int DIM){
       this.NP = NP;
       this .DIM = DIM;
       a= new Algorithm ( NP, DIM, functionNum);
      upper = a.upper;
      lowe = a.lower;
      CreateMatrix cm = new CreateMatrix();
      cm.create(NP, DIM);
      cm.add(0, 0.5*(a.upper-a.lower));
      particles = a.population;
      velocity   =  cm.input;
        pBest = a.result;
       fNum = functionNum;
   } 

   /**
    * initial gBest method for initialize the global best value. 
    */
   public void InitialgBest(){
      double[] copy = pBest;
      Arrays.sort(copy);
       double lower=0;

        lower = copy[0];
      this.gBest = lower;
   }
   /**
    * updateVelocity method for update Velocity.
    */
   public void updateVelocity(){
       for( int i =0;i<NP;i++){
           for( int j =0;j<DIM;j++){
              this. velocity[i][j] = k*(this.velocity[i][j]+ this.c1*m.nextDouble()*(this.pBest[i]-this.particles[i][j])+this.c2*m.nextDouble()*(this.gBest-this.particles[i][j]));
               
           }
       }

   }
   /**
    * 
    updateParticles method to update particles and check swarm boundary.
    */
   public void updateParticles(){
        for( int i =0;i<NP;i++){
           for( int j =0;j<DIM;j++){
                this.particles[i][j]= (this.particles[i][j]+this.velocity[i][j]);
                               if(this.particles[i][j]<lowe){
                    this.particles[i][j]=lowe;
                }
                else if (this.particles[i][j]>upper){
                    this.particles[i][j]=upper;
                }
          }
       
        }


    
   
   }
   /**
    * calculate method to calculate updated particles
    * @return result array for specific function 
    */
   public double[] calculate(){

       return     f.cal(fNum, NP, DIM,this.particles);
   }
   
   /**
    * compare method to compare  pbest and new fitness of updated particles 
    * @param a result of updated particles 
    */
    public void compare(double[]a){
        for( int i =0;i<a.length;i++){
            if( a[i]<this.pBest[i]){
            pBest[i]=a[i];
            }
        }
    }
    /**
     * gBest method to calculate new global best value.
     * @param a new pBest
     * @return  global best value
     */
    public double gBest(double[]a){
        double[]copy = a;
        Arrays.sort(copy);
        best = copy[0];
        
            if(gBest>best){
                gBest = best;
            }
       
            
        return gBest;
    }
    
}
