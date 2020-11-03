package src.com.dsa;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseArray {
	
	//Read inputs
	
	public static void main(String args[]) throws Exception {

		int[] inputArray;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numInputs =Integer.parseInt(br.readLine());
		inputArray = new int[numInputs];
		
		for(int i=0; i < numInputs-1; i++) {
			int input = Integer.parseInt(br.readLine());
			inputArray[i] = input;
			
			System.out.println("Original Array: " + inputArray[i]);
		}
		
		
		
		//reverse the array
		for(int j = numInputs; j>0; j--) {
			
			System.out.println("reverse arrya" + inputArray[j-1]);
			
		}

	}
	
}
