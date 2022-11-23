package registration_assistant;

public class Section extends Course {
	private int section;
	private String fullName;
	private String activity;
	private String crn;
	private String description;
	private String instructor;
	private String day;
	private String time;
	private String location;
	private int seats;
	private int waitlist;

	public Section(int credit, String name, Course[] corequisites, Course[] prerequisites,
			int section, String activity, String crn, String description, String instructor,
			String day, String time, String location, int seats, int waitlist) {
		super(credit, name, corequisites, prerequisites);
		this.section = section;
		this.fullName = String.format("%s-%02d", getName(), section);
		this.activity = activity;
		this.crn = crn;
		this.description = description;
		this.instructor = instructor;
		this.day = day;
		this.time = time;
		this.location = location;
		this.seats = seats;
		this.waitlist = waitlist;
	}

	public String getActivity() {
		return activity;
	}

	public String getCrn() {
		return crn;
	}

	public String getDay() {
		return day;
	}

	public String getDescription() {
		return description;
	}

	public String getFullName() {
		return fullName;
	}

	public String getInstructor() {
		return instructor;
	}

	public String getLocation() {
		return location;
	}

	public int getSeats() {
		return seats;
	}

	public int getSection() {
		return section;
	}

	public String getTime() {
		return time;
	}

	public int getWaitlist() {
		return waitlist;
	}
}
