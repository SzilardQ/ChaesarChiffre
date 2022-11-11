import java.util.Locale;

public class ChaesarChiffre {
    public static final String GERMAN_LANGUAGE_PATTERN = "Werden zwei Glasstaebe mit einem Wolltuch gerieben, dann kann " +
            "man feststellen, dass sich die beiden Staebe gegenseitig abstossen. Wird das gleiche Experiment mit zwei " +
            "Kunststoffstaeben wiederholt, dann bleibt das Ergebnis gleich, auch diese beiden Staebe stossen sich gegenseitig" +
            " ab. Im Gegensatz dazu ziehen sich ein Glas und ein Kunststoffstab gegenseitig an. Diese mit den Gesetzen der" +
            " Mechanik nicht zu erklaerende Erscheinung fuehrt man auf Ladungen zurueck. Da sowohl Anziehung als auch Abstossung " +
            "auftritt, muessen zwei verschiedene Arten von Ladungen existieren. Man unterscheidet daher positive und negative Ladungen.";
    public static final String ENCRYPTED_MESSAGE = "ugjt iwv! fw jcuv fgp eqfg igmpcemv wpf fkt uq twjo wpf gjtg gtyqtdgp." +
            " pqtocngtygkug mcpp ocp jkgt inwgjygkp qfgt cgjpnkejgu igykppgp. fkgu hcgnnv kp fkgugo ugoguvgt ngkfgt cwu... uqtt{";
    public static final char SEPARATOR = ' ';

    public static int getIndexOfMaximumEntry(int[] a) {
        int maxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= a[maxIndex]) {
                maxIndex = i;


            }

        }
        return maxIndex;
    }


    public static int[] getHistogram(String text) {
        int[] histogram = new int[text.length()];

        String lowerCase = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != SEPARATOR)
                histogram[lowerCase.charAt(i)] += 1;
        }

        return histogram;
    }


    public static char getSignificantLetter(String text) {
            int indexSignificantChar = getIndexOfMaximumEntry(getHistogram(inputText)); 
            int[] histogram = getHistogram(inputText);
            int quantity = histogram[indexSignificantChar];

            int quota = (int)((double)(quantity/ text.trim().length())*100);

        System.out.println("Most significant letter: " + significantLetter);
        System.out.println("Quantity: " + quantity + " times " + quota + " % of whole text");


        return significantLetter;
    }

    public static int getShift(String encryptedText, String languagePattern) {
        char sigOfChiffre = getSignificantLetter(encryptedText);
        char sigOfPattern = getSignificantLetter(languagePattern);
        int shift =  sigOfChiffre + sigOfPattern;

        System.out.println("Most significant letter in the pattern text: " + sigOfPattern);
        System.out.println("Most significant letter in the encrypted text: " + sigOfChiffre);
        System.out.println("Resulting shift: " + shift);

        return shift;
    }

    public static String decode(String encryptedText, String languagePattern) {
        int shift = getShift(encryptedText, languagePattern);
        char[] lettersEncryptedText = encryptedText.toCharArray();
        int shiftedIndexA = 'a' + shift;
        int shiftedIndexZ = 'z' + shift;

        String decoded = " ";
        for (int i = 0; i < lettersEncryptedText.length; i++) {
            if (shiftedIndexA <= lettersEncryptedText[i] && shiftedIndexZ <= lettersEncryptedText[i]) {
                lettersEncryptedText[i] += shift;

            }

            decoded = String.valueOf(lettersEncryptedText);


        }
        System.out.println();

        return decoded;
    }


    public static void main(String[] args) {
        String decodedText = decode(ENCRYPTED_MESSAGE, GERMAN_LANGUAGE_PATTERN);
        System.out.print("Unredablle, encrypted input text: ");
        System.out.println(ENCRYPTED_MESSAGE);
        System.out.println();
        System.out.print("Readable, decoded output text: ");
        System.out.println(decodedText);
    }
}
