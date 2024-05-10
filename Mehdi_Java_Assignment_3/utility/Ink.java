package utility;

import objects.Shelter;
import objects.User;
import objects.Pet;
import java.util.ArrayList;
import java.util.Scanner;

public class Ink {
    private Scanner input = new Scanner(System.in);
    private int choice;

    // Color codes for different parts of the text
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    public void printWelcome() {
        // do nothing yet...
    }

    public void printGoodday() {
        System.out.println(ANSI_YELLOW + "Have a great day pet lover" + ANSI_RESET);
    }

    public int validateMainMenu() {
        boolean valid = false;

        while (!valid) {
            System.out.println(ANSI_CYAN + "##### MAIN MENU #####" + ANSI_RESET);
            System.out.println("(1) View Pets\n(2) Shelter Details\n(3) Book Appointment\n(4) Exit");
            try {
                choice = input.nextInt();
                if (choice >= 1 && choice <= 4) { // Corrected the upper limit of the range
                    valid = true;
                } else {
                    System.out.println("Please enter a number between 1 and 4");
                }
            } catch (Exception e) {
                System.out.println("That's not a number!");
            } finally {
                input.nextLine(); // Wait for any input before going back
            }
        }
        return choice;
    }

    public void printPetDetails(Pet pet) {
        System.out.printf("Name: %s\n", pet.getName());
        System.out.printf("Age: %d\n", pet.getAge());
        System.out.printf("Breed: %s\n", pet.getBreed());
        System.out.printf(ANSI_CYAN + "Color: %s\n" + ANSI_RESET, pet.getColor());
        System.out.printf("Owner: %s\n", pet.getOwner());
        System.out.printf(ANSI_GREEN + "Is Adopted: %b\n" + ANSI_RESET, pet.getIsAdopted());
        System.out.println("Adopt this pet? Y/N");
    }

    public void printAvailablePets(ArrayList<Pet> pets) {
        for (int i = 0; i < pets.size(); i++) {
            if (!pets.get(i).getIsAdopted()) {
                System.out.printf("(%d) Name: %s Type: %s Age: %d\n", i + 1,
                        pets.get(i).getName(), pets.get(i).getType(), pets.get(i).getAge());
            }
        }
        System.out.println("Enter 0 to go back");
    }

    public void printShelterDetails(Shelter shelter) {
        System.out.printf("Shelter Address: %s\n", shelter.getAddress());
        String[] hours = shelter.getHours();
        for (int i = 0; i < hours.length; i++) {
            System.out.println(hours[i]);
        }
        System.out.println("Hit any key to go back");
        input.next(); // Wait for any input before going back
        printAppointmentMenu(); // Added line to print appointment menu
        input.next(); // Wait for any input before showing main menu
        validateMainMenu(); // Show main menu again
    }

    public void printAppointmentMenu() {
        System.out.println("Please select a day for appointment:");
        System.out.println("1. Monday\n2. Tuesday\n3. Wednesday\n4. Thursday\n5. Friday\n6. Saturday\n7. Sunday");
    }

    public void bookAppointment(User user) {
        printAppointmentMenu();
        int appointmentChoice = input.nextInt();
        input.nextLine(); // Consume the newline character
    
        String appointmentDay = "";
    
        // Validate the appointment day choice
        if (appointmentChoice >= 1 && appointmentChoice <= 7) {
            switch (appointmentChoice) {
                case 1:
                    appointmentDay = "Monday";
                    break;
                case 2:
                    appointmentDay = "Tuesday";
                    break;
                case 3:
                    appointmentDay = "Wednesday";
                    break;
                case 4:
                    appointmentDay = "Thursday";
                    break;
                case 5:
                    appointmentDay = "Friday";
                    break;
                case 6:
                    appointmentDay = "Saturday";
                    break;
                case 7:
                    appointmentDay = "Sunday";
                    break;
            }
    
            // Display a message with the selected appointment day
            System.out.println(ANSI_YELLOW + "You have successfully booked an appointment for " + appointmentDay + ANSI_RESET);
    
            // Set the appointment day for the user
            user.setAppointmentDay(appointmentDay);
        } else {
            // Display an error message for invalid choice
            System.out.println(ANSI_RED + "Invalid choice! Please enter a number between 1 and 7." + ANSI_RESET);
        }
    }
    
}
    