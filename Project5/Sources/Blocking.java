
package flowshop;

/**
 *
 * @author JuneYeob Lee(2462 9603)
 * * \class \Blocking
 * 
 * 
 * 
 * 
 * This class is for Folow Shop with Blocking

 * 
 * \date 5/27/2019
 * !\Contact:Leej @cwu.edu
 * !\Created on: 5/24/2019
 */
public class Blocking {
    
  /**Block method calculate completion time with processing time with Flow Shop Blocking
   * 
   * @param a initial processing time with best sequence from NEH.
   * @return  return to the completion time.
   */
   public int[][] block(int[][] a){
     int[][] block = a;  
           for( int i =0;i<block.length-1;i++){
               int j=0;
                    block[i+1][j] = a[i][j]+a[i+1][j];
                
         }        
      
           
                    
         for(int j =1;j<block[0].length;j++){
                  for( int i =0;i<block.length;i++){
                     if( i==0){
                         block[i][j] = Math.max(block[i][j-1]+a[i][j], block[i+1][j-1]);
                     }
                     else if( i==block.length-1){
                         block[i][j] = Math.max(block[i-1][j], block[i][j-1])+a[i][j];
                     }
                     else{ block[i][j] = Math.max(Math.max(block[i-1][j], block[i][j-1])+block[i][j], block[i+1][j-1]);}
                  }        
                  
      }
     
         

           return block;
   }
}
