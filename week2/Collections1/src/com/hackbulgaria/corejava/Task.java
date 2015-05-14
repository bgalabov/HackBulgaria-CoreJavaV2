package com.hackbulgaria.corejava;

public abstract class Task implements Comparable<Task>{
	int priority;
	float hoursToComplete;
	
	public enum PRIORITY_TYPES {
		DEFAULT(5), MIN(1), MAX(10), BELOW_AVERAGE(3);
		
		private final int value;
		PRIORITY_TYPES(int value) {
		this.value=value;
	}
		public int getValue() {
			return value;}
		}
	
	
	@Override
	public int compareTo(Task t) {
		return t.priority - this.priority;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public float getHoursToComplete() {
		return this.hoursToComplete;
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
