package edu.sjtu.holmes.sort;

/**
 * Created by holmes on 16/4/8.
 */
public class ShellSort extends AbstractSort {
    public static void sort(int[] a){
        int N = a.length;
        int h = 1;
        while( h < N/3) h = 3*h +1;

        while(h >= 1){
            for (int i = h; i < N; i++) {
                for(int j = i; j >= h && a[j-h] > a[j] ; j -= h){
                    swap(a, j-h, j);
                }
            }
            h = h/3;
        }
    }
}
