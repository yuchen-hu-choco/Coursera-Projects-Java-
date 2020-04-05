import java.util.Scanner;
import edu.duke.*;
/**
 * 在这里给出对类 Wordplay 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Wordplay {
    boolean isVowel(char ch)
    {
        String alphabet = "AEIOUaeiou";
        if(alphabet.indexOf(ch) != -1) return true;
        return false;
    }
    
    String replaceVowels(String phrase, char ch)
    {
        StringBuffer sb = new StringBuffer(phrase);
        for(int i=0; i<phrase.length(); i++)
        {
            if(isVowel(sb.charAt(i))) sb.setCharAt(i, ch);
        }
        return sb.toString();
    }
    
    String emphasize(String phrase, char ch)
    {
        StringBuffer sb = new StringBuffer(phrase);
        for(int i=0; i<phrase.length(); i++)
        {
            if(sb.charAt(i) == Character.toLowerCase(ch) || sb.charAt(i) == Character.toUpperCase(ch))
            {
                if(i%2 == 0) sb.setCharAt(i, '*');
                else sb.setCharAt(i, '+');
            }
        }
        return sb.toString();
    }
    
    void test()
    {
        Scanner input = new Scanner(System.in);
        //String str = input.next();
        //System.out.println(isVowel(str.charAt(0)));
        System.out.println("Please enter a String!");
        String inString = input.nextLine();
        //String haha = replaceVowels(inString, '*');
        //System.out.println(haha.toString());
        System.out.println(emphasize(inString, 'a'));
    }
}

