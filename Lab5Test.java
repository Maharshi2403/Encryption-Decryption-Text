/**

 * The program that tests the encryption methods

 * Student Name: Maharshi Patel

 * Student Number: 041091796

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor:  James Mwangi PhD.

 *

 */
import java.util.ArrayList;
import java.util.Scanner;

import encryption.Encryptable;
import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;

public class Lab5Test {
    private Scanner input;

    public Lab5Test() {
        input = new Scanner(System.in);
    }

    /**
     * 
     * @param options The menu options to display.
     * @return The user's selected menu item.
     */
    public int getMenuItem(String... options) {
        boolean optionmatched = false;
        int choice = -1;
        while (!optionmatched) {
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + " - " + options[i]);
            }
            System.out.print("Select action: ");
            try {
                choice = Integer.parseInt(input.nextLine());
                if (choice >= 1 && choice <= options.length) {
                    optionmatched = true;
                } else {
                    System.out.println("\nPlease select a number in the range\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPlease select an Integer\n");
            }

        }
        return choice;
    }

    /**
     * Gets a string input from the user.
     * @param prompt The prompt message to display.
     * @return The user's input string.
     */
    public String getString(String prompt) {
        System.out.print(prompt + ": ");
        return input.nextLine();
    }

    /**
     * Gets an integer input from the user within a specified range.
     * @param prompt The prompt message to display.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return The user's input integer.
     */
    public int getInt(String prompt, int min, int max) {
        int value = -1;
        boolean optionmatched = false;

        while (!optionmatched) {
            System.out.print(prompt + ": ");
            String inputStr = input.nextLine();

            try {
                value = Integer.parseInt(inputStr);
                if (value >= min && value <= max) {
                    optionmatched = true;
                } else {
                    System.out.println("\nPlease select a number in the range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter an integer");
            }
        }

        return value;
    }

    /**
     * Gets the encryption method chosen by the user.
     * @return An instance of the selected encryption method.
     */
    public Encryptable getMethod() {
        System.out.println("Encryption method");

        int userChoice = getMenuItem("Caesar", "Vigenere");
        if (userChoice == 1) {
            int shift = getInt("Shift value", Integer.MIN_VALUE, Integer.MAX_VALUE);
            return new CaesarCipher(shift);
        } else {
            String password = getString("Password");
            return new VigenereCipher(password);
        }
    }

    /**
     * The main method to run the encryption tester.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Encryption tester");

        ArrayList<String> encryptedText = new ArrayList<>();
        Lab5Test lab5 = new Lab5Test();

        while (true) {
            int choice = lab5.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit");

            if (choice == 1) {
                String text = lab5.getString("Please enter text to be encrypted");
                Encryptable method = lab5.getMethod();
                String encrypted = method.encrypt(text);
                encryptedText.add(encrypted);
                System.out.println("Encrypted value #" + encryptedText.size() + " is: " + encrypted);
            } else if (choice == 2) {
                if (encryptedText.isEmpty()) {
                    System.out.println();
                    System.out.println("Nothing to decrypt");
                    System.out.println();
                    continue;
                }
                int messageNumber = lab5.getInt("Message number you want to decrypt: ", 1, encryptedText.size());
                Encryptable method = lab5.getMethod();
                String decrypted = method.decrypt(encryptedText.get(messageNumber - 1));
                System.out.println("Decrypted value #" + messageNumber + " is: " + decrypted);
            } else if (choice == 3) {
                if (encryptedText.isEmpty()) {
                    System.out.println();
                    System.out.println("Nothing to Display");
                    System.out.println();
                    continue;
                }
                System.out.println("------------");
                for (int i = 0; i < encryptedText.size(); i++) {
                    System.out.println("#" + (i + 1) + ": " + encryptedText.get(i));
                }
                System.out.println("------------");
            } else if (choice == 4) {
                System.out.println("Good bye");
                break;
            }
        }
    }
}

