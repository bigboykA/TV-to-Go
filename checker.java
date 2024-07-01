
public class checker {

	public static void main(String[] args) {
		int[] episodes = {6,9,9,9,12,9,9,10,10};
		TVSeries series3 = new TVSeries("Call the Midwife", episodes);
		System.out.println(series3);
		System.out.println("\nThe title is " + series3.getTitle());
		System.out.println("The number of seasons is " + series3.getNumSeasons());
		try{
		    System.out.println(series3.getNumEpisodesInSeason(10));
		    System.out.println("This should not be printing");
		} catch(IllegalArgumentException error){
		    System.out.println(error);
		}
		System.out.println(series3.getNumEpisodesInSeason(1));
		System.out.println(series3.getNumEpisodesInSeason(5));
		System.out.println(series3.getNumEpisodesInSeason(9));

	}

}
