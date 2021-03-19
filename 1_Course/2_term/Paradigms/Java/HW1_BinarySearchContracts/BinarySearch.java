package search;

import java.util.Arrays;

public class BinarySearch {
    //Pred: args.length >= 1 && ( args != null )
    //Input format : a1, a2 ... an : ∀i 1)ai = args[i],
    //                            2)ai - integer,
    //                            3)ai >= ai+1(i!=n);
    //                          ( 4)ai != null )
    public static void main(String args[]) {
        int[] a = new int[args.length - 1];
        int x = Integer.parseInt(args[0]);
        for (int i = 0; i < args.length - 1; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
        }
        System.out.println(recursiveSearch(x, a, a.length, -1));
        System.out.println(iterativeSearch(x, a));
        /*
        int x = Integer.parseInt(args[0]);
        args[0]=String.valueOf(Integer.MAX_VALUE);
        int[] a = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        */
    }

    //Pred: a.length >= 0 && ( -1 <= left < i <= right <= a.length ) && ( a[left] < a[i] <= a[right] )
    public static int iterativeSearch(int x, int[] a) {
        //Pred: a.length >= 0
        int right = a.length;
        //a.length >= 0 && right == a.length
        int left = -1;
        //a.length >= 0 && right => 0 && left == -1
        int middle = (right + left) / 2;
        //a.length >= 0 && right >= 0 && left == -1 && middle >= 0

        //inv: ( -1 <= left < i <= right <= a.length ) && ( a[left] < a[i] <= a[right] )
        while (right - 1 > left) {
            //right > left + 1
            middle = (right + left) / 2;
            //right > left + 1 && middle >= 0
            if (a[middle] > x) {
                //inv: a[middle] > x
                left = middle;
                //a[0]..a[left] > x >= a[right]..a[a.length-1]
            }else {
                //inv: a[middle] <= x
                right = middle;
                //a[0]..a[left] >= x >= a[right]..a[a.length-1]
            }
        }
        //right - 1 <= left && left < right && -> i == right
        return right < a.length && a[right] == x ? right : -right - 1;
        //Post: if 0 <= right < a.length
        //         a[right] <= x
        //         if(right>0)
        //             a[right-1]>x
        //      else
        //         right == a.size
    }
    //Pred: a.length >= 0 && ( -1 <= left < i <= right <= a.length ) && ( a[left] < a[i] <= a[right] )
    public static int recursiveSearch(int x, int[] a, int right, int left) {
        if (right - 1 > left) {
            // right > left + 1
            int middle = (right + left) / 2;
            //right > left + 1 && middle >= 0
            if (a[middle] > x) {
                //inv: a[middle] > x
                left = middle;
                //a[0]..a[left] > x >= a[right]..a[a.length-1]
            }else {
                //inv: a[middle] <= x
                right = middle;
                //a[0]..a[left] >= x >= a[right]..a[a.length-1]
            }
            //a[0]..a[left] > x >= a[right]..a[a.length-1]
            right = recursiveSearch(x, a, right, left);
            //a[0]..a[left] > x >= a[|right|]..a[a.length-1]
            if(right<0){
                //inv: right<0
                right=(right+1)*-1;
            }
            //a[0]..a[left] > x >= a[right]..a[a.length-1]
        }
        return right < a.length && a[right] == x ? right : -right - 1;
        //Post: if 0 <= right < a.length
        //         a[right] <= x
        //         if(right>0)
        //             a[right-1]>x
        //      else
        //         right == a.size

    }
}
