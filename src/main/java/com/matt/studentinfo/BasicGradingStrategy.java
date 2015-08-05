package com.matt.studentinfo;

import com.matt.studentinfo.Student.Grade;

abstract public class BasicGradingStrategy implements GradingStrategy {
	 public int basicGradePointsFor(Grade grade) {
		 switch(grade){
		 case A: return 4; 
		 case B: return 3;
		 case C: return 2;
		 case D: return 1;
		 default: return 0;
		 }
	}

	abstract public int getGradePointsFor(Grade grade);
}
