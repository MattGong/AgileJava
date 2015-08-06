package com.matt;


import junit.framework.TestSuite;

public class AllTests {
	public static TestSuite suite(){
		TestSuite suite = new TestSuite();
		//suite.addTestSuite(RosterReporterTest.class);
		suite.addTest(com.matt.report.AllTests.suite());
		suite.addTest(com.matt.studentinfo.AllSuite.suite());
		return suite;
	}
}
