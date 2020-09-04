
package flowshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author JuneYeob Lee(2462 9603)
 * * \class \NEH
 * NEH was published in 1983, and over the past 20 years.
 * 
 * This class is for NEH algorithm to get optimized sequence of jobs
 * 
 * \date 5/27/2019
 * !\Contact:Leej @cwu.edu
 * !\Created on: 5/24/2019
 */

public class NEH extends FlowShop{
    // Create Random object
    Random rand = new Random();
    
    /**Step1 method calculate total processing time for each machine
     * 
     * @param a initial processing time from data file.
     * @return  sums of their total processing times
     */
    public int[] Step1 (int[][] a){
   int[] T = new int[a[0].length];
   
        for( int j =0;j<a[0].length;j++){
            int sum =0;
            for( int i =0;i<a.length;i++){
             sum+= a[i][j];
         }
            T[j] = sum;
     }   
        return T;
    }
    /**
     * Step2 arrange in decreasing total processing time
     * @param a sums of their total processing time 
     * @return  sequence with arrange first two jobs
     */
    public int [] Step2(int[] a){
        int[] copy = new int[a.length];
        int[] sequence = new int[a.length];
        for( int i =0;i<a.length;i++){
            copy[i] = a[i];
        }
        Arrays.sort(copy);
                for( int i =a.length-1;i>=0;i--){
                     for( int j =0;j<a.length;j++){
                         int k =i;
                         if( copy[i] == a[j]){
                             sequence[a.length-1-k] = j;
                         }
        }
        
    }
                return sequence;
}
    /**
     * Step 3 method  arrange first two jobs by shorter makespan.
     * @param a initial processing time from file.
     * @param sequence  sequence in decreasing time.
     * @return sequence which only arrange first two jobs.
     */
    public int [] Step3(int[][] a,int[]sequence){
       int[][] temp= new int [a.length][2];
       int[][] temp1= new int[a.length][2];
      
            for( int i =0;i<a.length;i++){
                temp[i][0] = a[i][sequence[0]];
                temp[i][1] = a[i][sequence[1]];
                 temp1[i][0] = a[i][sequence[1]];
                temp1[i][1] = a[i][sequence[0]];
            }
        if(makespan(Completion(temp))>makespan(Completion(temp1))){
            int tem = sequence[0];
            sequence[0] = sequence[1];
            sequence[1] = tem;
        }
        return sequence;
    }
    /**
     * Step 4 method arrange jobs with best sequence
     * @param a initial processing time.
     * @param sequence  sequence from step 3
     * @return optimized sequence
     */
    public int [] Step4(int[][] a, int[] sequence){
      // create arraylist 
        ArrayList<Integer> best = new ArrayList<Integer>();
      // add first two jobs 
        best.add(sequence[0]);
      best.add(sequence[1]);
      // set min make span
      int minComp=0;
      // create best sequence array
   int []bestseq= new int[sequence.length];
      int[][] temp;
      int k=2;
      while(k<sequence.length){     
          temp = new int[a.length][k+1];
          for( int i =0;i<=k;i++){
              best.add(i,sequence[k]);
             
              if(i==0){
                  for( int j =0;j<k+1;j++){
                      bestseq[j] = best.get(j);
                  }

                  for( int j =0;j<best.size();j++){
                  for( int l =0;l<a.length;l++){
                      temp[l][j] = a[l][best.get(j)];
                  }
                  }
                  minComp = makespan(Completion(temp)); 
    
                 best.remove(i);
          
              }
              
              else {  
                   for( int j =0;j<k+1;j++){
                  for( int l =0;l<a.length;l++){
                      temp[l][j] = a[l][best.get(j)];
                  }
                  }
                   int x =makespan(Completion(temp));
                 if( minComp > x){
                       for( int j =0;j<k+1;j++){
                      bestseq[j] = best.get(j);
                  }

                        minComp = x;        
                 }
                 else if(minComp ==x){
                     int r = rand.nextInt(2);
                     if(r==0){
                             for( int j =0;j<k+1;j++){
                      bestseq[j] = best.get(j);
                  }
                   
                        minComp = x; 
                         
                     }
                    
                 }
                
                    
                  best.remove(i);         
                 
                 }

          }
                      best.clear();
                 for( int h=0;h<k+1;h++){
                best.add(bestseq[h]);
                 }   

          
          k++;
         
      }

      return bestseq;
    }
    /**
     * best method is for arrange processing time with best sequence of jobs.
     * @param a is initial processing time array
     * @param bestseq   The best sequence of jobs
     * @return  processing time with best job sequence
     */
    public int[][] best(int[][]a,int[] bestseq){
       int[][] best = new int [a.length][bestseq.length];
        for( int i =0;i<a.length;i++){
            for(int j =0;j<bestseq.length;j++){
                best[i][j] =a[i][j];
            }
        }
       
        for( int j=0;j<bestseq.length;j++){
            for( int i =0;i<a.length;i++){
                best[i][j] = a[i][bestseq[j]];
            }
        }
        return best;
    }
}
