
package optimazation.pkg1;

/**
 *
 * @author lljjy
 */
public class Functioning {
     

    public double[][] funct(int length, int size){

        CreateMatrix c = new CreateMatrix(length,size);
        Functions f = new Functions();
        f.result = new double[19][length];  
        c.add(-512, 512);
        f.Schwefel(c.input, size);
        c.add(-100, 100);
        f.DeJong(c.input, size);
        f.Rosenbrock(c.input, size);
        f.Pathological(c.input, size);
        f.Quartic(c.input, size);
        f.Step(c.input,size);
        f.Alpine(c.input, size);       
        c.add(-30,30);
        f.Rastrigin(c.input, size);
        f.Masters(c.input, size);
        f.SineEnvelope(c.input, size);
        f.StretchedV(c.input, size);
       
        c.add(0, Math.PI);
        f.Michalewicz(c.input, size);
       
        c.add(-500, 500);
        f.Griewangk(c.input, size);
        f.EggHolder(c.input, size);
        f.Rana(c.input, size);
       
        c.add(-32, 32);
        f.Ackley1(c.input, size);
        f.Ackely2(c.input, size);
       
        c.add(-10,100);
        f.Levy(c.input, size);

         
    for( int i =0;i<f.result.length-1;i++){
           System.out.print("f(x"+(i+1)+")=  ");
           
         for( int j =0;j<f.result[i].length;j++){
             System.out.print(f.result[i][j]+"  ");
         }
         System.out.println();

     }
                return f.result;
    }

    
 
        
}
