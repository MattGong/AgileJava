package com.matt.report;

import com.matt.studentinfo.CourseSession;
import com.matt.studentinfo.Student;

public class RosterReporter {

	public static final String NEWLINE = System.getProperty("line.separator");
	public static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE
			+ "-----" + NEWLINE;
	public static final String ROSTER_REPORT_FOOTER = NEWLINE + "# sutdents = ";
	private CourseSession session;

	public RosterReporter(CourseSession session) {
		this.session = session;
	}

	public String getRosterReport() {
		StringBuilder buffer = new StringBuilder();

		wirteHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);

		return buffer.toString();
	}

	void wirteHeader(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_HEADER);
	}

	void writeBody(StringBuilder buffer) {

		for (Student student : session.getAllStudents()) {
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}

	}

	void writeFooter(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size()
				+ NEWLINE);
	}

}
