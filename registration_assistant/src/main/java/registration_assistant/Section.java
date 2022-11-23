package registration_assistant;

public class Section extends Course {
	private int section;
	private int registerAvailability;
	private int waitlistAvailability;
	private String activity;
	private String crn;
	private String days;
	private String description;
	private String fullName;
	private String instructor;
	private String location;
	private String time;

	public Section(int credit, String name, Course[] corequisites, Course[] prerequisites,
			int section, int registerAvailability, int waitlistAvailability, String activity,
			String crn, String days, String description, String instructor, String location, String time) {
		super(credit, name, corequisites, prerequisites);

		this.registerAvailability = registerAvailability;
		this.section = section;
		this.waitlistAvailability = waitlistAvailability;

		this.activity = activity;
		this.crn = crn;
		this.days = days;
		this.description = description;
		this.fullName = String.format("%s-%02d", getName(), section);
		this.instructor = instructor;
		this.location = location;
		this.time = time;
	}

	public int getSection() {
		return section;
	}

	public int getRegisterAvailability() {
		return registerAvailability;
	}

	public int getWaitlistAvailability() {
		return waitlistAvailability;
	}

	public String getActivity() {
		return activity;
	}

	public String getCrn() {
		return crn;
	}

	public String getDays() {
		return days;
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

	public String getTime() {
		return time;
	}
}
