/**
 * Name: Kofi Amo-Antwi
 * CSC 202-Project 2
 * VideoItem.java
 * Date: 13 October 2023
 * 
 * Represents a video content item for on-line downloading which
 * includes attributes common to movies and TV-episodes
 * 
 *
 */

public abstract class VideoItem {

	// maximum ranking value
	public final static int MAX_RANKING = 10;

	private String title;
	private int lengthMin;
	private String rating; // "R", "G", etc for films, "TV-14", "TV-MA" for episodes of TV series
	private int numDownloads;
	private double ranking;
	private int numResponses;

	/**
	 * Constructs a video item object. 
	 * @param title-
	 *            the title of this video item
	 * @param rating-
	 *            the rating (R, TV-13, etc) of this video item
	 * @param length-
	 *            the length of this video item in minutes
	 * @param numDownloads-
	 *            the number of times this video item has been downloaded
	 * @param ranking-
	 *            the average rank of the item 0-10 from the responses
	 * @param numResponses-
	 *            the number of responses ranking this video item
	 */
	public VideoItem(String title, String rating, int lengthMin, int numDownloads, double ranking, int numResponses) {

		this.title = title;
		setRating(rating);
		this.lengthMin = lengthMin;
		this.numDownloads = numDownloads;
		setRanking(ranking,numResponses);
	}

	/**
	 * Returns the title of this video item
	 * @return the title of this video item
	 */
	public String getTitle() {
		return title ;
	}

	/**
	 * Returns the rating (PG, etc.) for this video item
	 * @return the rating for this video item
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Returns the "full" title of this video item, including the series if a TV series
	 *         episode, surrounded by quotes
	 * @return the "full" title of this video item
	 */
	public String getFullTitle() {
		String str = "\"" + title + "\"";
		return str;
	}
	
	/**
	 * Returns the details of this video item excluding the title
	 * @return the details of this video item excluding the title
	 */
	public String getItemDetails() {
		String text = "";
		text += getRankingString();// I was getting an error for this so I commented it out.
		text += "\n    rated: " + rating;
		text += "\n    length: " + lengthMin;
		text += "\n    downloads: " + numDownloads;
		return text;
	}

	/**
	 * Returns the ranking of this video 0-10 to the nearest tenth
	 * @return the ranking of this video item
	 */
	public double getRanking() {
		double rank = Math.round(ranking * 10) / 10.0;
		return rank;
	}

	/**
	 * Returns the length of this video in minutes
	 * @return the length of this video item in minutes
	 */
	public int getLengthMin() {
		return lengthMin;
	}

	/**
	 * Returns the number of times this video item has been downloaded
	 * @return the number of times downloaded
	 */
	public int getNumDownloads() {
		return numDownloads;
	}

	/**
	 * Increments the downloads counter of this video item
	 */
	public String download() {
		numDownloads++;
		return null;
	}

	/**
	 * Sets the rating (PG, etc) for this video item
	 * 
	 * @param rating
	 *            - the rating to be stored for this video item
	 */
	public void setRating(String rating) {
		this.rating = rating;
	} 
	
	/**
	 * Returns a string of * equivalent to the rank (to the nearest whole
	 *         number) followed by the rank out of MAX_RANKING. For example,
	 *         ****     (4/10)
	 * @return a string of * equivalent to the rank (to the nearest whole
	 *         number) followed by the rank out of MAX_RANKING
	 */
	//TODO getRankingString
	public String getRankingString() {
		
		 int rounded = (int)Math.round(getRanking());
		 String rankString = "";
		 
		 for(int i = 0;i< rounded;i++) {
			 rankString += "*";
		 }
		 for(int i = 0;i< MAX_RANKING - rounded;i++) {
			 rankString += " ";
		 }
		 
		 return rankString + "(" + rounded  + "/10) based on " + numResponses+" responses";
		 
	}
	/**
	 * getnumResponses - method to get the number of responses.
	 */
	public int getnumResponses() {
		return numResponses;
	}

	/**
	 * Sets the rank and number of responses that determined the rank
	 * 
	 * @param rank
	 *            - the ranking of this video item, 0..10
	 * @param numResponses
	 *            - the number of times this video item has been ranked, must be positive
	 */
	// TODO setRanking
	public void setRanking(double ranking, int numResponses) {
		if(!(ranking >= 0 && ranking <= MAX_RANKING )) {
			throw new IllegalArgumentException
					("Invalid ranking: "+ranking);
		}
		if(!(numResponses > 0)) {
			throw new IllegalArgumentException
					("Invalid number of responses: "+ numResponses);
		}
		this.ranking = ranking;
		this.numResponses = numResponses;
	}

	
	/**
	 * Updates the rank for this video item to include this additional ranking if the
	 * new rank data is valid
	 * 
	 * @param additionalRanking
	 *            - another rank to be included in this video item's rank, 0..10
	 */
	// TODO processAnotherRanking
	public void processAnotherRanking(int additionalRank ) {
		 if(!(additionalRank >= 0 && additionalRank <= MAX_RANKING)) {
			 throw new IllegalArgumentException
			 			("Invalid ranking: "+additionalRank);
		 }
		 
		 double newRank = (getRanking()*numResponses + additionalRank) /(numResponses + 1);
		 numResponses++;
		 this.ranking = newRank;
	}
	
	

	@Override
	public String toString() {
		String str = "\"" + title + "\" ranking " + getRanking();
		return str;
	}

}
