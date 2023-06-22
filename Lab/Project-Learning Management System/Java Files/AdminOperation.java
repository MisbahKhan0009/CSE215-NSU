import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdminOperation {
    public static void performAdminOperations() throws IOException {
        System.out.println("::::::::::::: Admin Operations :::::::::::::");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Add Teacher");
        System.out.println("4. Remove Teacher");
        System.out.println("5. Add Course");
        System.out.println("6. Assign Teacher to Course");
        System.out.println("7. Add Student to Course");
        System.out.println("8. Show Salary of a Teacher");
        System.out.println("9. Show Grade of a Student");
        System.out.println("10. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                addStudent();
                System.out.println("\n");
                performAdminOperations();
            }
            case 2 -> {
                removeStudent();
                System.out.println("\n");
                performAdminOperations();
            }
            case 3 -> {
                addTeacher();
                System.out.println("\n");
                performAdminOperations();
            }
            case 4 -> {
                removeTeacher();
                System.out.println("\n");
                performAdminOperations();
            }
            case 5 -> {
                addCourse();
                System.out.println("\n");
                performAdminOperations();
            }
            case 6 -> {
                assignTeacherToCourse();
                System.out.println("\n");
                performAdminOperations();
            }
            case 7 -> {
                addStudentToCourse();
                System.out.println("\n");
                performAdminOperations();
            }
            case 8 -> {
                showSalary();
                System.out.println("\n");
                performAdminOperations();
            }
            case 9 -> {
                showGrade();
                System.out.println("\n");
                performAdminOperations();
            }
            case 10 -> welcomePage.showWelcomePage();
            default -> {
                System.out.println("Invalid choice. Please try again.");
                performAdminOperations();
            }
        }
    }

    private static void addStudent() throws IOException {
        System.out.println("::::::::::::: Add Student :::::::::::::");
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        loginSignup.saveSignupInformation("stuInfo.txt", username, password);
        System.out.println("Student added successfully!");
    }

    private static void removeStudent() throws IOException {
        System.out.println("::::::::::::: Remove Student :::::::::::::");
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        removeUser("stuInfo.txt", username);
        System.out.println("Student removed successfully!");
    }

    private static void addTeacher() throws IOException {
        System.out.println("::::::::::::: Add Teacher :::::::::::::");
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter teacher's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter teacher's salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        loginSignup.saveSignupInformation("teacherInfo.txt", username, password);
        saveTeacherSalary(username, salary);

        System.out.println("Teacher added successfully!");
    }

    private static void removeTeacher() throws IOException {
        System.out.println("::::::::::::: Remove Teacher :::::::::::::");
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        removeUser("teacherInfo.txt", username);
        removeSalary(username);
        System.out.println("Teacher removed successfully!");
    }

    private static void showGrade() throws IOException {
        System.out.println("::::::::::::: Show Grade of a Student :::::::::::::");
        System.out.print("Enter student's username: ");
        Scanner scanner = new Scanner(System.in);
        String studentUsername = scanner.nextLine();

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        double grade = getGrade(studentUsername, courseName);

        if (grade == -1) {
            System.out.println("Grade not found!");
        } else {
            System.out.println("Grade for " + courseName + ": " + grade);
        }
    }

    public static void showSalary() throws IOException {
        System.out.println("::::::::::::: Show Salary of a Teacher :::::::::::::");
        System.out.print("Enter teacher's username: ");
        Scanner scanner = new Scanner(System.in);
        String teacherUsername = scanner.nextLine();

        double salary = getTeacherSalary(teacherUsername);

        if (salary == -1) {
            System.out.println("Salary not found!");
        } else {
            System.out.println("Salary for teacher " + teacherUsername + ": " + salary + "tk");
        }
    }

    private static void addCourse() throws IOException {
        System.out.println("::::::::::::: Add Course :::::::::::::");
        System.out.print("Enter course name: ");
        Scanner scanner = new Scanner(System.in);
        String courseName = scanner.nextLine();

        saveCourse(courseName);
        System.out.println("Course added successfully!");
    }

    private static void saveTeacherSalary(String username, double salary) throws IOException {
        try (FileWriter writer = new FileWriter("salary.txt", false)) {
            writer.write(username + "," + salary + "\n");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void removeUser(String fileName, String username) throws IOException {
        String tempFile = "temp.txt";

        try (Scanner scanner = new Scanner(new File(fileName));
             FileWriter writer = new FileWriter(tempFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] user = line.split(",");

                if (user.length >= 1 && !user[0].equals(username)) {
                    writer.write(line + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        File file = new File(fileName);
        file.delete();

        File temp = new File(tempFile);
        temp.renameTo(file);
    }

    private static void removeSalary(String username) throws IOException {
        String tempFile = "temp.txt";

        try (Scanner scanner = new Scanner(new File("salary.txt"));
             FileWriter writer = new FileWriter(tempFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] salaryInfo = line.split(",");

                if (salaryInfo.length >= 1 && !salaryInfo[0].equals(username)) {
                    writer.write(line + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        File file = new File("salary.txt");
        file.delete();

        File temp = new File(tempFile);
        temp.renameTo(file);
    }

    private static double getGrade(String studentUsername, String courseName) throws IOException {
        try (Scanner scanner = new Scanner(new File("grade.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] gradeInfo = line.split(",");

                if (gradeInfo.length >= 3 && gradeInfo[0].equals(studentUsername) && gradeInfo[1].equals(courseName)) {
                    return Double.parseDouble(gradeInfo[2]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return -1;
    }

    private static double getTeacherSalary(String teacherUsername) throws IOException {
        try (Scanner scanner = new Scanner(new File("salary.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] salaryInfo = line.split(",");

                if (salaryInfo.length >= 2 && salaryInfo[0].equals(teacherUsername)) {
                    return Double.parseDouble(salaryInfo[1]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return -1;
    }

    private static void saveCourse(String courseName) throws IOException {
        try (FileWriter writer = new FileWriter("course.txt", true)) {
            writer.write(courseName + "\n");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void addStudentToCourse() throws IOException {
        System.out.println("::::::::::::: Add Student to Course :::::::::::::");
        System.out.print("Enter student's username: ");
        Scanner scanner = new Scanner(System.in);
        String studentUsername = scanner.nextLine();

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        boolean added = addStudentToCourseByUsername(studentUsername, courseName);

        if (added) {
            System.out.println("Student added to the course successfully!");
        } else {
            System.out.println("Failed to add student to the course.");
        }
        scanner.close();
    }

    private static boolean addStudentToCourseByUsername(String studentUsername, String courseName) throws IOException {
        File file = new File("AssignedCourse.txt");
        File FILE = new File("course.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        try (Scanner scanner = new Scanner(FILE);
             FileWriter writer = new FileWriter(file)) {

            boolean courseFound = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] courseInfo = line.split(",");
                String currentCourseName = courseInfo[0];

                if (currentCourseName.equals(courseName)) {
                    line += "," + studentUsername;
                    courseFound = true;
                }
                writer.write(line + "\n");
            }

            if (!courseFound) {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }

    private static void assignTeacherToCourse() throws IOException {
        System.out.println("::::::::::::: Assign Teacher to Course :::::::::::::");
        System.out.print("Enter teacher's username: ");
        Scanner scanner = new Scanner(System.in);
        String teacherUsername = scanner.nextLine();

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        boolean assigned = assignTeacherByUsername(teacherUsername, courseName);

        if (assigned) {
            System.out.println("Teacher assigned to the course successfully!");
        } else {
            System.out.println("Failed to assign teacher to the course.");
        }
    }

    private static boolean assignTeacherByUsername(String teacherUsername, String courseName) throws IOException {
        File file = new File("AssignedCourseTeacher.txt");
        File FILE = new File("course.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        try (Scanner scanner = new Scanner(FILE);
             FileWriter writer = new FileWriter(file)) {

            boolean courseFound = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] courseTeacherInfo = line.split(",");
                String currentCourseName = courseTeacherInfo[0];

                if (currentCourseName.equals(courseName)) {
                    line += "," + teacherUsername;

                    courseFound = true;
                }
                writer.write(line + "\n");
            }

            if (!courseFound) {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}