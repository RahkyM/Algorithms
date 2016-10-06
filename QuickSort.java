/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaphelper;

/**
 *
 * @author Matthew
 */
public class QuickSort <T extends Comparable<T>>{
    
    protected T[] array;
    protected int size;
    
    public QuickSort(){
        array = (T[]) new Comparable[10];
        size = 10;
    }
    
    public QuickSort(T[] list){
        array = list;
    }
     public QuickSort(int n){
         array =(T[]) new Comparable[n];
     }
    
    
    public void quickSort(int p, int r){
        if(p < r){
            int q = partition(p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }
    }
    
    public int partition(int p, int r){
        T x = array[r];
        int i = p - 1;
        
        for(int j = p; j < r; j++){
            if(array[j].compareTo(x) < 0){
                i = i + 1;
                swap(i, j);
            }
        }
        swap(i + 1, r);
        
        return i + 1;
    }
    
    public void swap(int n1, int n2){
        T temp = array[n1];
        array[n1] = array[n2];
        array[n2] = temp;
    }
    
    public void print(){
        for(T array1: array){
            System.out.print(array1 + " ");
        }
        System.out.println("");
    }
    
    
}
