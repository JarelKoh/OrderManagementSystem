/**
 * Provides methods to encrypt and decrypt passwords using a simple Caesar cipher shift approach.
 */

public class PasswordHide {
    /**
     * Constructs a new PasswordHide instance.
     */
    public PasswordHide(){};

    /**
     * The shift key for the Caesar cipher.
     */
    private static final int SHIFT_KEY = 3;

    /**
     * Encrypts a plaintext string by shifting each letter by a fixed number of positions in the alphabet.
     *
     * @param text the plaintext string to be encrypted
     * @return the encrypted string
     */
    public static String encrypt(String text) {
        return shift(text, SHIFT_KEY);
    }

    /**
     * Decrypts the given cipher text using a Caesar cipher shift.
     *
     * @param cipherText the text to decrypt
     * @return the decrypted text
     */
    public static String decrypt(String cipherText) {
        return shift(cipherText, -SHIFT_KEY);
    }

    /**
     * Shifts the characters of the given string by the specified number of positions.
     * Handles both lowercase and uppercase letters by cycling them within their alphabetic range.
     * Non-alphabetical characters are not modified.
     *
     * @param text the text to shift
     * @param shift the number of positions to shift each character
     * @return the shifted string
     */
    private static String shift(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (character >= 'a' && character <= 'z') {
                // Shift lowercase letters
                char shifted = (char) (((character - 'a' + shift) % 26 + 26) % 26 + 'a');
                result.append(shifted);
            } else if (character >= 'A' && character <= 'Z') {
                // Shift uppercase letters
                char shifted = (char) (((character - 'A' + shift) % 26 + 26) % 26 + 'A');
                result.append(shifted);
            } else {
                // Keep other characters unchanged
                result.append(character);
            }
        }

        return result.toString();
    }   
}