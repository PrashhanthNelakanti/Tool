package com.prashhanthN.algorithm;

public class ReturnOddFromN {

	static int a[],count=0; 

	public static int[] returnNum(int n) {
		a = new int[n];
		for (int i = 0; i < n; i++) {
			if (i>0 && i % 3== 0) {
				a[i] = i;
				System.out.println(a[i]);
			}
		}
		return a;
	}

	public static void main(String[] args) {
		a = returnNum(55);
		
		
	}

}
