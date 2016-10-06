/*
 * Uses quickSort with a random partition pivot point to find the kth 
 * element in an array.
 *
 * 
 */
package heaphelper;

/**
 *
 * @author Matthew
 */
public class RandomSelect {
    protected int[] array;
    
    RandomSelect(){
        array = new int[10];
    }
    
    RandomSelect(int[] list){
        array = list;
    }
    
    
    public int randomizedSelect(int p, int r, int i){
        if(i > array.length){
            return -1;
        }
        
        if(p == r){
            return array[p];
        }
        int q = randomizedPartition(p,r);
        int k = q - p + 1;
        if(i == k){
            return array[q];
        }
        else if(i < k){
            return randomizedSelect(p, q - 1, i);
        }
        else{
            return randomizedSelect(q + 1, r, i - k);
        }    
    }

    public int randomizedPartition(int p, int r) {
        int n = r - p + 1;
        int pivot = (int) (Math.random() % n);
        swap(p + pivot, r);
        return partition(p, r);
    }
    
    public void swap(int n1, int n2){
        int temp = array[n1];
        array[n1] = array[n2];
        array[n2] = temp;
    }

    private int partition(int p, int r) {
        int x = array[r], i = p;
        for (int j = p; j <= r - 1; j++){
            if (array[j] <= x){
                swap(i, j);
                i++;
            }
        }
        swap(i, r);
        return i;
    }
    
    public void print(){
        for(int array1: array){
            System.out.print(array1 + " ");
        }
        System.out.println("");
    }

}
