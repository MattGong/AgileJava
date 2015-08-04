package com.matt.studentinfo;

import com.matt.studentinfo.Student.Grade;

public class HonorsGradingStrategy implements GradingStrategy {

	public int getGradePointsFor(Grade grade) {
		int points = basicGradePointsFor(grade);
		if(points > 0) points += 1;
		return points;
	}

	 int basicGradePointsFor(Grade grade) {
		 switch(grade){
		 case A: return 4;
		 case B: return 3;
		 case C: return 2;
		 case D: return 1;
		 default: return 0;
		 }
	}

}
