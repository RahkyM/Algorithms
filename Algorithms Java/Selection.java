/*
 * Selection of kth smallest element in an array. CLRS 9.3.
 */
package heaphelper;

/**
 *
 * @author Matthew
 */
public class Selection {
    protected int[] array;
    
    Selection(){
        array = new int[10];
    }
    
    Selection(int[] list){
        array = list;
    }
    
    
    public int select(int p, int r, int i){
        if(i > array.length){
            return -1;
        }
        
        if(p == r){
            return array[p];
        }
        int q = partition(p,r);
        int k = q - p + 1;
        if(i == k){
            return array[q];
        }
        else if(i < k){
            return select(p, q - 1, i);
        }
        else{
            return select(q + 1, r, i - k);
        }    
    }

    
    public void swap(int n1, int n2){
        int temp = array[n1];
        array[n1] = array[n2];
        array[n2] = temp;
    }

    public int partition(int p, int r){
        int x = array[r];
        int i = p - 1;  
        for(int j = p; j < r; j++){
            if(array[j] <= x){
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, r);
        return i + 1;
    }
    
    public void print(){
        for(int array1: array){
            System.out.print(array1 + " ");
        }
        System.out.println("");
    }
    
    
    
    
}
