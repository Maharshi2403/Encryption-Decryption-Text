/**

 * A brief description of the role of this class

 * Student Name: Maharshi Patel

 * Student Number: 041091796

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor:  James Mwangi PhD.

 *

 */
package encryption;

public interface Encryptable {
    // Constants
    int START_CHAR = 32; // The first valid character of the range (i.e., space character)
    int END_CHAR = 122; // The last valid character of the range(i.e., 'z')
    int RANGE = (END_CHAR - START_CHAR) + 1; // The number of valid string values 

    /**
     * Encrypts the given input string.
     *
     * @param input the string to be encrypted
     * @return the encrypted version of the input string
     */
    public String encrypt(String input);

    /**
     * Decrypts the given input string.
     *
     * @param input the encrypted string to be decrypted
     * @return the decrypted version of the input string
     */
    public String decrypt(String input);
}
