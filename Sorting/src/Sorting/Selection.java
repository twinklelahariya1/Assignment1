package Sorting;
public class Selection implements SortingChoice{
	@Override
	public void sort(int array[], int size) {
		
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < size-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < size; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
		
        for (int i=0; i<size; ++i)
            System.out.print(array[i]+" ");
		
        System.out.println("SelectionSort");
        
        long endTime = System.nanoTime();
		
		System.out.println("\nSelection Sort Took "+(endTime - startTime) + " ns"); 
	}
}
	