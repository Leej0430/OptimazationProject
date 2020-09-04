/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimazation.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;



/**
 *
 * @author lljjy
 */
public class CreateCSV  {
   
    public void CreateCsv(double[][] a){
       double[] av= new double[a.length-1];
       double[] variance = new double[a.length-1];
       double[] min = new double[a.length-1];
       double[] max = new double[a.length-1];
       double [] med = new double[ a.length-1];
       double [][] copy = a;
 
        
       
    
       
       
        try(PrintWriter writer = new PrintWriter(new File("result.csv"))){
        StringBuilder sb = new StringBuilder();
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
            av[i]=sum/18;
            variance[i]=var/18 -Math.pow(av[i],2);
            min[i] = copy[i][0];
            max[i] = copy[i][a[i].length-1];
            med[i] = copy[i][a[i].length/2];
        } 
           
        sb.append("f(x)"+','+"average"+','+"SD(Standard Devation)"+','+"Range"+','+ "Median"+','+ "Time(ms)\n");
        sb.append("Schwefel"+','+av[0]+','+variance[0]+','+min[0]+"~ "+max[0]+','+med[0]+','+a[18][0]);
        sb.append("\nDe Jong 1"+','+av[1]+','+variance[1]+','+min[1]+"~ "+max[1]+','+med[1]+','+a[18][1]);
        sb.append("\nRosenbrock's Saddle"+','+av[2]+','+variance[2]+','+min[2]+"~ "+max[2]+','+med[2]+','+a[18][2]);
        sb.append("\nRastrigin"+','+av[3]+','+variance[3]+','+min[3]+"~ "+max[3]+','+med[3]+','+a[18][3]);
        sb.append("\nGriewangk"+','+av[4]+','+variance[4]+','+min[4]+"~ "+max[4]+','+med[4]+','+a[18][4]); 
        sb.append("\nSine Envelope Sine Wave"+','+av[5]+','+variance[5]+','+min[5]+"~ "+max[5]+','+med[5]+','+a[18][5]);
        sb.append("\nStretch V Sine Wave"+','+av[6]+','+variance[6]+','+min[6]+"~ "+max[6]+','+med[6]+','+a[18][6]);
        sb.append("\nAckley One"+','+av[7]+','+variance[7]+','+min[7]+"~ "+max[7]+','+med[7]+','+a[18][7]);
        sb.append("\nAckley Two"+','+av[8]+','+variance[8]+','+min[8]+"~ "+max[8]+','+med[8]+','+a[18][8]);
        sb.append("\nEgg Holder"+','+av[9]+','+variance[9]+','+min[9]+"~ "+max[9]+','+med[9]+','+a[18][9]); 
        sb.append("\nRana"+','+av[10]+','+variance[10]+','+min[10]+"~ "+max[10]+','+med[10]+','+a[18][10]);
        sb.append("\nPathological"+','+av[11]+','+variance[11]+','+min[11]+"~ "+max[11]+','+med[11]+','+a[18][11]);
        sb.append("\nMichalewicz"+','+av[12]+','+variance[12]+','+min[12]+"~ "+max[12]+','+med[12]+','+a[18][12]);
        sb.append("\nMaster's Cosine Wave"+','+av[13]+','+variance[13]+','+min[13]+"~ "+max[13]+','+med[13]+','+a[18][13]);
        sb.append("\nQuartic"+','+av[14]+','+variance[14]+','+min[0]+"~ "+max[14]+','+med[14]+','+a[18][14]);
        sb.append("\nLevy"+','+av[15]+','+variance[15]+','+min[0]+"~ "+max[15]+','+med[15]+','+a[18][15]);
        sb.append("\nStep"+','+av[16]+','+variance[16]+','+min[0]+"~ "+max[16]+','+med[16]+','+a[18][16]);
        sb.append("\nAlpine"+','+av[17]+','+variance[17]+','+min[0]+"~ "+max[17]+','+med[17]+','+a[18][17]);
     
 
 

        
        writer.write(sb.toString());
    }
    catch(FileNotFoundException e){
        System.out.println(e.getMessage());
    }
    }


}
