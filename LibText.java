package libsubject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides tools that help with editing text. The focus revolves around
 * scrambling and reversal of text.
 *
 * @author nate
 */
public abstract class LibText {

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
        String returnText = "";
        try {

            Scanner inputStream = new Scanner(textFile);
            do {
                returnText += inputStream.nextLine() + "\n";
            } while (inputStream.hasNextLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LibText.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnText;
    }

    /**
     * Reverses text supplied in the arguments.
     *
     * @param text to reverse
     * @return The reversed text.
     */
    public static String reverse(String text) {
        String reversed = "";
        char[] characters = text.toCharArray();

        for (int index = (characters.length - 1); index > -1; index--) {
            reversed += characters[index];
        }

        return reversed;
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
        String reversed = LibText.condenseArray(charArray);

        for (int index = 0; index < reversed.length(); index++) {
            returnArray[index] = reversed.charAt(index);
        }
        return returnArray;
    }

    /**
     * Predictably scrambles the content in the specified file, not the file
     * itself.
     *
     * @param the file to Scramble
     * @return the scrambled content of the file.
     *
     */
    public static String predictableScramble(File toScramble) {
        return LibText.predictableScramble(LibText.extractFileText(toScramble));
    }

    /**
     * Unscrambles the text located in the file. The file should not be
     * scrambled unless you reassigned the scrambled String to the file.
     *
     * @param The file that contains the text
     * @return The unscrambled content from the file.
     *
     */
    public static String unscramble(File toUnscramble) {
        return LibText.unscramble(LibText.extractFileText(toUnscramble));
    }

    /**
     * Scrambles a set of data in a predictable fashion. This can be
     * unscrambled.
     *
     * @param toScramble
     * @return scrambled text
     */
    public static String predictableScramble(String toScramble) {
        char[] content = toScramble.toCharArray();
        char temp;
        int secondIndex;
        String finalMessage = "";

        for (int counter = 0; counter < 1000; counter++)//Scambled 100 times
        {
            secondIndex = 2;
            if (secondIndex > content.length) {
                secondIndex = 0;
            }
            for (int index = 0; index < toScramble.length(); index++) //Does the actual scrambling
            {
                content = LibText.reverse(content);
                temp = content[index];
                content[index] = content[secondIndex];
                content[secondIndex] = temp;
            }
        }
        return LibText.condenseArray(content);
    }

    /**
     * In addition to probably being the longest method name in all existence,
     * this will unpredictably scrambles words but skip over whitespace.
     *
     * @param the text to Scramble.
     * @return the scrambled String.
     */
    public static String unpredictableScrambleIgnoreWhitespace(String toScramble) {
        char temporary;
        char[] charArray = toScramble.toCharArray();
        int placeHolder0;
        int placeHolder1;

        for (int index = 0; index < toScramble.length() * 2; index++) {
            do {
                placeHolder0 = rand.nextInt(toScramble.length());
                placeHolder1 = rand.nextInt(toScramble.length());
            } while (placeHolder0 == placeHolder1 || charArray[placeHolder0] == ' '
                    || charArray[placeHolder1] == ' ');

            temporary = charArray[placeHolder0];
            charArray[placeHolder0] = charArray[placeHolder1];
            charArray[placeHolder1] = temporary;
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
        char temporary;
        char[] charArray = toScramble;
        int placeHolder0;
        int placeHolder1;

        for (int index = 0; index < toScramble.length * 2; index++) {
            do {
                placeHolder0 = rand.nextInt(toScramble.length);
                placeHolder1 = rand.nextInt(toScramble.length);
            } while (placeHolder0 == placeHolder1 || charArray[placeHolder0] == ' '
                    || charArray[placeHolder1] == ' ');

            temporary = charArray[placeHolder0];
            charArray[placeHolder0] = charArray[placeHolder1];
            charArray[placeHolder1] = temporary;
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
        char temporary;
        char[] charArray = toScramble.toCharArray();
        int placeHolder0;
        int placeHolder1;

        for (int index = 0; index < toScramble.length() * 2; index++) {
            do {
                placeHolder0 = rand.nextInt(toScramble.length());
                placeHolder1 = rand.nextInt(toScramble.length());
            } while (placeHolder0 == placeHolder1);

            temporary = charArray[placeHolder0];
            charArray[placeHolder0] = charArray[placeHolder1];
            charArray[placeHolder1] = temporary;
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
        char temporary;
        char[] charArray = toScramble;
        int placeHolder0;
        int placeHolder1;

        for (int index = 0; index < toScramble.length * 2; index++) {
            do {
                placeHolder0 = rand.nextInt(toScramble.length);
                placeHolder1 = rand.nextInt(toScramble.length);
            } while (placeHolder0 == placeHolder1);

            temporary = charArray[placeHolder0];
            charArray[placeHolder0] = charArray[placeHolder1];
            charArray[placeHolder1] = temporary;
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
        char temp;
        int secondIndex;
        String finalMessage = "";

        for (int counter = 0; counter < 1000; counter++)//Scambled 100 times
        {
            secondIndex = 2;
            if (secondIndex > content.length) {
                secondIndex = 0;
            }
            for (int index = content.length - 1; index > -1; index--) //Does the actual unsrambling.
            {
                content = LibText.reverse(content);
                temp = content[index];
                content[index] = content[secondIndex];
                content[secondIndex] = temp;
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
        String sentence = "";
        String[] words = toScramble.split(" ");

        for (int index = 0; index < words.length; index++) {
            sentence += LibText.unpredictableScramble(words[index]) + " ";
        }

        return sentence;
    }

    /**
     * Turns the characters in the array into a String.
     *
     * @param character array
     * @return A string representative of the character array.
     */
    public static String condenseArray(char[] toCondense) {
        String returnString = "";

        for (int index = 0; index < toCondense.length; index++) {
            returnString += toCondense[index];
        }
        return returnString;
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
     *
     * @throws FileNotFoundException
     * @param filepath to save to.
     * @param String to write to the file.
     */
    public static void writeTofile(String filepath, String toWrite) throws FileNotFoundException {
        File writeTo = new File(filepath);
        try (PrintWriter outputStream = new PrintWriter(writeTo)) {
            outputStream.write(toWrite);
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