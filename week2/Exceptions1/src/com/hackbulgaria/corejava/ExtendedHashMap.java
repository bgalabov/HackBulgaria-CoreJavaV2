package com.hackbulgaria.corejava;

import java.util.HashMap;

public class ExtendedHashMap<K, V> extends HashMap<K, V> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean canContainsNull;
	
	public ExtendedHashMap() {
		this.canContainsNull = false;
	}
	
	public void setCanContainsNull(boolean option) {
		this.canContainsNull = option;
	}
	
	public boolean getCanContainsNull(boolean option) {
		return this.canContainsNull;
	}
	
	@Override
	public V put(K key, V value) {
		if((this.canContainsNull==false)&&((key==null)||(value==null))) {
			throw new NullKeyOrValueException(key, value);
		}
		return super.put(key, value);
	}
	
	
	


}
