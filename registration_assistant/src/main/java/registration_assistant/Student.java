package registration_assistant;

import java.util.ArrayList;

public class Student {
    private ArrayList<FinishedCourse> finishedCourses;
    private ArrayList<Schedule> schedules;

    public Student(ArrayList<FinishedCourse> finishedCourses, ArrayList<Schedule> schedules) {
        this.finishedCourses = finishedCourses;
        this.schedules = schedules;
    }

    public ArrayList<FinishedCourse> getFinisehdCourses() {
        return finishedCourses;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        schedules.remove(schedule);
    }

    public static void remainCourses(ArrayList<Course> courses, ArrayList<FinishedCourse> finishedCourses,
            ArrayList<Section> sections) {
        for (int i = 0; i < finishedCourses.size(); i++) {
            if (finishedCourses.get(i).getGrade().equals("F"))
                finishedCourses.remove(i);
        }

        for (int i = 0; i < finishedCourses.size(); i++) {
            FinishedCourse course = finishedCourses.get(i);
            for (int j = sections.size() - 1; j >= 0; j--) {
                if (sections.get(j).getName().equals(course.getCourse())) {
                    sections.remove(j);
                }
            }
        }

        ArrayList<Course> coursesWithPq = new ArrayList<>();
        for (int i = 0; i < finishedCourses.size(); i++) {
            String courseName = finishedCourses.get(i).getCourse();
            for (int j = 0; j < courses.size(); j++) {
                String[] prerequisiteCourses = courses.get(j).getPrerequisites();
                if (prerequisiteCourses.length == 1) {
                    for (int k = 0; k < prerequisiteCourses.length; k++) {
                        if (prerequisiteCourses[k].equals(courseName))
                            coursesWithPq.add(courses.get(j));
                    }
                }
            }
        }

        for (int j = 0; j < courses.size(); j++) {
            String[] prerequisiteCourses = courses.get(j).getPrerequisites();
            for (int k = 0; k < prerequisiteCourses.length; k++) {
                if (prerequisiteCourses[k].equals("None"))
                    coursesWithPq.add(courses.get(j));
            }
        }

        for (int i = sections.size() - 1; i >= 0; i--) {
            boolean found = false;
            for (int j = 0; j < coursesWithPq.size(); j++) {
                if (sections.get(i).getName().equals(coursesWithPq.get(j).getName()))
                    found = true;
            }
            if (!found)
                sections.remove(i);
        }
    }
}
