package steamstream;
import java.util.ArrayList;
import java.util.Scanner;

public class SteamStream {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<SteamStreamManager> seriesList = new ArrayList<>();
        // Declarations
        String seriesID;
        String seriesName;
        int ageRestriction;
        int numberOfEpisodes;
        String userChoice;
        int menuOption;
        boolean keepRunning = true; // this is a control variable
        
        System.out.println("Latest Series for 2025");
        System.out.println("*".repeat(50)); 
        System.out.println("Please enter 1 to launch menu or any other key to exit");
        
        String startChoice = input.nextLine();
        if (!startChoice.equals("1")) {
            System.exit(0);
        }
        
        while (keepRunning) {
            System.out.println("Please select one of the following menu items:");
            System.out.println("1 -  Capture a new series.");
            System.out.println("2 -  Search for a series.");
            System.out.println("3 - Update series age restriction");
            System.out.println("4 - Delete a series.");
            System.out.println("5 - Print series report - 2025");
            System.out.println("6 - Exit Application.");
            System.out.print("Enter your choice: ");
            
            try {
                menuOption = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                menuOption = -1;
            }
            
            if (menuOption == 1) {
                CaptureSeries(input, seriesList);
            } else if (menuOption == 2) {
                SearchSeries(input, seriesList);
            } else if (menuOption == 3) {
                UpdateSeries(input, seriesList);
            } else if (menuOption == 4) {
                DeleteSeries(input, seriesList);
            } else if (menuOption == 5) {
                SeriesReport(input, seriesList);
            } else if (menuOption == 6) {
                ExitSeriesApplication();
                keepRunning = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void CaptureSeries(Scanner input, ArrayList<SteamStreamManager> seriesList) {
        String seriesID;
        String seriesName;
        int ageRestriction;
        int numberOfEpisodes;
        String ageInput;
        
        System.out.println("Capture of new series.");
        System.out.println("*".repeat(25));
        
        System.out.print("Enter the series id: ");
        seriesID = input.nextLine();
        
        System.out.print("Enter the series name: ");
        seriesName = input.nextLine();
        
        while (true) {
            System.out.print("Enter the series age restriction: ");
            ageInput = input.nextLine();
            
            try {
                ageRestriction = Integer.parseInt(ageInput);
                if (ageRestriction >= 2 && ageRestriction <= 18) {
                    break;
                } else {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.print("Please re-enter the series age  ");
                }
            } catch (Exception e) {
                System.out.println("You have entered a incorrect series age!!!");
                System.out.print("Please re-enter the series age  "); // W3Schools. (n.d.) Java Exceptions (Try...Catch). Available at: w3schools.com/java/java_try_catch.asp (Accessed: 2 September 2025). 
            }
        }
        
        System.out.print("Enter the number of episodes for " + seriesName + " : ");
        numberOfEpisodes = Integer.parseInt(input.nextLine());
        
        SteamStreamManager newSeries = new SteamStreamManager(seriesID, seriesName, ageRestriction, numberOfEpisodes);
        seriesList.add(newSeries);
        
        System.out.println("Series processed successfully!!!");
        System.out.println(" Please enter 1 to launch menu or any other key to exit");
        
        String choice = input.nextLine();
        if (!choice.equals("1")) {
            ExitSeriesApplication();
        }
    }

    public static void SearchSeries(Scanner input, ArrayList<SteamStreamManager> seriesList) {
        String searchId;
        SteamStreamManager found = null;
        
        System.out.print("Enter the series id to search: ");
        searchId = input.nextLine();
        
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesID().equals(searchId)) {
                found = seriesList.get(i);
                break;
            }
        }
        
        if (found != null) {
            System.out.println("-".repeat(50)); 
            System.out.println("Series ID: " + found.getSeriesID());
            System.out.println("Series Name: " + found.getNameOfSeries());
            System.out.println("Age Restriction: " + found.getAgeRestriction());
            System.out.println("Number of episodes: " + found.getNumberOfEpisodes());
            System.out.println("-".repeat(50));
        } else {
            System.out.println("-".repeat(50)); 
            System.out.println("Series with Series Id: " + searchId + " was not found!");
            System.out.println("-".repeat(50));
        }
        
        System.out.println("Please enter 1 to launch menu or any other key to exit");
        String choice = input.nextLine();
        if (!choice.equals("1")) {
            ExitSeriesApplication();
        }
    }
    public static void UpdateSeries(Scanner input, ArrayList<SteamStreamManager> seriesList) {
        String updateId;
        String newName;
        int newAge;
        int newEpisodes;
        String ageInput;
        SteamStreamManager found = null;
        
        System.out.print("Enter the series id to update: ");
        updateId = input.nextLine();
        
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesID().equals(updateId)) {
                found = seriesList.get(i);
                break;
            }
        }
        
        if (found != null) {
            System.out.print("Enter the series name: ");
            newName = input.nextLine();
            
            while (true) {
                System.out.print("Enter the series age restriction: ");
                ageInput = input.nextLine();
                
                try {
                    newAge = Integer.parseInt(ageInput);
                    if (newAge >= 2 && newAge <= 18) {
                        break;
                    } else {
                        System.out.println("You have entered a incorrect series age!!!");
                        System.out.print("Please re-enter the series age  ");
                    }
                } catch (Exception e) {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.print("Please re-enter the series age  ");
                }
            }
            
            System.out.print("Enter the number of episodes: ");
            newEpisodes = Integer.parseInt(input.nextLine());
            
            found.setNameOfSeries(newName);
            found.setAgeRestriction(newAge);
            found.setNumberOfEpisodes(newEpisodes);
            
            System.out.println("Series updated successfully!");
        } else {
            System.out.println("Series not found!");
        }
        
        System.out.println("Please enter 1 to launch menu or any other key to exit");
        String choice = input.nextLine();
        if (!choice.equals("1")) {
            ExitSeriesApplication();
        }
    }

    public static void DeleteSeries(Scanner input, ArrayList<SteamStreamManager> seriesList) {
        String deleteId;
        String confirm;
        SteamStreamManager found = null;
        
        System.out.print("Enter the series id to delete: ");
        deleteId = input.nextLine();
        
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesID().equals(deleteId)) {
                found = seriesList.get(i);
                break;
            }
        }
        
        if (found != null) {
            System.out.print("Are you sure you want to delete series " + deleteId + " from the system? Yes (y) to delete: ");
            confirm = input.nextLine();
            
            if (confirm.equals("y") || confirm.equals("Y")) {
                seriesList.remove(found);
                System.out.println("-".repeat(50));
                System.out.println("Series with Series Id: " + deleteId + " was deleted!");
                System.out.println("-".repeat(50));
            }
        } else {
            System.out.println("Series not found!");
        }
        
        System.out.println(" Please enter 1 to launch menu or any other key to exit");
        String choice = input.nextLine();
        if (!choice.equals("1")) {
            ExitSeriesApplication();
        }
    }

    public static void SeriesReport(Scanner input, ArrayList<SteamStreamManager> seriesList) {
        if (seriesList.size() == 0) {
            System.out.println("No series available.");
            return;
        }
        
        for (int i = 0; i < seriesList.size(); i++) {
            SteamStreamManager series = seriesList.get(i);
            System.out.println("Series " + (i + 1));
            System.out.println("-".repeat(50)); 
            System.out.println("Series ID: " + series.getSeriesID());
            System.out.println("Series Name: " + series.getNameOfSeries());
            System.out.println("Age Restriction: " + series.getAgeRestriction());
            System.out.println("Number of episodes: " + series.getNumberOfEpisodes());
            System.out.println("-".repeat(50));
        }
        
        System.out.println("Please enter 1 to launch menu or any other key to exit");
        String choice = input.nextLine();
        if (!choice.equals("1")) {
            ExitSeriesApplication();
        }
    }

    public static void ExitSeriesApplication() {
        System.out.println("Thank you for using the application!");
        System.exit(0);
    }
}
/*

*/
