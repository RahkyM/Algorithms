/*
 * To BinaryHeap for ints.
 *
 * does not implement add, remove, findMin, etc...
 */
package heaphelper;

import static java.lang.Math.*;

/**
 *
 * @author Matthew
 */
public class IntBinaryHeap {
    protected int[] array;
    private static final int DEFAULT_SIZE = 10;
    protected int size;
    
    public IntBinaryHeap(){
        array = new int[10];
        this.size = DEFAULT_SIZE;
    }
    
    public IntBinaryHeap(int n){
        array = new int[n];
    }
    
    public IntBinaryHeap(int n, int[] heap){
        array = heap;
        size = n;
    }
    
    public IntBinaryHeap(int[] heap){
        array = heap;
        size = array.length;
    }
    
    public void maxHeapify(int i){ 
        int r = rightIndex(i);
        //System.out.println("right index is " + r);
        int l = leftIndex(i);
        //System.out.println("left index is " + l);
        //System.out.println("i is " + array[i]);
        int largest;
        if(l < size){
            //System.out.println("left is " + array[l]);
        }
        if(l < size && array[l] > array[i]){  
            largest = l;
        }
        else{
            largest = i;
        }
        if(r < size){
            //System.out.println("right is " + array[r]);
        }
        if(r < size && array[r] > array[largest]){
            largest = r;
        }
        if(largest != i){
            swap(i, largest);
            maxHeapify(largest);
        }    
    }
    
    public void minHeapify(int i){ 
        int r = rightIndex(i);
        //System.out.println("right index is " + r);
        int l = leftIndex(i);
        //System.out.println("left index is " + l);
        //System.out.println("i is " + array[i]);
        int smallest;
        if(l < size){
            //System.out.println("left is " + array[l]);
        }
        if(l < size && array[l] < array[i]){  
            smallest = l;
        }
        else{
            smallest = i;
        }
        if(r < size){
            //System.out.println("right is " + array[r]);
        }
        if(r < size && array[r] < array[smallest]){
            smallest = r;
        }
        if(smallest != i){
            swap(i, smallest);
            minHeapify(smallest);
        }    
    }
    public void heapMaxSort(){
        buildMaxHeap();
        for(int i = array.length - 1; i >= 0; i--){
            swap(0, i);
            size--;
            maxHeapify(0);
        }
        size = array.length;
    }
    
    public void heapMinSort(){
        buildMinHeap();
        for(int i = array.length - 1; i >= 0; i--){
            swap(0, i);
            size--;
            minHeapify(0);
        }
        size = array.length;
    }
    
    public void buildMaxHeap(){
        size = array.length;
        for(int i = (int) floor((array.length - 1) / 2); i >= 0; i--){
            //System.out.println("i is " + i);
            //print();
            maxHeapify(i);
        }
    }
    
    public void buildMinHeap(){
        size = array.length;
        for(int i = (int) floor((array.length - 1) / 2); i >= 0; i--){
            //System.out.println("i is " + i);
            //print();
            minHeapify(i);
        }
    }
    
    public void swap(int n1, int n2){
        int temp = array[n1];
        array[n1] = array[n2];
        array[n2] = temp;
    }
    
    public void print(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
    
    public int parentIndex(int i){
        return (int) (ceil(i / 2) - 1);
    }
    
    public int leftIndex(int i){
        return 2 * i + 2;
    }
    
    public int rightIndex(int i){
        return 2 * i + 1;
    }
}
