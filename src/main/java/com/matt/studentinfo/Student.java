package com.matt.studentinfo;

import java.util.*;


public class Student {
	public enum Grade{
		A(4),
		B(3),
		C(2),
		D(1),
		F(0);
		private int points;
		Grade(int points){
			this.points = points;
		}
		
		int getPoints(){
			return points;
		}
		}
	
	
	private String name;
	private int credits;
	private String state = "";
	public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	public static final String IN_STATE = "CO";
	private List<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	private String firstName = "";
	private String middleName = "";
	private String lastName;
	
	

	public Student(String fullName) {
		this.name = fullName;
		this.credits = 0;
		List<String> parts = split(fullName);
		setName(parts);
	}

	private void setName(List<String> parts) {
		if(parts.size() == 1){
			this.lastName = parts.get(0);
		}else if(parts.size() == 2){
			this.firstName = parts.get(0);
			this.lastName = parts.get(1);
		}else{
			this.firstName = parts.get(0);
			this.middleName = parts.get(1);
			this.lastName = parts.get(2);
		}
		
	}

	private List<String> split(String fullName) {
		List<String> parts = new ArrayList<String>();
		String[] partName = fullName.split(" ");
		for(String name : partName){
			parts.add(name);
		}
		return parts;
	}

	public String getName() {
		return name;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
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
