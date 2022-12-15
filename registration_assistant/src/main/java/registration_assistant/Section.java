package registration_assistant;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Section extends Course {
	private static final long serialVersionUID = -2029660102333991118L;
	private String section;
	private String status;
	private String waitlist;
	private String activity;
	private String crn;
	private String days;
	private String description;
	private String fullName;
	private String instructor;
	private String location;
	private String time;
	private CellButton add;
	private CellButton remove;
	private CellButton addtoBasket;
	private CellButton removeFromBasket;
	private Schedule schedule;

	public Section(int credit, String name, String[] corequisites, String[] prerequisites,
			String status, String section, String waitlist, String activity,
			String crn, String days, String description, String fullName, String instructor, String location,
			String time) {
		super(credit, name, corequisites, prerequisites);

		this.status = status;
		this.section = section;
		this.waitlist = waitlist;

		this.activity = activity;
		this.crn = crn;
		this.days = days;
		this.description = description;
		this.fullName = fullName;
		this.instructor = instructor;
		this.location = location;
		this.time = time;
		add = new CellButton("ADD", true);
		remove = new CellButton("REMOVE", false);
		addtoBasket=new CellButton("Add", true);
		removeFromBasket=new CellButton("Remove", true);

	}

	public String getSection() {
		return section;
	}

	public String getStatus() {
		return status;
	}

	public CellButton getAdd() {
		return add;
	}

	public CellButton getRemove() {
		return remove;
	}

	public String getWaitlist() {
		return waitlist;
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

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
		add.setOnAction(e -> {
			schedule.addSection(this);
		});
		remove.setOnAction(e -> {
			schedule.removeSection(this);
		});
	}

	public int getTimeToMinutes() {
		String[] hours = time.split("-");
		int start = Integer.parseInt(hours[0]);
		int end = Integer.parseInt(hours[1]);
		int startHours = start % 100;
		int endHours = end % 100;
		int startMinutes = start / 100;
		int endMinutes = end / 100;
		int difference = (endHours * 60 + endMinutes) - (startHours * 60 + startMinutes);
		int hd = difference / 60;
		int md = difference % 60 * 60;
		return hd + md;
	}
}
