package com.prashhanthN.ticketTool.test;

import org.springframework.scheduling.annotation.Async;

public class Thread2 extends Thread {

	@Override
	@Async
	public void run() {
		int i;
		for(i=0;i<500000;i++) {
			System.out.println(i);
		}
	}
}
