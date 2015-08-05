package com.matt.report;

import java.util.EnumMap;
import java.util.Map;

import com.matt.studentinfo.Student;
import com.matt.studentinfo.Student.Grade;

public class ReportCard {
	static final String A_MESSAGE = "Excellent";
	static final String B_MESSAGE = "Very good";
	static final String C_MESSAGE = "Hmmm...";
	static final String D_MESSAGE = "You're not trying";
	static final String F_MESSAGE = "Loser";
	
	private Map<Student.Grade, String> messages = null;
	
	public String getMessage(Student.Grade grade){
		return getMessages().get(grade);
	}

	private Map<Grade, String> getMessages() {
		if(messages == null) loadMessage();
		return messages;
	}

	private void loadMessage() {
		messages = new EnumMap<Student.Grade, String>(Student.Grade.class);
		messages.put(Student.Grade.A, A_MESSAGE);
		messages.put(Student.Grade.B, B_MESSAGE);
		messages.put(Student.Grade.C, C_MESSAGE);
		messages.put(Student.Grade.D, D_MESSAGE);
		messages.put(Student.Grade.F, F_MESSAGE);
		
	}
}
