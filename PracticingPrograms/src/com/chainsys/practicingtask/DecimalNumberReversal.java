package com.chainsys.practicingtask;

import java.util.Scanner;

public class DecimalNumberReversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number to be reversed: ");
        double number = sc.nextDouble();
        String reversedDecimalNumber = reverseDecimalNumber(number);
        System.out.println("After reverse: " + reversedDecimalNumber);
        sc.close();
    }

    public static String reverseDecimalNumber(double number) {
        String str = Double.toString(number);
        String[] position = str.split("\\.");
        
        String reversedInteger = reverseString(position[0]);
        String reversedDecimal = reverseString(position[1]);
        String reversedDecimalNumber = reversedInteger + "." + reversedDecimal;
        return reversedDecimalNumber;
    }

    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
}
