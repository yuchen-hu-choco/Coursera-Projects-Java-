import edu.duke.*;
/**
 * 在这里给出对类 CaesarBreaker 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class CaesarBreaker {
    int maxIndex(int[] stat)
    {
        int max = stat[0];
        int index = 0;
        for(int i=0; i<stat.length; i++)
        {
            if(stat[i] > max) {max = stat[i]; index = i;}
        }
        return index;
    }
    
    int[] countLetters(String letter)
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
    
    
    String decryption(String encrypted)
    {
        String original;
        int[] count = countLetters(encrypted);
        int maxIndex = maxIndex(count);
        int move;
        if(maxIndex >= 4) move = maxIndex - 4;
        else move = 22 + maxIndex;
        CaesarCipher cc = new CaesarCipher();
        original = cc.encrypt(encrypted, 26-move);
        return original;
    }
    
    void testDecrypt()
    {
        FileResource fr = new FileResource();
        String haha = null;
        for(String s : fr.words())
        {
            haha = haha + " " + s;
        }
        String letter = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        System.out.println(decryptTwoKeys(haha));
    }
    
    String halfOfString(String message, int start)
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
    
    int getKey(String s)
    {
        int[] a = countLetters(s);
        int i = maxIndex(a);
        if(i>=4) return i-4;
        else return 22+i;
    }
    
    String decryptTwoKeys(String encrypted)
    {
        String str0 = halfOfString(encrypted, 0);
        String str1 = halfOfString(encrypted, 1);
        int key1 = getKey(str0), key2 = getKey(str1);
        System.out.println("key1 is " + key1 + ", key2 is "+ key2);
        CaesarCipher cc = new CaesarCipher();
        String decrypt = cc.encryptTwoKeys(encrypted, (26-key1), (26-key2));
        return decrypt;
    }
    
}

