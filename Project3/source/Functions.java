 
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
  
public Functions(){
    
}    

    
public Functions(int populations){
    result=new double[18][populations];
}    
    
/**
 * Schwefel method
 * input range[-512,512]
 * expect global minimum = 0
 * @param a (input matrix)
 */
    public double[] Schwefel(double[][] a){
          sum=0;

        for(int i =0;i<a.length;i++)
        {
           for( int j =0; j < a[i].length; j++)
           {
               sum += -a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j])));
           }
         result[0][i]= (double) ((418.9829*a[i].length) -sum);
       }  
       return result[0];
    }
    
/**
 * DeJong 1 function
 * Range [-100,100]
 * expected minimum =0
 * @param a (input matrix)
 */
    public double[] DeJong(double[][] a){
          sum=0;

        for(int i =0; i<a.length; i++)
        {
           for( int j =0; j<a[i].length; j++){
                sum += Math.pow(a[i][j],2);
           }
            result[1][i] = sum ;
        }           
        return result[1];
    }
/**
 * Rosenbrock's Saddle function
 * Range[-100,100]
 * expected global minimum =0
 * @param a (input matrix)
 */
    public double[] Rosenbrock(double[][] a){
      sum=0;

        for(int i =0; i<a.length;i++)
        {
            for( int j =0;j<a[i].length-1;j++){
            sum += 100*(Math.pow(Math.pow(a[i][j],2)-a[i][j+1],2))+Math.pow(1-a[i][j],2);
            }
            result[2][i] = sum;
        }

        return result[2];
    }
/**
 * Rastrigin function
 * Range[-30,30]
 * expectedglobal minimum =0
 * @param a (input matrix)
 */
    public double[] Rastrigin(double[][] a){
        sum=0;

        for( int i =0; i<a.length;i++)
        {
            for( int j =0; j<a[i].length;j++)
            {
              sum += Math.pow(a[i][j],2) - 10* Math.cos(2*(double)Math.PI*a[i][j]);
            }
            result[3][i] = 10*a[i].length*sum;
        }
      return result[3];
    }
/**
 *Griewangk function
 * Range[-500,500]
 * expected global minimum =0
 * @param a (input matrix)
 */
    public double[] Griewangk(double[][] a){
         sum=0;

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
        return result[4];
    }
/**Sine Envelope Sine Wave 
 *  Range[-30,30]
 * expected global minimum =-1.4915(n-1) when n is size of input matrix
 * @param a (input matrix)
 */
    public double[] SineEnvelope(double[][] a){
         sum=0;

        for( int i =0;i<a.length; i++){
            for( int j =0;j<a[i].length-1;j++){
            sum += -0.5 + Math.pow(Math.sin(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)-0.5),2);
            }
            result[5][i] = sum;
        }

      return result[5];  
    }
/**
 * StretchedV
 *  Range[-30,30]
 * expected global minimum = 0
 * @param a (input matrix)
 */
    public double[] StretchedV(double[][] a){
          sum=0;

        for( int i =0; i<a.length;i++){
            for( int j =0;j<a[i].length-1;j++){
                sum += Math.pow(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2),1/4)*Math.sin(Math.pow(Math.pow(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2),1/10),2))+1;
            }
            result[6][i]=sum;
        }
        return result[6];
    }
/**
 * Ackley One Function
 *  *  Range[-32,32]
 * expected global minimum = -7.54276-2.91867(n-3)
 * @param a (input matrix)
 */
    public double[]  Ackley1(double[][] a){
         sum=0;
   
        for( int i =0;i<a.length;i++){
            for( int j =0;j<a[i].length-1;j++){
                sum += (1/Math.pow(Math.E,0.2))*Math.sqrt(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2))+3*(Math.cos(2*a[i][j])+Math.sin(2*a[i][j+1]));
            }
            result[7][i]=sum;
        }
        return result[7];
    }
/**
 * Ackley Two function
 *  Range[-32,32]
 * expected global minimum = 0
 * @param a (input matrix)
 */
    public double[]  Ackely2(double[][] a){
        sum=0;

        for( int i =0;i<a.length;i++){
            for( int j =0;j<a[i].length-1;j++){
               sum += 20+ Math.E - 20/(Math.pow(Math.E, 0.2*(Math.sqrt((Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2))/2))))-Math.pow(Math.E, 0.5*(Math.cos(2*Math.PI*a[i][j])+Math.cos(2*Math.PI*a[i][j+1])));
            }
            result[8][i]=sum;
        }
      return result[8];  
    }
/**
 * EggHolder
 * Range[-500,500]
 * expected global minimum none
 * @param a (input matrix)
 */
    public double[] EggHolder(double[][] a){
        sum=0;

        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length-1;j++)
            {
                sum += -a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j]-a[i][j+1]-47)))-(a[i][j+1]+47)*Math.sin(Math.sqrt(Math.abs(a[i][j+1]+47+a[i][j]/2)));
            }
            result[9][i]=sum;
        }

        return result[9];
    }
    /**
     * Rana function
     * Range[-500,500]
     * expected global minimum =none
     * @param a (input matrix)
     */
    public double[] Rana(double[][] a){
        sum=0;

        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length-1;j++)
            {
               sum += a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j+1]-a[i][j]+1)))*Math.cos(Math.sqrt(Math.abs(a[i][j+1]+a[i][j]+1)))+(a[i][j+1]+1)*Math.cos(Math.sqrt(Math.abs(a[i][j+1]-a[i][j]+1)))*Math.sin(Math.sqrt(Math.abs(a[i][j+1]+a[i][j]+1)));
            }
            result[10][i]=sum;
        }
        return result[10];
    }
/**
 * Pathological function
 *  Range[-100,100]
 * expected global minimum = none
 * @param a (input matrix)
 */
    public double[] Pathological(double[][] a){
        sum=0;
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length-1;j++)
            {
             sum += 0.5 + (Math.sin(Math.pow(Math.sqrt(100*Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)),2))-0.5)/(1+0.001*(Math.pow(Math.pow(a[i][j],2)-2*a[i][j]*a[i][j+1]+Math.pow(a[i][j+1],2),2)));
            }
            result[11][i]=sum;
        }
        return result[11];
    }
/**
 * Michalewicz function
 *  Range[0,Pi]
 * expected global minimum = 0.996n when n is size of input matrix
 * @param a (input matrix)
 */ 
    public double[] Michalewicz(double[][] a){
        sum=0;

        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length;j++)
            {
            sum+= -Math.sin(a[i][j])*Math.pow(Math.sin(j*Math.pow(a[i][j],2)/Math.PI),20);
            }
            result[12][i]=sum;
        }
return result[12];
        
    }
 /**
 * Masters'Cosine Wave function
 *  Range[-30,30]
 * expected global minimum = 1-n when n is size of input matrix
 * @param a (input matrix)
 */
    public double[] Masters(double[][] a){
        sum=0;
 
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length-1;j++)
            {
           sum+= -Math.pow(Math.E,-(1/8)*(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)+0.5*a[i][j+1])*a[i][j])*Math.cos(4*Math.sqrt(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)+0.5*a[i][j]*a[i][j+1]));
            }
            result[13][i]=sum;
        }
        return result[13];
    }
 /**
 * Quartic function
 *  Range[-100,100]
 * expected global minimum = 0
 * @param a (input matrix)
 */
    public double[] Quartic(double[][] a){
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

        return result[14];
    }
/**
 * Levy function
 *  Range[-10,10]
 * expected global minimum = 0
 * @param a (input matrix)
 */
    public double[]Levy(double[][] a){
            sum=0;
    
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
return result[15];
    }
 /**
 * Step function
 *  Range[-100,100]
 * expected global minimum = 0
 * @param a (input matrix)
 */
    public double[] Step(double[][] a){
            sum=0;
  
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length;j++)
            {
            sum += Math.pow(Math.abs(a[i][j])+0.5,2);
            }
            result[16][i]=sum;
        }
return result[16];
    }
 /**
 * Alpine function
 *  Range[-100,100]
 * expected global minimum = 0
 * @param a (input matrix)
 */ 
    public double[]Alpine(double[][] a){
        sum=0;
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<a[i].length;j++)
            {
            sum += Math.abs(a[i][j]*Math.sin(a[i][j])+0.1*a[i][j]);
            }
            result[17][i]=sum;
        }

return result[17];
    }

}
