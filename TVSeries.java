/**
 * Name: KOFI AMO - ANTWI
 * CSC 202-Project 2
 * TVSeries.java
 * Date: 16 OCTOBER 2023
 * 
 * This class represents a TV series with a title
 * and the number of episodes per season
 * 
 *  
 */
public class TVSeries {
	
	private String title; // instance variable for title of the series
	private int [] numEpisodes; // represents array of number of episodes in each season
	
	
	/**
	 * Constructs a TVSeries
	 * @param title - represents the title of a series
	 * @param numEpisodes - array of integers representing a series title
	 */
	public TVSeries(String title,int[]numEpisodes) {
		this.title = title;
		this.numEpisodes = numEpisodes;
	}
	
	
	/**
	 * returns the title of the series
	 * @return title  
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * returns the number of seasons in the season
	 * @return numEpisodes.length
	 */
	public int getNumSeasons() {
		return numEpisodes.length;
	}
	
	
	/**
	 * returns the number of episodes in seasonNumber
	 * @param seasonNumber 
	 * @return numEpisodes[seasonNumber - 1 ]
	 */
	public int getNumEpisodesInSeason(int seasonNumber) {
		if(seasonNumber < 1 || seasonNumber > numEpisodes.length) {
			throw new IllegalArgumentException
			("Invalid season number: "+ seasonNumber);
		}
		return numEpisodes[seasonNumber - 1];
		
	}
	
	
	@Override
	public String toString() {
		String result = "\"" + getTitle() + "\" TV Series\n";
		
		for(int i = 0; i < numEpisodes.length - 1;i++) {
			result += "    Season "+(i+1)+ " has " + numEpisodes[i] + " episodes.\n";
		}
		result += "    Season "+(numEpisodes.length)+ " has " +numEpisodes[numEpisodes.length - 1] + " episodes.";
		return result;
	}
	
}

	