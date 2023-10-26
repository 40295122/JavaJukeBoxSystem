package part03;

import part01.Genre;
import part01.MP3Player;

/**
 * Integration testing
 * 
 * @author Laura
 *
 */
public class MP3PlayerTester {

	public static void main(String[] args) throws Exception {
		// test cases:
		testCase7();
		System.out.println();
		testCase8();
		System.out.println();
		testCase9();
		System.out.println();
		testCase10();
		System.out.println();
		testCase11();
		System.out.println();
		testCase12();
		System.out.println();
		testCase13();
		System.out.println();
		testCase14();
		System.out.println();
		testCase15();
		System.out.println();
		testCase16();
		System.out.println();
		testCase17();
		System.out.println();
		testCase18();
		System.out.println();
	}

	public static void testCase7() {
		// test data
		String validTitle = "TitleTest";
		String validArtist = "ArtistTest";
		int validDuration = 200;
		Genre validGenre = Genre.DANCE;

		String addTitle = "NewTuneTitle";
		String addArtist = "NewArtistTest";
		int addDuration = 300;
		Genre addGenre = Genre.OTHER;

		// MP3Player reference
		MP3Player myPlayer;

		System.out.println("=================================================================");
		System.out.println("Test Case 7 - Testing Get Tune Info");
		System.out.println("=================================================================");
		try {
			myPlayer = new MP3Player();
			myPlayer.addTune(validTitle, validArtist, validDuration, validGenre);
			myPlayer.addTune(addTitle, addArtist, addDuration, addGenre);

			System.out.println("--> Expected Result : " + addTitle + ", " + addArtist + ", " + addDuration + ", "
					+ addGenre + ", 2, 0. " + validTitle + ", " + validArtist + ", " + validDuration + ", " + validGenre
					+ ", 1, 0. ");
			System.out.print("--> Actual Result   : ");
			String info[] = myPlayer.getTuneInfo();
			for (String str : info) {
				System.out.print(str);
				System.out.print(". ");
			}
			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 7.");

	}

	public static void testCase8() {
		System.out.println("=================================================================");
		System.out.println("Test Case 8 - Testing Get Tune when there are no tune objects");
		System.out.println("=================================================================");
		// MP3Player reference
		MP3Player myPlayer;
		try {
			myPlayer = new MP3Player();
			System.out.println("--> Expected Result : null");
			System.out.print("--> Actual Result   : ");
			String info[] = myPlayer.getTuneInfo();
			for (String str : info) {
				System.out.print(str);
			}
			System.out.println();
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("This should happen whenever myPlayer is null.");
		}
		System.out.println("End Test Case 8.");

	}

	public static void testCase9() {
		// test data
		String validTitle = "TitleTest";
		String validArtist = "ArtistTest";
		int validDuration = 200;
		Genre validGenre = Genre.DANCE;

		String addTitle = "NewTuneTitle";
		String addArtist = "NewArtistTest";
		int addDuration = 300;
		Genre addGenre = Genre.OTHER;

		// MP3Player reference
		MP3Player testPlayer;

		System.out.println("=================================================================");
		System.out.println("Test Case 9 - Adding duplicate tunes to MP3Player");
		System.out.println("=================================================================");
		try {
			testPlayer = new MP3Player();

			testPlayer.addTune(validTitle, validArtist, validDuration, validGenre);
			testPlayer.addTune(addTitle, addArtist, addDuration, addGenre);
			testPlayer.addTune(validTitle, validArtist, validDuration, validGenre);
			System.out.println("--> Expected Result : " + addTitle + ", " + addArtist + ", " + addDuration + ", "
					+ addGenre + ", 4, 0. " + validTitle + ", " + validArtist + ", " + validDuration + ", " + validGenre
					+ ", 3, 0. ");
			System.out.print("--> Actual Result   : ");
			String info[] = testPlayer.getTuneInfo();
			for (String str : info) {

				System.out.print(str);
				System.out.print(". ");

			}
			System.out.println();
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 9.");

	}

	public static void testCase10() {
		// test data
		String validTitle = "TitleTest";
		String validArtist = "ArtistTest";
		int validDuration = 200;
		Genre validGenre = Genre.DANCE;

		// MP3Player reference
		MP3Player myPlayer;

		System.out.println("=================================================================");
		System.out.println("Test Case 10 - Test Valid data in getTuneInfo(String artist)  ");
		System.out.println("=================================================================");
		try {

			myPlayer = new MP3Player();

			myPlayer.addTune(validTitle, validArtist, validDuration, validGenre);
			System.out.println("--> Expected Result : " + validTitle + ", " + validArtist + ", " + validDuration + ", "
					+ validGenre + ", 5");
			System.out.print("--> Actual Result     : ");
			String info2[] = myPlayer.getTuneInfo(validArtist);
			for (String str : info2) {

				System.out.print(str);

			}
			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 10.");

	}

	public static void testCase11() {
		// test data

		String addTitle = "NewTuneTitle";
		String addArtist = "NewArtistTest";
		int addDuration = 300;
		Genre addGenre = Genre.OTHER;

		String artist = "Not an avaliable artist";

		// MP3Player reference
		MP3Player myPlayer;

		System.out.println("=================================================================");
		System.out.println("Test Case 11 - Test unavailable artist in getTuneInfo(String artist)  ");
		System.out.println("=================================================================");
		try {

			myPlayer = new MP3Player();

			myPlayer.addTune(addTitle, addArtist, addDuration, addGenre);
			System.out.println("--> Expected Result : (no info) ");
			System.out.print("--> Actual Result   : ");
			String info[] = myPlayer.getTuneInfo(artist);
			for (String str : info) {

				System.out.print(str);

			}
			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 11.");

	}

	public static void testCase12() {
		// test data

		String addTitle = "NewTuneTitle";
		String addArtist = "NewArtistTest";
		int addDuration = 300;
		Genre addGenre = Genre.OTHER;

		String artist = null;

		// MP3Player reference
		MP3Player myPlayer;
		
		System.out.println("=================================================================");
		System.out.println("Test Case 12 - Testing null artist in getTuneInfo(String artist)  ");
		System.out.println("=================================================================");
		try {

			myPlayer = new MP3Player();

			myPlayer.addTune(addTitle, addArtist, addDuration, addGenre);
			System.out.println("--> Expected Result : (no info) ");
			System.out.print("--> Actual Result   : ");
			String info[] = myPlayer.getTuneInfo(artist);
			for (String str : info) {

				System.out.print(str);

			}
			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 12.");

	}

	public static void testCase13() {
		// test data
		String validTitle = "TitleTest";
		String validArtist = "ArtistTest";
		int validDuration = 200;
		Genre validGenre = Genre.DANCE;

		// MP3Player reference
		MP3Player myPlayer;

		System.out.println("=================================================================");
		System.out.println("Test Case 13 - Test Valid data in getTuneInfo(Genre gen)  ");
		System.out.println("=================================================================");
		try {
			myPlayer = new MP3Player();

			myPlayer.addTune(validTitle, validArtist, validDuration, validGenre);
			System.out.println("--> Expected Result : " + validTitle + ", " + validArtist + ", " + validDuration + ", "
					+ validGenre + ", 8");
			System.out.print("--> Actual Result   : ");
			String info[] = myPlayer.getTuneInfo(validGenre);
			for (String str : info) {

				System.out.print(str);

			}
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("\nEnd Test Case 13.");

	}

	public static void testCase14() {
		// test data
		String validTitle = "TitleTest";
		String validArtist = "ArtistTest";
		int validDuration = 200;
		Genre validGenre = Genre.DANCE;

		Genre testGenre = null;

		// MP3Player reference
		MP3Player myPlayer;

		System.out.println("=================================================================");
		System.out.println("Test Case 14 - Test null genre in getTuneInfo(Genre gen)  ");
		System.out.println("=================================================================");
		try {
			myPlayer = new MP3Player();

			myPlayer.addTune(validTitle, validArtist, validDuration, validGenre);
			System.out.println("--> Expected Result : (no Info) ");
			System.out.println("--> Actual Result : ");
			String info2[] = myPlayer.getTuneInfo(testGenre);
			for (String str : info2) {

				System.out.print(str);

			}
			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 14.");

	}

	public static void testCase15() {
		// test data

		String addTitle = "NewTuneTitle";
		String addArtist = "NewArtistTest";
		int addDuration = 300;
		Genre addGenre = Genre.OTHER;

		// MP3Player reference
		MP3Player testPlayer;

		System.out.println("=================================================================");
		System.out.println("Test Case 15 - Test Valid in play(int tuneId)  ");
		System.out.println("=================================================================");
		try {
			testPlayer = new MP3Player();

			testPlayer.addTune(addTitle, addArtist, addDuration, addGenre);

			System.out.print("--> Tune Info   : ");
			String info[] = testPlayer.getTuneInfo();
			for (String str : info) {

				System.out.print(str);

			}
			System.out.println();

			System.out.println("--> Expected Valid Result : " + addTitle + " by " + addArtist + " is playing...");
			System.out.print("--> Actual Result         : ");
			System.out.println(testPlayer.play(10));

			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 15.");
	}

	public static void testCase16() throws Exception {
		// test data

		String addTitle = "NewTuneTitle";
		String addArtist = "NewArtistTest";
		int addDuration = 300;
		Genre addGenre = Genre.OTHER;

		// MP3Player reference
		MP3Player testPlayer;
		testPlayer = new MP3Player();

		testPlayer.addTune(addTitle, addArtist, addDuration, addGenre);

		System.out.println("=================================================================");
		System.out.println("Test Case 16 - Test invalid in play(int tuneId)  ");
		System.out.println("=================================================================");
		try {
			System.out.println("--> Expected Invalid Result : null");
			System.out.print("--> Actual Result           : ");
			System.out.println(testPlayer.play(0));

			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 16.");

	}
	
	public static void testCase17() throws Exception{
		// test data

		String addTitle = "NewTuneTitle";
		String addArtist = "NewArtistTest";
		int addDuration = 300;
		Genre addGenre = Genre.OTHER;

		// MP3Player reference
		MP3Player testPlayer;
		testPlayer = new MP3Player();

		testPlayer.addTune(addTitle, addArtist, addDuration, addGenre);

		System.out.println("=================================================================");
		System.out.println("Test Case 17 - Testing addTune with valid data  ");
		System.out.println("=================================================================");
		try {
			System.out.println("--> Expected Result : " + addTitle + ", " + addArtist + ", " + addDuration + ", "
					+ addGenre +  ", 12, 0. ");
			System.out.print("--> Actual Result   : ");
			String info[] = testPlayer.getTuneInfo();
			for (String str : info) {
				System.out.print(str);
				System.out.print(". ");
			}
			System.out.println("\nTune successfully added");

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 17.");

	}
	
	public static void testCase18() throws Exception{
		// test data
		int addDuration = 100;
		// MP3Player reference
		MP3Player testPlayer;
		testPlayer = new MP3Player();

		testPlayer.addTune(null, null, addDuration, null);

		System.out.println("=================================================================");
		System.out.println("Test Case 18 - Testing addTune with invalid data  ");
		System.out.println("=================================================================");
		try {
			System.out.println("--> Expected Result : (no info)");
			System.out.println("--> Actual Result   : ");
			String info[] = testPlayer.getTuneInfo();
			for (String str : info) {
				System.out.print(str);
				System.out.print(". ");
			}
			System.out.println();

		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("This should happen for null data.");
		}
		System.out.println("End Test Case 18.");

	}
	
}
