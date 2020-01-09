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
    
    //! main method
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    
    public static void main(String[] args) throws FileNotFoundException, IOException   {
  
        //Create Functioning object which name is a
    Functioning a = new Functioning();
        
    //Create CreateCSV object which name c
        CreateCSV c = new CreateCSV();

        //Create Scanner object
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter the number of rows (At least 30)");
    
    int rows = sc.nextInt();
    
     System.out.println("Enter the number of colums (10 or 20 or 30)");
    
    int colums= sc.nextInt();
    
    System.out.println("How many time you want iterate for RandomWalk and IterativeLocalSearch");

   int iteration = sc.nextInt();
 

      RandomWalk x = new RandomWalk();   
    LocalSearch y = new LocalSearch();
      long start = System.nanoTime();     
    x.randomWalk(iteration, rows,colums, a);
     long stop = System.nanoTime();
        long start1 = System.nanoTime();
    double[][] localsearch =y.LocalSearch( rows, colums, a);
         long stop1= System.nanoTime();
    IterativeLocalSearch l = new IterativeLocalSearch();
      y.LocalSearch( rows, colums, a);
              long start2= System.nanoTime();
    l.IterativeLocalSearch( y,iteration,rows, colums, a);
          long stop2= System.nanoTime();

          c.CreateCsv0(x.randomWalk(iteration, rows,colums, a), colums, "RandomWalk(iter1)size"+Integer.toString(colums));
          c.CreateCsv0(  y.LocalSearch( rows, colums, a), colums, "Local(iter1)size"+Integer.toString(colums));
          c.CreateCsv0( l.IterativeLocalSearch( y,iteration,rows, colums, a), colums, "IterativeLocal(iter1)size"+Integer.toString(colums));
        System.out.println("Time"+(double)(stop-start)/100000);
        System.out.println("Time"+(double)(stop1-start1)/100000);
        System.out.println("Time"+(double)(stop2-start2)/100000);
    }
    }


