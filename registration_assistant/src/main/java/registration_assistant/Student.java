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

    public void remainCourses(ArrayList<Course> courses, ArrayList<FinishedCourse> finishedCourses,
            ArrayList<Section> sections) {
        System.out.println(sections.size());
        for (int i = 0; i < finisehdCourses.size(); i++) {
            FinishedCourse passedCourse = finishedCourses.get(i);
            for (int j = 0; j < courses.size(); j++) {
                Course currentCourse = courses.get(j);

                if (passedCourse.getCourse().equals(currentCourse.getName())) {
                    courses.remove(currentCourse);
                    break;
                }
            }
            for (int j = 0; j < courses.size(); j++) {
                Section coursePlace = sections.get(j);
                if (passedCourse.getCourse().equals(coursePlace.getName())) {
                    sections.remove(coursePlace);
                }
            }
        }
        System.out.println(courses.size());
        System.out.println(sections.size());
        // just for checking

    }
}
