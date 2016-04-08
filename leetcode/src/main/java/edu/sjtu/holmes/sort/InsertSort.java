package edu.sjtu.holmes.sort;

/**
 * Created by holmes on 16/4/8.
 */
public class InsertSort extends AbstractSort {
    public static void sort(int[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            int j, hold = a[i];
            for (j = i; j > 0 && a[j-1]>hold ; j--) {
                a[j] = a[j-1];
            }
            a[j] = hold;
        }
    }
}
