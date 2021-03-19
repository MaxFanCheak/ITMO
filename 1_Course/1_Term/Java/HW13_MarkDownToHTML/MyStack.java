package Md2Html;

import java.util.Arrays;

class MyStack {

    private int size = 0;
    private int[] arr = new int[3];

    void add(int value) {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size++] = value;
    }

    void pop() {
        size--;
    }

    int getSize() {
        return size;
    }
}