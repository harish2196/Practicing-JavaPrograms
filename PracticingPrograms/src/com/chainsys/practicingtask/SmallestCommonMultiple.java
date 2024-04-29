package com.chainsys.practicingtask;

import java.util.Scanner;

public class SmallestCommonMultiple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number1: ");
		int number1 = sc.nextInt();
		while (number1 < 0) {
			System.out.println("Negative Numbers!");
			System.out.println("Please Re-enter a Positive number: ");
			number1 = sc.nextInt();
		}
		System.out.println("Enter a Number2: ");
		int number2 = sc.nextInt();
		while (number2 < 0) {
			System.out.println("Negative Numbers!");
			System.out.println("Please Re-enter a Positive number: ");
			number2 = sc.nextInt();
		}
		int multiples = smallestCommonMultiple(number1,number2);
		System.out.println("The Common Multiples are: " + multiples);

		sc.close();
	}

	public static int smallestCommonMultiple(int num1,int num2) {
		int smallest = 0;
		switch (num1<num2 ? 1:num1>num2 ? 2:3) {
		case 1:
			smallest= calculateSmallestMultiple(num1,num2);
			break;
		case 2:
			smallest= calculateSmallestMultiple(num2,num1);
			break;
		case 3:
			smallest= num1;
			break;
		}
		return smallest;
	}
	private static int calculateSmallestMultiple(int smaller, int larger) {
		int lcm;
		int max=smaller>larger ? smaller:larger;
		while(true) {
			if((max%smaller==0) && (max%larger==0)) {
				lcm=max;
				break;
			}
			max++;
		}
		return lcm;


	}
}
