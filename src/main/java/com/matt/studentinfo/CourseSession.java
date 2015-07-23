package com.matt.studentinfo;

import java.util.*;

/*
 * This class provides a representation of a single-semester
 * session of a specific university course.
 */
public class CourseSession implements Comparable<CourseSession>{

	public static final int CREDITS = 0;
	private static int count = 0;
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	private int numberOfCredits;

	/*
	 * Constructs a CourseSession starting on a specific date
	 */
	private CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
		
	}


	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void enroll(Student student) {
		student.addCredits(this.numberOfCredits);
		students.add(student);
	}

	Student get(int index) {
		return students.get(index);
	}

	public int getNumberOfStudents() {
		return students.size();
	}

	/*
	 * @return Date the last date of the course session
	 */
	Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		final int sessionLength = 16;
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays = sessionLength * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

	public ArrayList<Student> getAllStudents() {
		return students;
	}

	public static int getCount() {
		return count;
	}

	public static void resetCount() {
		count = 0;
	}
	
	private static void incrementCount() {
		++count;
	}



	public static CourseSession create(String department, String number,
			Date startDate) {
		CourseSession.incrementCount();
		return new CourseSession(department, number, startDate);
	}



	public void setNumberOfCredits(int numberOfCredits) {
		
		this.numberOfCredits = numberOfCredits;
	}

	public int compareTo(CourseSession that) {
		int compare =  this.getDepartment().compareTo(that.getDepartment());
		if(compare == 0 ) compare = this.getNumber().compareTo(that.getNumber());
		return compare;
	}

}
