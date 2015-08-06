package com.matt.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

 abstract public class Session implements Comparable<Session> {
	private String department;
	private String number;
	private List<Student> students = new ArrayList<Student>();
	private Date startDate;
	private int numberOfCredits;
	

	protected Session(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
		
	}
	
	public String getDepartment(){
		return this.department;
	}
	public int compareTo(Session that) {
		int compare = this.getDepartment().compareTo(that.department);
		if(compare != 0) return compare;
		
		return this.getNumber().compareTo(that.getNumber());
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
	int getNumberOfStudents(){
		return students.size();
	}

	public void enroll(Student student){
		student.addCredits(numberOfCredits);
		students.add(student);
	}
	
	Student get(int index){
		return students.get(index);
	}
	
	protected Date getStartDate(){
		return startDate;
	}
	
	public List<Student> getAllStudents(){
		return students;
	}
	
	abstract protected int getSessionLength();
	
	/*
	 * @return Date the last date of the course session
	 */
	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}
}
