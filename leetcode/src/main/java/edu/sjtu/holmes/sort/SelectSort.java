package edu.sjtu.holmes.sort;

/**
 * Created by holmes on 16/4/8.
 */
public class SelectSort extends AbstractSort {
    public static void sort(int[] a){
        int N = a.length;
        for(int i=0; i<N; i++){
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(a[j] < a[min]) min = j;
            }
            swap(a, i, min);
        }
    }
}
