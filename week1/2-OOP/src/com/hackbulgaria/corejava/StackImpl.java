package com.hackbulgaria.corejava;

import java.util.Arrays;

//Warnining! Should enable assertion expressions (-ea) in Run Configuration in order to work!

public class StackImpl implements Stack {

	private Object[] stack;
	private int currentLength;
	
	public StackImpl(int size){
		this.stack = new Object[size];
		this.currentLength=0;
		
	}
	
	@Override
	public void push(Object newObject) {
		if (currentLength < stack.length) {
			assert this.notContains(newObject) : "Stack already contains element the element you want to insert";
				stack[currentLength++] = newObject;
		} else {
			throw new StackOverflowError();
		}
		assert newObject.equals(peek()) : "Insertion failed.";
	}
	
	@Override
	public Object pop(){
		if(isEmpty()){
			return null;
		} else {
			return stack[--currentLength];
		}
	}
	
	@Override
	public Object peek(){
		return stack[currentLength-1];
	}
	
	@Override
	public int getCapacity(){
		return stack.length;
	}
	
	@Override
	public int getCurrentLength(){
		return currentLength;
	}
	
	@Override
	public boolean isEmpty(){
		if(currentLength==0){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isFull(){
		if(currentLength==stack.length){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean notContains(Object object){
		for(int i=0; i<currentLength; i++){
			if(stack[i].equals(object)){
				return false;
				//System.out.println("true");
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentLength;
		result = prime * result + Arrays.hashCode(stack);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StackImpl other = (StackImpl) obj;
		if (currentLength != other.currentLength)
			return false;
		if (!Arrays.equals(stack, other.stack))
			return false;
		return true;
	}

	@Override
	public void clear(){
		for(int i=currentLength-1; i>=0; i--){
			stack[i]=null;
			currentLength--;
		}
	}
	
	public static void main(String[] args) {
		StackImpl s = new StackImpl(10);
		s.push(2);
		s.push("aa");
	//	s.push("aa"); blows up on assertion :)
		
		
		System.out.println(s.pop());
		System.out.println(s.pop());
	//	System.out.println(s.pop());
		
		
		

	}
}
	



