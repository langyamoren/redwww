package com.test;

import java.util.Arrays;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="201103062246006098.jpg||201103062246071717.jpg||";
		String [] ss=str.split("[|]{2}");
		System.out.println(Arrays.toString(ss));

	}

}
