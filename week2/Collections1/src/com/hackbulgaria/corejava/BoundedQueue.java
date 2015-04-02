package com.hackbulgaria.corejava;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BoundedQueue <E> implements Queue {
	private List<E> list;
	int capacity;
	int currentSize;
	
	public BoundedQueue(int capacity) {
		list = new LinkedList<E>();
		this.capacity=capacity;
		this.currentSize=0;
	}

	@Override
	public int size() {
		return capacity;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}

	@Override
	public Iterator iterator() {
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public Object[] toArray(Object[] a) {
		return list.toArray(a);
	}

	@Override
	public boolean remove(Object o) {
		if(list.isEmpty()){
			return false;
		}
		list.remove(o);
		return true;
	}

	@Override
	public boolean containsAll(Collection c) {
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection c) {
		return list.addAll(c);
	}

	@Override
	public boolean removeAll(Collection c) {
		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection c) {
		return list.retainAll(c);
	}

	@Override
	public void clear() {
		list.clear();
		
	}

	@Override
	public boolean add(Object e) {
		if(currentSize<capacity){
			list.add((E) e);
			currentSize++;
			return true;
		}
		remove(); //removes head;
		list.add((E) e);
		return true;
	}

	@Override
	public boolean offer(Object e) {
		if(currentSize<capacity){
			list.add((E) e);
			currentSize++;
			return true;
		}
		list.remove(0); //removes head;
		list.add((E) e);
		return true;
	}

	@Override
	public Object remove() {
		return list.remove(0);
	}

	@Override
	public Object poll() {
		if(!list.isEmpty()){
			return list.remove(0);
		}
		return null;
	}

	@Override
	public Object element() {
		if(list.isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		return list.get(0);
	}

	@Override
	public Object peek() {
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}
	
	public String toString() { 
		StringBuilder strbldr = new StringBuilder();
		for(int i=0; i<this.capacity; i++) {
			strbldr.append(list.get(i) + ", ");
		}
		return strbldr.subSequence(0, strbldr.length() - 2).toString();
	}
	
	

}
