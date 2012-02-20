package libsubject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides tools that help work with text. The focus revolves around
 * scrambling and reversal of text, as well as making the simplest text 
 * operations easier.
 *
 * @author Norton
 */
public abstract class LibText {
    /**
     * Temporary variable.
     */
private static String temporary = "";
    /**
     * Generates a random number.
     */
    private static Random rand = new Random();

    /**
     * Extracts the text of the file.
     *
     * @param textFile
     * @return The text from the file.
     */
    public static String extractFileText(File textFile) {
        temporary="";
        try {

            Scanner inputStream = new Scanner(textFile);
            do {
                temporary += inputStream.nextLine() + "\n";
            } while (inputStream.hasNextLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LibText.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temporary;
    }

    /**
     * Reverses text supplied in the arguments.
     *
     * @param text to reverse
     * @return The reversed text.
     */
    public static String reverse(String text) {
       temporary = "";
        char[] characters = text.toCharArray();

        for (int index = (characters.length - 1); index > -1; index--) {
            temporary += characters[index];
        }

        return temporary;
    }

    /**
     * Reverses the text found in the specified file.
     *
     * @param textFile
     * @return reversed text
     */
    public static String reverse(File textFile) {
        return LibText.reverse(LibText.extractFileText(textFile));
    }

    /**
     * Reverses the character array. Content from the beginning will be moved to
     * the end.
     *
     * @param charAray
     * @return The reversed character array.
     */
    public static char[] reverse(char[] charArray) {
        char[] returnArray = new char[charArray.length];
        temporary = "";
       temporary = LibText.condenseArray(charArray);

        for (int index = 0; index < temporary.length(); index++) {
            returnArray[index] = temporary.charAt(index);
        }
        return returnArray;
    }

    /**
     * In addition to probably being the longest method name in all existence,
     * this will unpredictably scrambles words but skip over whitespace.
     *
     * @param the text to Scramble.
     * @return the scrambled String.
     */
    public static String unpredictableScrambleIgnoreWhitespace(String toScramble) {
        temporary="";
        char[] charArray = toScramble.toCharArray();
        int placeHolder0;
        int placeHolder1;

        for (int index = 0; index < toScramble.length() * 2; index++) {
            do {
                placeHolder0 = rand.nextInt(toScramble.length());
                placeHolder1 = rand.nextInt(toScramble.length());
            } while (placeHolder0 == placeHolder1 || charArray[placeHolder0] == ' '
                    || charArray[placeHolder1] == ' ');

            temporary = String.valueOf(charArray[placeHolder0]);
            charArray[placeHolder0] = charArray[placeHolder1];
            charArray[placeHolder1] = temporary.charAt(0);
        }
        return LibText.condenseArray(charArray);
    }

    /**
     * In addition to probably being the longest method name in all existence,
     * this will unpredictably scrambles words but skip over whitespace.
     *
     * @param File containing the text to scramble.
     * @return the scrambled File text.
     */
    public static String unpredictableScrambleIgnoreWhitespace(File toScramble) {
        return LibText.unpredictableScrambleIgnoreWhitespace(LibText.extractFileText(toScramble));
    }

    /**
     * In addition to probably being the longest method name in all existence,
     * this will unpredictably scrambles words but skip over whitespace.
     *
     * @param the character array to scramble.
     * @return the scrambled character array.
     */
    public static char[] unpredictableScrambleIgnoreWhitespace(char[] toScramble) {
        temporary="";
        char[] charArray = toScramble;
        int placeHolder0;
        int placeHolder1;

        for (int index = 0; index < toScramble.length * 2; index++) {
            do {
                placeHolder0 = rand.nextInt(toScramble.length);
                placeHolder1 = rand.nextInt(toScramble.length);
            } while (placeHolder0 == placeHolder1 || charArray[placeHolder0] == ' '
                    || charArray[placeHolder1] == ' ');

            temporary = String.valueOf(charArray[placeHolder0]);
            charArray[placeHolder0] = charArray[placeHolder1];
            charArray[placeHolder1] = temporary.charAt(0);
        }
        return charArray;
    }

    /**
     * Unpredictably scrambles the text. It should be noted, however, that the
     * text is not unscramblabled through any automized means. Whitespace is
     * also scrambled.
     *
     * @param The text to be unpredictably scrambled.
     * @return The unpredictably scrambled text.
     */
    public static String unpredictableScramble(String toScramble) {
        temporary="";
        char[] charArray = toScramble.toCharArray();
        int placeHolder0;
        int placeHolder1;

        for (int index = 0; index < toScramble.length() * 2; index++) {
            do {
                placeHolder0 = rand.nextInt(toScramble.length());
                placeHolder1 = rand.nextInt(toScramble.length());
            } while (placeHolder0 == placeHolder1);

            temporary = String.valueOf(charArray[placeHolder0]);
            charArray[placeHolder0] = charArray[placeHolder1];
            charArray[placeHolder1] = temporary.charAt(0);
        }
        return LibText.condenseArray(charArray);
    }

    /**
     * Unpredictably unscrambles the character array. Whitespace is deliberately
     * included. Text scrambled in this way cannot be unscrambled through any
     * automated means.
     *
     * @param The character array to scramble.
     * @return The scrambled character array.
     */
    public static char[] unpredictableScramble(char[] toScramble) {
        temporary="";
        char[] charArray = toScramble;
        int placeHolder0;
        int placeHolder1;

        for (int index = 0; index < toScramble.length * 2; index++) {
            do {
                placeHolder0 = rand.nextInt(toScramble.length);
                placeHolder1 = rand.nextInt(toScramble.length);
            } while (placeHolder0 == placeHolder1);

            temporary = String.valueOf(charArray[placeHolder0]);
            charArray[placeHolder0] = charArray[placeHolder1];
            charArray[placeHolder1] = temporary.charAt(0);
        }
        return charArray;
    }

    /**
     * Unpredictably scrambles the text in the specified file. Whitespace is
     * also scrambled. Text scrambled in this fashion cannot be later
     * unscrambled through automated means.
     *
     * @param toUnscramble
     * @return
     */
    public static String unpredictableScramble(File toUnscramble) {
        return LibText.unpredictableScramble(LibText.extractFileText(toUnscramble));
    }

    /**
     * Unscrambles text scrambled with the predictable scrambler.
     *
     * @param scrambled
     * @return unscrambled.
     */
    public static String unscramble(String scrambled) {
        char[] content = LibText.reverse(scrambled).toCharArray();
        temporary="";
        int secondIndex;

        for (int counter = 0; counter < 1000; counter++)//Scambled 100 times
        {
            secondIndex = 2;
            if (secondIndex > content.length) {
                secondIndex = 0;
            }
            for (int index = content.length - 1; index > -1; index--) //Does the actual unsrambling.
            {
                content = LibText.reverse(content);
                temporary = String.valueOf(content[index]);
                content[index] = content[secondIndex];
                content[secondIndex] = temporary.charAt(0);
            }
        }
        return LibText.reverse(LibText.condenseArray(content));
    }

    /**
     * Returns the position of the letter in the English alphabet.
     *
     * @return the position of the letter, 0 is A and 25 is Z
     */
    public static short letterIndex(char letter) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String capAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (alphabet.indexOf(letter) != -1) //IndexOf returns -1 if the character is not found.
        {
            return (short) alphabet.indexOf(letter);
        } else if (capAlphabet.indexOf(letter) != -1) {
            return (short) capAlphabet.indexOf(letter);
        } else {
            return -1;
        }
    }

    /**
     * Unpredictably scrambles words of the sentence but keeps them within the
     * confines of the original whitespace. If you ran this method on "Hello
     * World", for instance, a sample output would be "oleHl drolW". notice that
     * the words have not traveled to one another.
     *
     * @param toScramble
     * @return
     */
    public static String unpredictableScrambleNoMigration(String toScramble) {
        temporary = "";
        String[] words = toScramble.split(" ");

        for (int index = 0; index < words.length; index++) {
            temporary += LibText.unpredictableScramble(words[index]) + " ";
        }

        return temporary;
    }

    /**
     * Turns the characters in the array into a String.
     *
     * @param character array
     * @return A string representative of the character array.
     */
    public static String condenseArray(char[] toCondense) {
        temporary="";

        for (int index = 0; index < toCondense.length; index++) {
            temporary += toCondense[index];
        }
        return temporary;
    }

    /**
     * Returns the number of the given character found in the String.
     *
     * @param character
     * @return
     */
    public static int numberOf(char character, String sentence) {
        int numberOf = 0;
        for (int index = 0; index < sentence.length(); index++) {
            if (sentence.charAt(index) == character) {
                numberOf++;
            }
        }
        return numberOf;
    }

    /**
     * This will write the text to the file. No extra characters will be added,
     * not even a carriage return. Make sure you have that handled in the String
     * before you call this method. WARNING: This will erase the contents of the
     * file.
     * All this method does is use PrintWriter to write to the file, and then
     * close the connection.
     *
     * @throws FileNotFoundException
     * @param filepath to save to.
     * @param String to write to the file.
     */
    public static void writeTofile(String filepath, String toWrite) throws FileNotFoundException {
        File writeTo = new File(filepath);
        try (PrintWriter outputStream = new PrintWriter(writeTo)) {
            outputStream.write(toWrite);
            outputStream.close();
        }
    }

    /**
     * Splits the String only before the specified index.
     *
     * @param the String to split
     * @param Where to end the splitting
     * @param What to split on
     * @return array of split Strings.
     */
    public static String[] splitBefore(String toSplit, int index, String regex) {
        return toSplit.substring(0, index).split(regex);
    }

    /**
     * Splits the String into sections after the given index.
     *
     * @param the String to split
     * @param where to begin the splitting.
     * @param what expression to split on.
     * @return array of split Strings
     */
    public static String[] splitAfter(String toSplit, int index, String regex) {
        return toSplit.substring(index).split(regex);
    }

    /**
     * Splits the specified String in between the two indexes and returns the
     * Strings that have been split.
     *
     * @param the String to split
     * @param first splitting point
     * @param second splitting point
     * @param what expression to split on
     * @return array of split Strings.
     */
    public static String[] splitBetween(String toSplit, int index, int secondIndex, String regex) {
        return toSplit.substring(index, secondIndex).split(regex);
    }
}