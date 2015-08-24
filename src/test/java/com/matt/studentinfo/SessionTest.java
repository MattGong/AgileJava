package com.matt.studentinfo;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.matt.studentinfo.Student;
import junit.framework.TestCase;


abstract public class SessionTest extends TestCase {
	private Session session;
	private Date startDate;
	private static final int CREDITS = 3;
	

	public void setUp(){
		startDate = createDate(2003, 1,6);
		session = createSession("ENGL","101",startDate);
	}
	
	abstract protected Session createSession(String department, String number, Date startDate);
	
	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}
	
	public void testEnrollStudents(){
		Student student1 = new Student("Cain Divoe");
		student1.addCredits(CREDITS);
		session.enroll(student1);
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		
		Student student2 = new Student("Coralee Devaughn");
		student2.addCredits(CREDITS);
		session.enroll(student2);
		assertEquals(CREDITS, student2.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}

	public void testComparable(){
		final Date date = new Date();
		Session sessionA = createSession("CMSC", "101", date);
		Session sessionB = createSession("ENGL", "101", date);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		assertTrue(sessionB.compareTo(sessionA) > 0);
		
		Session sessionC = createSession("CMSC", "101", date);
		assertEquals(0, sessionA.compareTo(sessionC));
		
		Session sessionD = createSession("CMSC", "210", date);
		assertTrue(sessionC.compareTo(sessionD) < 0 );
		assertTrue(sessionD.compareTo(sessionC) > 0 );
	}
	
	public void testSessionUrl() throws SessionException{
		final String url = "http://course.langrsoft.com/cmsc300";
		session.setUrl(url);
		assertEquals(url, session.getUrl().toString());
	}
	
	public void testInvalidSessionUrl(){
		final String url = "httsp://course.langrsoft.com/cmsc300";
		try{
		session.setUrl(url);
		fail("expected exception due to invalid protocol in URL");
		}catch(SessionException expectedException){
			Throwable cause = expectedException.getCause();
			assertEquals(MalformedURLException.class, cause.getClass());
		}
	}
	
	Date createDate(int year, int month, int date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, date);
		return calendar.getTime();
	}
	
}
