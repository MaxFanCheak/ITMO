import java.io.IOException;
import java.util.ArrayList;

public class ReverseHex {
    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner(System.in);
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        int a = 0;
        while (!sc.hasNotNextword()) {
            arr.add(new ArrayList<>());
            while (!sc.hasNotNextword()) {
                String i = sc.nextLine();
                if (i != null) {
                    arr.get(a).add(i);
                }
                if (sc.hasNotNextInWord()) {
                    break;
                }
            }
            a++;
        }
        arr.remove(a - 1);
        sc.close();
        for (int i = arr.size() - 1; i >= 0; i--) {
            for (int j = arr.get(i).size() - 1; j >= 0; j--) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}