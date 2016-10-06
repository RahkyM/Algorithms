/*
 * QuickSort for ints.
 */
package heaphelper;

/**
 *
 * @author Matthew
 */
public class IntQuickSort {
    
    protected int[] array;
    protected int size;
    
    public IntQuickSort(){
        array = new int[10];
    }
    
    public IntQuickSort(int n){
        array = new int[n];
    }
    
    public IntQuickSort(int n, int[] list){
        array = list;
        size = n;
    }
    
    public IntQuickSort(int[] list){
        array = list;
        size = array.length;
    }
    
    public void quickSort(int p, int r){
        if(p < r){
            int q = partition(p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }
    }
    
    public int partition(int p, int r){
        int x = array[r];
        int i = p - 1;
        
        for(int j = p; j < r; j++){
            if(array[j] <= x){
                i = i + 1;
                swap(i, j);
            }
        }
        swap(i + 1, r);
        
        return i + 1;
    }
    
    public void swap(int n1, int n2){
        int temp = array[n1];
        array[n1] = array[n2];
        array[n2] = temp;
    }
    
    public void print(){
        for(int array1: array){
            System.out.print(array1 + " ");
        }
        System.out.println("");
    }
    
}
