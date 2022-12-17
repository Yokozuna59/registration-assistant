package registration_assistant;

import java.util.ArrayList;

public class Student {
    private ArrayList<FinishedCourse> finishedCourses;
    private Basket basket;
    private Schedule schedules;

    public Student(ArrayList<FinishedCourse> finishedCourses, Schedule schedules, Basket basket) {
        this.finishedCourses = finishedCourses;
        this.schedules = schedules;
        this.basket = basket;
    }

    public ArrayList<FinishedCourse> getFinisehdCourses() {
        return finishedCourses;
    }

    public Schedule getSchedules() {
        return schedules;
    }

    public void setSchedules(Schedule schedules) {
        this.schedules = schedules;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    // public void addSchedule(Schedule schedule) {
    // schedules.add(schedule);
    // }

    // public void removeSchedule(Schedule schedule) {
    // schedules.remove(schedule);
    // }

    public void remainCourses(ArrayList<Course> courses, ArrayList<FinishedCourse> finishedCourses,
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
