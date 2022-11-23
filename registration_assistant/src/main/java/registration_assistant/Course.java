package registration_assistant;

public class Course {
    private int credit;
    private String name;
    private Course[] corequisites;
    private Course[] prerequisites;

    public Course(int credit, String name, Course[] corequisites, Course[] prerequisites) {
        this.credit = credit;
        this.name = name;
        this.corequisites = corequisites;
        this.prerequisites = prerequisites;
    }

    public int getCredit() {
        return credit;
    }

    public String getName() {
        return name;
    }

    public Course[] getCorequisites() {
        return corequisites;
    }

    public Course[] getPrerequisites() {
        return prerequisites;
    }
}
