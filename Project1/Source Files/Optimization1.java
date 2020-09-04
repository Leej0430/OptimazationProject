
package optimazation.pkg1;


import java.util.Scanner;



public class Optimization1 {

    /**
     * @param args the command line arguments
     */
    //main function
    public static void main(String[] args)   {

    Functioning a = new Functioning();
   
    CreateCSV c = new CreateCSV();
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter the number of rows (At least 30)");
    
    int rows = sc.nextInt();
    
    System.out.println("Enter the number of colums(10 or 20 or 30");
    
    int cols = sc.nextInt();
    
    double [][] result= a.funct(rows,cols);

    c.CreateCsv(result);
 

    }       
    }

