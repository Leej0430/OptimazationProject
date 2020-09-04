
package flowshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author JuneYeob Lee(2462 9603)
 * * \class \FileRead
 * 
 * 
 * 
 * 
 * This class is for read txt file and create 2d array of processing time.

 * 
 * \date 5/27/2019
 * !\Contact:Leej @cwu.edu
 * !\Created on: 5/24/2019
 */

public class FileRead {
    //number of machines
    int nMachine;
    // number of jobs
    int nJob;
    // array for processing time
    int[][]processingTime;
    /**
     * 
     * @param x name of the data file
     * @throws FileNotFoundException
     * @throws IOException 
     */
  public void read(String x) throws FileNotFoundException, IOException{  
      // create file object
  File file = new File(x);
  // create scanner object
  Scanner sc = new Scanner(file);
 // get the number of machines from file.
  nMachine=sc.nextInt();
  // get the number of jobs from file
  nJob=sc.nextInt();
  // get the processing time from data file
  processingTime = new int[nMachine][nJob];

for( int i =0;i<nMachine;i++){
    for( int j =0;j<nJob;j++){
        processingTime[i][j]= sc.nextInt();
    }
}
}
}
