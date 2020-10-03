
package heapsort;

import java.util.*;

public class HeapSort {
    
    public static void main(String[] args) {
        int maxHeapArr[] = {77,53,49,31,47,34,44,11,13,21,24,28};        
        System.out.println("Sample Max Heap: ");
        System.out.println(Arrays.toString(maxHeapArr));
        int n = maxHeapArr.length;
        for(int j=0;j<n;++j){
            deleteRoot(maxHeapArr, n-j-1,"MaxHeap");
        }
        System.out.println("Heap Sorted Array (Ascending): ");
        System.out.println(Arrays.toString(maxHeapArr));
        
        int minHeapArr[] = {2,5,7,10,11,9,71,19,49,57,73,15};
        System.out.println("Sample Min Heap: ");
        System.out.println(Arrays.toString(minHeapArr));
        
        int m = minHeapArr.length;
        for(int j=0;j<m;++j){
            deleteRoot(minHeapArr, n-j-1,"MinHeap");
        }
        System.out.println("Heap Sorted Array (Descending): ");
        System.out.println(Arrays.toString(minHeapArr));
    }
    
    public static void deleteRoot(int[] arr, int idxLast, String minmax){
        //System.out.println("Deleted Node: "+arr[0]);
        int temp = arr[0];
        arr[0] = arr[idxLast];
        arr[idxLast] = temp;
        if(minmax.equals("MaxHeap")){
            maxHeapify(arr,0,idxLast);  
        }
        if(minmax.equals("MinHeap")){
            minHeapify(arr,0,idxLast);  
        }
        //System.out.println("Heapified: ");
        //System.out.println(Arrays.toString(arr));
    }
    
    public static void maxHeapify(int arr[], int startIdx, int lastIdx) 
    { 
        int largest = startIdx; // Initialize largest as root 
        int l = 2 * startIdx + 1; // left = 2*i + 1 
        int r = 2 * startIdx + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < lastIdx && arr[l] > arr[largest]) largest = l; 
  
        // If right child is larger than largest so far 
        if (r < lastIdx && arr[r] > arr[largest]) largest = r; 
  
        // If largest is not root 
        if (largest != startIdx) { 
            int swap = arr[startIdx]; 
            arr[startIdx] = arr[largest]; 
            arr[largest] = swap;   
            // Recursively heapify the affected sub-tree 
            maxHeapify(arr, largest, lastIdx-1); 
        }       
    } 
    public static void minHeapify(int arr[], int startIdx, int lastIdx) 
    { 
        int smallest = startIdx; // Initialize largest as root 
        int l = 2 * startIdx + 1; // left = 2*i + 1 
        int r = 2 * startIdx + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < lastIdx && arr[l] < arr[smallest]) smallest = l; 
  
        // If right child is larger than largest so far 
        if (r < lastIdx && arr[r] < arr[smallest]) smallest = r; 
  
        // If largest is not root 
        if (smallest != startIdx) { 
            int swap = arr[startIdx]; 
            arr[startIdx] = arr[smallest]; 
            arr[smallest] = swap;   
            // Recursively heapify the affected sub-tree 
            minHeapify(arr, smallest, lastIdx-1); 
        }       
    } 
}
