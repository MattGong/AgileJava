package com.matt.studentinfo;

import junit.framework.TestSuite;

public class AllSuite {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		//suite.addTestSuite(RosterReporterTest.class);
		suite.addTestSuite(DateUtil.class);
		return suite;
	}
}
