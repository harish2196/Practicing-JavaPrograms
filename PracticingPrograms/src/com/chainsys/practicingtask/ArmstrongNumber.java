package com.chainsys.practicingtask;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a armstrong number: ");
		int num=sc.nextInt();
		if(isArmstrong(num)){  
			System.out.print("Armstrong Number");  
		}  
		else   
		{  
		System.out.print("Not Armstrong Number ");  
		}  
		sc.close();
	}
	public static boolean isArmstrong(int n) {
		int temp,last=0,count=0,sum=0;
		temp=n;
		while(temp!=0) {
			temp/=10;
			count++;
		}
		temp=n;
		while(temp!=0) {
			last=temp%10;
			sum+=Math.pow(last, count);
			temp/=10;
		}
	return n==sum;
			
	}

}
