package registration_assistant;

import java.io.Serializable;

public class Section extends Course implements Serializable {
	private String section;
	private String registerAvailability;
	private String waitlistAvailability;
	private String activity;
	private String crn;
	private String days;
	private String description;
	private String fullName;
	private String instructor;
	private String location;
	private String time;

	public Section(int credit, String name, String[] corequisites, String[] prerequisites,
			String section, String registerAvailability, String waitlistAvailability, String activity,
			String crn, String days, String description, String fullName, String instructor, String location,
			String time) {
		super(credit, name, corequisites, prerequisites);

		this.registerAvailability = registerAvailability;
		this.section = section;
		this.waitlistAvailability = waitlistAvailability;

		this.activity = activity;
		this.crn = crn;
		this.days = days;
		this.description = description;
		this.fullName = fullName;
		this.instructor = instructor;
		this.location = location;
		this.time = time;
	}

	public String getSection() {
		return section;
	}

	public String getRegisterAvailability() {
		return registerAvailability;
	}

	public String getWaitlistAvailability() {
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
