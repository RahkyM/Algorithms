/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaphelper;
import static java.lang.Math.*;
import java.util.*;
/**
 *
 * @author Matthew
 */
public class BinaryHeap<T extends Comparable<T>> {

    /**
     * @param args the command line arguments
     */
    private static final int DEFAULT_SIZE = 10; 
    protected T[] array;
    protected int size;
    
    BinaryHeap(){
        array =(T[]) new Comparable[DEFAULT_SIZE];
        this.size = DEFAULT_SIZE;
    }

    public BinaryHeap(int n){
        array = (T[]) new Comparable[n];
        size = n;
    }
    public BinaryHeap(int n, T[] heap){
        array = (T[]) heap;
        size = n;
    }
    
    public BinaryHeap(T[] heap){
        array = (T[]) heap;
        size = array.length;
    }
    
    public T[] resize(){
        return Arrays.copyOf(array, array.length * 2);
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
    
    public void heapMaxSort(){
        buildMaxHeap();
        for(int i = array.length - 1; i >= 0; i--){
            swap(0, i);
            size--;
            maxHeapify(0);
        }
        size = array.length;
    }
    
    public void minHeapify(int i){
        int l = Left(i);
        int r = Right(i);
        int largest;
        if(l <= size - 1 && array[l].compareTo(array[i]) < 0){
            largest = l;
        }
        else{
            largest = i;
        }
        if(r <= size - 1 && array[r].compareTo(array[largest]) < 0){
            largest = r;
        }
        if(largest != i){
            swap(i, largest);
            minHeapify(largest);
        }
    }
    
    public void maxHeapify(int i){
        int l = Left(i);
        int r = Right(i);
        int largest;
        if(l <= size - 1 && array[l].compareTo(array[i]) > 0){
            largest = l;
        }
        else{
            largest = i;
        }
        if(r <= size - 1 && array[r].compareTo(array[largest]) > 0){
            largest = r;
        }
        if(largest != i){
            swap(i, largest);
            maxHeapify(largest);
        }
    }
    
    public void swap(int n1, int n2){
        T temp = array[n1];
        array[n1] = array[n2];
        array[n2] = temp;
    }
    
    public void print(){
        for (T array1 : array) {
            System.out.print(array1 + " ");
        }
        System.out.println("");
    }
    
    public void buildMinHeap(){
        size = array.length;
        for(int i = (int) floor((array.length - 1) / 2); i >= 0; i--){
            minHeapify(i);
        }
    }
    
    public void buildMaxHeap(){
        size = array.length;
        for(int i = (int) floor((array.length - 1) / 2); i >= 0; i--){
            maxHeapify(i);
        }
    }
  
    public int Left(int i){
        return 2* i + 2;
    }
    
    public int Right(int i){
        return 2 * i + 1;   
    }
    
    public int Parent(int i){
        return (int) ceil(i/2) - 1;
    }
    
}
