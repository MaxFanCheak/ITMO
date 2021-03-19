import java.time.Duration;
import java.time.Instant;

public class MatrixTest {
    public static void main(String args[]) throws InterruptedException {
        for(int i = 50;i < 10000;i+=50){
            Matrix a = new Matrix(i,i);
            Instant start = Instant.now();
            int[][] matrix = a.MatrixMultiplicationOrdinary();
            Thread.sleep(1000);
            Instant finish = Instant.now();
            long elapsed = Duration.between(start, finish).toMillis();
            System.out.println(i + "\nПрошло времени при наивной реализации, мс: " + elapsed);
            start = Instant.now();
            int[][] matrix1 = a.MatrixMultiplicationEffective();
            Thread.sleep(1000);
            finish = Instant.now();
            elapsed = Duration.between(start, finish).toMillis();
            System.out.println("\nПрошло времени при кеш-эффективной, мс: " + elapsed);
        }
    }
}
