
/**
 * 在这里给出对类 CaesarCipher 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key)
    {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    String encrypt(String input)
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
    }
    /*String encryptTwoKeys(String input, int key1, int key2)
    {
        String encrypt1 = encrypt(input, key1);
        String encrypt2 = encrypt(input, key2);
        StringBuffer sb = new StringBuffer(input);
        for(int i=0; i<input.length(); i++)
        {
            if(i%2 == 0) sb.setCharAt(i, encrypt1.charAt(i));
            else sb.setCharAt(i, encrypt2.charAt(i));
        }
        return sb.toString();
    }*/
    
}