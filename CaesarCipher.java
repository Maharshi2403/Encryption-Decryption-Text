/**

 * An Encryptable class that uses a Caesar cipher to encrypt/decrypt strings

 * Student Name: Maharshi Patel

 * Student Number: 041091796

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor:  James Mwangi PhD.

 *

 */
package encryption.ciphers;

import encryption.Encryptable;

/**
 * CaesarCipher
 */
public class CaesarCipher implements Encryptable {
    int key;

    /**
     * Constructor for CaesarCipher class.
     * @param Shift The number of positions to shift the characters in the alphabet.
     */
    public CaesarCipher(int Shift) {
        this.key = Shift;
    }

    /**
     * Encrypts the given input using the Caesar cipher algorithm.
     * @param input The input text to be encrypted.
     * @return The encrypted text.
     */
    public String encrypt(String input) {
        char[] ch1 = new char[input.length()];
        char[] f1 = new char[input.length()];

        // Encrypt each character of the input
        for (int a = 0; a < input.length(); a++) {
            ch1[a] = input.charAt(a);
            int x = (int) ch1[a] + key;
            char g1 = (char) x;
            f1[a] = g1;
        }

        String output1 = new String(f1);
        return output1;
    }

    /**
     * Decrypts the given input using the Caesar cipher method.
     * @param input The input text to be decrypted.
     * @return The decrypted text.
     */
    public String decrypt(String input) {
        char[] ch2 = new char[input.length()];
        char[] f2 = new char[input.length()];

        // Decrypt each character of the input
        for (int a = 0; a < input.length(); a++) {
            ch2[a] = input.charAt(a);
            int x = (int) ch2[a] - key;
            char g2 = (char) x;
            f2[a] = g2;
        }

        String output2 = new String(f2);
        return output2;
    }
}
