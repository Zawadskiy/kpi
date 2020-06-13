import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int A = 1;
        double fp = Math.PI;
        int n = 12;
        double [] xArray = new double [10000];


        for(int t =0; t< 10000; t++){
            double x = 0;
            for(int i=0; i<= n; i++){
                x+= A * Math.sin(((n * t)*0.00001 + fp));
            }
            xArray[t] = x;
        }

        double M=0;
        for (double xt : xArray) {
            M+=xt;
        }
        M=M/xArray.length;
        System.out.println(M);
        double D = 0;
        for (double xt : xArray) {
            D+=Math.pow((xt-M),2);
        }
        D= D/(xArray.length-1);
        System.out.println(D);
    }
}
