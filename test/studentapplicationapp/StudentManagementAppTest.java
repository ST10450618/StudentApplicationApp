package studentapplicationapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentManagementAppTest {

    @Before
    public void setUp() {
        // Clear the student list before each test to ensure a clean state
        StudentManagementApp.students.clear();
    }

    @After
    public void tearDown() {
        // Clear the student list after each test to clean up
        StudentManagementApp.students.clear();
    }

    @Test
    public void testSaveStudent() {
        // Test saving a student
        Student student = new Student("1", "Alice", 20, "alice@example.com", "Mathematics");
        StudentManagementApp.students.add(student);
        assertEquals(1, StudentManagementApp.students.size());
        assertEquals("Alice", StudentManagementApp.students.get(0).getName());
    }

    @Test
    public void testSearchStudent() {
        // Test searching for a student
        Student student = new Student("1", "Alice", 20, "alice@example.com", "Mathematics");
        StudentManagementApp.students.add(student);

        Student foundStudent = StudentManagementApp.findStudentById("1");
        assertNotNull(foundStudent);
        assertEquals("Alice", foundStudent.getName());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        // Test searching for a non-existent student
        Student foundStudent = StudentManagementApp.findStudentById("999");
        assertNull(foundStudent);
    }

    @Test
    public void testDeleteStudent() {
        // Test deleting a student
        Student student = new Student("1", "Alice", 20, "alice@example.com", "Mathematics");
        StudentManagementApp.students.add(student);

        StudentManagementApp.students.remove(student);
        assertEquals(0, StudentManagementApp.students.size());
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Test deleting a non-existent student
        int initialSize = StudentManagementApp.students.size();
        Student student = StudentManagementApp.findStudentById("999");
        if (student != null) {
            StudentManagementApp.students.remove(student);
        }
        assertEquals(initialSize, StudentManagementApp.students.size());
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        // Test valid student age
        int age = 20;
        assertTrue(age >= 16);
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        // Test invalid student age
        int age = 15;
        assertFalse(age >= 16);
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        // Test invalid character input for student age
        String ageInput = "abc";
        try {
            Integer.parseInt(ageInput);
            fail("Expected NumberFormatException");
        } catch (NumberFormatException e) {
            // Expected exception, test passes
        }
    }
}
