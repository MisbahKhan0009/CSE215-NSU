import java.io.*;
import java.util.*;

public class StudentOperation {

    public static void performStudentOperations() throws IOException {
        System.out.println("::::::::::::: Student Operations :::::::::::::");
        System.out.println("1. View Grades");
        System.out.println("2. View Courses");
        System.out.println("3. View Teacher Names");
        System.out.println("4. View Course Materials");
        System.out.println("5. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                viewGrades();
                System.out.println("\n");
                performStudentOperations();
            }
            case 2 -> {
                viewCourses();
                System.out.println("\n");
                performStudentOperations();
            }
            case 3 -> {
                viewTeacherNames();
                System.out.println("\n");
                performStudentOperations();
            }
            case 4 -> {
                System.out.print("Enter the course name: ");
                String courseName = scanner.nextLine();
                viewCourseMaterials(courseName);
                System.out.println("\n");
                performStudentOperations();
            }
            case 5 -> welcomePage.showWelcomePage();
            default -> {
                System.out.println("Invalid choice. Please try again.");
                System.out.println("\n");
                performStudentOperations();
            }
        }
    }

    private static void viewGrades() throws IOException {
        System.out.println("::::::::::::: View Grades :::::::::::::");
        System.out.print("Enter the student's username: ");

        Scanner scanner = new Scanner(System.in);
        String studentUsername = scanner.nextLine();

        System.out.print("Enter the course name: ");
        String courseName = scanner.nextLine();

        String fileName = "grades.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean gradeFound = false;

            while ((line = reader.readLine()) != null) {
                String[] gradeInfo = line.split(",");

                if (gradeInfo.length >= 3 && gradeInfo[0].trim().equals(courseName) && gradeInfo[1].trim().equals(studentUsername)) {
                    String grade = gradeInfo[2].trim();
                    System.out.println("Your grade for " + courseName + " is " + grade);
                    gradeFound = true;
                    break;
                }
            }

            if (!gradeFound) {
                System.out.println("Grade not found for the specified course and student.");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void viewCourses() throws IOException {
        List<Course> courses = retrieveCourses();

        for (Course course : courses) {
            System.out.print("Your courses are:  " + course.getCourseName() + "\n");
        }
    }

    public static void viewTeacherNames() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Coursename: ");
        String courseName = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("AssignedCourseTeacher.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String course = parts[0];
                String teacherUsername = parts[1];
                if (course.equals(courseName)) {
                    System.out.println("Your teacher is " + teacherUsername);
                    return;
                }
            }
            System.out.println("No teacher found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }


    public static void viewCourseMaterials(String course) {


        String folderPath = "/Users/misbahkhan/Documents/ProjectTest/" + course;

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            System.out.println("Materials provided by your teacher:");
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Invalid folder path or empty folder.");
        }
    }

    private static List<Course> retrieveCourses() throws IOException {
        List<Course> courses = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("course.txt"))) {
            while (scanner.hasNextLine()) {
                String courseName = scanner.nextLine();
                courses.add(new Course(courseName));
            }
        }

        return courses;
    }


    static class Course {
        private final String courseName;

        public Course(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseName() {
            return courseName;
        }
    }


}

