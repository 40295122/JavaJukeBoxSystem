package part03;

import part01.Tune;
import part01.Genre;
/**
 * Unit testing
 * @author Laura
 *
 */
public class TuneTester {

	public static void main(String[] args) {
		testCase1();
		System.out.println();
		testCase2();
		System.out.println();
		testCase3();
		System.out.println();
		testCase4();
		System.out.println();
		testCase5();
		System.out.println();
		testCase6();
	}

	public static void testCase1() {
		// test data
		String validTitle = "TitleTest";
		String validArtist = "ArtistTest";
		int validDuration = 200;
		Genre validGenre = Genre.DANCE;

		// Tune reference
		Tune myTune;
		
		System.out.println("========================================================================");
		System.out.println("Test Case 1 - Valid Tune Construction");
		System.out.println("========================================================================");
		try {
			myTune = new Tune(validTitle, validArtist, validDuration, validGenre);
			System.out.println("Construction Successful");
			System.out.println("--> Expected Title : " + validTitle);
			System.out.println("--> Actual Title : " + myTune.getTitle());
			System.out.println("--> Expected Artist : " + validArtist);
			System.out.println("--> Actual Artist : " + myTune.getArtist());
			System.out.println("--> Expected Duration : " + validDuration);
			System.out.println("--> Actual Duration : " + myTune.getDuration());
			System.out.println("--> Expected Genre : " + validGenre);
			System.out.println("--> Actual Genre : " + myTune.getGenre());
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 1.");

	}

	public static void testCase2() {

		// Tune reference
		Tune myTune;
		
		System.out.println("========================================================================");
		System.out.println("Test Case 2 - Invalid Tune Data");
		System.out.println("========================================================================");

		myTune = Utility.createTune(null, "ArtistName", 300, Genre.JAZZ);
		if (myTune != null) {
			System.out.println("Error, should not see this - title is null");
			Utility.displayTune(myTune);
		}

		myTune = Utility.createTune("", "ArtistName", 300, Genre.JAZZ);
		if (myTune != null) {
			System.out.println("Error, should not see this - title is null string");
			Utility.displayTune(myTune);
		}

		myTune = Utility.createTune(" ", "ArtistName", 300, Genre.JAZZ);
		if (myTune != null) {
			System.out.println("Error, should not see this - title is blank string");
			Utility.displayTune(myTune);
		}
		myTune = Utility.createTune("TitleName", null, 300, Genre.JAZZ);
		if (myTune != null) {
			System.out.println("Error, should not see this - artist is null");
			Utility.displayTune(myTune);
		}

		myTune = Utility.createTune("TitleName", "", 300, Genre.JAZZ);
		if (myTune != null) {
			System.out.println("Error, should not see this - artist is null string");
			Utility.displayTune(myTune);
		}

		myTune = Utility.createTune("TitleName", " ", 300, Genre.JAZZ);
		if (myTune != null) {
			System.out.println("Error, should not see this - artist is blank string");
			Utility.displayTune(myTune);
		}
		myTune = Utility.createTune("TitleName", "ArtistName", -1, Genre.JAZZ);
		if (myTune != null) {
			System.out.println("Error, should not see this - duration is negative");
			Utility.displayTune(myTune);
		}

		myTune = Utility.createTune("TitleName", "ArtistName", 0, Genre.JAZZ);
		if (myTune != null) {
			System.out.println("Error, should not see this - duration is 0");
			Utility.displayTune(myTune);
		}

		myTune = Utility.createTune("TitleName", "ArtistName", 200, null);
		if (myTune != null) {
			System.out.println("Error, should not see this - genre is null");
			Utility.displayTune(myTune);
		}

		System.out.println("End Test Case 2.");

	}
	public static void testCase3() {
		// test data
		String validTitle = "TitleTest";
		String validArtist = "ArtistTest";
		int validDuration = 200;
		Genre validGenre = Genre.DANCE;

		// Tune reference
		Tune myTune;

		System.out.println("========================================================================");
		System.out.println("Test Case 3 - Testing accessors return correct values");
		System.out.println("========================================================================");
		try {
			myTune = new Tune(validTitle, validArtist, validDuration, validGenre);
			
			System.out.println("--> Expected Title  : " + validTitle);
			System.out.println("--> Actual Title    : " + myTune.getTitle());
			System.out.println("--> Expected Artist : " + validArtist);
			System.out.println("--> Actual Artist   : " + myTune.getArtist());
			System.out.println("--> Expected Duration : " + validDuration);
			System.out.println("--> Actual Duration   : " + myTune.getDuration());
			System.out.println("--> Expected Genre : " + validGenre);
			System.out.println("--> Actual Genre   : " + myTune.getGenre());
			System.out.println("--> Expected ID : " + 11);
			System.out.println("--> Actual ID   : " + myTune.getTuneId());
			System.out.println("--> Expected Play Count : " + 0);
			System.out.println("--> Actual Play Count   : " + myTune.getPlayCount());
			System.out.println("--> Expected toString : " + validTitle + ", " + validArtist + ", " + validDuration + ", " + validGenre + ", " + 11 );
			System.out.println("--> Actual toString   : " + myTune);
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 3.");

	}
	
	public static void testCase4() {
		// test data
		String validTitle = "TitleTest";
		String validArtist = "ArtistTest";
		int validDuration = 200;
		Genre validGenre = Genre.DANCE;

		// Tune reference
		Tune myTune;

		System.out.println("========================================================================");
		System.out.println("Test Case 4 - Testing Play Method");
		System.out.println("========================================================================");
		try {
			myTune = new Tune(validTitle, validArtist, validDuration, validGenre);
			System.out.println("--> Expected Play Count : " + 0);
			System.out.println("--> Actual Play Count   : " + myTune.getPlayCount());
			
			System.out.println("--> Expected String  : " + "Now Playing: " + validTitle + " by " + validArtist);
			System.out.println("--> Actual String    : " + myTune.play());
			
			System.out.println("--> Expected Play Count : " + 1);
			System.out.println("--> Actual Play Count   : " + myTune.getPlayCount());
			
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 4.");

	}
	
	public static void testCase5() {
		// test data
		String validTitle = "TitleTest";
		String validArtist = "ArtistTest";
		int validDuration = 200;
		Genre validGenre = Genre.DANCE;
		
		String addTitle = "NewTuneTitle";
		String addArtist = "NewArtistTest";
		int addDuration = 300;
		Genre addGenre = Genre.OTHER;

		// Tune reference
		Tune testTune;
		Tune testTune2;
		Tune testTune3;

		System.out.println("========================================================================");
		System.out.println("Test Case 5 - Testing each tune has a unique ID that increments by 1");
		System.out.println("========================================================================");
		try {
			testTune = new Tune(validTitle, validArtist, validDuration, validGenre);
			testTune2 = new Tune(addTitle, addArtist, addDuration, addGenre);
			testTune3 = new Tune(addTitle, addArtist, addDuration, addGenre);
			
			System.out.println("--> Expected String  : " + "Tune Title: " + validTitle + ", Tune Artist: " + validArtist + ", Tune ID: 13");
			System.out.println("--> Actual String    : " + "Tune Title: " + testTune.getTitle()+ ", Tune Artist: " + testTune.getArtist() + ", Tune ID: " + testTune.getTuneId());
			
			System.out.println("--> Expected String  : " + "Tune Title: " + addTitle + ", Tune Artist: " + addArtist + ", Tune ID: 14");
			System.out.println("--> Actual String    : " + "Tune Title: " + testTune2.getTitle()+ ", Tune Artist: " + testTune2.getArtist() + ", Tune ID: " + testTune2.getTuneId());
			
			System.out.println("--> Expected String  : " + "Tune Title: " + addTitle + ", Tune Artist: " + addArtist + ", Tune ID: 15");
			System.out.println("--> Actual String    : " + "Tune Title: " + testTune3.getTitle()+ ", Tune Artist: " + testTune3.getArtist() + ", Tune ID: " + testTune3.getTuneId());
			
			
		} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 5.");

		
		
		
	}
	
	public static void testCase6() {
		// test data
		String validTitle = "TitleTest";
		String validArtist = "ArtistTest";
		int validDuration = 200;
		
		Genre validGenre = Genre.DANCE;
		Genre validGenre2 = Genre.CLASSICAL;
		Genre validGenre3 = Genre.JAZZ;
		Genre validGenre4 = Genre.OTHER;
		Genre validGenre5 = Genre.ROCK;
		Genre validGenre6 = Genre.POP;

		// Tune reference
		Tune newTune;
		Tune newTune2;
		Tune newTune3;
		Tune newTune4;
		Tune newTune5;
		Tune newTune6;

		System.out.println("========================================================================");
		System.out.println("Test Case 6 - Testing genre enumateration");
		System.out.println("========================================================================");
		try {
			newTune = new Tune(validTitle, validArtist, validDuration, validGenre);
			newTune2 = new Tune(validTitle, validArtist, validDuration, validGenre2);
			newTune3 = new Tune(validTitle, validArtist, validDuration, validGenre3);
			newTune4 = new Tune(validTitle, validArtist, validDuration, validGenre4);
			newTune5 = new Tune(validTitle, validArtist, validDuration, validGenre5);
			newTune6 = new Tune(validTitle, validArtist, validDuration, validGenre6);
			
			System.out.println("--> Expected String  : " + "Tune Title: " + validTitle + ", Tune Artist: " + validArtist + ", Tune Genre: " + validGenre);
			System.out.println("--> Actual String    : " + "Tune Title: " + newTune.getTitle()+ ", Tune Artist: " + newTune.getArtist() + ", Tune Genre: " + newTune.getGenre());
			
			System.out.println("--> Expected String  : " + "Tune Title: " + validTitle + ", Tune Artist: " + validArtist + ", Tune Genre: " + validGenre2);
			System.out.println("--> Actual String    : " + "Tune Title: " + newTune2.getTitle()+ ", Tune Artist: " + newTune2.getArtist() + ", Tune Genre: " + newTune2.getGenre());
			
			System.out.println("--> Expected String  : " + "Tune Title: " + validTitle + ", Tune Artist: " + validArtist + ", Tune Genre: " + validGenre3);
			System.out.println("--> Actual String    : " + "Tune Title: " + newTune3.getTitle()+ ", Tune Artist: " + newTune3.getArtist() + ", Tune Genre: " + newTune3.getGenre());
			
			System.out.println("--> Expected String  : " + "Tune Title: " + validTitle + ", Tune Artist: " + validArtist + ", Tune Genre: " + validGenre4);
			System.out.println("--> Actual String    : " + "Tune Title: " + newTune4.getTitle()+ ", Tune Artist: " + newTune4.getArtist() + ", Tune Genre: " + newTune4.getGenre());
			
			System.out.println("--> Expected String  : " + "Tune Title: " + validTitle + ", Tune Artist: " + validArtist + ", Tune Genre: " + validGenre5);
			System.out.println("--> Actual String    : " + "Tune Title: " + newTune5.getTitle()+ ", Tune Artist: " + newTune5.getArtist() + ", Tune Genre: " + newTune5.getGenre());
			
			System.out.println("--> Expected String  : " + "Tune Title: " + validTitle + ", Tune Artist: " + validArtist + ", Tune Genre: " + validGenre6);
			System.out.println("--> Actual String    : " + "Tune Title: " + newTune6.getTitle()+ ", Tune Artist: " + newTune6.getArtist() + ", Tune Genre: " + newTune6.getGenre());
			
			} catch (Exception ex) {
			System.out.println("Exception : " + ex);
			System.out.println("Error - this should not happen for valid data.");
		}
		System.out.println("End Test Case 6.");

		
		
		
	}

	
	
	

}