package com.matt.studentinfo;

import java.util.*;


public class Student {
	public enum Grade{A, B, C, D, F};
	private String name;
	private int credits;
	private String state = "";
	public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	public static final String IN_STATE = "CO";
	private List<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy = new RegularGradingsStrategy();
	

	public Student(String name) {
		this.name = name;
		this.credits = 0;
	}

	public String getName() {
		return name;
	}

	public boolean isFullTime() {
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	public int getCredits() {

		return credits;
	}

	public void addCredits(int credits) {
		this.credits += credits;

	}

	public boolean isInState() {
		return state.toUpperCase().equals(Student.IN_STATE);
	}

	public void setState(String inState) {
		this.state = inState;
		
	}

	public void addGrade(Grade grade){
		grades.add(grade);
	}
	
	public double getGpa() {
		if(grades.isEmpty()) return 0.0;
		double total = 0.0;
		for(Grade grade : grades){
			total += gradingStrategy.getGradePointsFor(grade);
		}
		
		return total / grades.size();
	}
	
	
	public void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;	
	}

}
