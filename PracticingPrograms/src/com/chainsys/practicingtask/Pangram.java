package com.chainsys.practicingtask;

import java.util.Scanner;

public class Pangram {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a String1: ");
		String str1=sc.nextLine();
		boolean flag=pangram(str1);
		if(flag) { 
			System.out.println(str1 + " are Pangram");
		}else {
			System.out.println(str1 +  " are not Pangrams.");
		}
		sc.close();
	}
	public static boolean pangram(String str1) {
		char ch;
		if(str1.length()<26) {
			return false;
		}
		for(ch='a';ch<='z';ch++) {
			if(str1.indexOf(ch)<0) {
				return false;
			}
		}
		return true;
	}

}
