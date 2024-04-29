package com.chainsys.practicingtask;

import java.util.Scanner;

public class WordFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String: ");
		String word=sc.nextLine();
		while(i<word.length()) {
			char ch = word.charAt(i);
			if (!Character.isLetter(ch) && ch!=' ') {
				System.out.println("Only In Alphabet");
				System.out.println("Enter a string: ");
				word=sc.nextLine();

			}
			i++;
		}
		System.out.println("Enter the position of the word to be find:");
		int position = sc.nextInt();
		while(position<0) {
			System.out.println("Please Re-enter Positive Number: ");
			System.out.println("Enter the position of the word to be find: ");
			position= sc.nextInt();
		}

		String foundWord=findWordByIndex(word,position);

		if(foundWord!=null) {
			System.out.println("Word at position " + position + ": " + foundWord);
		} else {
			System.out.println("No word found at position " + position);
		}
		sc.close();
	}
	public static String findWordByIndex(String word,int position) {
		String[] words=word.split("\\s+");

		if(position>=1 && position<=words.length) {
			return words[position-1];
		}
		return null;

	}


}
