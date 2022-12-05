package registration_assistant;

public class FinishedCourse {
    private String course;
    private String grade;
    private String term;

    public FinishedCourse(String course, String grade, String term) {
        this.course = course;
        this.term = term;
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    public String getTerm() {
        return term;
    }
}
