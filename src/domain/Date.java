package domain;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		this.day = 1;
		this.month = 1;
		this.year = 1;
	}
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	//accessors/getters
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	

	//mutators/setters
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
