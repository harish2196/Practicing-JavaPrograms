package com.chainsys.practicingtask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
		linkedHashSet.add(7);
		linkedHashSet.add(3);
		System.out.println("LinkedHashSet: " + linkedHashSet);
		linkedHashSet.remove("Green");

		System.out.println("Contains 'Green': " + linkedHashSet.contains("Green"));

	}

}
