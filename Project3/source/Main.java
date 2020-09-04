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
 * @date 4/5/2019
 * Contact:Leej @cwu.edu
 * Created on: 3/28/2019
 *
 */
package optimazation.pkg1;

//! import Scanner class
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


//! Optimization1 class
public class Main {
    
    /**Main function will 
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    
    public static void main(String[] args) throws FileNotFoundException, IOException   {

        GeneticAlgorithms();
       
        System.out.println("**************************");
      // DifferentialEvolution();
   
        }

    //Algorithms implement 3 algorithms x iteration times to get best result for 18 functions

    public static void Algorithms() throws UnsupportedEncodingException, IOException{
           //Create Functioning object which name is a
    Functioning f = new Functioning();
    //Create CreateCSV object
    CreateCSV csv = new CreateCSV();   

    //Create Scanner object.
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter the number of rows (At least 30)");
    //get the  input length from user.
    int b = sc.nextInt();
    
     System.out.println("Enter the number of colums (10 or 20 or 30)");
    //get the input size from user.
    int c= sc.nextInt();
    
    System.out.println("How many time you want iterate for RandomWalk and IterativeLocalSearch");
    //get the iteration time from user.
   int a = sc.nextInt();
   
   
    RandomWalk x = new RandomWalk();   
    LocalSearch y = new LocalSearch();
    long start = System.nanoTime();     
    double[][] random=x.randomWalk(c, a,b, f);
   long stop = System.nanoTime();
   long start1 = System.nanoTime();
    double[][] localsearch =y.LocalSearch( b,c, f);
    long stop1= System.nanoTime();
    IterativeLocalSearch l = new IterativeLocalSearch();
    
    long start2= System.nanoTime();
    double[][] iter= l.IterativeLocalSearch( y,a,b, c, f);
    long stop2= System.nanoTime();
    
    
        //create CSV files for the bestsolutions of 3Algorithms
         csv.CreateCsv0(random, c, "RandomWalk(iter1)size"+Integer.toString(c));
         csv.CreateCsv0(  localsearch, c, "Local(iter1)size"+Integer.toString(c));
         csv.CreateCsv0( iter,c, "IterativeLocal(iter1)size"+Integer.toString(c));
        
        //output of execution time for three algorthm  
        System.out.println("Time"+(double)(stop-start)/100000);
        System.out.println("Time"+(double)(stop1-start1)/100000);
        System.out.println("Time"+(double)(stop2-start2)/100000);
    }
    // implement Genetic Algorithm
    public static void  GeneticAlgorithms() throws FileNotFoundException, FileNotFoundException, UnsupportedEncodingException, IOException{
       CreateCSV c = new CreateCSV();
       
        Scanner sc = new Scanner(System.in);
        System.out.println("size of population?");
        int NS = sc.nextInt();
        System.out.println("problem dimension?");
        int DIM = sc.nextInt();
        System.out.println("Number of generation?");
        int generation = sc.nextInt();

        System.out.println("cross over 1 or 2?");
        int ncr =sc.nextInt();
        int Elitism = (int) (0.2*NS);
        double[][] a = new double[18][NS];
for(int functionNum=0;functionNum<18;functionNum++){

        int i=0;
        //initilize new population
         Algorithm ga = new Algorithm(NS,DIM,functionNum);
        while(i<generation){
           
            //case for 1 crossover point
            if(ncr==1){     
            for(int s=0;s<NS;s+=2){
             ga.select(ga.population);   
             //ga.tournament(ga.population);
              ga.crossover(ga.selected[0],ga.selected[1],1);
              ga.mutate(ga.crossover,ga.upper, ga.lower);
             ga.newpopulation[s]=ga.mutation[0];
              ga.newpopulation[s+1]=ga.mutation[1];
           }
            }
            else{
                //case for 2 crossover points.
for(int s=0;s<NS;s+=6){
     ga.select(ga.population); 
              //ga.tournament(ga.population);
              ga.crossover(ga.selected[0],ga.selected[1],2);
              ga.mutate(ga.crossover,ga.upper, ga.lower);
           
            for( int k =0;k<6;k++){
              if( s >=NS-2){
                 
              }  
              else{ga.newpopulation[s+k]=ga.mutation[k];}
            }
            
}
            }

            
            ga.reduce(ga.population,ga.newpopulation,Elitism,functionNum);

////get best solution
            if(ga.result[0]<=ga.newresult[0]){
System.out.print(ga.result[0]+"    ");
a[functionNum][i]=ga.result[0];
}
else {System.out.print(ga.newresult[0]+"   ");
            a[functionNum][i]=ga.newresult[0];}
            


        
i++;
        }
       System.out.println("");    

    }
c.CreateCsv1(a, "GA");
    }
    // To implement DifferentialEvolution Algorithm.
    public static void DifferentialEvolution() throws FileNotFoundException, UnsupportedEncodingException, IOException{
       CreateCSV c = new CreateCSV();

        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner (System.in);
        System.out.println("size of population?");
        int NS = sc.nextInt();
        System.out.println("problem dimension?");
        int DIM = sc.nextInt();
        System.out.println("Number of generation?");
        int generation = sc.nextInt();
        System.out.println("exponential crossover =1 binomial crossover =2");
        int exbin = sc.nextInt();
        System.out.println("Strategy Number");
        int strategy = sc.nextInt();
        double F;
        System.out.println("F [1.0~2.0]");
        F= sc.nextDouble();
        double[][] a = new double[18][NS];
for(int functionNum=0;functionNum<18;functionNum++){
      
        int i=0;
         Algorithm ga = new Algorithm(NS,DIM,functionNum);
        while(i<generation){    
            //mutate and recombine
        ga.newpopulation= ga.mutateandRecombine(ga.population,F,functionNum,exbin,strategy);
          
            System.out.print(ga.calc(ga.newpopulation, functionNum)+"    ");
            a[functionNum][i]=    ga.calc(ga.newpopulation, functionNum);  
            i++;
        }
             System.out.println("");
    }
c.CreateCsv1(a, "DE");
    }
}


