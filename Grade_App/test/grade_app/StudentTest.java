package grade_app;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testCalculateAverage() {
        // Arrange
        int[] marks = {80, 90, 70};
        Student student = new Student("John", "Doe", 16, "S001", "10A", marks);
        double expectedAverage = (80 + 90 + 70) / 3.0;

        // Act
        double actualAverage = student.calculateAverage();

        // Assert
        assertEquals(expectedAverage, actualAverage, 0.01);
    }

    @Test
    public void testCalculateAverage_NoMarks() {
        // Arrange
        int[] marks = {};
        Student student = new Student("Jane", "Smith", 17, "S002", "11B", marks);

        // Act
        double actualAverage = student.calculateAverage();

        // Assert
        assertEquals(0, actualAverage, 0.01);
    }

    @Test
    public void testGetHighestMark() {
        // Arrange
        int[] marks = {45, 67, 89, 56};
        Student student = new Student("Mike", "Brown", 18, "S003", "12C", marks);

        // Act
        int highest = student.getHighestMark();

        // Assert
        assertEquals(89, highest);
    }

    @Test
    public void testGetHighestMark_NoMarks() {
        // Arrange
        int[] marks = {};
        Student student = new Student("Anna", "White", 15, "S004", "9A", marks);

        // Act
        int highest = student.getHighestMark();

        // Assert
        assertEquals(0, highest);
    }

    @Test
    public void testGetLowestMark() {
        // Arrange
        int[] marks = {45, 67, 89, 56};
        Student student = new Student("Sam", "Green", 17, "S005", "11C", marks);

        // Act
        int lowest = student.getLowestMark();

        // Assert
        assertEquals(45, lowest);
    }

    @Test
    public void testGetLowestMark_NoMarks() {
        // Arrange
        int[] marks = {};
        Student student = new Student("Lily", "Black", 14, "S006", "8B", marks);

        // Act
        int lowest = student.getLowestMark();

        // Assert
        assertEquals(0, lowest);
    }

    @Test
    public void testSetMarks_RecalculateAverage() {
        // Arrange
        int[] marks = {60, 70, 80};
        Student student = new Student("Tom", "Hall", 16, "S007", "10B", marks);

        // Act
        student.setMarks(new int[]{100, 90, 80});

        // Assert
        assertEquals(90.0, student.getAverage(), 0.01);
    }

    @Test
    public void testSetGrade() {
        // Arrange
        int[] marks = {50, 60, 70};
        Student student = new Student("Eva", "King", 16, "S008", "9C", marks);

        // Act
        student.setGrade("10C");

        // Assert
        assertEquals("10C", student.getGrade());
    }
}

