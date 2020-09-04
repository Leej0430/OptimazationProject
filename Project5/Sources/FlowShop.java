
package flowshop;
/**
 *
 * @author JuneYeob Lee(2462 9603)
 * * \class \FlowShop
 * 
 * 
 * 
 * 
 * This class is for Folow Shop Scheduling

 * 
 * \date 5/27/2019
 * !\Contact:Leej @cwu.edu
 * !\Created on: 5/24/2019
 */
public class FlowShop {
    /**
     * Completion method calculate completion time with processing time with Flow shop scheduling.
     * @param a initial processing time with best sequence from NEH.
     * @return return completion time array
     */
    public int[][] Completion(int[][]a){
      int[][] com= a;
        for( int i =0;i<com.length-1;i++){
         for(int j =0;j<com[i].length-1;j++){
                if(i==0){
                    com[i][j+1]=com[i][j]+a[i][j+1];
                }
                if(j==0){
                    com[i+1][j] = com[i][j]+a[i+1][j];
                }
         
                    
         }        
      }
                for( int i =1;i<com.length;i++){
         for(int j =1;j<com[i].length;j++){
      com[i][j]=Math.max(com[i-1][j],com[i][j-1])+a[i][j];
                    
         }        
      }

        return com;
    }
    /**
     * Makesapn method return make span value. 
     * @param a completion time array
     * @return  makespan value
     */
    public int makespan(int[][] a){
       
        return a[a.length-1][a[0].length-1];
    }

    
}
