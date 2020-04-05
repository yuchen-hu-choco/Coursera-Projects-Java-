import java.util.*;
import edu.duke.*;
import java.io.*;
/**
 * 在这里给出对类 WordFrequencies 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class WordFrequencies {
    
    private ArrayList<String> myWords = new ArrayList<String>();
    private ArrayList<Integer> myFreqs = new ArrayList<Integer>();
    
    void WordFrequencies()
    {}
    
    void findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        DirectoryResource dr = new DirectoryResource();
        int index, num;
        for(File f: dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            for(String s : fr.words())
            {
                s = s.toLowerCase();
                if(!myWords.contains(s))
                {
                    myWords.add(s);
                    myFreqs.add(1);
                }
                else
                {
                    index = myWords.indexOf(s);
                    num = myFreqs.get(index).intValue() +1;
                    myFreqs.set(index, num);
                }
            }
        }
        
    }
    
    int findIndexOfMax()
    {
        int num = 0;
        for(int i=0; i<myWords.size(); i++)
        {
            if(myFreqs.get(i) > num)
            num = myFreqs.get(i);
        }
        return num;
    }
    
    void tester()
    {
        findUnique();
        //System.out.println(myWords.get(myFreqs.indexOf(findIndexOfMax())));
        System.out.println(findIndexOfMax());
        /*int index = 0;
        int num = 0;
        for(String s: myWords)
        {
            if(myFreqs.get(index) == 5)
            {System.out.println(s + ": " + myFreqs.get(index)); num++;}
            index++;
        }
        System.out.println("Total num is : " + num);
        //System.out.println(myWords.size());
        //System.out.println("The biggest number is " + findIndexOfMax());
        // System.out.println(myWords.get(myFreqs.indexOf(findIndexOfMax())));*/
    } 
}
