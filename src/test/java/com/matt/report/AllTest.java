package com.matt.report;


import junit.framework.TestSuite;

public class AllTest {
	public static TestSuite suite(){
		TestSuite suite = new TestSuite();
		suite.addTestSuite(RosterReporterTest.class);
		return suite;
	}
}
