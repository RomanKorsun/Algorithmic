package stringcomporation;

/**
 * Created by Roman Korsun on 21.07.2016.
 * Implementation of Knuth–Morris–Pratt string searching algorithm
 */
public class KMPSubStringFinder {

    /**
     * Finds sub string in the given text using Knuth–Morris–Pratt string searching algorithm
     * @param text - text to search in
     * @param subString - sub string
     * @return index of first character of the subStr in text
     */
    public int find(String text, String subString) {

        int subLoc = 0;
        int textLoc = 0;
        int[] fail = findConsequenses(subString);
        while (textLoc < text.length() && subLoc < subString.length()) {
            if(subLoc == 0 | text.charAt(textLoc)==subString.charAt(subLoc)) {
                textLoc++;
                subLoc++;
            } else {
                subLoc=fail[subLoc];
            }
        }

        if(subLoc>=subString.length()) {
            return textLoc-subString.length();
        } else {
            return -1;
        }

    }

    public int[] findConsequenses(String subString) {
        int [] fail = new int[subString.length()];
        fail[0] = 0;
        for (int i = 1; i < subString.length(); i++) {
            int temp = fail[i-1];
            while (temp>0 && subString.charAt(temp)!= subString.charAt(i-1)) {
                temp = fail[temp];
            }
            if(subString.charAt(temp)==subString.charAt(i)) {
                fail[i] = temp + 1;
            } else {
                fail[i] = 0;
            }
        }
        return fail;
    }
}
