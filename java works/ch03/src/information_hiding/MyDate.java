package information_hiding;

public class MyDate {
	private int day=0;
	private int month=0;
	private int year=0;
	
	public void setDay(int day) {
		if(this.month==2){
			if(1<=day&&day<=28) {
				this.day = day;
			}else {
				System.out.println(day);
				this.day = day;
			}
		}else {
			this.day = day;
		}
	}
	
	public int getDay() {
		return this.day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return this.year;
	}
}
