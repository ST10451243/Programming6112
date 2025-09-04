package steamstream;

public class SteamStreamManager {
     private String seriesID;
     private String nameOfSeries;
     private int ageRestriction;
     private int numberOfEpisodes;
     
     // Constructors
    public SteamStreamManager(String seriesID, String nameOfSeries, int ageRestriction, int numberOfEpisodes) {
        this.seriesID = seriesID;
        this.nameOfSeries = nameOfSeries;
        this.ageRestriction = ageRestriction;
        this.numberOfEpisodes = numberOfEpisodes;
    }
    
    // Getters
    public String getSeriesID() {
        return seriesID;
    }

    public String getNameOfSeries() {
        return nameOfSeries;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }
    
    // Setters
    public void setNameOfSeries(String nameOfSeries) {
        this.nameOfSeries = nameOfSeries;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }
      
}
