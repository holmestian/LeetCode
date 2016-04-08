package edu.sjtu.holmes.sort;

/**
 * Created by holmes on 16/4/8.
 */
public class AbstractSort {
    public static void sort(Comparable[] a){}

    public static void sort(int[] a){}

    protected static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        int[] test = {1,3,6,2,9,1,23,1,7,56};
        //SelectSort.sort(test);
        //InsertSort.sort(test);
        //ShellSort.sort(test);
        //QuickSortBase.sort(test);
        MergeSort.sort(test);
        print(test);
    }

    private static void print(int[] a){
        int N = a.length;
        for (int e :
                a) {
            System.out.print(e+", ");
        }
        System.out.println();
    }

}
