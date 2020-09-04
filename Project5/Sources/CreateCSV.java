package flowshop;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;



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
 * \date 5/27/2019
 * !\Contact:Leej @cwu.edu
 * !\Created on: 3/28/2019
 */
//! CreateCSV class
public class CreateCSV  {


    /**
     * Create CSV1 method create CSV file of completion time. 
     * @param a 2d array of completion time
     * @param b the best sequence of the jobs.
     * @param C name of the CSV file
     * @throws IOException 
     */
    public void CreateCsv1(int[][]a,int[] b,int[][] c,String C)throws IOException{
        int [][] sample = new int[a.length][b.length*2]; 
        try( PrintWriter writer = new PrintWriter(new File(C))){  
        StringBuilder sb = new StringBuilder();
        
        for( int i =0;i<a.length;i++){
            for( int j =0;j<(b.length);j++){

          sample[i][j*2+1] =c[i][b[j]];         
          sample[i][j*2]= a[i][j]-c[i][b[j]];
                
            }
        }
        
        for( int i =0;i<sample.length;i++){
            for( int j =0;j<sample[0].length;j++){
                if(j%2==0){
                
                    for( int k=j-1;k>=0;k--){
                     sample[i][j] -= sample[i][k];
                    }
                    
                }
            }
        }

        for( int i =0;i<b.length;i++){
                sb.append("Start").append(",").append("Job").append(b[i]+1).append(',');//.append("End").append(",");
        }
           sb.append("\n");
          for( int i =0;i<a.length;i++){

      for(int j=0;j<sample[i].length;j++){ 
          sb.append(sample[i][j]).append(',');

 
          
          }
      sb.append("\n");
    }
             writer.write(sb.toString());
    }
      
       catch(FileNotFoundException e){
        System.out.println(e.getMessage());
    }
      
}
    public void CreateCsv2(long[][]a,String C)throws IOException{
 
        try( PrintWriter writer = new PrintWriter(new File(C))){  
        StringBuilder sb = new StringBuilder();
        
     
        
     

        for( int i =0;i<1;i++){
                sb.append("Makespan").append(",");
        }
           sb.append("\n");
          for( int i =0;i<a.length;i++){

      for(int j=0;j<1;j++){ 
          sb.append(a[i][j]);

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


