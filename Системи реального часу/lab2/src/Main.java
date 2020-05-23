import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    double s = 0.1;
    int P =4;
    double [] enters;
    int outer;
    double []weights;
    double patterns[][] ={
            {1,5 ,1},
            {2,4 ,0},
            {1,0 ,0},
//            {1,1, 1}
    };

    public Main(){
        enters=new double [2];
        weights = new double[enters.length];
        for (int i =0; i< enters.length; i++){
            weights[i]=0;
        }
    }

    public void countOuter(){
        outer = 0;
        for (int i= 0 ; i<enters.length; i++){
            outer+=enters[i]*weights[i];
        }
        if (outer>P) outer=1; else outer =0;
    }

    public void study(){
        double gError=0;
        do{
            gError=0;
            for(int i=0; i<patterns.length; i++){
                enters = Arrays.copyOf(patterns[i], patterns[i].length-1);
                countOuter();
                double error = patterns[i][2] - outer;
                gError+=Math.abs(error);
                for (int j =0; j<enters.length; j++){
                    weights[j]+= s * error * enters[j];
                }
            }
        }while(gError!=0);
    }

    public void test(){
        study();
        for(int i=0; i<patterns.length; i++) {
            enters = Arrays.copyOf(patterns[i], patterns[i].length - 1);
            countOuter();
            System.out.println(outer);
        }
    }

    public static void main(String[] args) {
        new Main().test();
    }
}
