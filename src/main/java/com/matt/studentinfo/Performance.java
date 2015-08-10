package com.matt.studentinfo;

public class Performance {
	private int[] tests;
	
	public void setNumberOfTests(int numberOfTests) {
		tests = new int[numberOfTests];
	}

	public void set(int testNumber, int score) {
		tests[testNumber] = score;
	}

	public int get(int index) {
		return tests[index];
	}

	public double average() {
		double total = 0.0;
		
		for(int score : tests){
			total += score;
		}
		return total/tests.length;
	}

	public void setScores(int... scores) {
		this.tests = scores;
		
	}

}
