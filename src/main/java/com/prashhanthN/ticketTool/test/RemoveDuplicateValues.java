package com.prashhanthN.ticketTool.test;

import java.util.HashMap;

public class RemoveDuplicateValues {

	public static void removeDupl(String statement ){
		String breakArr[]=statement.split(" ");
		HashMap<String, Integer> map= new HashMap<>();
		for(String word: breakArr){
			
			if(map.get(word)!=null){
				map.put(word, map.get(word)+1);
			}
			else{
				map.put(word, 1);	
			}
			
		}
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		removeDupl("Hi how how are you how");
	}
}
