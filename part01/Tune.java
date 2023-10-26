package part01;

/**
 * Tune object class with attributes and methods of tune
 * 
 * @author Laura
 *
 */
public class Tune implements iTune {
	private int id; // ID to uniquely identify tune
	private static int nextId = 1; // Next tune ID available
	private String title; // Tune title
	private String artist; // Tune artist
	private int duration; // Tune duration
	private int playCount; // Tunes play count
	private Genre style; // Tunes genre

	/**
	 * Constructor to create tune object
	 * 
	 * @param title
	 * @param artist
	 * @param duration
	 * @param style
	 * @throws Exception
	 */
	public Tune(String title, String artist, int duration, Genre style) throws Exception {
		this.id = useNextId();

		if (title.isBlank() == false && title.isEmpty() == false && title != null) {
			this.title = title;

		} else {

			throw new Exception("Error in title");
		}
		if (artist.isBlank() == false && artist.isEmpty() == false && artist != null) {
			this.artist = artist;
		} else {
			throw new Exception("Error in artist");
		}
		if (style != null) {
			this.style = style;
		} else {
			throw new Exception("Error in genre");
		}

		if (duration > 0) {
			this.duration = duration;
		} else {
			throw new Exception("Error in duration");
		}
		this.playCount = 0;

	}

	/**
	 * Increments tune ID
	 * 
	 * @return
	 */
	private int useNextId() {
		id = nextId;
		nextId = nextId + 1;

		return id;
	}

	/**
	 * Gets tune ID
	 * 
	 * @return id is returned as an int
	 */
	public int getTuneId() {
		return this.id;
	}

	/**
	 * Gets duration of tune
	 * 
	 * @return duration is returned as an int
	 */
	public int getDuration() {
		return this.duration;
	}

	/**
	 * Gets play count of tune
	 * 
	 * @return play count is returned as an int
	 */
	public int getPlayCount() {
		return this.playCount;
	}

	/**
	 * Gets the title of the tune
	 * 
	 * @return title is returned as a string
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Gets the artist of the tune
	 * 
	 * @return artist is returned as a string
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * Gets the genre of the tune
	 * 
	 * @return style is returned as a genre
	 */
	public Genre getGenre() {
		return this.style;
	}

	/**
	 * Play is used to increment play count and forms a string of the tune that's
	 * playing
	 */
	public String play() {
		this.playCount++;
		String play = "";
		play += "Now Playing: ";
		play += this.title + " by ";
		play += this.artist;

		return play;
	}

	/**
	 * to String is used to form tune details as a String
	 */
	public String toString() {
		String str = "";
		str += this.title + ", ";
		str += this.artist + ", ";
		str += this.duration + ", ";
		str += this.style + ", ";
		str += this.id;
		return str;

	}

}
