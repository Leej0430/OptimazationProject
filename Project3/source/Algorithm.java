/** @author JuneYeob Lee(24629603)
 * \class Optimization1
 * \ingroup optimization
 * 
 * \main
 * 
 * This class is for main method.
 * 
 * 
 * 
 * @date 5/2/2019
 * Contact:Leej @cwu.edu
 * Created on: 4/26/2019
 *
 */
package optimazation.pkg1;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;


public class Algorithm {
    /**
     * Algorithm class has 11 methods for Genetic Algorithm and Differential Evolution Algorithm.
     * * 
     */
   // Internal state
    int best;
    MTRandom mr = new MTRandom();
    double [][] selected;
    double [][] crossover;
    double[][] mutation;
    double[][] population;
    double[][] newpopulation;
    double[] result;
    double[] newresult;
    double[] fitness;
    double totalfitness;
    int populations;
    int chromazoms;
    double upper;
    double lower;
   // Constant values.
    //0.85
    double crmin =0.85;
    //0.95
    double crmax=0.95;
    //0.005
    double mutationRate =0.005;
    //0.1
    double mutationRange =0.1;
    Functions f;
    /**
     * The constructor for Genetic Algorithm and Differential Algorithm.
     *  Create initialize populations.
     * @param populations
     * @param chromazones
     * @param functNum
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    
    public Algorithm(int rows, int colums,int functNum) throws FileNotFoundException, UnsupportedEncodingException{
        f = new Functions(rows);
        populations = rows;
        chromazoms = colums;
        newpopulation=new double[populations][chromazoms];
        selected= new double [2][chromazoms];
        newresult = new double[populations];
      CreateMatrix c = new CreateMatrix(populations,chromazoms);
      c.create(populations,chromazoms);
               switch(functNum){
                   case 0: 
                       upper=512;
                       lower=-512;
                       c.add(lower,upper);
                       population=c.input;
                       result =f.Schwefel(population);
                       
                       break;
                         case 1: 
                       upper=100;
                       lower=-100;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.DeJong(population);
                       
                       break;
                         case 2: 
                          upper=100;
                       lower=-100;
                       c.add(lower,upper);
                       population=c.input;
                       result =f.Rosenbrock(population);
                       
                       break;
                         case 3: 
                          upper=30;
                       lower=-30;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Rastrigin(population);
                       
                       break;
                         case 4: 
                          upper=500;
                       lower=-500;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Griewangk(population);

                       break;
                         case 5: 
                          upper=30;
                       lower=-30;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.SineEnvelope(population);

                       break;
                         case 6: 
                          upper=30;
                       lower=-30;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.StretchedV(population);

                       break;
                         case 7: 
                                                upper=32;
                       lower=-32;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Ackley1(population);
                        
                       break;
                         case 8: 
                         upper=32;
                       lower=-32;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Ackely2(population);
                        
                       break;
                         case 9: 
                        upper=500;
                       lower=-500;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.EggHolder(population);
                         
                       break;
                         case 10: 
                       upper=500;
                       lower=-500;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Rana(population);  
                      
                       break;
                         case 11: 
                              upper=100;
                       lower=-100;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Pathological(population);

                       break;
                         case 12: 
                          upper=Math.PI;
                       lower=0;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Michalewicz(population);

                       break;
                         case 13: 
                       upper=30;
                       lower=-30;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Masters(population);
                          
                       break;
                         case 14: 
                       upper=100;
                       lower=-100;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Quartic(population);
                          
                       break;
                         case 15: 
                        upper=10;
                       lower=-10;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Levy(population);
                         
                       break;
                         case 16: 
                         upper=100;
                       lower=-100;
                             c.add(lower,upper );
                       population=c.input;
                       result =f.Step(population);
                        
                       break;
                         case 17: 
                         upper=100;
                       lower=-100;
                             c.add(lower,upper);
                       population=c.input;
                       result =f.Alpine(population);
                        
                       break; 
         }

    }
/**
 * This method to get fitness value for each populations. 
 * Array for fitness value for each population will be provided.
 * @param result 
 */
    public void getFitness(double[]result){

        fitness = new double[result.length];
        

        for( int i =0;i<result.length;i++){
            if(result[i]>=0){
                fitness[i] = 1/( 1+result[i]);
            }
            else{fitness[i] =( 1+Math.abs(result[i]));}
       totalfitness+= fitness[i]; 
        }

    }
/**
 *  This method is method to choose parents.
 * @return int value 0< x< population.
 */

    public int selectParent(){
        getFitness(result);
        double rand = 1+mr.nextDouble()*(this.totalfitness-1);
        int s =0;
        while(s<populations-1&&rand>0){
         
        rand-= fitness[s];
         s++;
      }
        return s;
    }
    /**
     *  This method provide 2 parents.
     * @param initial matrix.
     * @return  2d array which has 2 parents vector.
     */
    public double[][] select (double[][]input){
        selected = new double[2][chromazoms];
        selected[0]= input[selectParent()];
        selected[1]= input[selectParent()];
        return selected;
    }
    /**
     *  Tournament Selection, parents are chosen at random from population.
     * @param initial matrix.
     * @return two parents.
     */
    public double[][]tournament(double[][]input){
        // create 4 random numbers
        int rand = mr.nextInt(populations);
        int rand1 = mr.nextInt(populations);
        int rand2 = mr.nextInt(populations);
        int rand3 = mr.nextInt(populations);
        //if rand ==rand1 re generate two random number
        if(rand==rand1){
          rand = mr.nextInt(populations);
          rand1 = mr.nextInt(populations);
        }
        // if rand2 ==rand3 regenerate two random number.
        if(rand2==rand3){
            rand2 = mr.nextInt(populations);
            rand3 = mr.nextInt(populations);
        }
        // pick more optimized population
        if(result[rand]<result[rand1]){
            selected[0]=input[rand];
        }
        else{selected[0]=input[rand1];}
          if(result[rand2]<result[rand3]){
            selected[1]=input[rand2];
        }
        else{selected[1]=input[rand3];}
        
        return selected;
    }
    /**
     * Crossover method(CR probability(0.8~0.95).
     * @param First parent
     * @param Second parent
     * @param number of crossover point.
     */
    public void crossover(double[]p1, double[] p2,int n){
        double d= mr.nextDouble();
        // create crossover point
        int c = mr.nextInt(chromazoms-1);
        int c1 = mr.nextInt(chromazoms-1);
        // if 2 crossover points are same re generate one crossover point
        if(c==c1){
            c1=mr.nextInt(chromazoms);
        }
        // switch statement for number of crossover point
        switch(n){
            // 1 crossover point
            case 1:
                  crossover= new double[2][p1.length];
                  // check crossover probability
            if(d>=crmin&&d<=crmax){
            for( int i =0;i<c;i++){
                crossover[0][i]=p1[i];
                crossover[1][i]=p2[i];
            }
            for( int j=c;j<p1.length;j++){
                crossover[0][j]=p2[j];
                crossover[0][j]=p1[j];
            }
        }
        else {crossover[0] =p1;
                crossover[1] =p2;}
            break;
            // 2 crossover points
            case 2: 
                crossover = new double[6][p1.length];
               if(d>=crmin&&d<=crmax){
            for( int i =0;i<c;i++){
                crossover[0][i]=p1[i];
                crossover[1][i]=p1[i];
                crossover[2][i]=p1[i];
                crossover[3][i]=p2[i];
                crossover[4][i]=p2[i];
                crossover[5][i]=p2[i];
            }
            for( int j=c;j<c1;j++){
                crossover[0][j]=p1[j];
                crossover[1][j]=p2[j];
                crossover[2][j]=p2[j];
                crossover[3][j]=p2[j];
                crossover[4][j]=p1[j];
                crossover[5][j]=p1[j];
            }
             for( int k=c1;k<p1.length;k++){
                crossover[0][k]=p2[k];
                crossover[1][k]=p1[k];
                crossover[2][k]=p2[k];
                crossover[3][k]=p1[k];
                crossover[4][k]=p1[k];
                crossover[5][k]=p2[k];
            }
        }
        else {crossover[0] =p1;
                crossover[1] =p2;}
                break;
}    
}
    /**
     *  This method for mutation after crossover.
     * mutation probability 0.005
     * Mutation Range 0.1
     * Mutation Precision (1~5)
     * @param cr
     * @param Upper
     * @param Lower 
     */
        public void mutate (double[][]cr,double Upper, double Lower){
    mutation = new double[cr.length][chromazoms];
            for( int j=0;j<cr.length;j++){  
        for( int i=0;i<chromazoms;i++){
            if(mr.nextDouble()<0.005){
                cr[j][i] += (-1+mr.nextDouble()*(2))*(Upper-Lower)*mutationRange*Math.pow(2, (-1*mr.nextDouble()*(mr.nextInt(5)+1)));
                mutation[j][i]=cr[j][i];
            }
            else{mutation[j][i]=cr[j][i];}
        }
    }
                
    }
 /**
  * Reduce method.(
  * @param initialpopulation
  * @param newpopulation
  * @param Elitism(Elitism Rate * number of population)
  * @param functionNum
  * @throws FileNotFoundException 
  */


    public void reduce(double[][]popu,double[][]newpopu,int Elitism,int functionNum) throws FileNotFoundException{
        // copy population and new population
        double[][] copy1 = popu;
        double[][] copy2= newpopu;
              double []copy =result;
        double[] newcopy=newresult;

   
//  get result for population and new population
        switch(functionNum){
                   case 0: 
                       result = f.Schwefel(popu);
                       newresult =f .Schwefel(newpopu);
                       break;
                         case 1: 
                      result = f.DeJong(popu);
                       newresult =f .DeJong(newpopu);
                    
                       break;
                         case 2: 
                      result =f.Rosenbrock(popu);
                      newresult =f .Rosenbrock(newpopu);
                       
                       break;
                         case 3: 
                      result = f.Rastrigin(popu);
                     newresult =f .Rastrigin(newpopu);
                        

                       break;
                         case 4: 
                             result=f.Griewangk(popu);
                       newresult =f .Griewangk(newpopu);
      
                       break;
                         case 5: 
                 
                             result = f.SineEnvelope(popu);
                       newresult =f .SineEnvelope(newpopu);
                 
                       break;
                         case 6: 
                  
                             result = f.StretchedV(popu);
                       newresult =f .StretchedV(newpopu);
                   
                       break;
                         case 7: 
                  result= f.Ackley1(popu);
                       newresult =f .Ackley1(newpopu);
                       
                       break;
                         case 8: 
                 result = f.Ackely2(popu);
                       newresult =f .Ackely2(newpopu);
                    
                       break;
                         case 9: 
                             result = f.EggHolder(popu);
                       newresult =f .EggHolder(newpopu);
                     
                       break;
                         case 10: 
                             result = f.Rana(popu);
                       newresult =f .Rana(newpopu);  
          
                       break;
                         case 11: 
                             result = f.Pathological(popu);
                       newresult =f .Pathological(newpopu);
                  
                       break;
                         case 12: 
                             result = f.Michalewicz(popu);
                      newresult =f .Michalewicz(newpopu);
                  
                       break;
                         case 13: 
                             result = f.Masters(popu);
                     newresult =f .Masters(newpopu);
                   
                       break;
                         case 14: 
                             result = f.Quartic(popu);
                       newresult =f .Quartic(newpopu);
                    
                       break;
                         case 15: 
                             result = f.Levy(popu);
                       newresult =f .Levy(newpopu);
                
                       break;
                         case 16: 
                             result = f.Step(popu);
                       newresult =f .Step(newpopu);
                      
                       break;
                         case 17: 
                             result = f.Alpine(popu);
                       newresult =f .Alpine(newpopu);
                       break;
         }
    

        // sort result and newresult in ascending order
        Arrays.sort(this.result);
        Arrays.sort(this.newresult);
  
//sort population by result
       for( int i=0;i<result.length;i++){
           for(int j=0;j<result.length;j++){
               // to compare double
               if(result[i]-copy[j]<=0.0000000000000001){
                   population[i]=popu[j];
                   
                   
               }
           }
       }
       //sort new population by sorted new result
         for( int i=0;i<newresult.length;i++){
            for(int j=0;j<newresult.length;j++){
                // to compare double
               if(newresult[i]-newcopy[j]<=0.000000000000000001){
                  newpopulation[i]=newpopu[j];
              
               }
           }
       }
        // replace worst solutions in newpopulation by best solutions in population
        for( int i=0;i<Elitism;i++){
         
          newpopulation[populations-1-i]=population[i];
            
            }
       population = newpopulation;
  
    
        }
    /**
     * Mutate and recombine method is first step of differential evolution.
     * @param init
     * @param F
     * @param functionNum
     * @param num
     * @return 
     */
    //F should be in [1,2]
    public double[][] mutateandRecombine(double[][]init,double F,int functionNum,int num,int strategy){
        MTRandom mr = new MTRandom();
        double [] mutate = new double[chromazoms];
        double [][] temp = new double[2][chromazoms];
        for( int i =0;i<init.length;i++){
            mr.setSeed(i);
            // create 5 random int.
            int r1 =mr.nextInt(populations);
            int r2 = mr.nextInt(populations);
            int r3 = mr.nextInt(populations);
            int r4 = mr.nextInt(populations);
            int r5 = mr.nextInt(populations);
            int jRand = mr.nextInt(30);
            // In exponential crossover
            if( num==1){
                double randj = mr.nextDouble();
                for(int j=0;j<chromazoms;j++){
                if((randj>=crmin&&randj<=crmax)|| j==jRand){
                 mutate[j]=expbin(strategy, best,i,F,1.5, j,r1, r2, r3, r4, r5);
                }
                else {mutate[j]=population[j][jRand];}
                
                }
            }
            // In binomial crossover
            if(num==2){
                double randj = mr.nextDouble();
                for(int j=0;j<chromazoms;j++){
                 randj=mr.nextDouble();
                    if((randj>=crmin&&randj<=crmax)|| j==jRand){
                   
                 mutate[j]=expbin(strategy, best,i,F,1.5, j,r1, r2, r3, r4, r5);
                }
                else {mutate[j]=population[j][jRand];}
                
                }
            }
                temp[0]=init[i];
             temp[1]=mutate;
            
            init[i]=select(temp,functionNum);
        }
        return init;
          }
    /**
     * select method is method to check mutate vector's cost is more optimized than original vector's cost
     * @param a
     * @param functionNum
     * @return 
     */
    public double[] select(double[][] a,int functionNum){
        double original=0;
        double mutat=0;
        Functions f = new Functions(a.length);
        switch(functionNum){
                   case 0: 
                       original= f.Schwefel(a)[0];
                       mutat=f.Schwefel(a)[1];
                       break;
                         case 1: 
                       original =f.DeJong(a)[0];
                       mutat=f.DeJong(a)[1];
                       break;
                         case 2: 
                       original =f.Rosenbrock(a)[0];
                       mutat = f.Rosenbrock(a)[1];
                       break;
                         case 3: 

                      original =f.Rastrigin(a)[0];
                      mutat = f.Rastrigin(a)[1];
                       break;
                         case 4: 
 
               
                       original =f.Griewangk(a)[0];
      mutat =f.Griewangk(a)[1];
                       break;
                         case 5: 
                 
                    
                       original =f.SineEnvelope(a)[0];
                       mutat = f.SineEnvelope(a)[1];
                       break;
                         case 6: 
                  
                 
                       original =f.StretchedV(a)[0];
                       mutat = f.StretchedV(a)[1];
                       break;
                         case 7: 
                  
                       original =f.Ackley1(a)[0];
                       mutat = f.Ackley1(a)[1];
                       break;
                         case 8: 
                 
                       original =f.Ackely2(a)[0];
                       mutat = f.Ackely2(a)[1];
                       break;
                         case 9: 
                       original =f.EggHolder(a)[0];
                       mutat = f.Ackely2(a)[1];
                       break;
                         case 10: 

                       original =f.Rana(a)[0];  
                       mutat = f.Rana(a)[1];
                       break;
                         case 11: 
     
                       original=f.Pathological(a)[0];
                       mutat = f.Pathological(a)[1];
                       break;
                         case 12: 
             
                      original =f.Michalewicz(a)[0];
                      mutat = f.Michalewicz(a)[1];
                       break;
                         case 13: 
                
                        original =f.Masters(a)[0];
                        mutat = f.Masters(a)[1];
                       break;
                         case 14: 
              
                       original =f.Quartic(a)[0];
                       mutat = f.Quartic(a)[1];
                       break;
                         case 15: 
   
                       original =f.Levy(a)[0];
                       mutat = f.Levy(a)[1];
                       break;
                         case 16: 
      
                       original =f.Step(a)[0];
                      mutat = f.Step(a)[1];
                       break;
                         case 17: 

                       original =f.Alpine(a)[0];
                       mutat = f.Alpine(a)[1];
                       break;
         }
       if(mutat <original){
            return a[1];
        }
        else {return a[0];}

 
    }
    /**
     * calc method to get best solution after differential algorithm.
     * @param newpopulation
     * @param functionNum
     * @return  solution
     */
public double calc(double[][] a,int functionNum){

     switch(functionNum){
                   case 0: 
                       newresult =f.Schwefel(a);
                       break;
                         case 1: 
                       newresult =f.DeJong(a);
                       break;
                         case 2: 
                       newresult =f.Rosenbrock(a);
                       break;
                         case 3: 

                       newresult =f.Rastrigin(a);

                       break;
                         case 4: 
 
               
                       newresult =f.Griewangk(a);
      
                       break;
                         case 5: 
                 
                    
                      newresult =f.SineEnvelope(a);
                 
                       break;
                         case 6: 
                  
                 
                       newresult =f.StretchedV(a);
                   
                       break;
                         case 7: 
                  
                       newresult =f.Ackley1(a);
                       
                       break;
                         case 8: 
                 
                       newresult =f.Ackely2(a);
                    
                       break;
                         case 9: 
                      newresult =f.EggHolder(a);
                     
                       break;
                         case 10: 

                       newresult =f.Rana(a);  
          
                       break;
                         case 11: 
     
                       newresult =f.Pathological(a);
                  
                       break;
                         case 12: 
             
                      newresult =f.Michalewicz(a);
                  
                       break;
                         case 13: 
                
                     newresult =f.Masters(a);
                   
                       break;
                         case 14: 
              
                       newresult =f.Quartic(a);
                    
                       break;
                         case 15: 
   
                       newresult =f.Levy(a);
                
                       break;
                         case 16: 
      
                       newresult =f.Step(a);
                      
                       break;
                         case 17: 

                       newresult =f.Alpine(a);
                       break;
         }
    double[] copy = newresult;
    Arrays.sort(newresult);
    for( int j =0;j<newresult.length;j++){
        if(newresult[0]-copy[j]<0.0000000000001){
            best = j;
        }
    }
    return newresult[0];
}

/**
 * method for 10 strategies for differential evolution.
 * @param num
 * @param best
 * @param i
 * @param F[1,2]
 * @param Lamda[1,2]
 * @param j
 * @param r1
 * @param r2
 * @param r3
 * @param r4
 * @param r5
 * @return mutate individual after crossover.
 */
 public double expbin (int num,int best,int i,double F,double Lam,int j,int r1,int r2,int r3,int r4,int r5){
     double a= 0;
     switch(num){
        //1st and 6th stratiges
         case 1:
          
             a= population[best][j]+F*(population[r2][j]);
         
             break;
             //2nd and 7th stratiges
         case 2:
     
                 a = population[r1][j]+F*(population[r2][j]-population[r3][j]);
            
             break;
             //3rd and 8th stratiges
             case 3:
                 a = population[i][j]+Lam*(population[best][j]-population[i][j])+F*(population[r1][j]-population[r2][j]);
             
             break;
             //4th and 9th stratiges
         case 4 :
             
                 a = population[best][j]+F*(population[r1][j]+population[r2][j]-population[r3][j]-population[r4][j]);
             
             break;
             //5th and 10th stratiges
         case 5 : 
        
                 a = population[r5][j]+F*(population[r1][j]+population[r2][j]-population[r3][j]-population[r4][j]);
             
             break;
             
     }
     return a;
 }  

 }


       
     
   

  

   

