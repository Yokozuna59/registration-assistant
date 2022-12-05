package registration_assistant;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;

public class ReadCSV {
    public static ArrayList<Section> readCourseOffering(URI filePath) {
        try (Scanner sectionsFile = new Scanner(new File(filePath))) {
            ArrayList<Section> SectionArrList = new ArrayList<>();
            sectionsFile.nextLine();
            while (sectionsFile.hasNext()) {
                String currentLine = sectionsFile.nextLine();
                String[] sectionData = currentLine.split(",");
                String[] fullName = sectionData[0].replace(" ", "").split("-");
                SectionArrList.add(
                        new Section(0, fullName[0], null, null, sectionData[8],
                                fullName[1], sectionData[9], sectionData[1], sectionData[2], sectionData[5],
                                sectionData[3], sectionData[0], sectionData[4], sectionData[7], sectionData[6]));
            }
            sectionsFile.close();
            return SectionArrList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Course> readDegreePlan(URI filePath) {
        try (Scanner degreePlanFile = new Scanner(new File(filePath))) {
            ArrayList<Course> degreePlanArrList = new ArrayList<>();
            degreePlanFile.nextLine();
            while (degreePlanFile.hasNext()) {
                String currentLine = degreePlanFile.nextLine();
                String[] degreePlanArrayList = currentLine.split(",");
                degreePlanArrList.add(new Course(Integer.parseInt(degreePlanArrayList[1]), degreePlanArrayList[0],
                        degreePlanArrayList[2].split(";"), degreePlanArrayList[3].split(";")));
            }
            degreePlanFile.close();
            return degreePlanArrList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<FinishedCourse> readFinishedCourse(URI filePath) {
        try (Scanner finishedCoursedFile = new Scanner(new File(filePath))) {
            ArrayList<FinishedCourse> finishedCourseArrList = new ArrayList<>();
            while (finishedCoursedFile.hasNext()) {
                String currentLine = finishedCoursedFile.nextLine();
                String[] finishedCourseData = currentLine.split(",");
                finishedCourseArrList.add(new FinishedCourse(finishedCourseData[0],
                        finishedCourseData[2], finishedCourseData[1]));
            }
            finishedCoursedFile.close();
            return finishedCourseArrList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
