package com.matt.studentinfo;


import java.util.logging.Handler;
import java.util.logging.Logger;

import junit.framework.TestCase;

public class StudentTest extends TestCase {
	private static final double GRADE_TOLERANCE = 0.05;

public void testCreate(){
		final String firstSudentName = "Jane Doe";
		Student student = new Student("Jane Doe");
		assertEquals(firstSudentName, student.getName());
		assertEquals("Jane", student.getFirstName());
		assertEquals("", student.getMiddleName());
		assertEquals("Doe",student.getLastName());
		
		final String secondStudentName = "Blow";
		Student secondStudent = new Student("Blow");
		assertEquals(secondStudentName, secondStudent.getName());
		assertEquals("", secondStudent.getFirstName());
		assertEquals("", secondStudent.getMiddleName());
		assertEquals("Blow",secondStudent.getLastName());
		
		assertEquals(firstSudentName, student.getName());
		
		final String thirdStudentName = "Raymond Bouglas Davies";
		Student thirdStudent = new Student(thirdStudentName);
		assertEquals(secondStudentName, secondStudent.getName());
		assertEquals("Raymond", thirdStudent.getFirstName());
		assertEquals("Bouglas", thirdStudent.getMiddleName());
		assertEquals("Davies",thirdStudent.getLastName());
	}
	
    public void testCharges(){
    	Student student = new Student("a");
    	student.addCharge(500);
    	student.addCharge(200);
    	student.addCharge(399);
    	
    	assertEquals(1099,student.getCharges());
    }
	
	public void testStudentStatus(){
		Student student = new Student("a");
		assertEquals(0,student.getCredits());
		assertFalse("not enough credits for FT status",student.isFullTime());
		
		student.addCredits(3);
		assertEquals(3,student.getCredits());
		
		student.addCredits(4);
		assertEquals(7,student.getCredits());
		
		student.addCredits(5);
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
		assertTrue(student.isFullTime());
	}
	
	public void testInState(){
		Student student = new Student("a");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("MD");
		assertFalse(student.isInState());
	}
	
	public void testCalculateGpa(){
		Student student = new Student("a");
		assertGpa(student,0.0);
		student.addGrade(Student.Grade.A);
		assertGpa(student,4.0);
		student.addGrade(Student.Grade.B);
		assertGpa(student,3.5);
		student.addGrade(Student.Grade.C);
		assertGpa(student,3.0);
		student.addGrade(Student.Grade.D);
		assertGpa(student,2.5);
		student.addGrade(Student.Grade.F);
		assertGpa(student,2.0);
	}
	
	public void testCalculateHonorsStudentGpa(){
		assertGpa(createHonorsStudent(), 0.0);
		assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
		assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
		assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
		assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
		assertGpa(createHonorsStudent(Student.Grade.F), 0.0);
	}
	
	private Student createHonorsStudent(Student.Grade grade){
		Student student = createHonorsStudent();
		student.addGrade(grade);
		return student;
	}
	
	public Student createHonorsStudent(){
		Student student = new Student("a");
		student.setGradingStrategy(new HonorsGradingStrategy());
		return student;
	}
	
	public void testBadlyFormattedName(){
		Logger logger = Logger.getLogger(Student.class.getName());
		Handler handler = new TestHandler();
		logger.addHandler(handler);
		final String studentName = "a b c d";
		try{
			new Student(studentName);
			fail("expected exception from 4-part name");
		}catch(StudentNameFormatException expectedException){	
			String message = String.format(Student.TOO_MANY_NAME_PARTS_MSG, studentName, Student.MAX_NAME_PARTS);
			assertEquals(message, expectedException.getMessage());
			assertTrue(wasLogged(message,(TestHandler)handler));
		}
	}

	private boolean wasLogged(String message,TestHandler handler) {
		
		return message.equals(handler.getMessage());
	}

	private void assertGpa(Student student, double expectedGpa){
		assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
	}
}
