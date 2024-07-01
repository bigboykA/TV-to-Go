 /**
 * Name: Kofi Amo - Antwi
 * CSC 202-Project 2
 * Movie.java
 * Date: 24 October 2023
 * 
 * This class represents a movie including its title, the year it was released,
 * its rating (G, R, etc.), its length in minutes, the number of times it has
 * been downloaded, its ranking out of 10, and the number of responses that
 * determined that ranking.
 * 
 * Document Assistance(who and describe; if no assistance, declare that fact):
 * Assistance from Dr.Mueller to debug my setReleaseYear method
 */

import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Movie extends VideoItem {
	private static final String[] POSSIBLE_RATINGS = {"G", "NC-17", "PG", "PG-13", "R"};
	private static final String FIRST_RELEASE_YEAR = "1906";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
	private static final String CURRENT_YEAR = dateFormat.format(new Date());
	private static final int NUM_DIGITS_IN_YEAR = 4;
	private String releaseYear; // the year the movie was released
	/**
	 * Constructs a Movie object
	 * @param title - the title of this movie
	 * @param releaseYear - the year this movie was released
	 * @param rating - the rating of this movie (G, R, ...)
	 * @param length - the length of this movie in minutes
	 * @param numDownloads - the number of times this movie has been downloaded
	 * @param ranking - the average ranking of this movie from the responses
	 * @param numResponses - the number of responses ranking this movie
	 */
	//TODO: Constructor
	
	public Movie(String title,String releaseYear,String rating,int lengthMin,int numDownloads,double ranking,int numResponses) {
		super(title,rating,lengthMin,numDownloads,ranking,numResponses);
		setReleaseYear(releaseYear);
		setRating(rating);
		
	}

	@Override   // for setRating
	public void setRating(String rating) {
		boolean validRating = false;
		for(int i = 0;i<POSSIBLE_RATINGS.length;i++) {
			if(rating.equals(POSSIBLE_RATINGS[i])) {
				validRating = true;
				super.setRating(rating);
				break;
			}
		}
		if(!validRating) {
			throw new IllegalArgumentException
			("Invalid rating: "+rating);
		}
		
	}
	//TODO: setRanking
	/**
	 * sets the year this movie was released to the year received (Between "1906" and the current year inclusive)
	 * @param releaseYear - the year this movie was released
	 */
	//TODO: setReleaseYear
	public void setReleaseYear(String yearReleased) {
		boolean validYear = false;
		if(yearReleased.matches("[0-9]+") && yearReleased.length()== NUM_DIGITS_IN_YEAR &&
				FIRST_RELEASE_YEAR.compareTo(yearReleased) <= 0 && yearReleased.compareTo(CURRENT_YEAR) <= 0	) {
				    validYear = true;
			this.releaseYear = yearReleased;
		}
		if(!validYear) {
			throw new IllegalArgumentException
			("Invalid release year: "+yearReleased);
		}
	}
	
	@Override
	//TODO: getItemDetails
	public String getItemDetails() {
		String result = "\""+getTitle()+ "\"\n"+
					this.releaseYear+"\n"+
					super.getItemDetails();
		return result;
					
	}
	
	@Override
	//TODO: toString
	public String toString() {
		String result = "\""+getTitle()+ "\"";
		return result;
	}
	
}

