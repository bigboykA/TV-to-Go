# TV-to-Go
Java object oriented implementation of a personalized entertainment management system. 


Project2 is a Java application simulating the management of a person's list of available movies and TV shows from a service called "TV to Go". The project demonstrates object-oriented programming principles such as inheritance and composition through the creation and manipulation of various classes.

Features
Content Management:

Stores video items available for the user to watch.
Provides methods to search for video items by title, find the top-ranked video item, and find the video item with the most downloads.
VideoItem Class:

Represents an item available to the user.
Methods to manage video item ranking, including adding new rankings and computing average rankings.
TVSeries Class:

Represents a TV series with a title and the number of episodes in each season.
Methods to get series information and produce a string description of a TVSeries object.
Episode Class:

Subclass of VideoItem.
Represents a specific episode in a TV series.
Methods to manage episode-specific data and interactions with its parent TV series.
Movie Class:

Subclass of VideoItem.
Represents a movie with a specific release year.
Methods to manage movie-specific data such as rating and release year.
Getting Started
Prerequisites
Java Development Kit (JDK)
Eclipse IDE or any Java-supporting IDE
Installation

Methods and Classes:

Complete the Content and VideoItem classes as specified in the project requirements.
Implement the TV series, Episodes, and Movie classes.
Testing:

Use the provided client program TVtoGO.java to test the implementation.
Ensure that TVtoGO.java runs without syntax errors.
Classes and Methods
Content Class
findVideoItem(String title): Searches for a video item by title.
topRanked(): Returns the video item with the highest ranking.
mostDownloads(): Returns the video item with the most downloads.
VideoItem Class
getRankingString(): Returns a string representation of the ranking.
setRanking(double ranking, int responses): Sets the ranking with validation.
processAnotherRanking(int newRanking): Processes an additional ranking.
TVSeries Class
getTitle(): Returns the title of the series.
getNumSeasons(): Returns the number of seasons.
getNumEpisodesInSeason(int season): Returns the number of episodes in a specific season.
toString(): Returns a string description of the TV series.
Episode Class
getEpisodeNum(): Returns the episode number.
getSeries(): Returns the series to which the episode belongs.
getSeason(): Returns the season number.
getNumEpisodesLeftThisSeason(): Returns the number of episodes left in the season.
setRating(String rating): Sets the rating with validation.
getFullTitle(): Returns the full title of the episode.
getItemDetails(): Returns a string description of the episode.
download(): Increments the number of downloads and returns a status message.
toString(): Returns a string containing the episode’s series title, season number, and episode number.
Movie Class
setRating(String rating): Sets the rating with validation.
setReleaseYear(String year): Sets the release year with validation.
getItemDetails(): Returns a string description of the movie.
toString(): Returns a string containing the movie title.
Usage
Select Video Item: Choose a video item from the list to view its details.
Search: Enter a keyword to search for a video item by title.
Rank: Enter a rank between 0 and 10 to update the ranking of the selected video item.
Download: Download the selected video item and view the updated download status.
