/** @author JuneYeob Lee(24629603)
 * \class Optimization1
 * \ingroup optimization
 * 
 * 
 * 
 * This class is for main method.
 * 
 * 
 * 
 * @date 5/17/2019
 * Contact:Leej @cwu.edu
 * Created on: 5/17/2019
 * 
 *
 */
package optimazation.pkg1;

//! import Scanner class
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


//! Optimization1 class
public class Main {
    
    /**Main function will 
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    
    public static void main(String[] args) throws FileNotFoundException, IOException   {
  //Implement PSO algorithm
    PSO();
      //Implement Ff algorithm
    Ff(); 
    // Implement HS algorithm
  HS();       

        }

    /**
     * PSO algorithm implement Particle Swarm Optimization Algorithm
     * @throws IOException 
     */
    public static void PSO() throws IOException  {
        //Create CreateCSV object
        CreateCSV csv = new CreateCSV();
        //Create Scanner object
        Scanner sc = new Scanner (System.in);
        //get the user input
        System.out.println("size of population?");
        int NP = sc.nextInt();
        System.out.println("problem dimension?");
        int DIM = sc.nextInt();
        System.out.println("Number of generation?");
        int generation = sc.nextInt();
        System.out.println("Function Number?(0~17)");
        int fNum = sc.nextInt();
        // result array for CSV file
        double[][] result = new double[500][2];
        // create PSO object with user input
        PSO p = new PSO(fNum,NP,DIM);
        //initialize g Best value
        p.InitialgBest();
        // start time
      long startTime = System.nanoTime();
      //array for all particles
      double[][] x = new double[250000][30];
        for( int i =0;i<generation;i++){
            //update velocity
         p.updateVelocity();
         //update particles
         p.updateParticles();
         // compare new particle's solution and personal best 
         p.compare( p.calculate());
         result[i][0]=p.gBest(p.pBest);
       
         //save all the populations
         for( int l=0;l<500;l++){
             for( int k =0;k<30;k++){
             x[i*l][k]=p.particles[l][k];}
         }
       
        System.out.println("");
        System.out.println("Generation "+i+" "+p.gBest(p.pBest));
        }
        long endTime = System.nanoTime();

long duration = (endTime - startTime)/1000000;
        //CSV file for PSO algorithm
        csv.CreateCsv1(result, "PSO Function ("+duration+")"+ Integer.toString(fNum)+"c1,c2,k "+Double.toString(p.c1)+", "+Double.toString(p.c2)+", "+Double.toString(p.k));
       //SAVE all the particles
        csv.CreateCsv1(x,"stagnationPSO");
        System.out.println("\n");

    // }
    }
    
    /**
     * Ff method implement Fireflies Algorithm
     * @throws IOException 
     */
    public static void Ff() throws IOException{
        //Create createCSV object
         CreateCSV csv = new CreateCSV();
         // Create Scanner Object
               Scanner sc = new Scanner (System.in);
               //get user inputs
        System.out.println("size of population?");
        int NP = sc.nextInt();
        System.out.println("problem dimension?");
        int DIM = sc.nextInt();
        System.out.println("Number of generation?");
        int generation = sc.nextInt(); 
        System.out.println("Function Number?(0~17)");
        int fNum = sc.nextInt();

//Create Firefly object with user input
      Firefly f = new Firefly(fNum,NP,DIM);
      // result array for CSV file
     double[][] result = new double[500][2];
    //initialize the global best value and worst value
     f.calc();
        //array for all fireflies
           double[][] x = new double[250000][30];
           long startTime = System.nanoTime();
    for( int k=0;k<generation;k++){          

            for( int i =0;i<NP;i++){
                                         
                for ( int j =0;j<NP;j++){
                    if(f.fitness[i]>f.fitness[j]){
                        // calculate distance
                           f.caldistance(i,j);
                           // calculate attractiveness
                           f.calattract(i, j);
                         // implement equation4
                           f.equation4(i,j);
                          //evaluate and update the worst fireflies
                            f. evaluate();
                         
                    }
                           
                }
                
                     
            }
                  for( int l=0;l<500;l++){
             for( int b =0;b<30;b++){
             x[k*l][b]=f.fireflies[l][b];}
         }
            
            f.calc();
            //print global best value and person best value
                    System.out.println("Generation "+ k+"   "+f.gbest+"  ** "+f.worst);
                       result[k][0]=f.gbest;result[k][1] = f.worst;
                       //Create csv file for HS algorithm

    }
    long endTime = System.nanoTime();

long duration = (endTime - startTime)/1000000;
 //Create csv file for HS algorithm
  csv.CreateCsv1(result, "Ff Function("+duration+")"+ Integer.toString(fNum)+"c1,c2,k "+Double.toString(f.alpha)+", "+Double.toString(f.Beta)+", "+Double.toString(f.g));
      csv.CreateCsv1(x,"stagnationFA");
    }
    /**
     * HS method implement Harmony search Algorithm
     * @throws IOException 
     */
    public static void HS() throws IOException{
             //Create createCSV object
         CreateCSV csv = new CreateCSV();
         // Create Scanner Object
               Scanner sc = new Scanner (System.in);
               
               //get user input
        System.out.println("size of population?");
        int NP = sc.nextInt();
        System.out.println("problem dimension?");
        int DIM = sc.nextInt();
        System.out.println("Number of generation?");
        int NI= sc.nextInt(); 
       System.out.println("Function Number?(0~17)");
        int fNum = sc.nextInt();
        // create HS object with user input.
        HS h = new HS (fNum,NP,DIM);
        //result array for CSV file   
        double[][] result = new double[500][2];
        int i =0;
        int j =0;
        
              long startTime = System.nanoTime();
              // 2d arrray to save all the harmonies
             double[][] x = new double[250000][30];     
        while(i<NI){
            // sort Harmonies with ascending order
         h.sortHarmony();
         //improvise
            h.improvise();
            // convert new harmony if it is better than worst harmony
           h.convert();
           // set the globest and worst harmony solution
            h.last();
           
            result[i][0]=h.best;result[i][1] = h.worst;
             // save all the harmonies
                     for( int l=0;l<500;l++){
           for( int k =0;k<30;k++){
             x[i*l][k]=h.harmony[l][k];}
         }
            i++;

 System.out.println("Generation "+ i+"   "+h.best+"   "+h.worst+"   ");
        }
        long endTime = System.nanoTime();

long duration = (endTime - startTime)/1000000;
        // Create CSV file for HS algorithm
        csv.CreateCsv1(result, "HS Function("+duration+")"+ Integer.toString(fNum)+"HCMR,PAR, bw "+Double.toString(h.HMCR)+", "+Double.toString(h.PAR)+", "+Double.toString(h.bw)); 
                csv.CreateCsv1(x,"stagnationHS");
    }
    
}


