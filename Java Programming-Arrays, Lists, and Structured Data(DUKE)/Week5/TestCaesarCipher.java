
/**
 * 在这里给出对类 TestCaesarCipher 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class TestCaesarCipher {

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
        
    int getKey(String s)
    {
        int[] a = countLetters(s);
        int i = maxIndex(a);
        if(i>=4) return i-4;
        else return 22+i;
    }
    
    void test()
    {
        CaesarCipher cc = new CaesarCipher(15);
        String str = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String enc =  cc.encrypt(str);
        System.out.println(enc);
        //System.out.println(getKey(enc));
        //CaesarCipherTwo cct = new CaesarCipherTwo(5,7);
        //System.out.println(cct.encryptTwoKeys(str));
    }
}
