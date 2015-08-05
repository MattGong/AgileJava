package com.matt.studentinfo;

import com.matt.studentinfo.Student.Grade;

public class RegularGradingsStrategy extends BasicGradingStrategy{

	public int getGradePointsFor(Grade grade) {
		return basicGradePointsFor(grade);
	}

}
