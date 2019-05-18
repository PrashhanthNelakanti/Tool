package com.prashhanthN.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Algorithm1 {

	public static void main(String[] args) {
		int a[] = { 1, 5, 8, 7, 9 };
		int b[] = { 12, 5, 80, 70 };
		List<Integer> alist = new ArrayList<Integer>();
		List<Integer> blist = new ArrayList<Integer>();
		List<Integer> clist = new ArrayList<Integer>();

		int count = 0;
		int c[] = { 4, 3 };

		for (int al : a) {
			alist.add(al);
		}

		for (int bl : b) {
			blist.add(bl);
		}

		if (alist.size() != blist.size()) {
			if (alist.size() > blist.size()) {
				count = alist.size() - blist.size();
				 clist = equalizer(blist, count);
				 for(int x:clist){
				//	blist.add(x); 
				 }
			} else {
				count = blist.size() - alist.size();
				equalizer(blist, count);
				clist = equalizer(alist, count);
				 for(int x:clist){
					blist.add(x); 
				 }
			}
		}
		System.out.println(alist);
		System.out.println(blist);
		System.out.println(clist);
		
		process(alist,blist);

	}

	public static List<Integer> equalizer(List<Integer> alist, int count) {
		for (int i = 0; i < count; i++) {
			alist.add(0);
		}
		return alist;
	}
	
	static void process(List<Integer> al,List<Integer> bl){
		for(int i=0;i<al.size()-1;i++){
			 System.out.println(al.get(i)*bl.get(i));
			
		}
		
	}
}