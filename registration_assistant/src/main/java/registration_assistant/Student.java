package registration_assistant;

import java.util.ArrayList;

public class Student {
    private ArrayList<FinishedCourse> finisehdCourses;
    private ArrayList<Schedule> schedules;

    public Student(ArrayList<FinishedCourse> finisehdCourses, ArrayList<Schedule> schedules) {
        this.finisehdCourses = finisehdCourses;
        this.schedules = schedules;
    }

    public ArrayList<FinishedCourse> getFinisehdCourses() {
        return finisehdCourses;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }
}
