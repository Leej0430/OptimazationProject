
package optimazation.pkg1;


/**
 *
 * @author JuneYeob Lee(24629603)
 * Functions class is composed with 18 functions
 * * \date 4/5/2019
 * Contact:Leej @cwu.edu
 * Created on: 3/28/2019
 */

public class Functions {
    //! double[][] result 
    double[][] result;
    // double sum
    double sum;
    
/**
 * Schwefel method
 * input range[-512,512]
 * expect global minimum = 0
 * @param a (input matrix)
 */

    public void Schwefel(double[][] a){
          sum=0;
    long start = System.nanoTime();
        for(int i =0;i<a.length;i++)
        {
           for( int j =0; j < a[i].length; j++)
           {
               sum += -a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j])));
           }
         result[0][i]= (double) ((418.9829*a[i].length) -sum);
       }  
        long stop = System.nanoTime();
        result[18][0]=(double)(stop-start)/100000;
       
    }
    
/**
 * DeJong 1 function
 * Range [-100,100]
 * expected minimum =0
 * @param a (input matrix)
 */
    public void DeJong(double[][] a){
          sum=0;
     long start = System.nanoTime();
        for(int i =0; i<a.length; i++)
        {
           for( int j =0; j<a[i].length; j++){
                sum += Math.pow(a[i][j],2);
           }
            result[1][i] = sum ;
        }           
                long stop = System.nanoTime();
  result[18][1]=(double)(stop-start)/100000;
        

    }
/**
 * Rosenbrock's Saddle function
 * Range[-100,100]
 * expected global minimum =0
 * @param a (input matrix)
 */
    public void Rosenbrock(double[][] a){
      sum=0;
            long start = System.nanoTime();
        for(int i =0; i<a.length;i++)
        {
            for( int j =0;j<a[i].length-1;j++){
            sum += 100*(Math.pow(Math.pow(a[i][j],2)-a[i][j+1],2))+Math.pow(1-a[i][j],2);
            }
            result[2][i] = sum;
        }
                long stop = System.nanoTime();
  result[18][2]=(double)(stop-start)/100000;
        
    }
/**
 * Rastrigin function
 * Range[-30,30]
 * expectedglobal minimum =0
 * @param a (input matrix)
 */
    public void Rastrigin(double[][] a){
        sum=0;
           long start = System.nanoTime();
        for( int i =0; i<a.length;i++)
        {
            for( int j =0; j<a[i].length;j++)
            {
              sum += Math.pow(a[i][j],2) - 10* Math.cos(2*(double)Math.PI*a[i][j]);
            }
            result[3][i] = 10*a[i].length*sum;
        }
                long stop = System.nanoTime();
    result[18][3]=(double)(stop-start)/100000;
    }
/**
 *Griewangk function
 * Range[-500,500]
 * expected global minimum =0
 * @param a (input matrix)
 */
    public void Griewangk(double[][] a){
         sum=0;
            long start = System.nanoTime();
        double mul = 0;
        
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length;j++)
            {
            sum += Math.pow(a[i][j],2)/4000;
            mul *= Math.cos(a[i][j]/Math.sqrt(j+1));
            }
            result[4][i] = 1+ sum -mul;
        }
                long stop = System.nanoTime();
        result[18][4]=(double)(stop-start)/100000;
    }
/**Sine Envelope Sine Wave 
 *  Range[-30,30]
 * expected global minimum =-1.4915(n-1) when n is size of input matrix
 * @param a (input matrix)
 */
    public void SineEnvelope(double[][] a){
         sum=0;
            long start = System.nanoTime();
        for( int i =0;i<a.length; i++){
            for( int j =0;j<a[i].length-1;j++){
            sum += -0.5 + Math.pow(Math.sin(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)-0.5),2);
            }
            result[5][i] = sum;
        }
                long stop = System.nanoTime();
   result[18][5]=(double)(stop-start)/100000;
        
    }
/**
 * StretchedV
 *  Range[-30,30]
 * expected global minimum = 0
 * @param a (input matrix)
 */
    public void StretchedV(double[][] a){
          sum=0;
          long start = System.nanoTime();
        for( int i =0; i<a.length;i++){
            for( int j =0;j<a[i].length-1;j++){
                sum += Math.pow(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2),1/4)*Math.sin(Math.pow(Math.pow(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2),1/10),2))+1;
            }
            result[6][i]=sum;
        }
                long stop = System.nanoTime();
      result[18][6]=(double)(stop-start)/100000;
    }
/**
 * Ackley One Function
 *  *  Range[-32,32]
 * expected global minimum = -7.54276-2.91867(n-3)
 * @param a (input matrix)
 */
    public void Ackley1(double[][] a){
         sum=0;
           long start = System.nanoTime();
        for( int i =0;i<a.length;i++){
            for( int j =0;j<a[i].length-1;j++){
                sum += (1/Math.pow(Math.E,0.2))*Math.sqrt(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2))+3*(Math.cos(2*a[i][j])+Math.sin(2*a[i][j+1]));
            }
            result[7][i]=sum;
        }
                long stop = System.nanoTime();
        result[18][7]=(double)(stop-start)/100000;
    }
/**
 * Ackley Two function
 *  Range[-32,32]
 * expected global minimum = 0
 * @param a (input matrix)
 */
    public void Ackely2(double[][] a){
        sum=0;
            long start = System.nanoTime();   
        for( int i =0;i<a.length;i++){
            for( int j =0;j<a[i].length-1;j++){
               sum += 20+ Math.E - 20/(Math.pow(Math.E, 0.2*(Math.sqrt((Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2))/2))))-Math.pow(Math.E, 0.5*(Math.cos(2*Math.PI*a[i][j])+Math.cos(2*Math.PI*a[i][j+1])));
            }
            result[8][i]=sum;
        }
                   long stop = System.nanoTime();
    result[18][8]=(double)(stop-start)/100000;
        
    }
/**
 * EggHolder
 * Range[-500,500]
 * expected global minimum none
 * @param a (input matrix)
 */
    public void EggHolder(double[][] a){
        sum=0;
            long start = System.nanoTime();
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length-1;j++)
            {
                sum += -a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j]-a[i][j+1]-47)))-(a[i][j+1]+47)*Math.sin(Math.sqrt(Math.abs(a[i][j+1]+47+a[i][j]/2)));
            }
            result[9][i]=sum;
        }
                  long stop = System.nanoTime();
        result[18][9]=(double)(stop-start)/100000;
        
    }
    /**
     * Rana function
     * Range[-500,500]
     * expected global minimum =none
     * @param a (input matrix)
     */
    public void Rana(double[][] a){
        sum=0;
        long start = System.nanoTime();
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length-1;j++)
            {
               sum += a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j+1]-a[i][j]+1)))*Math.cos(Math.sqrt(Math.abs(a[i][j+1]+a[i][j]+1)))+(a[i][j+1]+1)*Math.cos(Math.sqrt(Math.abs(a[i][j+1]-a[i][j]+1)))*Math.sin(Math.sqrt(Math.abs(a[i][j+1]+a[i][j]+1)));
            }
            result[10][i]=sum;
        }
            long stop = System.nanoTime();
         result[18][10]=(double)(stop-start)/100000;
        
    }
/**
 * Pathological function
 *  Range[-100,100]
 * expected global minimum = none
 * @param a (input matrix)
 */
    public void Pathological(double[][] a){
        sum=0;
           long start = System.nanoTime();
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length-1;j++)
            {
             sum += 0.5 + (Math.sin(Math.pow(Math.sqrt(100*Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)),2))-0.5)/(1+0.001*(Math.pow(Math.pow(a[i][j],2)-2*a[i][j]*a[i][j+1]+Math.pow(a[i][j+1],2),2)));
            }
            result[11][i]=sum;
        }
                 long stop = System.nanoTime();
        result[18][11]=(double)(stop-start)/100000;
        
    }
/**
 * Michalewicz function
 *  Range[0,Pi]
 * expected global minimum = 0.996n when n is size of input matrix
 * @param a (input matrix)
 */ 
    public void Michalewicz(double[][] a){
        sum=0;
            long start = System.nanoTime();  
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length;j++)
            {
            sum+= -Math.sin(a[i][j])*Math.pow(Math.sin(j*Math.pow(a[i][j],2)/Math.PI),20);
            }
            result[12][i]=sum;
        }
                    long stop = System.nanoTime();
          result[18][12]=(double)(stop-start)/100000;
        
    }
 /**
 * Masters'Cosine Wave function
 *  Range[-30,30]
 * expected global minimum = 1-n when n is size of input matrix
 * @param a (input matrix)
 */
    public void Masters(double[][] a){
        sum=0;
            long start = System.nanoTime();    
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length-1;j++)
            {
           sum+= -Math.pow(Math.E,-(1/8)*(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)+0.5*a[i][j+1])*a[i][j])*Math.cos(4*Math.sqrt(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)+0.5*a[i][j]*a[i][j+1]));
            }
            result[13][i]=sum;
        }
                      long stop = System.nanoTime();
    result[18][13]=(double)(stop-start)/100000;
        
    }
 /**
 * Quartic function
 *  Range[-100,100]
 * expected global minimum = 0
 * @param a (input matrix)
 */
    public void Quartic(double[][] a){
            sum=0;
            long start = System.nanoTime();   
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length-1;j++)
            {
                sum+= j*Math.pow(a[i][j],4);
            }
            result[14][i]=sum;
        }
                      long stop = System.nanoTime();
result[18][14]=(double)(stop-start)/100000;
        
    }
/**
 * Levy function
 *  Range[-10,10]
 * expected global minimum = 0
 * @param a (input matrix)
 */
    public void Levy(double[][] a){
            sum=0;
           long start = System.nanoTime();
        double w;
              for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length-1;j++)
            {
                w=1+(a[i][j]-1)/4;
                sum+= (1+10*Math.pow(Math.sin(Math.PI*w+1),2))*Math.pow(w-1, 2)+(1+Math.pow(Math.sin(2*Math.PI*w),2))*Math.pow(w-1,2);
           
            }
            result[15][i]=a[0][0]+sum;
        }
                      long stop = System.nanoTime();
result[18][15]=(double)(stop-start)/100000;
    }
 /**
 * Step function
 *  Range[-100,100]
 * expected global minimum = 0
 * @param a (input matrix)
 */
    public void Step(double[][] a){
            sum=0;
            long start = System.nanoTime();     
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length;j++)
            {
            sum += Math.pow(Math.abs(a[i][j])+0.5,2);
            }
            result[16][i]=sum;
        }
                      long stop = System.nanoTime();
result[18][16]=(double)(stop-start)/100000;
    }
 /**
 * Alpine function
 *  Range[-100,100]
 * expected global minimum = 0
 * @param a (input matrix)
 */ 
    public void Alpine(double[][] a){
        sum=0;
            long start = System.nanoTime();     
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length;j++)
            {
            sum += Math.abs(a[i][j]*Math.sin(a[i][j])+0.1*a[i][j]);
            }
            result[17][i]=sum;
        }
                      long stop = System.nanoTime();
  result[18][17]=(double)(stop-start)/100000;


    }

}
