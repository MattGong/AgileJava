package com.matt.studentinfo;

import java.util.*;
import java.util.logging.Logger;



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
	public static final int MAX_NAME_PARTS = 3;
	public static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s' contains more than %d parts";
	private List<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	private String firstName = "";
	private String middleName = "";
	private String lastName;
	//学费
	private List<Integer> charges = new ArrayList<Integer>();
	final static Logger logger = Logger.getLogger(Student.class.getName());
	
	

	public Student(String fullName) {
		
		this.name = fullName;
		this.credits = 0;
		List<String> parts = split(fullName);
		if(parts.size() > MAX_NAME_PARTS){
			String message = String.format(TOO_MANY_NAME_PARTS_MSG, fullName,MAX_NAME_PARTS);
			logger.info(message);
			throw new StudentNameFormatException(message);
			}
		
		setName(parts);
	}


	public void addCharge(int charge){
		charges.add(charge);
	}
	
	public int getCharges(){
		int total = 0;
		for(Integer charge : charges){
			total += charge;
		}
		return total;
	}

	private void setName(List<String> nameParts) {

		this.lastName = removeLast(nameParts);
		String name = removeLast(nameParts);
		if(nameParts.isEmpty()) this.firstName = name;
		else{
			this.middleName = name;
			this.firstName = removeLast(nameParts);
		}
		
	}

	private String removeLast(List<String> list) {
		if(list.isEmpty()) return "";
		return list.remove(list.size()-1);
	}

	private List<String> split(String fullName) {
		List<String> results = new ArrayList<String>();
		for(String name: fullName.split(" ")){
			results.add(name);
		}
		return results;
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
		logger.info("begin getGpa "+ System.currentTimeMillis());
		if(grades.isEmpty()) return 0.0;
		double total = 0.0;
		for(Grade grade : grades){
			total += gradingStrategy.getGradePointsFor(grade);
		}
		logger.info("end getGap "+ System.currentTimeMillis());
		return total / grades.size();
	}
	
	
	public void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;	
	}

}
