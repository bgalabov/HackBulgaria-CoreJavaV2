package com.hackbulgaria.corejava;

public interface Stack {
	
		
		public void push(Object newObject);
		
		public Object pop();
		public Object peek();		
		public int getCapacity();		
		public int getCurrentLength();		
		public boolean isEmpty();		
		public boolean isFull();

		public void clear();

		boolean notContains(Object object);

		
		





}
