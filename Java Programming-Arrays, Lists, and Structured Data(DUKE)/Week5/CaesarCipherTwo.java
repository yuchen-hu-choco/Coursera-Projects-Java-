
/**
 * 在这里给出对类 CaesarCipherTwo 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class CaesarCipherTwo {
    //private String alphabet;
    //private String shiftedAlphabet;
    private int mainKey1, mainKey2;
    
    public CaesarCipherTwo(int key1, int key2)
    {
        //alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    
    /*
    String encrypt(String input, int key)
    {
        String lowerAlphabet = alphabet.toLowerCase();
        StringBuffer sb = new StringBuffer(input);
        String shiftedAlphabetLower = shiftedAlphabet.toLowerCase();
        for(int i=0; i<input.length(); i++)
        {
            char currChar = sb.charAt(i);
            if(shiftedAlphabet.indexOf(currChar) != -1)
            sb.setCharAt(i, shiftedAlphabet.charAt(alphabet.indexOf(currChar)));
            if(shiftedAlphabetLower.indexOf(currChar) != -1)
            sb.setCharAt(i, shiftedAlphabetLower.charAt(lowerAlphabet.indexOf(currChar)));
        }
        return sb.toString();
    }
    
    
    String decrypt(String input)
    {
        shiftedAlphabet = alphabet.substring(26-mainKey) + alphabet.substring(0, 26-mainKey);
        return encrypt(input);
    }*/
    
    
    String encryptTwoKeys(String input)
    {
        CaesarCipher cc1 = new CaesarCipher(mainKey1);
        CaesarCipher cc2 = new CaesarCipher(mainKey2);
        String encrypt1 = cc1.encrypt(input);
        String encrypt2 = cc2.encrypt(input);
        StringBuffer sb = new StringBuffer(input);
        for(int i=0; i<input.length(); i++)
        {
            if(i%2 == 0) sb.setCharAt(i, encrypt1.charAt(i));
            else sb.setCharAt(i, encrypt2.charAt(i));
        }
        return sb.toString();
    }
    
}

