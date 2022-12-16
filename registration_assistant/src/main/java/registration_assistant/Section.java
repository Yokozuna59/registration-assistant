package registration_assistant;

import java.util.ArrayList;

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
	private CellButton addToSchedule;
	private CellButton removeFromSchedule;
	private BasketButton addToBasket;
	private BasketButton removeFromBasket;
	private Schedule schedule;
	private Basket basket;

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
		addToSchedule = new CellButton("ADD", true);
		removeFromSchedule = new CellButton("REMOVE", false);
		addToBasket = new BasketButton("Add", true);
		removeFromBasket = new BasketButton("Remove", false);
	}

	public String getSection() {
		return section;
	}

	public String getStatus() {
		return status;
	}

	public CellButton getAddToSchedule() {
		return addToSchedule;
	}

	public CellButton getRemoveFromSchedule() {
		return removeFromSchedule;
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
		addToSchedule.setOnAction(e -> {
			schedule.addSection(this);
		});
		removeFromSchedule.setOnAction(e -> {
			schedule.removeSection(this);
		});
	}

	public Section checkDuplicateCrn() {
		ArrayList<Section> sections = App.getSections();
		for (int i = 0; i < sections.size(); i++) {
			if (sections.get(i).getCrn().equals(crn)
					&& !sections.get(i).getActivity().equals(activity)) {
				return sections.get(i);
			}
		}
		return null;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
		addToBasket.setOnAction(e -> {
			addToBasket.disable();
			removeFromBasket.enable();
			basket.addSection(this);
			Section sectionWithDuplicateCrn=checkDuplicateCrn();
			if(sectionWithDuplicateCrn!=null){
				sectionWithDuplicateCrn.addToBasket.disable();
				sectionWithDuplicateCrn.removeFromBasket.enable();
				basket.addSection(sectionWithDuplicateCrn);
			}
		});
		removeFromBasket.setOnAction(e -> {
			addToBasket.enable();
			removeFromBasket.disable();
			basket.removeSection(this);
			Section sectionWithDuplicateCrn=checkDuplicateCrn();
			if(sectionWithDuplicateCrn!=null){
				sectionWithDuplicateCrn.addToBasket.enable();
				sectionWithDuplicateCrn.removeFromBasket.disable();
				basket.removeSection(sectionWithDuplicateCrn);
			}
		});
	}

	public void setDisabledAddButton(boolean status) {
		addToSchedule.setDisable(status);
	}

	public void setDisabledRemoveButton(boolean status) {
		removeFromSchedule.setDisable(status);
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

	public BasketButton getAddToBasket() {
		return addToBasket;
	}

	public BasketButton getRemoveFromBasket() {
		return removeFromBasket;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public Basket getBasket() {
		return basket;
	}
}
