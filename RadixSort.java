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
public class RadixSort {
    
    protected int[] array;
    protected int size;
    
    RadixSort(){
        array = new int[10];
        size = 10;
    }
    
    RadixSort(int[] list){
        array = list;
        size = array.length;
    }
    
    public int findMax(){
       int max = array[0];
       for(int i = 1; i < size; i++){
           if(array[i] > max){
               max = array[i];
           }
       }         
       return max;
    }
    
    void sort(){
        int max = findMax();
        int exp = 1;
        int[] b = new int[size];
        
        while(max / exp > 0){
            int[] bucket = new int[10];
            for(int i = 0; i < size; i++){
                bucket[(array[i] / exp) % 10]++;
            }           
            for(int i = 1; i < 10; i++){
                bucket[i] += bucket[i - 1];
            }
            for (int i = size - 1; i >= 0; i--){
                b[--bucket[(array[i] / exp) % 10]] = array[i];
            }
            for (int i = 0; i < size; i++){
                array[i] = b[i];
            }
            exp *= 10;
        }
    }
    void print(){
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}