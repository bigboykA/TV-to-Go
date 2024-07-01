/**
 * Name: Kofi Amo - Antwi
 * CSC 202-Project 2
 * Episode.java
 * Date: 21 October 2023
 * 
 * This class represents a one episode of a TV series with 
 * the series, the episode number, and the season number of this episode.
 * 
 * Document Assistance(who and describe; if no assistance, declare that fact):
 *  
 */


public class Episode extends VideoItem{
	
	private static final String[] POSSIBLE_RATINGS = {"TV-14", "TV-G", "TV-MA", "TV-PG", "TV-R"};
	
	private TVSeries series;  
	private int seasonNumber;
	private int episodeNumber;
	
	/**
	 *  Episode constructs an episode object
	 * @param series - the TV series to which this episode belongs
	 * @param rating - the rating of this episode
	 * @param lengthMin - length of this episode in minutes
	 * @param seasonNumber - the season number 
	 * @param episodeNumber - the number of episodes in each season
	 * @param title - the title of this episode 
	 * @param numDownloads - the number of times this episode has been downloaded
	 * @param ranking - the average ranking of this episode based on the number of responses 
	 * @param numResponses - the number of responses ranking this episode
	 */
	
	
	public Episode(TVSeries series,String rating,int lengthMin,int seasonNumber,int episodeNumber
			,String title,int numDownloads,double ranking,int numResponses){
		super(title,rating,lengthMin,numDownloads,ranking,numResponses);
		if(seasonNumber < 1 || series.getNumSeasons()<seasonNumber) {
			throw new IllegalArgumentException
			("Invalid season number: "+ seasonNumber);
		}
		if(episodeNumber < 1 || episodeNumber  > series.getNumEpisodesInSeason(seasonNumber) ) {
			throw new IllegalArgumentException
			("Invalid episode number: "+episodeNumber);
		}
		setRating(rating);
		this.series = series;
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		
	}
	
	
	/**
	 * accesses the number of episodes
	 * @return episodeNumber - the number of episodes in each season
	 */
	public int getEpisodeNum() {
		return episodeNumber;
	}
	
	/**
	 * access the number of series
	 * @return series - returns TV series to which this episode belongs
	 */
	public  TVSeries getSeries() {
		return series;
	}
	
	
	/**
	 * returns the season number 
	 * @return seasonNumber - the season number
	 */
	public int getSeason() {
		return seasonNumber;
	}
	
	
	/**
	 * returns the number of episodes left in the season
	 * @return episodeLeft
	 */
	public int getNumEpisodesLeftThisSeason() {
		int totalEpisodes = series.getNumEpisodesInSeason(seasonNumber);
		int episodeWatched = episodeNumber ;
		int episodeLeft = totalEpisodes - episodeWatched;
		return episodeLeft;
	}
	
	
	
	@Override
	public void setRating(String newRating) {
		boolean isValid = false;
		for(int i = 0;i<POSSIBLE_RATINGS.length;i++) {
			
			if(newRating.equals(POSSIBLE_RATINGS[i])) {
				super.setRating(newRating);
				isValid = true;
			}
			
		}
		
		if(!isValid){
		    throw new IllegalArgumentException
		    ("Invalid rating: "+newRating);
		    
		}
	}
	
	@Override
	public String getFullTitle() {
		String str = "\""+series.getTitle() + "\" Season " + getSeason()+", Episode " + getEpisodeNum() + ", \"" + getTitle() +"\"";
		return str;
	}
	
	@Override
	public String getItemDetails() {
		 String itemString = "\"" + series.getTitle() + "\"\n"
		           + "Season " +getSeason()+ ", Episode " + getEpisodeNum() + "\n"
		           +"\""+super.getTitle()+"\"\n"
		            + super.getItemDetails();
		            
		    return itemString;
	}
	@Override
	public String download() {
		super.download();
		
		
		  int episodesLeft = series.getNumEpisodesInSeason(seasonNumber) - episodeNumber;
		    if (episodesLeft == 0) {
		        return "No episodes left in this season.";
		    } else if (episodesLeft == 1) {
		        return "1 episode left in this season.";
		    } else {
		        return episodesLeft + " episodes left in this season.";
		    }
		
		
	}
	
	
	@Override
	public String toString() {
		String itemString = "\"" +series.getTitle()+"\""+" Season "+getSeason()+", Episode "+getEpisodeNum();
		return itemString;
	}
	
	
	
	
}