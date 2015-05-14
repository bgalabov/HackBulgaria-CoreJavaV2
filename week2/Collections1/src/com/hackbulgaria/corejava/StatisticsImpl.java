package com.hackbulgaria.corejava;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StatisticsImpl implements Statistics, Iterable<Integer> {
	private List<Integer> list;
	private Map<Integer, Integer> unSortedMap;
	private Map<Integer, Integer> sortedMap;
	private float sum;
	
	public StatisticsImpl() {
		list = new LinkedList<Integer>();
		unSortedMap = new HashMap<Integer, Integer>();
		sortedMap = new HashMap<Integer, Integer>();
		this.sum=0;
	}
	
	
	public void add(Integer e) {
		int i=0;
		if(list.size()==0) {
			list.add(e);
			putInUnsortedMap(e, unSortedMap);
			sum+=e;
			//return;
		} 
		else if(list.size()<2) {
			if(list.get(0)>e) {
				list.add(0, e);
				putInUnsortedMap(e, unSortedMap);
				sum+=e;
				//return;
			} else {
				list.add(e);
				putInUnsortedMap(e, unSortedMap);
				sum+=e;
				//return;
			}
		} 
		else if (list.get(list.size() - 1) < e) {
			list.add(list.size(), e);
			putInUnsortedMap(e, unSortedMap);
			sum+=e;
			//return;
        } 
		else {
			while(list.get(i)<e) {
				i++;
			}
			list.add(i, e);
			putInUnsortedMap(e, unSortedMap);
			sum+=e;
			//return;
		}
		sortedMap = sortByValue(unSortedMap);
	}
	
	public float getSumOfNums() {
		return sum;
	}
	
	public int getCountOfNums() {
		return list.size();
	}

	@Override
	public float getMean() {
		return getSumOfNums()/getCountOfNums();
	}

	@Override
	public float getMedian() {
		if(getCountOfNums()%2!=0) {
			return new Float(list.get((getCountOfNums())/2));
		}
		else {
			return (list.get((list.size()/2)-1) + ((list.size()/2)-1))/2;
		}
	}

	@Override
	public Integer getMode() {
		Set<Entry<Integer, Integer>> set=sortedMap.entrySet();
		Iterator it = set.iterator();
		Map.Entry<Integer, Integer> entry=null;
		if(!set.isEmpty()) {
			entry = (Map.Entry<Integer, Integer>) it.next();
			return entry.getKey();
		}
		
		return null;
	}

	@Override
	public float getRange() {
		return list.get(list.size()-1) - list.get(0);
	}

	@Override
	public Iterator<Integer> iterator() {
		return list.iterator();
	}
	
	public static Map<Integer, Integer> sortByValue(Map<Integer, Integer> unsortMap) {	 
		List list = new LinkedList(unsortMap.entrySet());
	 
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
							.compareTo(((Map.Entry) (o1)).getValue());
			}
		});
	 
		Map<Integer, Integer> sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry<Integer, Integer> entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	
	private static void putInUnsortedMap(Integer e, Map<Integer, Integer> m) {
		if(!m.containsKey(e)){
			m.put(e, 1);
		} else {
			m.put(e, m.get(e) + 1);
		}
	}

}
