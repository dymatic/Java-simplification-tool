package libsubject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides tools that help work with text. The focus revolves around scrambling
 * and reversal of text, as well as making the simplest text operations easier.
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
        temporary = "";
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
        temporary = "";
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
        temporary = "";
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
        temporary = "";
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
        temporary = "";
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
     * @param The file to scramble
     * @return The text of the file taht has been scrambled.
     */
    public static String unpredictableScramble(File toUnscramble) {
        return LibText.unpredictableScramble(LibText.extractFileText(toUnscramble));
    }

    /**
     * Returns the position of the letter in the English alphabet.
     *
     * @return the position of the letter, 0 is A and 25 is Z
     */
    public static short letterIndex(char letter) {
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        String capAlphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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
        temporary = "";

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
     * Gets the letter at the alphabetical index. Note that indexes start at 0.
     *
     * @param the alphabetical index
     * @return the letter at the index
     */
    public static char getLetterAt(short index) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.charAt(index);
    }

    /**
     * Predictably encrypts the text using the encrypter key. Unlike most
     * encryption, a password is not used, but rather a randomly generated set
     * of numbers called an encrypter key. An encrypter key must be generated
     * and used in this method in order for the method to work. This will turn
     * capital letters into lower case ones
     *
     * @param the text to encrypt
     * @param the encrypter key. To generate a new key, use generateEncrypterKey
     * @return the encrypted text text
     */
    public static String encrypt(String toScramble, File key) throws FileNotFoundException {
        short[] indexes;
        try (Scanner fileReader = new Scanner(key)) {
            indexes = new short[26];
            for (int index = 0; fileReader.hasNextShort(); index++) {
                indexes[index] = fileReader.nextShort();
            }
        }
        String tempText=toScramble.replace('z', '9').toLowerCase();

        
        char[] text = tempText.toCharArray();
        String oddAlphabet = "";

        for (int index = 0; index < indexes.length; index++) {

            oddAlphabet += String.valueOf(LibText.getLetterAt(indexes[index]));
        }

        for (int index = 0; index < text.length; index++) //Core encrypter
        {
            if (!Character.isUpperCase(text[index])) {
                if (LibText.letterIndex(text[index]) != -1 && LibText.letterIndex(text[index])<26) {
                    text[index] = oddAlphabet.charAt(LibText.letterIndex(text[index]));
                }
            } else if(LibText.letterIndex(text[index])<26) {
                text[index] = Character.toUpperCase(oddAlphabet.charAt(index));
            }else {
                text[index] = '9';
            }
        }
        return LibText.condenseArray(text);
    }

    /**
     * Unencrypts text that has been encrypted with the specified key.
     * Generating a new key and using it will almost never work.
     *
     * @param The text to unencrypt
     * @param the encrypter key
     * @return the unencrypted text
     */
    public static String unencrypt(String toUnencrypt, File key) throws FileNotFoundException {
        short[] indexes;
        try (Scanner fileReader = new Scanner(key)) {
            indexes = new short[26];
            for (int index = 0; fileReader.hasNextShort(); index++) {
                indexes[index] = fileReader.nextShort();
            }//loop
            char[] text = toUnencrypt.toCharArray();
            String normalAlphabet = " abcdefghijklmnopqrstuvwxyz";
            String oddAlphabet = "";
            for (int index = 0; index < indexes.length; index++) {

                oddAlphabet += String.valueOf(LibText.getLetterAt(indexes[index]));
            }
            for (int index = 0; index < text.length; index++) {
               
                if(Character.isAlphabetic(text[index])&&Character.isLowerCase(text[index]))
                {
                if(text[index]!='1'&&text[index]!='9') {
                if (!Character.isUpperCase(text[index])) {
                    text[index] = normalAlphabet.charAt(oddAlphabet.indexOf(text[index]));
                } 
                }
            } else if(Character.isDigit(text[index]))
                {
                    if(text[index]=='9')
                        text[index]='z';
                    else if(text[index]=='1')
                        text[index]='Z';
                    
                } else if(Character.isUpperCase(text[index]))
                {
                    System.out.println("Entered super secret area DEBUG");
                    text[index]=Character.toLowerCase(text[index]);
                    text[index] = normalAlphabet.charAt(oddAlphabet.indexOf(text[index])); ////////////////////NOT QUITE WORKING
                    text[index]=Character.toUpperCase(text[index]);
            }
            }


            return LibText.condenseArray(text);
        }//try
    }//method

    /**
     * Creates a new encyption key at the specified filepath. encryption keys
     * are used in predictable encrypting. Each of the numbers represents a
     * letter in the alphabet at that index. Encrypter keys consist of random
     * numbers, 0 to 25.
     *
     * @param The file path.
     */
    public static void generateEncrypterKey(String filepath) throws FileNotFoundException {
        short[] data = new short[26];
        short randomNumber;
        short secondRandomNumber;
        short numeralTemp;
        String output = " ";
        for (int index = 0; index < 26; index++) {
            data[index] = (short) index;
        }

        for (int secondIndex = 0; secondIndex < 1000; secondIndex++) //Randomized 1000 times
        {
            do {
                randomNumber = (short) rand.nextInt(26);
                secondRandomNumber = (short) rand.nextInt(26);
            } while (randomNumber == secondRandomNumber);

            numeralTemp = data[randomNumber];
            data[randomNumber] = data[secondRandomNumber];
            data[secondRandomNumber] = numeralTemp;
        }
        for (int index = 0; index < data.length; index++) {
            output += data[index] + " ";
        }
        LibText.writeTofile(filepath, output);
    }

    /**
     * This will write the text to the file. No extra characters will be added,
     * not even a carriage return. Make sure you have that handled in the String
     * before you call this method. WARNING: This will erase the contents of the
     * file. All this method does is use PrintWriter to write to the file, and
     * then close the connection.
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
    public static void main(String[] args) throws FileNotFoundException
    {
        LibText.generateEncrypterKey("/home/nate/key");
        File filius = new File("/home/nate/key");
        System.out.println("Encrypted phrase: "+LibText.encrypt("Basic", filius));
        System.out.println("Unencrypted: "+LibText.unencrypt(LibText.encrypt("BzZzZa,,,sic", filius), filius));
    }
} /*
 * Status update: You had to leave for school, but you are having a problem with capitals in the unencrypter. First, look at your encryption algorithm to determine where you're going
 * wrong. If yo can't, just as Y!A.
 */