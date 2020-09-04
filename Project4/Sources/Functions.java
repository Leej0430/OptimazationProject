 
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
    double sum;
    int size;
    int populations;
public Functions(){
    
}    

    
public Functions(int populations,int size){
    this.populations = populations;
    this. size = size;
}    
    
/**
 * Schwefel method
 * input range[-512,512]
 * expect global minimum = 0
 * @param a (input matrix)
     * @return result
 */
    public double[] Schwefel(double[][] a){
          
          double[] cresult = new double[a.length];
        for(int i =0;i<a.length;i++)
        {   sum=0;

           for( int j =0; j < size; j++)
           {
               sum += (-1*a[i][j])*Math.sin(Math.sqrt(Math.abs(a[i][j])));
    
           }

        cresult[i] = (418.9829*(double)size)-sum; 
        
       }  
       return cresult;

    }
    
/**
 * DeJong 1 function
 * Range [-100,100]
 * expected minimum =0
 * @param a (input matrix)
     * @return result
 */
    public double[] DeJong(double[][] a){
          
   double[] cresult = new double[a.length];
        for(int i =0; i<a.length; i++)
        {
               sum=0;
           for( int j =0; j<size; j++){
                sum += Math.pow(a[i][j],2);
           }
            cresult[i] = sum ;
             
        }           
        return cresult;
    }
/**
 * Rosenbrock's Saddle function
 * Range[-100,100]
 * expected global minimum =0
 * @param a (input matrix)
     * @return result
 */
    public double[] Rosenbrock(double[][] a){
     
   double[] cresult = new double[a.length];
        for(int i =0; i<a.length;i++)
        {
               sum=0;
            for( int j =0;j<size-1;j++){
            sum += 100*(Math.pow(Math.pow(a[i][j],2)-a[i][j+1],2))+Math.pow(1-a[i][j],2);
            }
            cresult[i] = sum;
        
        }

        return cresult;
    }
/**
 * Rastrigin function
 * Range[-30,30]
 * expectedglobal minimum =0
 * @param a (input matrix)
     * @return result
 */
    public double[] Rastrigin(double[][] a){
        
   double[] cresult = new double[a.length];
        for( int i =0; i<a.length;i++)
        {
               sum=0;
            for( int j =0; j<size;j++)
            {
              sum += Math.pow(a[i][j],2) - 10* Math.cos(2*(double)Math.PI*a[i][j]);
            }
           cresult[i] = 10*size*sum;
         
        }
      return cresult;
    }
/**
 *Griewangk function
 * Range[-500,500]
 * expected global minimum =0
 * @param a (input matrix)
     * @return  result
 */
    public double[] Griewangk(double[][] a){
         
   double[] cresult = new double[a.length];
        double mul = 0;
        
        for( int i =0; i<a.length; i++)
        {
               sum=0;
            for( int j =0;j<size;j++)
            {
            sum += Math.pow(a[i][j],2)/4000;
            mul *= Math.cos(a[i][j]/Math.sqrt(j+1));
            }
            cresult[i] = 1+ sum -mul;
        
        }
        return cresult;
    }
/**Sine Envelope Sine Wave 
 *  Range[-30,30]
 * expected global minimum =-1.4915(n-1) when n is size of input matrix
 * @param a (input matrix)
 */
    public double[] SineEnvelope(double[][] a){
         
   double[] cresult = new double[a.length];
        for( int i =0;i<a.length; i++){
               sum=0;
            for( int j =0;j<size-1;j++){
            sum += 0.5 + Math.sin(Math.pow(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)-0.5, 2));
            }
            cresult[i] = -sum;
        
        }

      return cresult;  
    }
/**
 * StretchedV
 *  Range[-30,30]
 * expected global minimum = 0
 * @param a (input matrix)
     * @return  result
 */
    public double[] StretchedV(double[][] a){
          
   double[] cresult = new double[a.length];
        for( int i =0; i<a.length;i++){
               sum=0;
            for( int j =0;j<size-1;j++){
                sum += Math.pow(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2),1/4)*Math.sin(Math.pow(Math.pow(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2),1/10),2))+1;
            }
            cresult[i]=sum;
        }
        return cresult;
    }
/**
 * Ackley One Function
 *  *  Range[-32,32]
 * expected global minimum = -7.54276-2.91867(n-3)
 * @param a (input matrix)
     * @return result
 */
    public double[]  Ackley1(double[][] a){
         
      double[] cresult = new double[a.length];
        for( int i =0;i<a.length;i++){
               sum=0;
            for( int j =0;j<size-1;j++){
                sum += (1/Math.pow(Math.E,0.2))*Math.sqrt(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2))+3*(Math.cos(2*a[i][j])+Math.sin(2*a[i][j+1]));
            }
            cresult[i]=sum;
        
        }
        return cresult;
    }
/**
 * Ackley Two function
 *  Range[-32,32]
 * expected global minimum = 0
 * @param a (input matrix)
     * @return result
 */
    public double[]  Ackely2(double[][] a){
        
   double[] cresult = new double[a.length];
        for( int i =0;i<a.length;i++){
               sum=0;
            for( int j =0;j<size-1;j++){
               sum += 20+ Math.E - 20/(Math.pow(Math.E, 0.2*(Math.sqrt((Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2))/2))))-Math.pow(Math.E, 0.5*(Math.cos(2*Math.PI*a[i][j])+Math.cos(2*Math.PI*a[i][j+1])));
            }
             cresult[i]=sum;
        
        }
      return cresult;  
    }
/**
 * EggHolder
 * Range[-500,500]
 * expected global minimum none
 * @param a (input matrix)
     * @return result
 */
    public double[] EggHolder(double[][] a){
     
   double[] cresult = new double[a.length];
        for( int i =0; i<a.length; i++)
        {
               sum=0;
            for( int j =0;j<size-1;j++)
            {
                sum += -a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j]-a[i][j+1]-47)))-(a[i][j+1]+47)*Math.sin(Math.sqrt(Math.abs(a[i][j+1]+47+a[i][j]/2)));
            }
            cresult[i]=sum;
         
        }

        return cresult;
    }
    /**
     * Rana function
     * Range[-500,500]
     * expected global minimum =none
     * @param a (input matrix)
     */
    public double[] Rana(double[][] a){
       
   double[] cresult = new double[a.length];
        for( int i =0; i<a.length; i++)
        {
               sum=0;
            for( int j =0;j<size-1;j++)
            {
               sum += a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j+1]-a[i][j]+1)))*Math.cos(Math.sqrt(Math.abs(a[i][j+1]+a[i][j]+1)))+(a[i][j+1]+1)*Math.cos(Math.sqrt(Math.abs(a[i][j+1]-a[i][j]+1)))*Math.sin(Math.sqrt(Math.abs(a[i][j+1]+a[i][j]+1)));
            }
            cresult[i]=sum;
        
        }
        return cresult;
    }
/**
 * Pathological function
 *  Range[-100,100]
 * expected global minimum = none
 * @param a (input matrix)
     * @return result
 */
    public double[] Pathological(double[][] a){
   
           double[] cresult = new double[a.length];
        for( int i =0; i<a.length; i++)
        {   sum=0;
            for( int j =0;j<size-1;j++)
            {
             sum += 0.5 + (Math.sin(Math.pow(Math.sqrt(100*Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)),2))-0.5)/(1+0.001*(Math.pow(Math.pow(a[i][j],2)-2*a[i][j]*a[i][j+1]+Math.pow(a[i][j+1],2),2)));
            }
           cresult[i]=sum;
         
        }
        return cresult;
    }
/**
 * Michalewicz function
 *  Range[0,Pi]
 * expected global minimum = 0.996n when n is size of input matrix
 * @param a (input matrix)
     * @return result
 */ 
    public double[] Michalewicz(double[][] a){
        
   double[] cresult = new double[a.length];
        for( int i =0; i<a.length; i++)
        {
               sum=0;
            for( int j =0;j<size;j++)
            {
            sum+= Math.sin(a[i][j])*Math.pow(Math.sin(j*Math.pow(a[i][j],2)/Math.PI),20);
            }
            cresult[i]=-sum;
      
        }
return cresult;
        
    }
 /**
 * Masters'Cosine Wave function
 *  Range[-30,30]
 * expected global minimum = 1-n when n is size of input matrix
 * @param a (input matrix)
     * @return result
 */
    public double[] Masters(double[][] a){
     
    double[] cresult = new double[a.length];
        for( int i =0; i<a.length; i++)
        {
               sum=0;
            for( int j =0;j<size-1;j++)
            {
           sum+= -Math.pow(Math.E,-(1/8)*(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)+0.5*a[i][j+1])*a[i][j])*Math.cos(4*Math.sqrt(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)+0.5*a[i][j]*a[i][j+1]));
            }
            cresult[i]=sum;
        
        }
        return cresult;
    }
 /**
 * Quartic function
 *  Range[-100,100]
 * expected global minimum = 0
 * @param a (input matrix)
     * @return result
 */
    public double[] Quartic(double[][] a){
         
               double[] cresult = new double[a.length];
            
        for( int i =0; i<a.length; i++)
        {
               sum=0;
            for( int j =0;j<size-1;j++)
            {
                sum+= j*Math.pow(a[i][j],4);
            }
           cresult[i]=sum;
         
        }
                   

        return cresult;
    }
/**
 * Levy function
 *  Range[-10,10]
 * expected global minimum = 0
 * @param a (input matrix)
     * @return result
 */
    public double[]Levy(double[][] a){
         
       double[] cresult = new double[a.length];
        double w;
              for( int i =0; i<a.length; i++)
        {
            sum=0;
            w=0;
            for( int j =0;j<size-1;j++)
            {
                w=1+(a[i][j]-1)/4;
                sum+= (1+10*Math.pow(Math.sin(Math.PI*w+1),2))*Math.pow(w-1, 2)+(1+Math.pow(Math.sin(2*Math.PI*w),2))*Math.pow(w-1,2);
           
            }
            cresult[i]=a[0][0]+sum;
    
        }
return cresult;
    }
 /**
 * Step function
 *  Range[-100,100]
 * expected global minimum = 0
 * @param a (input matrix)
     * @return result
 */
    public double[] Step(double[][] a){
           
     double[] cresult = new double[a.length];
        for( int i =0; i<a.length; i++)
        {
            sum=0;
            for( int j =0;j<size;j++)
            {
            sum += Math.pow(Math.abs(a[i][j])+0.5,2);
            }
            cresult[i]=sum;
       
        }
return cresult;
    }
 /**
 * Alpine function
 *  Range[-100,100]
 * expected global minimum = 0
 * @param a (input matrix)
     * @return result
 */ 
    public double[]Alpine(double[][] a){
        
           double[] cresult = new double[a.length];
        for( int i =0; i<a.length; i++)
        {
            sum=0;
            for( int j =0;j<size;j++)
            {
            sum += Math.abs(a[i][j]*Math.sin(a[i][j])+0.1*a[i][j]);
            }
            cresult[i]=sum;
        
        }

return cresult;
    }

}
