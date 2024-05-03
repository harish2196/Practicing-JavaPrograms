package com.chainsys.project;


import java.util.regex.Pattern;

public class Validation {
	public boolean isNumeric(String input) {
	    String regex = "\\d+";
	    if (input.matches(regex)) {
	        return true; 
	    } else {
	        System.out.println("Invalid Data. Please enter a numeric value.");
	        return false; 
	    }
	}
	public boolean isNumerics(int input) {
	if(input<0) {
		System.out.println("Invalid Data");
		return false;
	}
	return true;
	}

	public boolean isDle(double regNo1) {
		if(regNo1 < 0)
		{
			System.out.println("Invalid Data");
			return false;
		}
		return true;
	}
	
	public static boolean validateString(String input) {
		String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);       
        if (!pattern.matcher(input).matches()) {
            System.out.println("Error: Input should contains only spaces and numbers.");
            return false;
        } else {
            return true;
        }
    }

	public boolean longNumerics(long regNo1) {
		if(regNo1 < 0)
		{
			System.out.println("Invalid Data");
			return false;
		}
		return true;
	}
	public  boolean stringChecker(String s) 
	{
		try
		{
			Integer.parseInt(s);
			System.out.println("Dont use numbers");
			return false;

		}
		catch(Exception e){

			return true;

		}
	}

	public boolean isSpecialChar(String input)
	{

		String specialCharRegex = "^[^a-zA-Z0-9]+[!@#$%^&*()]+$";
		if(Pattern.matches(specialCharRegex, input))
		{
			System.out.println("Invalid!.Dont use Special Characters");
			return false;
		}
		return true;
	}
	

}


