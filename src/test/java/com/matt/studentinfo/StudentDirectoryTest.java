package com.matt.studentinfo;

import java.io.IOException;

import junit.framework.TestCase;

public class StudentDirectoryTest extends TestCase{
	private StudentDirectory dir;
	
	public void setUp(){
		dir = new StudentDirectory();
	}
	
	public void testStoreAndRetrieve() throws IOException{
		final int numberOfStuents = 10;
		
		for(int i=0;i<numberOfStuents ;i++){
			addStudent(dir,i);
		}
		
		for(int i=0; i<numberOfStuents ;i++){
			verifyStudentLookup(dir,i);
		}
	}

	private void verifyStudentLookup(StudentDirectory dir, int i) {
		String id = ""+i;
		Student student = dir.findById(id);
		
		assertEquals(id,student.getId());
		assertEquals(id, student.getLastName());
		assertEquals(i,student.getCredits());
		
	}

	private void addStudent(StudentDirectory dir2, int i) {
		String id = "" + i;
		Student student = new Student(id);
		student.setId(id);
		student.addCredits(i);
		dir.add(student);
		
	}
	
}

