package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Sort {

	public static void main(String[] args) throws IOException {
		
		long startTime = System.nanoTime();
		
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.println("\nEnter the size of array::");
		int num = Integer.parseInt(br.readLine()); //Length of Array
		System.out.println("\nEnter array elements");
		String s= br.readLine(); //Input the number seperated by space
		int[] arr= new int[num];
		String[] s1 = s.split(" ");
		
		
		for(int i=0;i<num;i++)
		{
		    arr[i]=Integer.parseInt(s1[i]);
		}
		
		
		
		char characterToContinue;
		
		
		
		do {
			
			BufferedReader brObj = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\nEnter choice of sorting\n");
			System.out.println("1:Selection Sort\n");
			System.out.println("2:Quick Sort\n");
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String choiceString = reader.readLine();
			//System.out.println(choiceString);    
			
			int choiceInt = Integer.parseInt(choiceString);
		
			switch (choiceInt) {
			case 1:
				SortingChoice interfaceObject1 = new Selection();
				int[] sortedArrayWithSelection=interfaceObject1.sort(arr,num);
				printSortedData(sortedArrayWithSelection);
				break;
			
		
			case 2:
				SortingChoice interfaceObject2 = new Quick();
				int[] sortedArrayWithQuick=interfaceObject2.sort(arr,num);
				printSortedData(sortedArrayWithQuick);
				break;
			
			
			default:
				break;
			}
		System.out.println("Do you want to continue(Y/N)::");
		
		characterToContinue = (char) brObj.read();
		
		}while(characterToContinue != 'N');
		
		
		long endTime = System.nanoTime();
		
		System.out.println("\nEntire Program Took "+(endTime - startTime) + " ns"); 


	
	
	}
	
	private static void printSortedData(int[] array) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(array));
	}
}
