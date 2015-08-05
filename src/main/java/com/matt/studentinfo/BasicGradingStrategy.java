package com.matt.studentinfo;

import com.matt.studentinfo.Student.Grade;

public class BasicGradingStrategy implements GradingStrategy {
	 public int getGradePointsFor(Grade grade) {
		 return grade.getPoints();
	}


}
