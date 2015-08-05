package com.matt.studentinfo;

import com.matt.studentinfo.Student.Grade;

public class HonorsGradingStrategy extends BasicGradingStrategy{

	public int getGradePointsFor(Grade grade) {
		int points = basicGradePointsFor(grade);
		if(points > 0) points += 1;
		return points;
	}

}
