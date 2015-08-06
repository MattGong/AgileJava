package com.matt.studentinfo;

import java.util.*;

/*
 * This class provides a representation of a single-semester
 * session of a specific university course.
 */
public class CourseSession extends Session{
	private static int count;
  
	protected CourseSession(String department, String number, Date startDate) {
		super(department, number, startDate);
	}


	static private void incrementCount(){
		++count;
	}
	
	static void resetCount(){
		count = 0;
	}
	
	static int getCount(){
		return count;
	}
	
	
	@Override
	protected int getSessionLength() {
		return 16;
	}

	public static CourseSession create(String department, String number,
			Date startDate) {
		CourseSession.incrementCount();
		return new CourseSession(department, number, startDate);
	}
	

}
