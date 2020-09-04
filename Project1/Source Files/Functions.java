
package optimazation.pkg1;



//function class
public class Functions  {
    Functioning f = new Functioning();
    double[][] result;
    double sum=0;


 // Schwefel function   
    public void Schwefel(double[][] a, int size){
    long start = System.nanoTime();
        for(int i =0;i<a.length;i++)
        {
           for( int j =0; j < size; j++)
           {
               sum += -a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j])));
           }
         result[0][i]= (double) ((418.9829*size) -sum);
       }  
        long stop = System.nanoTime();
        result[18][0]=stop-start;
       
    }
    
    // DeJong function
    public void DeJong(double[][] a,int size){
     long start = System.nanoTime();
        for(int i =0; i<a.length; i++)
        {
           for( int j =0; j<size; j++){
                sum += Math.pow(a[i][j],2);
           }
            result[1][i] = sum ;
        }           
                long stop = System.nanoTime();
  result[18][1]=stop-start;
        

    }
    //Rosenbrock function
    public void Rosenbrock(double[][] a, int size){
            long start = System.nanoTime();
        for(int i =0; i<a.length;i++)
        {
            for( int j =0;j<size-1;j++){
            sum += 100*(Math.pow(Math.pow(a[i][j],2)-a[i][j+1],2))+Math.pow(1-a[i][j],2);
            }
            result[2][i] = sum;
        }
                long stop = System.nanoTime();
  result[18][2]=stop-start;
        
    }
    //Rastrigin function
    public void Rastrigin(double[][] a, int size){
           long start = System.nanoTime();
        for( int i =0; i<a.length;i++)
        {
            for( int j =0; j<size;j++)
            {
              sum += Math.pow(a[i][j],2) - 10* Math.cos(2*(float)Math.PI*a[i][j]);
            }
            result[3][i] = 10*size*sum;
        }
                long stop = System.nanoTime();
    result[18][3]=stop-start;
    }
    // Griwangk function
    public void Griewangk(double[][] a, int size){
            long start = System.nanoTime();
        float mul = 0;
        
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<size;j++)
            {
            sum += Math.pow(a[i][j],2)/4000;
            mul *= Math.cos(a[i][j]/Math.sqrt(j+1));
            }
            result[4][i] = 1+ sum -mul;
        }
                long stop = System.nanoTime();
        result[18][4]=stop-start;
    }
    // SineEnvelope
    public void SineEnvelope(double[][] a, int size){
            long start = System.nanoTime();
        for( int i =0;i<a.length; i++){
            for( int j =0;j<size-1;j++){
            sum += -0.5 + Math.pow(Math.sin(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)-0.5),2);
            }
            result[5][i] = sum;
        }
                long stop = System.nanoTime();
   result[18][5]=stop-start;
        
    }
    // StretchedV functon
    public void StretchedV(double[][] a, int size){
          long start = System.nanoTime();
        for( int i =0; i<a.length;i++){
            for( int j =0;j<size-1;j++){
                sum += Math.pow(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2),1/4)*Math.sin(Math.pow(Math.pow(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2),1/10),2))+1;
            }
            result[6][i]=sum;
        }
                long stop = System.nanoTime();
      result[18][6]=stop-start;
    }
    //Ackley1 function
    public void Ackley1(double[][] a, int size){
           long start = System.nanoTime();
        for( int i =0;i<a.length;i++){
            for( int j =0;j<size-1;j++){
                sum += (1/Math.pow(Math.E,0.2))*Math.sqrt(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2))+3*(Math.cos(2*a[i][j])+Math.sin(2*a[i][j+1]));
            }
            result[7][i]=sum;
        }
                long stop = System.nanoTime();
        result[18][7]=stop-start;
    }
    // Ackely2 function
    public void Ackely2(double[][] a, int size){
            long start = System.nanoTime();   
        for( int i =0;i<a.length;i++){
            for( int j =0;j<size-1;j++){
               sum += 20+ Math.E - 20/(Math.pow(Math.E, 0.2*(Math.sqrt((Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2))/2))))-Math.pow(Math.E, 0.5*(Math.cos(2*Math.PI*a[i][j])+Math.cos(2*Math.PI*a[i][j+1])));
            }
            result[8][i]=sum;
        }
                   long stop = System.nanoTime();
    result[18][8]=stop-start;
        
    }
    // EggHolder function
    public void EggHolder(double[][] a, int size){
            long start = System.nanoTime();
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<size-1;j++)
            {
                sum += -a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j]-a[i][j+1]-47)))-(a[i][j+1]+47)*Math.sin(Math.sqrt(Math.abs(a[i][j+1]+47+a[i][j]/2)));
            }
            result[9][i]=sum;
        }
                  long stop = System.nanoTime();
        result[18][9]=stop-start;
        
    }
    // Rana function
    public void Rana(double[][] a, int size){
        long start = System.nanoTime();
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<size-1;j++)
            {
               sum += a[i][j]*Math.sin(Math.sqrt(Math.abs(a[i][j+1]-a[i][j]+1)))*Math.cos(Math.sqrt(Math.abs(a[i][j+1]+a[i][j]+1)))+(a[i][j+1]+1)*Math.cos(Math.sqrt(Math.abs(a[i][j+1]-a[i][j]+1)))*Math.sin(Math.sqrt(Math.abs(a[i][j+1]+a[i][j]+1)));
            }
            result[10][i]=sum;
        }
            long stop = System.nanoTime();
         result[18][10]=stop-start;
        
    }
    // Pathological function
    public void Pathological(double[][] a, int size){
           long start = System.nanoTime();
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<size-1;j++)
            {
             sum += 0.5 + (Math.sin(Math.pow(Math.sqrt(100*Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)),2))-0.5)/(1+0.001*(Math.pow(Math.pow(a[i][j],2)-2*a[i][j]*a[i][j+1]+Math.pow(a[i][j+1],2),2)));
            }
            result[11][i]=sum;
        }
                 long stop = System.nanoTime();
        result[18][11]=stop-start;
        
    }
    // Michalewicz function
    public void Michalewicz(double[][] a, int size){
            long start = System.nanoTime();  
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<size;j++)
            {
            sum+= -Math.sin(a[i][j])*Math.pow(Math.sin(j*Math.pow(a[i][j],2)/Math.PI),20);
            }
            result[12][i]=sum;
        }
                    long stop = System.nanoTime();
          result[18][12]=stop-start;
        
    }
    // Masters function
    public void Masters(double[][] a, int size){
            long start = System.nanoTime();    
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<size-1;j++)
            {
           sum+= -Math.pow(Math.E,-(1/8)*(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)+0.5*a[i][j+1])*a[i][j])*Math.cos(4*Math.sqrt(Math.pow(a[i][j],2)+Math.pow(a[i][j+1],2)+0.5*a[i][j]*a[i][j+1]));
            }
            result[13][i]=sum;
        }
                      long stop = System.nanoTime();
    result[18][13]=stop-start;
        
    }
    // Quartic function
    public void Quartic(double[][] a, int size){
            long start = System.nanoTime();   
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<size-1;j++)
            {
                sum+= j*Math.pow(a[i][j],4);
            }
            result[14][i]=sum;
        }
                      long stop = System.nanoTime();
result[18][14]=stop-start;
        
    }
    // Levy function
    public void Levy(double[][] a, int size){
           long start = System.nanoTime();
        double w;
              for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<size-1;j++)
            {
                w=1+(a[i][j]-1)/4;
                sum+= (1+10*Math.pow(Math.sin(Math.PI*w+1),2))*Math.pow(w-1, 2)+(1+Math.pow(Math.sin(2*Math.PI*w),2))*Math.pow(w-1,2);
           
            }
            result[15][i]=a[0][0]+sum;
        }
                      long stop = System.nanoTime();
result[18][15]=stop-start;
    }
    // Step function
    public void Step(double[][] a, int size){
            long start = System.nanoTime();     
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<size;j++)
            {
            sum += Math.pow(Math.abs(a[i][j])+0.5,2);
            }
            result[16][i]=sum;
        }
                      long stop = System.nanoTime();
result[18][16]=stop-start;
    }
    // Alpine function
    public void Alpine(double[][] a, int size){
            long start = System.nanoTime();     
        for( int i =0; i<a.length; i++)
        {
            for( int j =0;j<size;j++)
            {
            sum += Math.abs(a[i][j]*Math.sin(a[i][j])+0.1*a[i][j]);
            }
            result[17][i]=sum;
        }
                      long stop = System.nanoTime();
  result[18][17]=stop-start;


    }
}
