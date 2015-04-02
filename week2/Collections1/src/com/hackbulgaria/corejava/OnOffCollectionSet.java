package com.hackbulgaria.corejava;

import java.util.HashSet;
import java.util.Set;

public class OnOffCollectionSet {
	private Set<Object> s;
	
	public OnOffCollectionSet() {
		s = new HashSet();
	}
	
	public void add(Object e) {
		if(s.contains(e)){
			s.remove(e);
			return;
		}
		s.add(e);
		
	}
	
	/*public boolean contains(Object e) {
		return s.contains(e);
	}*/
	
	public Object[] getAllElements() {
		return s.toArray();
	}
	
	
}

	