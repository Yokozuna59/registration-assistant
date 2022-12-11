package registration_assistant;

import java.io.Serializable;

public class Course implements Serializable {
    private int credit;
    private String name;
    private String[] corequisites;
    private String[] prerequisites;

    public Course(int credit, String name, String[] corequisites, String[] prerequisites) {
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

    public String[] getCorequisites() {
        return corequisites;
    }

    public String[] getPrerequisites() {
        return prerequisites;
    }
}
