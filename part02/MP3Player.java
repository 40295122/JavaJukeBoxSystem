package part02;

import java.util.ArrayList;

import part01.Genre;
import part01.Tune;
import part01.iPlayer;

/**
 * MP3 Player class
 * 
 * @author Laura
 *
 */
public class MP3Player implements iPlayer {

	protected ArrayList<Tune> soundData;

	/**
	 * MP3 Player Constructor
	 */
	public MP3Player() {
		soundData = new ArrayList<Tune>();
	}

	/**
	 * This is a method that adds a new tune
	 * 
	 * @param title    - this will be the new tunes title
	 * @param artist   - this will be the new tunes artist
	 * @param duration - this will be the new tunes duration
	 * @param gen      - this will be the new tunes genre
	 * @return - returns true if data passes validation, if not it returns false
	 * @throws Exception
	 */
	public boolean addTune(String title, String artist, int duration, Genre gen) throws Exception {

		int size = soundData.size();

		// validation for null data:
		if (title == null || artist == null || duration < 0 || gen == null) {
			return false;
		}

		// validation checking for duplicate tunes
		for (int index = 0; index < size; index++) {
			Tune currentTune = soundData.get(index);
			if (title.equals(currentTune.getTitle()) && artist.equals(currentTune.getArtist())
					&& duration == currentTune.getDuration() && gen == currentTune.getGenre()) {
				return false;
			}

		}
		Tune newTune = new Tune(title, artist, duration, gen);
		soundData.add(newTune);

		return true;
	}

	/**
	 * The getTuneInfo method returns an string array containing all of the tunes
	 * data
	 */
	public String[] getTuneInfo() {

		int size = soundData.size();

		String[] info = new String[size];
		String[] sort = new String[size];

		// validation to check if there are any tunes in the soundData array list
		if (size == 0) {
			return null;

		} else {

			for (int index = 0; index < size; index++) {
				Tune currentTune = soundData.get(index);
				info[index] = currentTune.toString() + ", " + currentTune.getPlayCount();

			}

			sort = info;

			// The for loops sort the tunes into alphabetical order by their titles
			for (int i = 0; i < sort.length - 1; i++) {

				for (int j = i + 1; j < sort.length; j++) {

					if (sort[i].compareTo(sort[j]) > 0) {
						String temp = sort[i];
						sort[i] = sort[j];
						sort[j] = temp;
					}
				}
			}

		}

		return sort;

	}

	/**
	 * The getTuneInfo(String artist) method returns an string array containing all
	 * of the tune data of a specified artist Parameter String artist specifies the
	 * artist
	 */
	public String[] getTuneInfo(String artist) {

		// Array list of tune data related to the artist
		ArrayList<String> artistArray = new ArrayList<String>();
		for (int index = 0; index < soundData.size(); index++) {
			if (soundData.get(index).getArtist().equals(artist)) {
				artistArray.add(soundData.get(index).toString());

			}
		}
		int size = artistArray.size();
		String info[] = new String[size];

		// for loop to convert the artist array list into a string array
		for (int index = 0; index < size; index++) {
			info[index] = artistArray.get(index);
		}

		String sort[] = new String[size];
		sort = info;

		// The for loops sort the tunes into alphabetical order by their titles
		for (int i = 0; i < sort.length - 1; i++) {

			for (int j = i + 1; j < sort.length; j++) {

				if (sort[i].compareTo(sort[j]) > 0) {
					String temp = sort[i];
					sort[i] = sort[j];
					sort[j] = temp;
				}

			}
		}
		return sort;
	}

	/**
	 * The getTuneInfo(Genre gen) method returns an string array containing all of
	 * the tune data of a specified genre Parameter Genre gen specifies the genre
	 */
	public String[] getTuneInfo(Genre gen) {

		// Array list of tune data related to the genre
		ArrayList<String> genreArray = new ArrayList<String>();
		for (int counter = 0; counter < soundData.size(); counter++) {
			if (soundData.get(counter).getGenre().equals(gen)) {
				genreArray.add(soundData.get(counter).toString());

			}
		}
		int size = genreArray.size();
		String info[] = new String[size];

		// for loop to convert the genre array list into a string array
		for (int index = 0; index < size; index++) {
			info[index] = genreArray.get(index);
		}
		String sort[] = new String[size];
		sort = info;

		// The for loops sort the tunes into alphabetical order by their titles
		for (int i = 0; i < sort.length - 1; i++) {

			for (int j = i + 1; j < sort.length; j++) {

				if (sort[i].compareTo(sort[j]) > 0) {
					String temp = sort[i];
					sort[i] = sort[j];
					sort[j] = temp;
				}

			}
		}
		return sort;

	}

	/**
	 * The play(int tuneId) method is used to play a tune by id specified
	 * 
	 * @param tuneId - specifies the id to play
	 * @return - returns string play if validation is passed, if not it returns null
	 */
	public String play(int tuneId) {
		String play = "";
		for (int index = 0; index < soundData.size(); index++) {
			// Validation to check if the specified id is available
			if (soundData.get(index).getTuneId() == tuneId) {
				soundData.get(index).play();
				play = soundData.get(index).getTitle() + " by " + soundData.get(index).getArtist() + " is playing...";
				return play;
			}

		}
		return null;

	}

	public boolean switchOff() {

		return false;

	}

	public boolean switchOn() {

		return true;
	}

}
