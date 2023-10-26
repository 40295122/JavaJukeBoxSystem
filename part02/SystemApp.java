package part02;

import java.util.Scanner;

import part01.Genre;

/**
 * Application class
 * 
 * @author Laura
 *
 */
public class SystemApp {

	static Jukebox myPlayer = new Jukebox();
	private static int controlSOn = 0; // variable is used to control the switch on method
	private static int controlSOff = 0; // variable is used to control the switch off method

	public static void main(String[] args) throws Exception {

		// Adds tunes to myPlayer
		addSomeTunes();

		// Menu Options:
		String[] consoleOptions = { "Select from Full List", "Select Tune by Artist", "Select Tune by Genre",
				"Add New Tune", "Display the Top 10", "Purchase Credits", "Switch Off", "Switch On", "Exit" };

		// Menu creation:
		Menu console = new Menu("MP3 Player", consoleOptions);

		int quitOption = consoleOptions.length;
		int choice;
		boolean finished = false;

		do {
			choice = console.getUserChoice();
			if (choice == quitOption) {

				System.out.println("Goodbye!");
				finished = true;
			} else {
				processOption(choice);

			}
		} while (!finished);
	}

	/**
	 * This method consists of a switch statement which will call a method that the
	 * user has selected
	 * 
	 * @param choice - this corresponds to the method the user wants to run
	 * @throws Exception
	 */
	private static void processOption(int choice) throws Exception {

		switch (choice) {
		case 1:
			selectFromFullList();
			System.out.println();
			break;
		case 2:
			selectTuneByArtist();
			System.out.println();
			break;
		case 3:
			selectTuneByGenre();
			System.out.println();
			break;
		case 4:

			// Gets user input for the tune title
			Scanner input1 = new Scanner(System.in);
			System.out.println("Please enter tune title:");
			String title = "";

			// Validation to check if title is not null
			if (title != null) {
				title = input1.nextLine();
			}

			// Gets user input for the tune artist
			Scanner input2 = new Scanner(System.in);
			System.out.println("Please enter tune artist:");
			String artist = "";

			// Validation to check if artist is not null
			if (artist != null) {
				artist = input2.nextLine();
			}

			// Gets user input for the tune duration
			Scanner input3 = new Scanner(System.in);
			System.out.println("Please enter tune duration:");
			int duration = 0;

			// Validation to check if duration is an integer variable
			try {
				duration = input3.nextInt();
			} catch (Exception ex) {
				System.out.println("Error input.");
				break;
			}

			// Gets user input for the tune genre
			Scanner input4 = new Scanner(System.in);
			System.out.println("Please enter tune genre:");
			String gen = "";

			// Validation to check if genre is not null
			if (gen != null) {
				gen = input4.nextLine();
			}

			addNewTune(title, artist, duration, gen);
			System.out.println();
			break;
		case 5:
			displayTopTen();
			System.out.println();
			break;
		case 6:
			Scanner inputA = new Scanner(System.in);
			System.out.println("Set Cost Per Credit in pence: ");
			int cost = 0;

			try {
				cost = inputA.nextInt();
			} catch (Exception ex) {
				System.out.println("Error input.");
				break;
			}

			Scanner inputB = new Scanner(System.in);
			System.out.println("Enter coins in pence: ");
			int coins = 0;

			try {
				coins = inputB.nextInt();
			} catch (Exception ex) {
				System.out.println("Error input.");
				break;
			}

			purchaseCredits(cost, coins);
			System.out.println();
			break;
		case 7:
			if (controlSOff == 0) {
				switchOff();
				controlSOff = 1;
				controlSOn = 0;
			} else {
				System.out.println("System is already off");
			}
			System.out.println();
			break;
		case 8:
			if (controlSOn == 0) {
				switchOn();
				controlSOn = 1;
				controlSOff = 0;
			} else {
				System.out.println("System is already on");
			}
			System.out.println();
			break;
		case 9:
			exit();
			System.out.println();
			break;
		}
	}

	/**
	 * This method allows the user to select a tune from a list and play it
	 * 
	 * @throws Exception
	 */
	private static void selectFromFullList() throws Exception {
		try {
			// Validation to make sure the tune details are not null
			if (myPlayer.getTuneInfo() != null) {
				String tuneDetails[] = myPlayer.getTuneInfo();
				String tuneList[] = new String[tuneDetails.length];

				for (int index = 0; index < tuneDetails.length; index++) {

					// Splits the title from string of tune information
					String str = tuneDetails[index];
					String splitTitle[] = str.split(", ");
					String title = splitTitle[0];

					// Splits the artist from string of tune information
					String str2 = tuneDetails[index];
					String splitArtist[] = str2.split(", ");
					String artist = splitArtist[1];

					// This string array is formatted for the tune menu
					tuneList[index] = title + ", by " + artist;

				}

				// New menu to contain tunes
				Menu tuneMenu = new Menu("\nSelect a tune to play:", tuneList);

				// Gets the users tune choice
				int userChoice = tuneMenu.getUserChoice();
				// Initiates the corresponding tune id
				int thisId = 0;

				int count = tuneDetails.length;
				// Searches for the corresponding tune id to match the users choice
				for (int index = 0; index < count; index++) {
					if (index == (userChoice - 1)) {

						// Splits tune ID from string of tune info
						String gettingID = tuneDetails[index];
						String[] idArray = gettingID.split(", ");
						String id = idArray[4];
						// Converts the id from String to Integer
						thisId = Integer.parseInt(id);

					}
				}
				// Validation to check if tune exists
				if (thisId == 0) {
					System.out.println("Tune not available.");
				} else {
					System.out.println("\n" + myPlayer.play(thisId));
					System.out.println("\nYour credits: " + myPlayer.getCredits());
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

	/**
	 * This method allows the user to select an artist from a list then select a
	 * tune by that artist to play
	 */
	private static void selectTuneByArtist() {
		try {

			String artistOptions[] = myPlayer.getTuneInfo();
			String options[] = new String[artistOptions.length];
			for (int index = 0; index < artistOptions.length; index++) {
				// Splits the artist from string of tune information
				String str = artistOptions[index];
				String splitArtist[] = str.split(", ");
				String artist = splitArtist[1];

				// array of artists for menu
				options[index] = artist;

			}

			// New menu to contain artists
			Menu artistMenu = new Menu("\nArtists", options);
			// Gets the users artist choice
			int choice2 = artistMenu.getUserChoice();
			String artist = options[choice2 - 1];
			String data[] = myPlayer.getTuneInfo(artist);

			// Validation to make sure there are tunes for the artist
			if (data.length != 0) {

				String format[] = new String[data.length];

				for (int index = 0; index < data.length; index++) {

					// Splits the title from string of tune information
					String thisTitle = data[index];
					String titleArray[] = thisTitle.split(", ");
					String titleInfo = titleArray[0];

					// Splits the artist from string of tune information
					String thisArtist = data[index];
					String artistArray[] = thisArtist.split(", ");
					String artistInfo = artistArray[1];

					// This string array is formatted for the artist's tunes menu
					format[index] = titleInfo + " by, " + artistInfo;
				}
				// New menu to contain artist's tunes
				Menu myArtistMenu = new Menu("\nSelect a Tune - Artist: " + artist, format);

				// Gets the users tune choice
				int userChoice = myArtistMenu.getUserChoice();
				// Initiates the corresponding tune id
				int thisId = 0;
				int count = data.length;
				// Searches for the corresponding tune id to match the users choice
				for (int index = 0; index < count; index++) {
					if (index == (userChoice - 1)) {

						// Splits tune ID from string of tune info
						String gettingID = data[index];
						String[] idArray = gettingID.split(", ");
						String id = idArray[4];

						// Converts the id from String to Integer
						thisId = Integer.parseInt(id);

					}
				}
				// Validation to check if tune exists
				if (thisId == 0) {
					System.out.println("Tune not available.");
				} else {
					System.out.println("\n" + myPlayer.play(thisId));
					System.out.println("\nYour credits: " + myPlayer.getCredits());
				}
			}

		} catch (

		Exception ex) {
			System.out.println(ex.toString());
		}
	}

	/**
	 * This method allows the user to select a genre from a list then select a tune
	 * by that genre to play
	 */
	private static void selectTuneByGenre() {
		try {
			// New menu to contain genres
			String genreOptions[] = { "Rock and Roll", "Easy Listening Pop", "Techno Dance", "Smooth Jazz", "Classical",
					"Unknown Genre" };
			Menu genreMenu = new Menu("\nSelect a Genre", genreOptions);
			// Gets the users genre choice
			int choice = genreMenu.getUserChoice();

			// Switch to convert the users choice to the corresponding genre
			Genre gen = null;
			switch (choice) {
			case 1:
				gen = Genre.ROCK;
				break;
			case 2:
				gen = Genre.POP;
				break;
			case 3:
				gen = Genre.DANCE;
				break;
			case 4:
				gen = Genre.JAZZ;
				break;
			case 5:
				gen = Genre.CLASSICAL;
				break;
			case 6:
				gen = Genre.OTHER;
				break;
			default:
				System.out.print("Error genre not available\n");
			}

			String data[] = myPlayer.getTuneInfo(gen);

			// Validation to make sure there are tunes for the genre
			if (data.length != 0) {

				String format[] = new String[data.length];

				for (int index = 0; index < data.length; index++) {
					// Splits the title from string of tune information
					String thisTitle = data[index];
					String titleArray[] = thisTitle.split(", ");
					String titleInfo = titleArray[0];

					// Splits the artist from string of tune information
					String thisArtist = data[index];
					String artistArray[] = thisArtist.split(", ");
					String artistInfo = artistArray[1];

					// This string array is formatted for the genre's tunes menu
					format[index] = titleInfo + " by, " + artistInfo;
				}
				// New menu to contain genres tunes
				Menu genMenu = new Menu("\nSelect a Tune - Genre: " + gen, format);

				// Gets the users tune choice
				int userChoice = genMenu.getUserChoice();
				// Initiates the corresponding tune id
				int thisId = 0;
				int count = data.length;
				// Searches for the corresponding tune id to match the users choice
				for (int index = 0; index < count; index++) {
					if (index == (userChoice - 1)) {

						// Splits tune ID from string of tune info
						String gettingID = data[index];
						String[] idArray = gettingID.split(", ");
						String id = idArray[4];

						// Converts the id from String to Integer
						thisId = Integer.parseInt(id);

					}
				}
				// Validation to check if tune exists
				if (thisId == 0) {
					System.out.println("Tune not available.");
				} else {
					System.out.println("\n" + myPlayer.play(thisId));
					System.out.println("\nYour credits: " + myPlayer.getCredits());
				}

			} else {
				System.out.println("There are no tunes available for this genre.");
			}

		} catch (

		Exception ex) {
			System.out.println(ex.toString());
		}
	}

	/**
	 * This method allows the user to add a new tune to the system
	 * 
	 * @param title
	 * @param artist
	 * @param duration
	 * @param gen
	 * @throws Exception
	 */
	private static void addNewTune(String title, String artist, int duration, String gen) throws Exception {
		try {
			// Some Validation:
			if (title == null) {
				System.out.println("Error in title input");
			}
			if (artist == null) {
				System.out.println("Error in artist input");
			}
			if (duration < 0) {
				System.out.println("Error in duration input");
			}
			if (gen == null) {
				System.out.println("Error in genre input");
			}

			// Converts the String gen to Genre
			Genre style = null;
			if (gen.equalsIgnoreCase("Rock")) {
				style = Genre.ROCK;
			} else if (gen.equalsIgnoreCase("Pop")) {
				style = Genre.POP;
			} else if (gen.equalsIgnoreCase("Dance")) {
				style = Genre.DANCE;
			} else if (gen.equalsIgnoreCase("Jazz")) {
				style = Genre.JAZZ;
			} else if (gen.equalsIgnoreCase("Classical")) {
				style = Genre.CLASSICAL;
			} else if (gen.equalsIgnoreCase("Other")) {
				style = Genre.OTHER;
			} else {
				System.out.println("Unavailable Genre");
			}

			// Adds tune
			myPlayer.addTune(title, artist, duration, style);
			System.out.println("Done");

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	/**
	 * This method is used to sort the display top ten tunes by play count
	 * 
	 * @param data
	 * @return
	 */
	private static String[] bubbleSort(String data[]) {
		int swaps;
		do {
			swaps = 0;
			for (int i = 0; i < data.length - 1; i++) {
				// char test and test 2 retrieves the first character of the tune info string
				// which I set to the playcount
				char test = data[i].charAt(0);
				char test2 = data[i + 1].charAt(0);
				// The chars are converted to integers:
				int x = (int) (test);
				int y = (int) (test2);
				// Swaps the string array until the tunes are sorted from most to least played
				if (x < y) {
					String temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					swaps++;
				}
			}

		} while (swaps > 0);
		// returns the sorted string array
		return data;
	}

	private static void displayTopTen() throws Exception {
		try {

			String info[] = myPlayer.getTuneInfo();
			int size = info.length;
			String[] sort = new String[size];
			String playCounts[] = new String[size];

			// Adds play count to the beginning of each string in the string array
			for (int index = 0; index < size; index++) {
				String details = info[index];
				playCounts = info;
				int num = playCounts[index].length();
				String test = "";
				test = test + playCounts[index].charAt(num - 1);
				playCounts[index] = test + "~ " + details;
			}

			sort = bubbleSort(playCounts);
			System.out.println("\nTop 10 Tunes:\n");
			for (int index = 0; index < 10; index++) {

				// Splits the play count from the rest of the tune info string
				String thisSort = sort[index];
				String data1[] = thisSort.split("~ ");
				String tuneInfo = data1[1];

				// Splits the title
				String titleArray[] = tuneInfo.split(",");
				String titleInfo = titleArray[0];

				// Splits the Artist
				String thisArtist = sort[index];
				String artistArray[] = thisArtist.split(",");
				String artistInfo = artistArray[1];

				// Splits the Duration
				String thisDuration = sort[index];
				String dataArray[] = thisDuration.split(",");
				String durationInfo = dataArray[2];

				// Splits the Genre
				String thisGenre = sort[index];
				String genreArray[] = thisGenre.split(",");
				String genreInfo = genreArray[3];

				// Splits the ID
				String thisID = sort[index];
				String idArray[] = thisID.split(",");
				String idInfo = idArray[4];

				// Splits the Play count:
				String thisPlayC[] = thisSort.split(",");
				String pCInfo = thisPlayC[5];


				System.out.println(index + 1 + ": " + titleInfo + " by, " + artistInfo + ", Duration: " + durationInfo
						+ ", Genre: " + genreInfo + ", ID: " + idInfo + ", Playcount: " + pCInfo);

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	/**
	 * This method allows the user to purchase credits to play tunes
	 * 
	 * @param cost  - user sets the cost per credit
	 * @param coins - user inputs coins they want to insert into jukebox
	 */
	private static void purchaseCredits(int cost, int coins) {
		try {
			System.out.println("\nPurchase Credits: ");
			System.out.println("++++++++++++++++");
			System.out.println();

			myPlayer.setCostPerCredit(cost);

			myPlayer.insertCoin(coins);

			System.out.println("Your credits: " + myPlayer.getCredits());

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	/**
	 * This method stores the state of a Jukebox to a CSV file
	 */
	private static void switchOff() {

		try {

			System.out.println("Switching off...");
			myPlayer.switchOff();

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	/**
	 * This method restores the state of a Jukebox from a CSV file
	 */
	private static void switchOn() {
		try {

			System.out.println("Switching on...");
			myPlayer.switchOn();

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	/**
	 * Used to exit the system
	 */
	private static void exit() {

	}

	/**
	 * A 'freebie' - just to get you started
	 * 
	 * @throws Exception
	 */
	private static void addSomeTunes() throws Exception {
		myPlayer.addTune("One", "U2", 380, Genre.ROCK);
		myPlayer.addTune("Four Seasons - Winter", "Vivaldi", 5500, Genre.CLASSICAL);
		myPlayer.addTune("The Chain", "Fleetwood Mac", 750, Genre.ROCK);
		myPlayer.addTune("Graceland", "Paul Simon", 350, Genre.POP);
		myPlayer.addTune("Help", "The Beatles", 300, Genre.POP);

	}

}
