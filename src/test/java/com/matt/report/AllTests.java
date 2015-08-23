package com.matt.report;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(CourseReportTest.class);
		suite.addTestSuite(ReportCardTest.class);
		suite.addTestSuite(RosterReporterTest.class);
		//$JUnit-END$
		return suite;
	}

}
