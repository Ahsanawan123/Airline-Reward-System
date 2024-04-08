// Main class
/*
* Author: Ahsan Awan  Date: 3/29/2023  Project Title: Airline Reward System

* The rewards program works by calculating the number of miles you've flown
* within a year, which is then determined by the number of flights you've
* had to cancel. This includes all flights taken between January 1st and
* December 31st of that year. The rewards are then tiered based on the
*  number of miles earned and flights cancelled within that year.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/** @author Ahsan Awan
 * @version 0.01
 *
 * Main takes in the input file, creates an array list, allocates space and assigns the data, then displays the
 * information that the user desires to see
 */
public class Main {
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Passenger> passList = new ArrayList<Passenger>(); // Created an array list to store the respective passenger
        FileInputStream inputFile = new FileInputStream("flight-data.txt"); // Opens the flight data file
        Scanner inputFi = new Scanner(inputFile);

        // While scanner variable inputFi has a line stored
        while (inputFi.hasNextLine()) {
                String temp = inputFi.nextLine(); // Stores the line in a temp file
                String[] values = temp.split(" "); // Splits the line into a string array
                int id = Integer.parseInt(values[0]); // Assigns the ID
                char FlightCan = values[1].charAt(0); // Assigns if the flight got cancelled or not
                char PassComp  = 'N'; // Automatically assigns the customer to not complaining

                // If the flight was cancelled
                if (FlightCan == 'Y') {
                   PassComp = values[2].charAt(0); // There is three values in the line inputted, get the value in the
                                                   // the third space (second index in the string array)
                } // End of if

                boolean duplicate = false; // This variable is a flag to see if there is an existing ID
                int index = -1; // Represents what index the ID exists at; assigned -1 to represent that there's no
                                // such ID


                // Loops through the passList array to see if an ID exists or not
                for (int i = 0; i < passList.size(); i++) {
                    // If the value of ID is equal to the value in the array list
                    if (passList.get(i).getPassID() == id) {
                        duplicate = true; // Assign duplicate to true
                        index = i; // Records the index that matches
                        break; // Breaks from the for loop
                    } // End of if
                } // End of for

                // If duplicate == true
                if (duplicate) {
                    Passenger retrieveInfo = passList.get(index);  // Create a new passenger object and assign it the
                                                                   // information in the array list at the given index
                    retrieveInfo.addFlight(FlightCan == 'Y'); // If flightCan == 'Y', it will execute this
                                                                        // this statement which increments cancelled
                                                                        // flights and num of miles

                    // If the passenger complained
                    if (PassComp == 'Y') {
                        retrieveInfo.passComplained(); // Flags the passenger and makes them negligible for special
                                                       // sub tiers
                    } // end of if

                } // end if
                else {
                    Passenger currPass = new Passenger(id, FlightCan, PassComp); // Creates a new passenger object
                                                                                 // and assigns the respectable data
                    passList.add(currPass); // Adds the object to the array list
                } // end of else

        } // End of while loop
        inputFi.close(); // Closes the file

        // Loops through the array list
        for (int i = 0; i < passList.size(); i++) {
            passList.get(i).upgradePass(); // upgrades the users that need to be upgraded to special tiers
        } // End of for loop

        Scanner userInput = new Scanner(System.in);
        int userIdInput; // Stores the ID that the user is searching for

        // An infinite loop that will be broken by a sentinel value
        while (true) {
            System.out.print("Enter an existing passenger's ID (Enter -1 to quit): "); // Prompts user to enter the
                                                        // the desired ID or to quit the program (Sentinel value: 1)
            userIdInput = userInput.nextInt(); // Stores user input

            // If user inputs -1
            if (userIdInput == -1) {
                break; // Breaks from loop and terminates program
            } // end of if block

            int index = -1; // Stores the index that the search was found; -1 represents that the index wasn't found

            // Loops through the array list
            for (int i = 0; i < passList.size(); i++) {
                // If the ID matches an id in the array list
                if (passList.get(i).getPassID() == userIdInput) {
                    index = i; // Marks which index the ID existed at
                } // End of if
            } // End of for loop

            // If index wasn't found
            if (index == -1) {
                System.out.println("User not found, please try again."); // Prompts user to try again and then prompts
                // user to search for another ID or quit the program
            } // end of if
            else {
                Passenger passFound = passList.get(index); // Assigns a passenger object the list array object at the
                // index

                System.out.println("Tier: " + passFound.getTier()); // Outputs the Passenger's tier
                System.out.println("Total miles (in a year): " + passFound.getMiles() + " Mi"); // How many miles they
                                                                                                // accumulated
                System.out.println("Total cancellations (in a year): " + passFound.getCancelledFlights()); // How many
                                                                                        // cancellations in a year
                // If passenger has multiplier (they are in special sub tiers)
                if (passFound.hasMultiplier()) {
                    System.out.println("Passenger " + passFound.getPassID() + " has Multiplier? Yes");
                    System.out.println(); // Outputs Passenger ID followed by them having a multiplier followed by a
                                          // a newline
                } // End of if
                else {
                    System.out.println("Passenger " + passFound.getPassID() + " has Multiplier? No");
                    System.out.println(); // Outputs Passenger ID followed by them having a multiplier followed by a
                                          // newline
                } // End of else

            } // End of else
        } // End of while
    } // End of public static void main
} // End of public class main
