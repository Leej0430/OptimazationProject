
package flowshop;
/**
 *
 * @author JuneYeob Lee(2462 9603)
 * * \class \noWait
* This class is for Flow Shop Scheduling with No-Wait
 * 
 * \date 5/27/2019
 * !\Contact:Leej @cwu.edu
 * !\Created on: 5/24/2019
 */
public class Nowait {
    /**
     * noWait method calculate completion time with processing time with Flow shop scheduling with No-Wait.
     * @param a initial processing time with best sequence from NEH.
     * @return  return to the completion time.
   */
  
    public int[][] noWait(int[][] a){
           
        int [][] copy = new int[a.length][a[0].length];
        
        for( int i=0;i<a.length;i++){
                     for( int j =0;j<a[0].length;j++){
                     copy[i][j]= a[i][j];
                     }
                    
                       }   
        int[][] nw=a; 

           
           for( int i =0;i<nw.length-1;i++){
               int j=0;
                    nw[i+1][j] = a[i][j]+a[i+1][j];
                
         }   
                 for(int j =1;j<nw[0].length;j++){
                  for( int i =0;i<nw.length;i++){
                     if( i==0){
                         nw[i][j] = nw[i][j-1]+a[i][j];
                     }
                     else{
                         if(nw[i-1][j]>=nw[i][j-1]){
                         nw[i][j] = nw[i-1][j]+a[i][j];
                     }
                     else{  
                            for(int k= 0;k<i;k++){
                              nw[k][j]+=  nw[i][j-1]-nw[i-1][j];
                            }
                          nw[i][j] = nw[i][j-1]+a[i][j];
                     }
                            
                     }
                     } 
      } 
                 for( int i=0;i<a.length;i++){
                     for( int j =0;j<a[0].length;j++){
                     nw[i][j]-= copy[i][j];
                     }
                    
                       }
           
           
           
         
      return nw;  
    }
}
