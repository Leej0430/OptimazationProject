/**
 *
 * @author JuneYeob Lee(24629603)
 * * \date 5/17/2019
 * Contact:Leej @cwu.edu
 * Created on: 5/17/2019
 */
package optimazation.pkg1;

import java.util.Arrays;
/**
 *  Harmony Search Algorithm.
 *  this class to implement HS algorithm
 * 
 */

public class HS {
double HMCR=0.7;
double PAR=0.3;
//harmony array
double[][] harmony;
//new harmony
double []HM;
// number of harmonies
int NP;
//size of harmony
int DIM;
//upper bound
double upper;
// lower bound
double lower;
// best harmony solution
double best;
// worst harmony solution
double worst;
double bw=0.2;
int fNum;
int rand3;
double newVal;
Algorithm a; 
//Create merseane twister Object
MTRandom m = new MTRandom();
//Create Functioning object
Functioning f = new Functioning();
/**
 * HS constructor 
 * @param functionNum  Function number
 * @param NP        number of harmonies
 * @param DIM       size of 2D array
 */
public HS(int functionNum, int NP, int DIM){
a = new Algorithm(NP,DIM,functionNum);
this.NP = NP;
this.DIM = DIM;
this.fNum = functionNum;
//new harmony array
HM = new double[DIM];
//initialize harmony
harmony = a.population;
this.upper = a.upper;
this.lower = a.lower;
}
/**
 * sortHarmony method sort harmony in ascending order.
 */
public void sortHarmony(){
    double[][] copy = harmony;
    double[] fit = f.cal(fNum, NP, DIM, harmony);
    double[] copyf = f.cal(fNum, NP, DIM,harmony );
    Arrays.sort(fit);
    // sort Harmonies in ascending order
    for( int i =0;i<NP;i++){
        for (int j =0;j<NP;j++){
            if(fit[i]==copyf[j]){
                System.arraycopy(copy[j], 0, harmony[i], 0, DIM); 
            }
        }
    }
  
    
    this.best = fit[0];
    this.worst = fit[NP-1];
   
}
/**
 * improvise method.
 * in this method adjust pitch to get new harmonics
 */
public void improvise(){
   for( int i =0;i<DIM;i++){
   
     int j =m.nextInt(NP);
    if( m.nextDouble()<=HMCR){ 
   
        HM[i] = harmony[j][i];
        if(m.nextDouble()<=PAR){
            if(m.nextDouble()>0.5){
            HM[i] = harmony[j][i] +m.nextDouble() *bw;
            }
            else{   HM[i] = harmony[j][i] -m.nextDouble() *bw;}
        }
    }
    else {HM[i] = this.lower +m.nextDouble()* (this.upper-this.lower);}
   // adjust swarm bound
    if(HM[i]>a.upper){
            HM[i] =a.upper;
        }
        if(HM[i]<a.lower){
            HM[i] = a.lower;
        }
   
   }


}

/**
 * convert method. 
 * check new harmony's solution is better than worst solution and if it is better convert.
 */
public void convert(){

double [][] temp = new double [1][DIM];
temp[0] = HM;
double[] resultHM = f.cal(fNum, NP, DIM, temp);
 newVal = resultHM[0];
//replace worst harmony to new harmony
 if(worst>newVal){

    for( int k =0;k<DIM;k++){
    harmony[NP-1][k] =HM[k];}
}
}

/**
 * last method set the best harmony value and worst harmony value.
 */
public void last (){
    double[] last = 
             f.cal(fNum, NP, DIM, harmony);
Arrays.sort(last);

this.best = last[0];
this.worst = last[NP-1];
}

}
