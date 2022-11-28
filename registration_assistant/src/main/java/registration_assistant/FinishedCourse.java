package registration_assistant;

public class FinishedCourse {
    private Course course;
    private String grade;
    private String term;

    public FinishedCourse(Course course, String grade, String term) {
        this.course = course;
        this.term = term;
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    public String getTerm() {
        return term;
    }
}
