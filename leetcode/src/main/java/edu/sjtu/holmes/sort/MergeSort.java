package edu.sjtu.holmes.sort;

/**
 * Created by holmes on 16/4/9.
 */
public class MergeSort extends AbstractSort{
    private static int[] aux;

    public static void sort(int[] a){
        aux = new int[a.length];
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int lo, int hi){
        if(hi <= lo) return;
        int N = a.length;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        if(a[mid] < a[mid+1]) return;
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi){
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int k = lo;
        while(k <= hi){
            if(i > mid) a[k++] = aux[j++];
            else if(j > hi) a[k++] = aux[i++];
            else if(aux[i] > aux[j]) a[k++] = aux[j++];
            else a[k++] = aux[i++];
        }
    }
}
