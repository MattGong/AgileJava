package com.matt.studentinfo;

import com.matt.studentinfo.Student.Grade;

public class RegularGradingsStrategy implements GradingStrategy {

	public int getGradePointsFor(Grade grade) {
		if(grade == Student.Grade.A) return 4;
		if(grade == Student.Grade.B) return 3;
		if(grade == Student.Grade.C) return 2;
		if(grade == Student.Grade.D) return 1;
		return 0;
	}

}
