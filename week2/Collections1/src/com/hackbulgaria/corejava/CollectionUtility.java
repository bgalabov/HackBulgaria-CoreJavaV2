package com.hackbulgaria.corejava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


public class CollectionUtility {
	
	public static <T> void rotate(Collection<T> collection, int rotateStep) {
		List<T> list = new LinkedList<T>();
		list.addAll(collection);
		collection.clear();
		if(rotateStep>0) {
			if(rotateStep>list.size())
				rotateStep%=list.size();
			collection.addAll(list.subList(list.size()-rotateStep, list.size()));
			collection.addAll(list.subList(0, list.size()-rotateStep));
		} 
		else {
			if(Math.abs(rotateStep)>list.size())
				rotateStep%=list.size();
			rotateStep=Math.abs(rotateStep);
			collection.addAll(list.subList(rotateStep, list.size()));
			collection.addAll(list.subList(0, rotateStep));
		}
	}
	
	public static Integer firstUnique(Collection <Integer> collection) {
		Map<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
		java.util.Iterator<Integer> it = collection.iterator();
		Integer currentInt;
		java.util.Iterator it1;
		Set entrySet;
		Map.Entry<Integer, Integer> me;
		
		while(it.hasNext()){
			currentInt=it.next();
			if(!linkedHashMap.containsKey(currentInt)) {
				linkedHashMap.put(currentInt, 1);
			} else {
				linkedHashMap.put(currentInt, linkedHashMap.get(currentInt)+1);
			}
		}
		
		entrySet=linkedHashMap.entrySet();
		it1=entrySet.iterator();
		while(it1.hasNext()) {
			me = (Entry) it1.next();
			if(me.getValue().equals(1)){
				return (Integer) me.getKey();
			}
		}
		
		return null;
	}
	
	public static <T> Set getDupplicatingValues(Set... sets) {
		Set <T> result = sets[0];
		for(int i=1; i<sets.length; i++) {
			result.retainAll(sets[i]);
		}
		
		return result;
	
	}
	
	public static String hashMapToString(Map<? extends Object, ? extends Object> map) {
		Set<?> entrySet = map.entrySet();
		Iterator<?> it =  entrySet.iterator();
		Map.Entry<? extends Object, ? extends Object> entry=null;
		StringBuilder strbldr = new StringBuilder();
		strbldr.append("{ ");
		while(it.hasNext()) {
			entry = (Entry<? extends Object, ? extends Object>) it.next();
			strbldr.append(entry.getKey() +":" +entry.getValue() + ", ");
		}
		return new StringBuilder(strbldr.substring(0, strbldr.length()-2)).append(" }").toString();
	}
	
	public static Map<String, Integer> countOccurencesOfWords(String str) {
		String[] words = str.split(("[\\p{IsPunctuation}\\p{IsWhite_Space}]+"));
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String s : words) {
			System.out.println(s);
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}
			else {
				map.put(s, 1);
			}
		}
		return map;
	}
	

}
