package com.prashhanthN.algorithm;

public class HalfPyrimid {

	public static void main(String[] args) {
		for (int a = 0; a < 5; a++) {
			for (int i = 1; i < 6; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print(j);
				}
				System.out.println();
			}
		}
	}

}
