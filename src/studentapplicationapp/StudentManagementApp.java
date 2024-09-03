/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentapplicationapp;
/**
 *
 * @author lab_services_student
 */
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp
{
    public static ArrayList<Student> students = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        while (true)
        {
            System.out.println(ColorClass.CYAN_BOLD + "\nSTUDENT MANAGEMENT APPLICATION");
            System.out.println(ColorClass.RED_BOLD + "─── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ──");
            System.out.println(ColorClass.CYAN_BOLD + "Enter the number 1 to launch menu or any other key to exit");

            String option = scanner.nextLine();
            if (!option.equals("1"))
            {
                break;
            }

            showMenu();
        }
    }
    //menu system
    public static void showMenu()
    {
        while (true)
        {
            System.out.println(ColorClass.YELLOW_UNDERLINED + "\nPlease select one of the following menu items:");
            System.out.println(ColorClass.YELLOW_UNDERLINED + "(1) Capture a new student.");
            System.out.println(ColorClass.YELLOW_UNDERLINED + "(2) Search for a student.");
            System.out.println(ColorClass.YELLOW_UNDERLINED + "(3) Delete a student.");
            System.out.println(ColorClass.YELLOW_UNDERLINED + "(4) Print student report.");
            System.out.println(ColorClass.YELLOW_UNDERLINED + "(5) Exit Application.");

            String choice = scanner.nextLine();

            switch (choice)
            {
                case "1":
                    saveStudent();
                    break;
                case "2":
                    searchStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    studentReport();
                    break;
                case "5":
                    exitApplication();
                    return; // Exit the loop and the method
                default:
                    System.out.println("Wrong Input, Please try again.");
                    break;
            }
        }
    }

    //capturing the student details
    public static void saveStudent()
    {
        System.out.println(ColorClass.PURPLE_BOLD + "\nCAPTURE A NEW STUDENT");
        System.out.println(ColorClass.PURPLE_BOLD + "─── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ──");

        System.out.print(ColorClass.PURPLE_BOLD + "Enter the student id: ");
        String id = scanner.nextLine();

        System.out.print(ColorClass.PURPLE_BOLD + "Enter the student name: ");
        String name = scanner.nextLine();

        int age;
        while (true)
        {
            System.out.print(ColorClass.PURPLE_BOLD + "Enter the student age: ");
            try
            {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 16)
                {
                    break;
                }
                else
                {
                    System.out.println(ColorClass.RED_BOLD + "You have entered an incorrect student age!!!");
                    System.out.println(ColorClass.RED_BOLD + "Please re-enter the student age >> ");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(ColorClass.RED_BOLD + "Please enter a valid number.");
            }
        }

        System.out.print(ColorClass.PURPLE_BOLD + "Enter the student email: ");
        String email = scanner.nextLine();

        System.out.print(ColorClass.PURPLE_BOLD + "Enter the student course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, email, course));
        System.out.println(ColorClass.GREEN_BOLD + "Student details have been successfully saved.");
    }

    public static void searchStudent()
    {
        System.out.print(ColorClass.PURPLE_BOLD + "Enter the student id to search: ");
        String id = scanner.nextLine();

        Student student = findStudentById(id);

        if (student != null)
        {
            System.out.println(student);
        }
        else
        {
            System.out.println(ColorClass.RED_BOLD + "Student with Student Id: " + id + " was not found!");
        }
    }

    public static void deleteStudent()
    {
        System.out.print(ColorClass.PURPLE_BOLD + "Enter the student id to delete: ");
        String id = scanner.nextLine();

        Student student = findStudentById(id);

        if (student != null)
        {
            System.out.print(ColorClass.PURPLE_BOLD + "Are you sure you want to delete the student (yes/no)? ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("yes"))
            {
                students.remove(student);
                System.out.println(ColorClass.BLUE_BOLD + "Student with Student Id: " + id + " was deleted!");
            }
            else
            {
                System.out.println(ColorClass.BLUE_BOLD + "Student deletion cancelled.");
            }
        }
        else
        {
            System.out.println(ColorClass.RED_BOLD + "Student with Student Id: " + id + " was not found!");
        }
    }

    public static void studentReport()
    {
        if (students.isEmpty())
        {
            System.out.println(ColorClass.RED_BOLD + "No students available.");
        }
        else
        {
            for (int i = 0; i < students.size(); i++)
            {
                System.out.println(ColorClass.PURPLE_BOLD + "STUDENT " + (i + 1));
                System.out.println(ColorClass.PURPLE_BOLD + "─── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ──");
                System.out.println(students.get(i));
                System.out.println(ColorClass.PURPLE_BOLD + "─── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ──");
            }
        }
    }

    public static void exitApplication()
    {
        System.out.println(ColorClass.YELLOW_BOLD + "Exiting the application. Goodbye!");
        System.exit(0);
    }

    public static Student findStudentById(String id)
    {
        for (Student student : students)
        {
            if (student.getId().equals(id))
            {
                return student;
            }
        }
        return null;
    }
}

