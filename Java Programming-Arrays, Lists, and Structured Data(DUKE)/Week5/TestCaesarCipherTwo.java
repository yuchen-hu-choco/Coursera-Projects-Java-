import edu.duke.*;
/**
 * 在这里给出对类 TestCaesarCipherTwo 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class TestCaesarCipherTwo {

    private int[] countLetters(String letter)
    {
        String albt = "abcdefghijklmnopqrstuvwxyz";
        int index;
        int[] count = new int[26];
        for(int i=0; i<letter.length(); i++)
        {
            char curr = letter.charAt(i);
            index = albt.indexOf(curr);
            if(index != -1)
            {
                count[index]++;
            }
        }
        return count;
    }
    
    private int maxIndex(int[] stat)
    {
        int max = stat[0];
        int index = 0;
        for(int i=0; i<stat.length; i++)
        {
            if(stat[i] > max) {max = stat[i]; index = i;}
        }
        return index;
    }
    
    private String halfOfString(String message, int start)
    {
        StringBuffer sb = new StringBuffer(message);
        int num = 0;
        for(int i=0; i<message.length(); i++)
        {
            if(i%2 == start) sb.setCharAt(num++, message.charAt(i));
        }
        String result = sb.toString().substring(0,num);
        return result;
    }
    
    String breakCaesarCipher(String str)
    {
        String str1 = halfOfString(str, 0);
        String str2 = halfOfString(str, 1);
        int key1, key2;
        int maxIndex1 = maxIndex(countLetters(str1));
        int maxIndex2 = maxIndex(countLetters(str2));
        if(maxIndex1 >= 4) key1 = maxIndex1 - 4;
        else key1 = 22 + maxIndex1;
        if(maxIndex2 >= 4) key2 = maxIndex2 - 4;
        else key2 = 22 + maxIndex2;
        System.out.println(key1 + " " + key2);
        CaesarCipherTwo cct = new CaesarCipherTwo(22, 9);
        return cct.encryptTwoKeys(str);
    }
    
    void test()
    {
        //CaesarCipherTwo cct = new CaesarCipherTwo(12, 2);
        FileResource fr = new FileResource();
        String letter = "";
        for(String s : fr.words())
        {
            letter += " " + s;
        }
        System.out.println(letter);
        System.out.println(breakCaesarCipher(letter));
    }
}
