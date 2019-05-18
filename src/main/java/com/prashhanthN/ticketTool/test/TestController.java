package com.prashhanthN.ticketTool.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prashhanthN.ticketTool.Exceptions.ResourceNotFound;

@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping ("/ays1")
@RestController
//@ControllerAdvice
public class TestController {
	HashMap<String, String>hm= new HashMap<String,String>();
	ArrayList<Integer> al= new ArrayList<>();
	List<Object>l;
	
	
	@GetMapping("/test")
	public Long test() {
		int i=0;
		long start= System.currentTimeMillis();
/*		for(i=0;i<1000000;i++) {
			System.out.println(i);
		}		
*/		TestController t= new TestController();
        t.run1();
        t.run2();
        t.run3();
		long end= System.currentTimeMillis();
		return (end-start)/1000;
	}
	
	@GetMapping("/test1")
	public Long test1() throws InterruptedException {
		long start= System.currentTimeMillis();
		Thread t1= new Thread(new Thread2());
		Thread t2= new Thread(new Thread1());
		Thread t3= new Thread(new Thread3());
		t1.start();
		t2.start();
		t3.start();
		t3.join();
		long end= System.currentTimeMillis();
		return (end-start)/1000;
	}
	
	public void run1() {
		int i;
		for(i=0;i<500000;i++) {
			System.out.println(i);
		}
	}
	
	
	public void run3() {
		int i;
		for(i=0;i<500000;i++) {
			System.out.println(i);
		}
	}
	public void run2() {
		int i;
		for(i=0;i<500000;i++) {
			System.out.println(i);
		}
	}
	
    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "meters/notfound";
    }
    
    
    @GetMapping("/etms")
    public HashMap<String, ArrayList<String>> getTickets(){
    	ArrayList<String> al= new ArrayList<>();
    	ArrayList<String> al1= new ArrayList<>();
    	al.add("1546564665");
    	al.add("7546564665");
    	al.add("5546564665");
    	
    	al1.add("1546564665");
    	al1.add("7546564665");
    	al1.add("5546564665");
    	
    	HashMap<String, ArrayList<String>> hm= new HashMap<>();
    	hm.put("7458146",al);
    	return hm;
    }
    
    @GetMapping(value="/q/{query}")
    public Object release(@PathVariable("query")String q){
    	l= new ArrayList<>();;
    	hm.put("Avatar","James");
    	hm.put("Titanic","James");
    	hm.put("Indiana Jones","Steve");
    	hm.put("Hangover","Todd Phippe");
    	hm.put("Inception","Christoper Nolan");
    	
    	al.add(1);
    	al.add(11);
    	al.add(2);
    	al.add(55);
    	al.add(14);
    	
    	if("m".equals(q)){
    		for(String s:hm.keySet()){
    		String director=hm.get(s);
    		l.add(director);
    		}
    		
    	}
    	else if("l".equals(q)){
    		l.add(al);
    		System.out.println("hi");
    	}
    	else{
    		l.add(hm);
    		l.add(al);
    	}
    	
    	return new ResponseEntity<Object>(l.toString(),HttpStatus.OK);
    }
}
