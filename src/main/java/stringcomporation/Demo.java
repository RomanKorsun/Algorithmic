package stringcomporation;

/**
 * Created by Roman Korsun on 20.07.2016.
 */
public class Demo {

    public static void main(String[] args) {
        String text = "they are human beings";
        String subString = "human";
        System.out.println(text.charAt(new BoyerMooreStringFinder().find(text, subString)));
    }
}
