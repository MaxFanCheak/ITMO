import java.util.Random;

public class Matrix {
    public static int[][] mA;
    public static int[][] mB;
    public static int m;
    public static int g;
    public static int n;
    public static int o;
    public Matrix(int n, int m){
        mA = new int[n][m];
        mB = new int[n][m];
        m = mA.length;
        g = mA[0].length;
        n = mB[0].length;
        o = mB.length;
        Random rnd = new Random();
        for (int i=0;i < m;i++) {
            for (int j=0;j < g;j++) {
                mA[i][j]=rnd.nextInt(100) + 1;
            }
        }
        for (int i=0;i < o;i++) {
            for (int j=0;j < n;j++) {
                mB[i][j]=rnd.nextInt(100) + 1;
            }
        }
    }
    public static int[][] MatrixMultiplicationEffective(){
        int[][] res = new int[m][n];
        int[] copy = new int[o];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for(int l = 0; l < 0; l++) {
                    copy[l]=mA[l][j];
                }
                int sum = 0;
                for (int k = 0; k < o; k++) {
                    sum += mA[i][k] * copy[k];
                }
                res[i][j]=sum;
            }
        }
        return res;
    }
    public static int[][] MatrixMultiplicationOrdinary(){

        int[][] res = new int[mA.length][mB[0].length];
        for (int i = 0; i < mA.length; i++) {
            for (int j = 0; j < mB[0].length; j++) {
                for (int k = 0; k < mB.length; k++) {
                    res[i][j] += mA[i][k] * mB[k][j];
                }
            }
        }
        return res;
    }
}
