package com.matt.report;

import java.util.*;
import com.matt.studentinfo.*;
import static com.matt.report.RosterReporter.NEWLINE;

public class CourseReport {
	private ArrayList<CourseSession> sessions = new ArrayList<CourseSession>();

	public void add(CourseSession session) {
		sessions.add(session);	
	}

	public String text() {
		StringBuilder builder = new StringBuilder();
		Collections.sort(sessions);
		/* Collections.sort(sessions,new Comparator<CourseSession>(){

			public int compare(CourseSession session1, CourseSession session2) {
				
				return session1.getDepartment().compareTo(session2.getDepartment());
			}
			
		}); */
		for(CourseSession session : sessions){
			builder.append(session.getDepartment() + " " + session.getNumber() + NEWLINE);
		}
		return builder.toString();
	}
}
