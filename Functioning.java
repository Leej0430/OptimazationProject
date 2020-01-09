
package optimazation.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author JuneYeob Lee(24629603)
 * \This Functioning class has made to implemente  all 18 functions by ranges.
 * * \date 4/5/2019
 * Contact:Leej @cwu.edu
 * Created on: 3/28/2019
 */
//! Functioning class
public class Functioning  {
           
    //! A funct method
    /*!@param int length for first parameter
      !@param int size for second parameter
      !@return result of 18 functions from x(number of rows of 2dmatrix) vectors

    */ 
    // 2d array to get best Vector. 
      double[][]bestVector=new double[18][100000];      
    public double[][] funct(int length, int size) throws FileNotFoundException, UnsupportedEncodingException{
        
//! CreateMatrix object has created
        CreateMatrix c = new CreateMatrix(length,size);
        
//! Functions object has created
        Functions f = new Functions();
        //! result 2d arrays
        f.result = new double[19][length];     
        
//implement function which range is between [-512,512]
       c.add(-512, 512,"Input1");      
       f.Schwefel(c.input);               
//implement function which range is between [-100,100] 
        c.add(-100, 100,"Input2");
        f.DeJong(c.input);  
        f.Rosenbrock(c.input);
        f.Pathological(c.input);
        f.Quartic(c.input);
        f.Step(c.input);
        f.Alpine(c.input);       
       
//implement function which range is between [-30,30]
        c.add(-30,30,"Input3");
        f.Rastrigin(c.input);
        f.Masters(c.input);
        f.SineEnvelope(c.input);
        f.StretchedV(c.input);
       
//implement function which range is between [0,Pi]
        c.add(0, Math.PI,"Input4");
        f.Michalewicz(c.input);
        
//implement function which range is between [-500,500]
        c.add(-500, 500,"Input5");
        f.Griewangk(c.input);
        f.EggHolder(c.input);
        f.Rana(c.input);
        
//implement function which range is between [-32,32]
        c.add(-32, 32,"Input6");
        f.Ackley1(c.input);
        f.Ackely2(c.input);
        
//implement function which range is between [-10,100]
        c.add(-10,100,"Input7");
        f.Levy(c.input);
        

                return f.result;
    }
/**
/* BestVector method is for finding the best vector of the best solution.
 * for the function number search different input file because each function has different range
 * @param functionnumber (number of function number 0~17
 * @param solutioncolum  (colum number of result  2d array)
 * @param size           (size of input matrix)
 * @throws FileNotFoundException 
 */
       public void bestVector(int functionnumber,int solutioncolum,int size) throws FileNotFoundException{
         Scanner scan;
         int functionnum=functionnumber;
         switch(functionnum){
             case 0:
                 functionnum=1;
                 break;
             case 1:
             case 2:
             case 11:
             case 14:
             case 16:
             case 17:
                 functionnum =2;
                 break;
             case 3:
             case 5:
             case 6:
             case 13:
                 functionnum =3;
                 break;
             case 12:
                 functionnum =4;
                 break;
             case 4:
             case 9:
             case 10:
                 functionnum =5;
                 break;
             case 7:
             case 8:
                 functionnum =6;
                 break;
             case 15:
                 functionnum =7;
                 break;
         }

   int count=0;
       int fo =0;
         File file = new File("Input"+Integer.toString(functionnum));   
                  scan = new Scanner(file); 
                  if(solutioncolum==0){
                      for(int i =0;i<size;i++){
                     bestVector[functionnumber][i]=Double.valueOf(scan.next());
                 }
                  }else{
         while(count<size*solutioncolum){

                  if(count>size*solutioncolum-size-1&&count<size*solutioncolum){
                 bestVector[functionnumber][fo]=Double.valueOf(scan.next());                 
              
                 fo++; 
                        
             }

             else{
                 scan.next();
             }

                    count++;
              
         }
     
    }
      }
      
    
}
    
     

