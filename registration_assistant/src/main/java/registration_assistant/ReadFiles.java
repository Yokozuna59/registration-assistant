package registration_assistant;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadFiles {

    public static ArrayList<Section> readCourseOffering(String fileName) {
        try (Scanner in1 = new Scanner(new File(fileName))) {
            ArrayList<Section> list1 = new ArrayList<>();
            in1.nextLine();
            while (in1.hasNext()) {
                String s1 = in1.nextLine();
                String[] myArray = s1.split(",");
                String[] Course_Section = myArray[0].replace(" ", "").split("-");
                list1.add(new Section(0, Course_Section[0], null, null, myArray[8], Course_Section[1], myArray[9],
                        myArray[1],myArray[2], myArray[5], myArray[3],myArray[0], myArray[4], myArray[7], myArray[6]));
            }

            in1.close();
            return list1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static ArrayList<Course> readDegreePlan(String fileName) {
        try (Scanner in1 = new Scanner(new File(fileName))) {
            ArrayList<Course> list1 = new ArrayList<>();

            in1.nextLine();
            while (in1.hasNext()) {
                String s1 = in1.nextLine();
                String[] myArray = s1.split(",");

                list1.add(new Course(Integer.parseInt(myArray[1]), myArray[0], myArray[2].split(";"),
                        myArray[3].split(";")));
            }
            in1.close();
            return list1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static ArrayList<FinishedCourse> readFinshedCourses(String fileName) {
        try (Scanner in1 = new Scanner(new File(fileName))) {
            ArrayList<FinishedCourse> list1 = new ArrayList<>();
            in1.nextLine();
            while (in1.hasNext()) {
                String s1 = in1.nextLine();
                String[] myArray = s1.split(",");
                list1.add(new FinishedCourse(myArray[0], myArray[2], myArray[1]));
            }
            in1.close();
            return list1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

}
