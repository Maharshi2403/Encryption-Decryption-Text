/**

 * An Encryptable class that uses a Vigenere cipher to encrypt/decrypt strings

 * Student Name: Maharshi Patel

 * Student Number: 041091796

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor:  James Mwangi PhD.

 *

 */
package encryption.ciphers;

import encryption.Encryptable;

public class VigenereCipher implements Encryptable {
    private String key;
    private int keyLength;

    /**
     * Constructor for VigenereCipher class.
     * @param password The key / password used for encryption and decryption.
     */
    public VigenereCipher(String password) {
        this.key = password;
        this.keyLength = key.length();
    }

    @Override
    public String encrypt(String input) {
        StringBuilder finalKey = new StringBuilder();
        finalKey.append(key);
        char[] ch = new char[input.length()];

        // Extend the key if its length is less than the input
        while (keyLength < input.length()) {
            for (int i = 0; i < key.length(); i++) {
                finalKey.append(key.charAt(i));
                keyLength++;
            }
        }

        // Encrypt each character of the input
        for (int a = 0; a < input.length(); a++) {
            int x = ((int) finalKey.charAt(a) - 32) + ((int) input.charAt(a) - 32);
            if (x >= RANGE || x == RANGE) {
                int z = (x % RANGE) + 32;
                ch[a] = (char) z;
            } else {
                int w = (x + RANGE) % RANGE + 32;
                ch[a] = (char) w;
            }
        }
        String encrypted = new String(ch);
        return encrypted;
    }

    @Override
    public String decrypt(String encrypted) {
        StringBuilder fKey = new StringBuilder();
        fKey.append(key);
        char[] chr = new char[encrypted.length()];

        // Extend the key if its length is less than the encrypted text
        while (keyLength < encrypted.length()) {
            for (int j = 0; j < key.length(); j++) {
                fKey.append(key.charAt(j));
                keyLength++;
            }
        }

        // Decrypt each character of the encrypted text
        for (int b = 0; b < encrypted.length(); b++) {
            int y = ((int) encrypted.charAt(b) - 32) - ((int) fKey.charAt(b) - 32);
            if (y >= 0 && y <= RANGE) {
                int g = y + 32;
                chr[b] = (char) g;
            } else {
                int h = (y + RANGE) + 32;
                chr[b] = (char) h;
            }
        }
        String decrypted = new String(chr);
        return decrypted;
    }

   
}
