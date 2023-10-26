package part03;

import part01.Tune;
import part01.Genre;

public class Utility {

	public static Tune createTune(String title, String artist, int duration, Genre gen) {
		Tune result = null;
		try {
			result = new Tune(title, artist, duration, gen);
			System.out.println("--> Tune successfully created.");
		} catch (Exception ex) {
			System.out.println("--> Could not create Tune: " + ex);
		}
		return result;
	}

	public static void displayTune(Tune myTune) {
		if (myTune != null) {
			System.out.println("--> Title     :" + myTune.getTitle());
			System.out.println("--> Artist    :" + myTune.getArtist());
			System.out.println("--> Duration  :" + myTune.getDuration());
			System.out.println("--> Genre     :" + myTune.getGenre());

		}
	}


}
