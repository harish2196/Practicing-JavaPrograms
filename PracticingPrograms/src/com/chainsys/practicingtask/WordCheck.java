package com.chainsys.practicingtask;

import java.util.Scanner;

public class WordCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String: ");
		String word=sc.nextLine();
		while( i<word.length()) {
			char ch=word.charAt(i);
			if(!Character.isLetter(ch) && ch!=' ') {
				System.out.println("Only In Alphabet");
				System.out.println("Enter a string: ");
				word=sc.nextLine();
				
			}
			i++;
		}
		System.out.println("Enter a Word to be Check: ");
		String search=sc.nextLine();
		while( i<search.length()) {
			char ch=search.charAt(i);
			if(!Character.isLetter(ch) && ch!=' ') {
				System.out.println("Only In Alphabet");
				System.out.println("Enter a string: ");
				search=sc.nextLine();
				
			}
			i++;
		}
		
		boolean finder=wordChecker(word,search);
		System.out.println(finder);
	}
	public static boolean wordChecker(String word,String search) {
		return word.startsWith(search);
	}

}
