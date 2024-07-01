
/**
 * Name:Kofi Amo - Antwi
 * CSC 202--Project 2
 * Content.java
 * Date: 13 october 2023
 * 
 * Content.java implements a collection of VideoItems for on-line posting.
 * It provides methods to search for a video item given a phrase in its title and to
 * find the top-ranked item.
 * 
 * Document Assistance(who and describe; if no assistance, declare that fact):
 */

import java.util.ArrayList;

public class Content {

	private String name; // the name of the content
	private ArrayList<VideoItem> items; // the items

	/**
	 * Creates a content object with the given name and list of items
	 * 
	 * @param name-the  name of this content collection
	 * @param items-the list of video items in this content collection
	 */
	public Content(String name, ArrayList<VideoItem> items) {
		this.name = name;
		this.items = items;
	}

	/**
	 * Returns a short description of all video items in this content object
	 * 
	 * @return a short description of all video items in the Content object
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < items.size(); i++) {
			result += items.get(i).toString() + "\n";
		}
		return result;
	}

	/**
	 * Returns a list of all of the video items
	 * 
	 * @return an list of all of the video items
	 */
	public ArrayList<VideoItem> getItems() {
		return items;
	}

	/**
	 * Returns the name of the collection of video items
	 * 
	 * @return the name of the collection of video items
	 */
	public String getName() {
		return name;
	}

	/**
	 * searches for a video item with a title that contains the identified search
	 * phrase regardless of case
	 * 
	 * @param searchPhrase - the phrase which is being searched for
	 * @return the first video item with the searchPhrase in its title
	 */
	// TODO findVideoItem
	public VideoItem findVideoItem(String searchPhrase) {
		for(int i = 0; i < items.size();i++) {
		VideoItem theItem = items.get(i);
		String itemToString = theItem.getTitle();
		if(itemToString.toLowerCase().contains(searchPhrase.toLowerCase())) {
			return theItem;
		}
		}
		return null;
	}

	/**
	 * finds the video item with the highest rank in the collection
	 * 
	 * @return the VideoItem with the highest rank or the first encountered if more
	 *         than one item has the same highest rank
	 */
	// TODO topRanked
	public VideoItem topRanked() {
		VideoItem highestRankItem = items.get(0); // initialize the highest ranking to the  first index
		double highestRankToDouble = highestRankItem.getRanking();
		
		for(int i = 1; i< items.size();i++) {
			VideoItem compareItem = items.get(i);
			double compareItemToDouble = compareItem.getRanking();
			if(compareItemToDouble > highestRankToDouble) {
				highestRankToDouble = compareItemToDouble;
				highestRankItem = compareItem;
			}
		}
		return highestRankItem;
	}
	/**
	 * finds the video item with the most downloads
	 * 
	 * @return the VideoItem with the most downloads or the first encountered if more
	 *         than one item has the same greatest downloads
	 */
	// TODO mostDownloads
	public VideoItem mostDownloads() {
		VideoItem mostDownload = items.get(0); // initialize index 1 as element with most downloads
		int mostDownloadToInt = mostDownload.getNumDownloads();
		
		for(int i = 1;i<items.size();i++) {
			VideoItem compareItem = items.get(i);
			int compareItemToString = compareItem.getNumDownloads();
			if(compareItemToString > mostDownloadToInt) {
				mostDownloadToInt = compareItemToString;
				mostDownload = compareItem;
			}
		}
		return mostDownload;
	}
	
	
	

}
