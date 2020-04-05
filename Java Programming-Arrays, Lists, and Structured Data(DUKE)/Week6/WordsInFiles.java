import java.util.*;
import edu.duke.*;
import java.io.File;
/**
 * 在这里给出对类 WordsInFiles 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class WordsInFiles {
    private HashMap<String, ArrayList<String>> data;
    
    WordsInFiles()
    {
        data = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f)
    {
            FileResource fr = new FileResource(f);
            for(String s : fr.words())
            {
                ArrayList<String> temp = new ArrayList<String>();
                temp.clear();
                if(!data.containsKey(s))
                {
                    temp.add(f.getName());
                    data.put(s, temp);                    
                }
                else
                {
                    temp = data.get(s);
                    if(data.get(s).contains(f.getName()))
                    continue;
                    temp.add(f.getName());
                    data.put(s, temp);
                }
            }
    }
    
    private void buildWordFileMap()
    {
        data.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            addWordsFromFile(f);
        }
    }
    
    private int maxNumber()
    {
        int num = 0;
        for(String s: data.keySet())
        {
            if(data.get(s).size() > num)
            {
                num = data.get(s).size();
            }
        }
        return num;
    }
    
    private ArrayList<String> wordsInNumFiles(int number)
    {
        ArrayList<String> words = new ArrayList<String>();
        for(String s: data.keySet())
        {
            if(data.get(s).size() == number)
            {
                words.add(s);
            }
        }
        return words;
    }
    
    private void printFilesIn(String word)
    {
        for(String s : data.get(word))
        {System.out.println(s + "\t");}
    }
    
    void tester()
    {
        buildWordFileMap();
        //int maxNum = maxNumber();
        //System.out.println("There are " + wordsInNumFiles(4).size() + " words");
        //System.out.println("The max number of files has the same word is " + maxNum + ", Those words are " + wordsInNumFiles(maxNum).toString());
        /*for(String s : wordsInNumFiles(maxNum))
        {
            System.out.println(s + " are in ");
            printFilesIn(s);
        }*/
        printFilesIn("tree");
    }
}
