package com.algo;

public class Inversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		In in= new In("G:/data/IntegerArray.txt");
		
		int[] fileResults =in.readAllInts();
		
		System.out.println(Integer.toString(fileResults.length));
		
		//int[] inputArray = new int[]{1,3,5,2,4,6};
		
	
		
		// Divide the array into two halves and then pass it to Sort_Count
		
		long resultTotalInversions= Sort_Count(fileResults);
		
		System.out.println(resultTotalInversions);

	}
	
static 	long Sort_Count(int[] inputArray){
		
	// base Case
		if (inputArray.length ==1) return 0;
	
		int midIndex = inputArray.length/2;
		
		
	// Divide the arrays
		//Copy first Array
	int[] arrayFirst= new int[midIndex];
	for(int i=0;i<midIndex;i++)
	{
		arrayFirst[i]= inputArray[i];
		
	}
	
	
		// 	copy Second Array
	int inputArrayIndex = midIndex;
	int secondArrayLength= inputArray.length-midIndex;
	int[] arraySecond= new int[secondArrayLength];
	for(int j=0; j<secondArrayLength;j++)
	{
		arraySecond[j]= inputArray[inputArrayIndex++];
		
		
	}
		
	//sort them	
	long x=	Sort_Count(arrayFirst);
	
	long y=	Sort_Count(arraySecond);
		
	long z=	Sort_Count_SplitInv(arrayFirst, arraySecond);
			
	return x+y+z;
				
	}
	
	static long Sort_Count_SplitInv(int[] arrayFirst, int[] arraySecond){
		
		long totalInversions=0;
		
		java.util.Arrays.sort(arrayFirst);
		java.util.Arrays.sort(arraySecond);
		
		
		int resultArrayLength = arrayFirst.length+arraySecond.length;
		
		
		//int[] resultArray = new int[resultArrayLength];
		
		// implement merge Sort and then count the inversions
		int i=0;
		int j=0;
		
		for(int k=0;k<resultArrayLength;k++){
			
			if (i==arrayFirst.length) break;
			if(j==arraySecond.length) break;
			
			if( arrayFirst[i] < arraySecond[j] )
			{
				
				//resultArray[k] = arrayFirst[i];
				i++;
				
			}
			else if(arraySecond[j]<arrayFirst[i])
			{
				totalInversions = totalInversions + arrayFirst.length - i;
				
				//resultArray[k] = arraySecond[j];
				j++;
				
			}
				
			
		}
		
		
		return totalInversions;
	}

}
