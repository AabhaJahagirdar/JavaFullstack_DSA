public class EnumDemo {

	public static void main(String[] args) {
		System.out.println("All days");
		for (Day day : Day.values()) {
			System.out.println(day);
		}

		System.out.println("Ordinal Values");
		for (Day day : Day.values()) {
			System.out.println(day + " ordinal value is " + day.ordinal());
		}
		Day specialDay = Day.valueOf("WEDNESDAY");

		System.out.println("Checking Weekends");
		for (Day day : Day.values()) {
			System.out.println(day + " is a " + day.getType());
		}

	}// main

}// EnumDemo

enum Day {
	SUNDAY(true), MONDAY(false), TUESDAY(false), WEDNESDAY(false), THURSDAY(false), FRIDAY(false), SATURDAY(true);

	private final boolean isWeekend;

	Day(boolean weekend) {
		this.isWeekend = weekend;
	}

	public String getType() {
		return isWeekend ? "Weekend" : "Workday";
	}

	public boolean isWeekend() {
		return isWeekend;
	}
}// enum Day