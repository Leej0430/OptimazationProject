
package optimazation.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;



/**
 *
 * @author JuneYeob Lee(2462 9603)
 * * \class \CreateCSV
 * \ingroup optimization
 * 
 * 
 * 
 * This class is for creating CSV file about results

 * 
 * \date 4/5/2019
 * !\Contact:Leej @cwu.edu
 * !\Created on: 3/28/2019
 */
//! CreateCSV class
public class CreateCSV  {

/**
 * CreateCsv0 method for creating the csv file of the best Vectors
 * @param a (a for the best solution);
 * @param colums (the number of colums)
 * @param C
 * @throws IOException 
 */
    public void CreateCsv0(double[][] a,int colums, String C) throws IOException {
      try( PrintWriter writer = new PrintWriter(new File(C))){  
        StringBuilder sb = new StringBuilder();
          sb.append("   Best Solution "+','+"\n");
          for( int i =0;i<a.length;i++){
      sb.append("f(x").append(i+1).append(") = ").append(String.format("%.4f",a[i][0])).append(',');
 
      sb.append("\n");
    }
             writer.write(sb.toString());
    }
      
       catch(FileNotFoundException e){
        System.out.println(e.getMessage());
    }
      
}
    /**CreateCsv method to create the csv file for best solutions
     * 
     * @param a(the best solutions 2d array length should be 18 size should be the number of iteration)
     * @param C (File name)
     * @throws IOException 
     */
    public void CreateCsv1(double[][]a,String C)throws IOException{
          try( PrintWriter writer = new PrintWriter(new File(C))){  
        StringBuilder sb = new StringBuilder();

          for( int i =0;i<a.length;i++){
   // sb.append("Generation").append(i+1).append(",");
      for(int j=0;j<a[i].length;j++){
     sb.append(a[i][j]).append(',');    
      }
      sb.append("\n");
    }
             writer.write(sb.toString());
    }
      
       catch(FileNotFoundException e){
        System.out.println(e.getMessage());
    }
      
}
        
    }


