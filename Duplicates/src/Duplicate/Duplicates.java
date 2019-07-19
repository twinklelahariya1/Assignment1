package Duplicate;
import Sort.MergeSort;

public class Duplicates{  
    public static int removeDuplicateElements(int arr[], int n){  
        if (n==0 || n==1){  
            return n;  
        }    
        int j = 0;
        for (int i=0; i < n-1; i++){  
            if (arr[i] != arr[i+1]){  
                arr[j++] = arr[i];  
            }  
        }  
        arr[j++] = arr[n-1];  
        return j;  
    }  
       
    public static void main (String[] args) {  
        int arr[] = {10,10,30,10,30,70,90,100};
        
        int length = arr.length;  
        MergeSort.sort(arr, 0, arr.length - 1);
        length = removeDuplicateElements(arr, length);   
        for (int i=0; i<length; i++)  
           System.out.print(arr[i]+" ");  
    }  
}
