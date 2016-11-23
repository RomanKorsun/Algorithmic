package stringcomporation;

import com.sun.corba.se.impl.orbutil.graph.Graph;

/**
 * Created by Roman Korsun on 23.07.2016.
 * Implementation of Boyer–Moore string search algorithm
 */
public class BoyerMooreStringFinder  {

    /**
     * Finds sub string in the given text using Boyer–Moore string search algorithm
     * @param text - text to search in
     * @param subString - sub string
     * @return index of first character of the subStr in text
     */
    public int find(String text, String subString) {
        int[] slides = makeSlidesTable(subString);  //slides table
        int[] jumps = makeJumpsTable(subString);    //jumps table
        int textLoc = subString.length()-1;
        int subStrLoc = subString.length()-1;
        while (textLoc< text.length() && subStrLoc>-1) {
            if(text.charAt(textLoc)==subString.charAt(subStrLoc)) {
                textLoc--;
                subStrLoc--;
            } else {
                textLoc = textLoc+Math.max(slides[text.charAt(textLoc)], jumps[subStrLoc]);
            }
        }
        if(subStrLoc == -1) {
            return textLoc+1;
        } else {
            return -1;
        }
    }

    //Makes the slides table
    private int[] makeSlidesTable(String subString) {
        int alphabetSize = 256;
        int[] table = new int[alphabetSize];
        for (int i = 0; i < table.length; i++) {
            table[i]=subString.length();
        }
        for (int i = 0; i < subString.length(); i++) {
            table[subString.charAt(i)]=subString.length()-1-i;
        }
        return table;
    }

    //Makes the jump table
    private int[] makeJumpsTable(String subString) {
        int[] jumps = new int[subString.length()];
        int[] link = new int[subString.length()];
        for (int i = 0; i < subString.length(); i++) {
            jumps[i] = 2*subString.length()-i-1;
        }
        int test = subString.length()-1;
        int target = subString.length();

        while (test>-1) {
            link[test] = target;
            while (target<subString.length() && subString.charAt(test) != subString.charAt(target)) {
                jumps[target]=Math.min(jumps[target], subString.length()-test);
                target=link[target];
            }
            test--;
            target--;
        }
        for (int i = 0; i < target; i++) {
            jumps[i]=Math.min(jumps[i], subString.length()+target-i);
        }
        int temp = link[target];
        while (target<subString.length()) {
            while (target<=temp) {
                jumps[target] = Math.min(jumps[target], temp-target+subString.length());
                target++;
            }
            temp = link[temp];
        }
        return jumps;
    }

    
}
