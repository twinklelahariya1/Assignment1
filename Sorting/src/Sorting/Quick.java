package Sorting;
public class Quick implements SortingChoice{
	@Override
	public void sort(int array[], int size) {
		// TODO Auto-generated method stub
		
		long startTime = System.nanoTime();
        for (int i = 0; i < size-1; i++) 
            for (int j = 0; j < size-i-1; j++) 
                if (array[j] > array[j+1]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    int temp = array[j]; 
                    array[j] = array[j+1]; 
                    array[j+1] = temp; 
                }
		
        
        for (int i=0; i<size; ++i)
            System.out.print(array[i]+" ");
		
		System.out.println("QuickSort");
		
		long endTime = System.nanoTime();
		
		System.out.println("\nQuick Sort Took "+(endTime - startTime) + " ns"); 
	}
	
}