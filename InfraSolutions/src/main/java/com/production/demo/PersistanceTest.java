package com.production.demo;

import java.util.ArrayList;
import java.util.List;

import com.production.demo.PersistanceTest.Days;

public class PersistanceTest {
	enum Days {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	public static void main(String[] agrs) {
		String s ="N°12 W°45";
		String[] q = s.split(" ");
		for(String n:q) {
			System.out.println(n);
		}
		int a = 314947075;
		int b = 317969990;
		System.out.println(a);
		System.out.println(b);
		System.out.println(Double.valueOf(b)/Double.valueOf(a));
		
		System.out.println(Double.valueOf((a/b)));
	}
}
