package edu.sjtu.holmes.sort;

/**
 * Created by holmes on 16/4/9.
 */
public class QuickSortBase extends AbstractSort {
    public static void sort(int[] a) {
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        int v = a[lo];

        while(true){
            while(a[++i] < v) if(i >= hi) break;
            while(a[--j] > v) if(j <= lo) break;
            if(i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

}
