package de.hs_lu.mensa.model;

public class MealPlan {
	Integer weekNum, year;
	Meal[][] meals;
	
	public MealPlan(){
		
	}

	public Integer getWeekNum() {
		return weekNum;
	}

	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}
