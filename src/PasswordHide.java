public class PasswordHide {
    public PasswordHide(){};
    private static final int SHIFT_KEY = 3;

    public static String encrypt(String text) {
        return shift(text, SHIFT_KEY);
    }

    public static String decrypt(String cipherText) {
        return shift(cipherText, -SHIFT_KEY);
    }

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