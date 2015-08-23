package com.matt.studentinfo;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		//suite.addTestSuite(RosterReporterTest.class);
		suite.addTestSuite(DateUtilTest.class);
		return suite;
	}
}
