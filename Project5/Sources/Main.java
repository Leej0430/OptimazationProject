
package flowshop;


import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author JuneYeob Lee(2462 9603)
 * * \class Main
 * 
 * This class is for main to implement 3 Flow shop scheduling with NEH algorithm
 * 
 * \date 5/27/2019
 * !\Contact:Leej @cwu.edu
 * !\Created on: 5/24/2019
 */

public class Main {

    /** Main
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
      //Create FileRead object
        FileRead fr = new FileRead();
      //Create FlowShop object
        FlowShop ct = new FlowShop();
      // Create Blocking object
        Blocking bl = new Blocking();
        // Create Nowait object
        Nowait nw = new Nowait();
        // Create NEH object
        NEH n = new NEH();
        //Create CreateCSV object
        CreateCSV cc = new CreateCSV();
        
        // array for saving execution time
        long[][]result= new long [121][1];
        //create scanner object
        Scanner sc = new Scanner(System.in);
        Scanner scr = new Scanner(System.in);
        System.out.println("Type Data file number (1~120)");
        int i =sc.nextInt();
        System.out.println("What Algorithm (FSS =F, FSSB =B, FSSNW =N)");
        String a= scr.nextLine();
        
        fr.read(Integer.toString(i)+".txt");
        
        //set the timer
        long startTime = System.nanoTime();
        
    int[] b =n.Step2(n.Step1(fr.processingTime));
    
    int [] c = n.Step3(fr.processingTime, b);
    // d is best job order.
    int[] d = n.Step4(fr.processingTime, c);
    // rearrange processing time with best sequenct
    int[][] best = n.best(fr.processingTime, d);
    int [][] bestcom =best;

    //switch statement for user input algorithm
    switch(a){
        case "F":  bestcom = ct.Completion(best);
            break; 
            case"B":bestcom = bl.block(best);
                break; 
                case"N": bestcom = nw.noWait(best);
                    break;  
    }
   
    
    long stopTime = System.nanoTime();
    
    long elapsedTime = (stopTime - startTime)/1000000;


        System.out.println("Job sequence");
    for( int k =0;k<d.length;k++){
        int x = d[k]+1;
        if( k==d.length-1){
            System.out.print("Job "+x);
        }
        else{System.out.print("Job "+x+"- ");}
    }
       
    System.out.println("\nMakespan: "+bestcom[best.length-1][d.length-1]+"  ");
        System.out.println("Execution time: "+ elapsedTime+" milisecond");

        // CSV file for the gantt graph
        cc.CreateCsv1(bestcom,d,fr.processingTime,Integer.toString(i)+ "th Data Block");


    }
    
}
