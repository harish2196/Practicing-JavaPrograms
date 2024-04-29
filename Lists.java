package com.chainsys.practicingtask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.LinkedList;

public class Lists {

	public static void main(String[] args) {

		//ArrayList
		ArrayList li = new ArrayList<>();
		ArrayList li1 = new ArrayList<>();
		li.add("Apple");
		li.add("Banana");
		li.add("Orange");
		li.add(2);
		li.add(2,"Papaya");
		System.out.println(li + " ");
		System.out.println(li.get(0));
		li.remove("Banana");
		System.out.println(li + " ");

		li1.add(22);
		li1.add("Naveen");

		li.addAll(li1);
		System.out.println("----------"+ li);

		//LinkedList

		List numbers = new LinkedList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add("Helo");
		numbers.add(3);
		numbers.add(2,"Hi");
		numbers.add(5);
		System.out.println(numbers + " ");
		System.out.println(numbers.get(0));
		System.out.println(numbers.contains(2));
		numbers.remove(Integer.valueOf(5));
		System.out.println(numbers + " ");
		System.out.println("Size: " + numbers.size());
		numbers.remove(1);
		System.out.println("LinkedList: "+ numbers + " ");


		//Hashset

		Set hashSet = new HashSet<>();
		hashSet.add("Apple");
		hashSet.add("Banana");
		hashSet.add("Banana");
		hashSet.add("Orange");
		System.out.println("HashSet: " + hashSet);
		String searchElement = "Banana";
		if (hashSet.contains(searchElement)) {
			System.out.println(searchElement + " is present in the HashSet");
		} else {
			System.out.println(searchElement + " is not present in the HashSet");
		}
		hashSet.clear();
		System.out.println("HashSet after clearing:");
		System.out.println(hashSet);

		//TreeSet

		TreeSet treeSet = new TreeSet<>();
		treeSet.add(5);
		treeSet.add(2);
		treeSet.add(8);
		treeSet.add(1);
		System.out.println("TreeSet elements:");
		System.out.println(treeSet);
		int searchElement1 = 8;
		if (treeSet.contains(searchElement1)) {
			System.out.println(searchElement1 + " is present in the TreeSet");
		} else {
			System.out.println(searchElement1 + " is not present in the TreeSet");
		}
		treeSet.remove(2);
		System.out.println("TreeSet after removing 2:");
		System.out.println(treeSet);
		System.out.println("Size of the TreeSet: " + treeSet.size());
		treeSet.clear();
		System.out.println("TreeSet after clearing:");
		System.out.println(treeSet);


		// LinkedHashSet

		Set linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Red");
		linkedHashSet.add("Blue");
		linkedHashSet.add("Green");
		linkedHashSet.add("Red");
		linkedHashSet.add(7);
		linkedHashSet.add(3);
		linkedHashSet.add(8);
		linkedHashSet.add(11);



		System.out.println("LinkedHashSet: " + linkedHashSet);
		linkedHashSet.remove("Green");

		System.out.println("Contains 'Green': " + linkedHashSet.hashCode());

		//Queue

		Queue<String> queue = new LinkedList<>();
		queue.offer("Person 1");
		queue.offer("Person 2");
		queue.offer("Person 3");

		String removedElement = queue.poll();
		System.out.println("Removed Element: " + removedElement);

		String frontElement = queue.peek();
		System.out.println("Front Element: " + frontElement);

		//Stack

		Stack<String> stack=new Stack<>();
		stack.push("Person 1");
		stack.push("Person 2");
		stack.push("Person 3");

		System.out.println("Stack: "+ stack);
		removedElement = stack.pop();
		System.out.println("Removed Element: " + removedElement);

		String lastElement = stack.peek();
		System.out.println("Last Element: " + lastElement);

		//Hashmap

		HashMap<Integer,String> map=new HashMap<Integer,String>();    
		map.put(1,"Mango");  
		map.put(2,"Apple");    
		map.put(3,"Banana");   
		map.put(4,"Grapes");   

		System.out.println("Iterating Hashmap...");  
		for(Map.Entry m : map.entrySet()){    
			System.out.println(m.getKey()+" "+m.getValue());    
		}
		map.remove(1);      
		System.out.println("After invoking remove() method");  
		for(Map.Entry m:map.entrySet())  
		{  
			System.out.println(m.getKey()+" "+m.getValue());      
		}  

		//Treemap

		TreeMap<Integer,String> map1=new TreeMap<Integer,String>();    
		map1.put(1,"Mango");  
		map1.put(2,"Apple");    
		map1.put(3,"Banana");   
		map1.put(4,"Grapes");   

		System.out.println("Iterating TreeMap...");  
		for(Map.Entry m1 : map.entrySet()){    
			System.out.println(m1.getKey()+" "+m1.getValue());   

			System.out.println(map1.descendingKeySet());

			//LinkedHashMap

			LinkedHashMap<Integer,String> map11=new LinkedHashMap<Integer,String>();  

			map11.put(1,"Mango");  
			map11.put(2,"Apple");    
			map11.put(3,"Banana");   
			map11.put(4,"Grapes");   

			System.out.println("Iterating LinkedHashMap...");  
			for(Map.Entry m11 : map.entrySet()){    
				System.out.println(m11.getKey()+" "+m11.getValue());
			}
		}

	}
}
