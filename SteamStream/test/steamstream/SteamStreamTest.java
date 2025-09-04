package steamstream;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SteamStreamTest {

    @Test
    public void TestSearchSeries() {
        // Arrange
        ArrayList<SteamStreamManager> seriesList = new ArrayList<>();
        seriesList.add(new SteamStreamManager("S001", "BreakingCode", 16, 10));
        String inputData = "S001 1"; 
        Scanner scanner = new Scanner(inputData);

        // Act
        SteamStream.SearchSeries(scanner, seriesList);

        // Assert
        assertEquals("S001", seriesList.get(0).getSeriesID());
        assertEquals("BreakingCode", seriesList.get(0).getNameOfSeries());
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        // Arrange
        ArrayList<SteamStreamManager> seriesList = new ArrayList<>();
        seriesList.add(new SteamStreamManager("S002", "CodeWars", 12, 8));
        String inputData = "WRONGID 1"; 
        Scanner scanner = new Scanner(inputData);

        // Act
        SteamStream.SearchSeries(scanner, seriesList);

        // Assert
        assertEquals(1, seriesList.size()); 
    }

    @Test
    public void TestUpdateSeries() {
        // Arrange
        ArrayList<SteamStreamManager> seriesList = new ArrayList<>();
        seriesList.add(new SteamStreamManager("S003", "OldShow", 10, 5));
        String inputData = "S003 NewShow 15 20 1"; 
        Scanner scanner = new Scanner(inputData);

        // Act
        SteamStream.UpdateSeries(scanner, seriesList);

        // Assert
        assertEquals("NewShow", seriesList.get(0).getNameOfSeries());
        assertEquals(15, seriesList.get(0).getAgeRestriction());
        assertEquals(20, seriesList.get(0).getNumberOfEpisodes());
    }

    @Test
    public void TestDeleteSeries() {
        // Arrange
        ArrayList<SteamStreamManager> seriesList = new ArrayList<>();
        seriesList.add(new SteamStreamManager("S004", "DeleteMe", 14, 7));
        String inputData = "S004 y 1"; 
        Scanner scanner = new Scanner(inputData);

        // Act
        SteamStream.DeleteSeries(scanner, seriesList);

        // Assert
        assertEquals(0, seriesList.size());
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        // Arrange
        ArrayList<SteamStreamManager> seriesList = new ArrayList<>();
        seriesList.add(new SteamStreamManager("S005", "KeepMe", 13, 6));
        String inputData = "WRONGID y 1"; 
        Scanner scanner = new Scanner(inputData);

        // Act
        SteamStream.DeleteSeries(scanner, seriesList);

        // Assert
        assertEquals(1, seriesList.size()); 
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        // Arrange
        ArrayList<SteamStreamManager> seriesList = new ArrayList<>();
        String inputData = "S006 ValidShow 12 5 1"; 
        Scanner scanner = new Scanner(inputData);

        // Act
        SteamStream.CaptureSeries(scanner, seriesList);

        // Assert
        assertEquals(1, seriesList.size());
        assertEquals(12, seriesList.get(0).getAgeRestriction());
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        // Arrange
        ArrayList<SteamStreamManager> seriesList = new ArrayList<>();
        // invalid age 25, then corrected age 15
        String inputData = "S007 InvalidShow 25 15 5 1"; 
        Scanner scanner = new Scanner(inputData);

        // Act
        SteamStream.CaptureSeries(scanner, seriesList);

        // Assert
        assertEquals(1, seriesList.size());
        assertEquals(15, seriesList.get(0).getAgeRestriction()); 
    }
}
/*
Coding with John (n.d.) Java Unit Testing with JUnit – Tutorial – How to Create And Use Unit Tests. Available at: YouTube video ID vZm0lHciFsQ (Accessed: 4 September 2025). 
*/






