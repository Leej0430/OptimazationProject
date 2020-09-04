/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimazation.pkg1;

/**
 *
 * @author lljjy
 */
public class CreateMatrix {
    int siz;
    MTRandom rnd = new MTRandom();
    double[][] input ;
    
    public CreateMatrix(){
        
    }
    public CreateMatrix(int a, int b){
    create(a,b);
    }
    
    public void create(int length, int size){

        input= new double[length][size];
        siz = size;
    }
    public void add(double min, double max){
       
        for(int i =0;i<input.length;i++){
            for( int j =0;j<input[i].length;j++){
                 double randf = min+rnd.nextDouble()*(max-min);
                input[i][j]=randf;
            }
        }
        
    }
    
}
