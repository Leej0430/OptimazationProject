
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

  
    
    
    /** CreateCsv method
    //! this method will create csv file and calculate datas for csv file
    /**
     * @param a 2d array
     * @param rows 
     * @param b for the file name
     */

    public void CreateCsv(double[][] a,int rows, String b){
      
       double[] av= new double[a.length-1]; 
       double[] variance = new double[a.length-1];  
       double[] min = new double[a.length-1];   
       double[] max = new double[a.length-1];  
       double [] med = new double[ a.length-1]; 
       double [][] copy = a;                   
       // !handling File not found exception error
        try(PrintWriter writer = new PrintWriter(new File(b))){
         //Object creation
       
          StringBuilder sb = new StringBuilder();
          
          // for loop to store average, variance, min,max, med
           for( int i =0;i<a.length-1;i++){
              double sum=0;
              double var =0;
              double mi =a[0][0];
              double ma =0;
              Arrays.sort(copy[i]);
            for(int j =0;j<a[i].length;j++){
               sum += a[i][j];
               var += Math.pow(a[i][j],2);
               if(mi>a[i][j]){
               mi = a[i][j];
               }
               if(ma<a[i][j]){
                   ma = a[i][j];
               }
            }
            av[i]=sum/rows;
            variance[i]=var/rows -Math.pow(av[i],2);
            min[i] = copy[i][0];
            max[i] = copy[i][a[i].length-1];
            med[i] = copy[i][a[i].length/2];
        } 

     sb.append("f(x)"+','+"average  "+','+" SD(Standard Devation)"+','+" Range"+','+ "                       Median"+','+ "               Time(ms)\n");
for( int i =0;i<18;i++){

             sb.append("f(x)").append(i+1).append(',').append(String.format("%.4f",av[i])).append(',').append(String.format("%.4f",variance[i])).append(',').append(String.format("%.4f",min[i])).append("~ ").append(String.format("%.4f",max[i])).append(',').append(String.format("%.4f",med[i])).append(',').append(String.format("%.4f",a[18][i])).append("\n");            

}

        writer.write(sb.toString());
    }
        //! message if cannot find file
    catch(FileNotFoundException e){
        System.out.println(e.getMessage());
    }
    }
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
    sb.append("f(x").append(i+1).append(") = ");
      for(int j=0;j<a[i].length;j++){
     sb.append(a[i][j]).append(',');     //(String.format("%.4f",a[i][j])).append(',');
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


