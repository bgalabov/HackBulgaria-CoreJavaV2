package com.hackbulgaria.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMain {

	/*public static void main(String[] args) {
		BoundedQueue <Integer> boundedQueue = new BoundedQueue<Integer>(3);
		boundedQueue.offer(1);
		boundedQueue.offer(2);
		boundedQueue.offer(3);
		
		System.out.println(boundedQueue.toString());
		
		boundedQueue.offer(4);
		boundedQueue.offer(5);
		
		System.out.println(boundedQueue.toString());
	}*/
	
	/*public static void main(String[] args) {
		List<String> nums;
		List<Integer> n1;
		String[] strs = { "one", "two", "three", "four", "five", "six", "seven" };
		nums = new ArrayList<String>(Arrays.asList(strs));
		CollectionUtility.rotate(nums, 1);
		
		for(int i=0; i < nums.size(); i++) {
			System.out.print(nums.get(i) + " ");
		}
		
		System.out.println();
		
		Integer[] n = {1, 2, 3, 4, 5, 6, 7 };
		n1 =  new ArrayList<Integer>(Arrays.asList(n));
		CollectionUtility.rotate(n1, 1);
		
		for(int i=0; i < nums.size(); i++) {
			System.out.print(n1.get(i) + " ");
		}
	}*/
	
	/*public static void main(String[] args) {
		Collection<Integer> ints = Arrays.asList(1,2,3,4,5,5,4,3,1);
		System.out.println(CollectionUtility.firstUnique(ints));
	}*/
	
	/*public static void main(String[] args) {
		int[] values1 = {1, 2, 3, 4, 5, 6};
		Set<Integer> s1 = new HashSet<Integer>();
		s1.add(1); s1.add(2); s1.add(3); s1.add(4); s1.add(5);
		
		int[] values2 = {4, 5, 6};
		Set<Integer> s2 = new HashSet<Integer>();
		s2.add(4); s2.add(5); s2.add(6);
		
		int[] values3 = {5, 6, 7, 8};
		Set<Integer> s3 = new HashSet<Integer>();
		s3.add(5); s3.add(6); s3.add(7); s3.add(8);
		
		System.out.println(CollectionUtility.getDupplicatingValues(s1, s2, s3));
		
	}*/
	
	/*public static void main(String[] args) {
		List<Student> students = new LinkedList<Student>();
		students.add(new Student("Borislav", 6));
		students.add(new Student("Pesho", 3));
		students.add(new Student("Krisi", 5));
		students.add(new Student("Ilia", 4));
		students.add(new Student("Geri", 4));
		students.add(new Student("Lalka", 6));
		students.add(new Student("Pasho", 3));
		
		Collections.sort(students);
		
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).name +", " +students.get(i).grade);
		}
	}*/
	
	/*public static void main(String[] args) {
		StatisticsImpl s = new StatisticsImpl();
		s.add(13);
		s.add(18);
		s.add(13);
		s.add(14);
		s.add(13);
		s.add(16);
		s.add(14);
		s.add(21);
		s.add(13);
		
		System.out.println(s.getMean());
		System.out.println(s.getMedian());
		System.out.println(s.getMode());
		System.out.println(s.getRange());
		
		}*/
	
	/*public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Boby", 6);
		map.put("Pesho", 3);
		map.put("Nelly", 5);
		
		System.out.println(CollectionUtility.hashMapToString(map));
		
	}*/
	
	/*public static void main(String[] args) {
		HashMap<String, Integer> map = (HashMap<String, Integer>) CollectionUtility
				.countOccurencesOfWords("Ninjas are all over the place! We are all going to die!");
		System.out.println(CollectionUtility.hashMapToString(map));
	}*/
	
	/*public static void main(String[] args) {
		ToDoList todo = new ToDoList(11); //11 hours remaining!
		todo.addTask(new StudyForAlgebraTask(10)); //maximum priority!
		todo.addTask(new LearnGeometryTask()); //default priority, smaller than 10
		todo.addTask(new GoOutTask(1.5f));  //default priority, smaller than 10
		todo.addTask(new SleepTask()); //straight 8 hours, of course!
		
		//System.out.println(todo.getRemainingTime());

		if (todo.canFinish()){
		    System.out.println("Woohoo!");
		} else {
		    System.out.println("I am ...screwed :(");
		}

		System.out.println(todo.top()); //StudyForAlgebraTask
		System.out.println(todo.getTimeNeeded()); //sum of the time needed for every task added in todo list
	}*/

}