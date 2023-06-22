import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherOperation {

    private static String username;
    private static String courseName;
    public static String courseFolderPath;

    public TeacherOperation(String username, String courseName) {
        TeacherOperation.username = username;
        TeacherOperation.courseName = courseName;


    }

    public static void performTeacherOperations() throws IOException {
        while (true) {
            System.out.println("::::::::::::: Teacher Operations :::::::::::::");
            System.out.println("1. Create Course Folder");
            System.out.println("2. Add File to Course Folder");
            System.out.println("3. Remove File from Course Folder");
            System.out.println("4. View Student List");
            System.out.println("5. Submit Grades");
            System.out.println("6. View Salary");
            System.out.println("7. Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    assignCourseFolder();
                    System.out.println("\n");
                    performTeacherOperations();
                }
                case 2 -> {
                    addFileToCourseFolder();
                    System.out.println("\n");
                    performTeacherOperations();
                }
                case 3 -> {
                    removeFileFromCourseFolder();
                    System.out.println("\n");
                    performTeacherOperations();
                }
                case 4 -> {
                    viewStudentList();
                    System.out.println("\n");
                    performTeacherOperations();
                }
                case 5 -> {
                    submitGrades();
                    System.out.println("\n");
                    performTeacherOperations();
                }
                case 6 -> {
                    AdminOperation.showSalary();
                    continue;
                }
                case 7 -> welcomePage.showWelcomePage();
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
            }
            return;
        }
    }


    public static void assignCourseFolder() throws IOException {
        System.out.println("::::::::::::: Assign Course Folder :::::::::::::");
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.print("Enter your course name: ");
        String courseName = scanner.nextLine();

        File file = new File("AssignedCourseTeacher.txt");

        if (!file.exists()) {
            System.out.println("AssignedCourseTeacher.txt file not found.");
            return;
        }

        try (Scanner fileScanner = new Scanner(file)) {
            boolean courseFound = false;
            boolean accessGranted = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] courseInfo = line.split(",");
                String currentCourseName = courseInfo[0];
                String teacherName = courseInfo[1];

                if (currentCourseName.equals(courseName)) {
                    courseFound = true;
                    if (teacherName.equals(username)) {
                        accessGranted = true;

                        String folderName = courseName.replaceAll("\\s", "_");
                        Path folderPath = Path.of(folderName);
                        Files.createDirectories(folderPath);
                        courseFolderPath = folderPath.toString();
                        System.out.println("Folder created successfully!");
                    }
                    break;
                }
            }

            if (!courseFound) {
                System.out.println("Course not found.");
            } else if (!accessGranted) {
                System.out.println("You do not have access to this course.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void addFileToCourseFolder() {
        if (courseFolderPath == null) {
            System.out.println("Course folder not created. Please assign a course folder first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the file to be copied: ");
        String filePath = scanner.nextLine();

        File fileToCopy = new File(filePath);
        if (!fileToCopy.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        String fileName = fileToCopy.getName();
        Path destinationPath = Path.of(courseFolderPath, fileName);

        try {
            Files.copy(fileToCopy.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied to the course folder successfully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    private static void removeFileFromCourseFolder() {
        if (courseFolderPath == null) {
            System.out.println("Course folder not created. Please assign a course folder first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file to be removed: ");
        String fileName = scanner.nextLine();

        File fileToDelete = new File(fileName);
        if (!fileToDelete.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        String filename = fileToDelete.getName();
        Path destinationPath = Path.of(courseFolderPath, filename);


        try {
            Files.delete(fileToDelete.toPath());
            System.out.println("File Deleted from the course folder successfully!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void viewStudentList() throws IOException {
        File file = new File("AssignedCourse.txt");
        System.out.print("Enter Course name: ");
        Scanner sc = new Scanner(System.in);
        String courseName = sc.nextLine();


        if (!file.exists()) {
            System.out.println("AssignedCourse.txt file not found.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            boolean courseFound = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] courseInfo = line.split(",");
                String currentCourseName = courseInfo[0];

                if (currentCourseName.equals(courseName)) {
                    courseFound = true;
                    String studentUsername = courseInfo[1];
                    System.out.println(studentUsername);
                }
            }

            if (!courseFound) {
                System.out.println("Course not found.");
            }
        }
    }

    private static void submitGrades() throws IOException {
        System.out.println("::::::::::::: Submit Grades :::::::::::::");
        System.out.print("Enter the student's username:");

        Scanner scanner = new Scanner(System.in);
        String studentUsername = scanner.nextLine();

        System.out.print("Enter the grade:");

        String grade = scanner.nextLine();
        System.out.print("Enter the course:");

        String courseName = scanner.nextLine();

        String fileName = "grades.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(courseName + "," + studentUsername + "," + grade + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("Grade submitted successfully!");
        performTeacherOperations();
    }

}