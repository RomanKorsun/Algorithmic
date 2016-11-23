package stringcomporation;

/**
 * Created by Roman Korsun on 20.07.2016.
 */
public class SubStringFinder {
    /**
     * Finds sub string in the given text
     * @param text - text to search in
     * @param subString - sub string
     * @return index of first character of the subStr in text
     */
    public int find(String text, String subString) {
        int subLoc = 0;
        int textLoc = 0;
        int startText = 0;
        while (textLoc < text.length() && subLoc < subString.length()) {
            if(subString.charAt(subLoc) == text.charAt(textLoc)) {
                subLoc++;
                textLoc++;
            } else {
                startText++;
                subLoc=0;
                textLoc++;
            }
        }
        if(subLoc >= subString.length()) {
            return startText+1;
        } else {
            return -1;
        }
    }
}
