package com.nithya.assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

	
	public static void main(String[] args) {
			
		Pattern pattern = Pattern.compile("a.b.c = c.b.a");
		Matcher matcher = pattern.matcher("a.b.c");
	
		
	}
	
}

