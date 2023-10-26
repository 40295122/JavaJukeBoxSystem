package part02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import part01.Genre;
import part01.Tune;

import java.io.PrintWriter;

/**
 * Jukebox class
 * 
 * @author Laura
 *
 */
public class Jukebox extends MP3Player {

	private int credits; // Jukebox credits variable
	private int costPerCredit; // Jukebox cost per credit variable

	//file path:
	File f = new File("tunes.csv");
	String csv = f.getAbsolutePath();

	/**
	 * Jukebox Constructor
	 */
	public Jukebox() {
		this.credits = 0;
		this.costPerCredit = 0;
	}

	/**
	 * This method allows the user to insert coins into the system
	 * 
	 * @param coin - coin is input as a parameter
	 */
	public void insertCoin(int coin) {
		int totalCoins = 0;

		// Validation to check if the input coin is acceptable
		if (coin == 10) {
			totalCoins += coin;
		} else if (coin == 20) {
			totalCoins += coin;
		} else if (coin == 50) {
			totalCoins += coin;
		} else if (coin == 100) {
			totalCoins += coin;
		} else if (coin == 200) {
			totalCoins += coin;
		} else {
			System.out.println("Error, can't accept this coin");
		}

		if (costPerCredit == 0) {

		} else if (costPerCredit > 0) {
			if (totalCoins >= costPerCredit) {
				credits++;
				totalCoins = totalCoins - costPerCredit;
			}

		}

	}

	/**
	 * Sets the cost per credit
	 * 
	 * @param cost - cost per credit
	 */
	public void setCostPerCredit(int cost) {
		this.costPerCredit = cost;
	}

	/**
	 * Gets the users purchased credits
	 * 
	 * @return - returns the credits that the user has
	 */
	public int getCredits() {
		return this.credits;
	}

	/**
	 * This play method overrides the play method in the MP3Player class
	 */
	@Override
	public String play(int tuneId) {
		if (costPerCredit == 0) {

			String play = "";
			for (int index = 0; index < soundData.size(); index++) {
				if (soundData.get(index).getTuneId() == tuneId) {
					soundData.get(index).play();
					play = soundData.get(index).getTitle() + " by " + soundData.get(index).getArtist()
							+ " is playing...";
					return play;
				}

			}

		} else if (credits > 0) {
			credits--;
			String play = "";
			for (int index = 0; index < soundData.size(); index++) {
				if (soundData.get(index).getTuneId() == tuneId) {
					soundData.get(index).play();
					play = soundData.get(index).getTitle() + " by " + soundData.get(index).getArtist()
							+ " is playing...";
					return play;
				}

			}
		} else {
			System.out.println("Error, not enough credits");
		}
		return null;

	}

	/**
	 * switchOff overrides the switchOff method in the MP3Player class This method
	 * will store the tune information to a csv at its current state
	 */
	@Override
	public boolean switchOff() {

		try {
			PrintWriter myPw = new PrintWriter(csv);

			for (Tune eachTune : soundData) {
				myPw.print(eachTune.getTitle() + ", ");
				myPw.print(eachTune.getArtist() + ", ");
				myPw.print(eachTune.getDuration() + ", ");
				myPw.print(eachTune.getGenre() + ", ");
				myPw.print(eachTune.getPlayCount() + ", ");
				myPw.println();

			}
			System.out.println("Tune Data Output Complete.");
			myPw.close();

			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * switchOn overrides the switchOff method in the MP3Player class This method
	 * will restore the tune information from a csv
	 * 
	 * @throws Exception
	 */
	@Override
	public boolean switchOn() {

		boolean hasHeader = true;

		try {
			File myFile = new File(csv);
			Scanner mySc = new Scanner(myFile);
			if (hasHeader) {
				mySc.nextLine();
			}
			while (mySc.hasNextLine()) {
				String record = mySc.nextLine();
				String[] parts = record.split(",");

				String title = parts[0].trim();
				String artist = parts[1].trim();
				int duration = Integer.parseInt(parts[2].trim());
				String genre = parts[3].trim();

				Genre style = null;
				if (genre.equalsIgnoreCase("Rock and Roll")) {
					style = Genre.ROCK;
				} else if (genre.equalsIgnoreCase("Easy Listening Pop")) {
					style = Genre.POP;
				} else if (genre.equalsIgnoreCase("Techno Dance")) {
					style = Genre.DANCE;
				} else if (genre.equalsIgnoreCase("Smooth Jazz")) {
					style = Genre.JAZZ;
				} else if (genre.equalsIgnoreCase("Classical")) {
					style = Genre.CLASSICAL;
				} else if (genre.equalsIgnoreCase("Unknown Genre")) {
					style = Genre.OTHER;
				}

				try {

					addTune(title, artist, duration, style);
				} catch (Exception ex) {

				}

			}

			mySc.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();

			return false;
		}
	}

}
