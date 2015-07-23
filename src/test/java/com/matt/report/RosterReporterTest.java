package com.matt.report;


import com.matt.report.RosterReporter;
import com.matt.studentinfo.CourseSession;
import com.matt.studentinfo.DateUtil;
import com.matt.studentinfo.Student;

import junit.framework.TestCase;

public class RosterReporterTest extends TestCase {

	public void testRosterReporter(){
		CourseSession session = CourseSession.create("ENGL", "101", DateUtil.createDate(2003,1,6));
		
		
			session.enroll(new Student("A"));
			session.enroll(new Student("B"));
			
			String rosterReport = new RosterReporter(session).getRosterReport();
			System.out.println(rosterReport);
			assertEquals(				
					RosterReporter.ROSTER_REPORT_HEADER + 
					"A" + RosterReporter.NEWLINE + 
					"B" + RosterReporter.NEWLINE +
					RosterReporter.ROSTER_REPORT_FOOTER + "2" +
					RosterReporter.NEWLINE, rosterReport);
			
	}
	
}
