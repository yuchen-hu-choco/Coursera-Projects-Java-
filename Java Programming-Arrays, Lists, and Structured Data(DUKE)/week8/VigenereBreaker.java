import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder sb = new StringBuilder();
        message = message.substring(whichSlice);
        int i = 0;
        for(char c : message.toCharArray())
        {
            if(i%totalSlices == 0)
                sb.append(c);
            i++;    
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        for(int i=0; i<klength; i++)
        {
            String sliced = sliceString(encrypted, i, klength);
            CaesarCracker cc = new CaesarCracker(mostCommon);
            key[i] = cc.getKey(sliced);
        }
        return key;
    }

    public void breakVigenere () {
        DirectoryResource dr = new DirectoryResource();
        HashMap<String, HashSet<String>> directory = new HashMap<String, HashSet<String>>();
        for(File f : dr.selectedFiles())
        {
            directory.put(f.getName(), readDictionary(new FileResource(f)));
            
        }
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println(breakForAllLangs(message, directory).substring(0,150));

    }
    
    public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet<String> dict = new HashSet<String>();
        for(String s: fr.lines())
        {
            dict.add(s.toLowerCase());
        }
        return dict;
    }
    
    int countWords(String message, HashSet<String> dictionary)
    {
        int count = 0;
        String[] words = message.split("\\W+");
        for(String s : words)
        {
            if (dictionary.contains(s.toLowerCase()))
            count ++;
        }
        return count;
    }
    
    int[] breakForLanguage(String message, HashSet<String> dictionary, char c)
    {
        int max = 0;
        int[] key = null;
        for(int i=1; i<100; i++)
        {
            int[] tempKey = tryKeyLength(message, i, c);
            VigenereCipher vc = new VigenereCipher(tempKey);
            int temp = countWords(vc.decrypt(message), dictionary);
            if(temp > max) {max = temp; key = tempKey;}
        }
        return key;
    }
    
    char mostCommonCharIn(HashSet<String> dictionary)
    {
        String albet = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        char[] dict = dictionary.toString().toLowerCase().toCharArray();
        int max = 0, pos = -1;
        for(int i=0; i<dict.length; i++)
        {
            int index = albet.indexOf(dict[i]);
            if(index != -1) count[albet.indexOf(dict[i])] ++;
        }
        for(int i=0; i<26; i++)
        {
            if(count[i]>max) {max = count[i]; pos = i;}
        }
        return albet.charAt(pos);
    }
    
    String breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages)
    {
        int max = 0;
        VigenereCipher record = null;
        String lang = null;
        for(String s : languages.keySet())
        {
        char c = mostCommonCharIn(languages.get(s));
        int[] key = breakForLanguage(encrypted, languages.get(s), c);
        VigenereCipher vc = new VigenereCipher(key);
        int temp = countWords(vc.decrypt(encrypted), languages.get(s));
        if(max < temp)
            {max = temp; record = vc; lang = s;}
        }
        System.out.println(lang);
        return record.decrypt(encrypted);
    }
}
