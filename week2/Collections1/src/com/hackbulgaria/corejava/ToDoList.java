package com.hackbulgaria.corejava;

import java.util.PriorityQueue;

public class ToDoList {
	float hoursCapacity;
	float busyHours;
	private PriorityQueue<Task> queue;

	public ToDoList(int hoursCapacity) {
		this.hoursCapacity = hoursCapacity;
		this.busyHours = 0;
		queue = new PriorityQueue<Task>();
	}

	public void addTask(Task t) {
		this.busyHours += t.getHoursToComplete();
		queue.add(t);
	}

	public void markFinished(Task t) {
		queue.remove(t);
	}

	public void markCancelled(Task t) {
		this.hoursCapacity += t.hoursToComplete;
		queue.remove(t);
	}

	public Task getTop() {
		return queue.peek();
	}

	public boolean canFinish() {
		if (getRemainingTime() >= 0) {
			return true;
		}
		return false;
	}

	public float getRemainingTime() {
		return this.hoursCapacity - this.busyHours;
	}
	
	public float getTimeNeeded() {
		return this.busyHours;
	}

	public String top() {
		return getTop().toString();
	}
}
