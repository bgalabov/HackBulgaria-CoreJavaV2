package com.hackbulgaria.corejava;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class TestMain {

	public static void fooUncheckedException() {
		throw new DatabaseCorruptedException("Column `name` from database table `users` is corrupted.");
	}
	
	public static ServiceNotAvailableAtTheMoment fooCheckedException() throws ServiceNotAvailableAtTheMoment {
		throw new ServiceNotAvailableAtTheMoment("Heartbeat", "dead connection");
	}
	/*public static void main(String[] args) {
		//no need to catch it, it's RuntimeException
		//fooUncheckedException();
		
		try {
			fooCheckedException();
		} catch (ServiceNotAvailableAtTheMoment e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//no fail, everything is valid
		Time t = new Time(12, 12, 12, 12, 12, 2012);
		System.out.println(t.toString());
		
		//fail
		Time t1 = new Time(-3, 12, 12, 12, 12, 2012);
		System.out.println(t1.toString());
	}*/
	
	/*public static void main(String[] args) {
		ExtendedHashMap<String, Integer> map = new ExtendedHashMap<String, Integer>();
		Integer a=1;
		Integer b=null;
		String str=null;
		map.put("a", 2);
		map.put(str, b);
		System.out.println("I am resuming");
	}*/
	
	public static void main(String[] args) {
		List<StringBuilder> ll = new LinkedList<StringBuilder>();
		List<StringBuilder> ll1 = new LinkedList<StringBuilder>();
		ll1.add(new StringBuilder("1"));
		ll1.add(new StringBuilder("2"));
		System.out.println(ll1.get(0));
		/*ll.add(1);
		ll.add(2);
		ll.add(3);*/
		
		ImmutableList<StringBuilder> il = new ImmutableList<StringBuilder>(ll1);
		/*System.out.println(il.get(0));
		System.out.println(il.get(1));
		System.out.println(il.get(2));*/
		
		//blows Exeption
		//il.remove(2);
		
		//Test that the get() method returns a copy of element, but not a reference!
		StringBuilder a = il.get(0);
		//a++;
		System.out.println(a.append("!"));
		System.out.println(il.get(0));
	}
	
	
}
