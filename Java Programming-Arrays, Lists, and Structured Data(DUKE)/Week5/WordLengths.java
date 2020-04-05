import  edu.duke.*;
/**
 * 在这里给出对类 WordLengths 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class WordLengths {
    void countWordLengths(FileResource fr, int[] counts)
    {
        for(String s : fr.words())
        {
            int currLength = 0;
            for(int i=0; i<s.length(); i++)
            {
                if(Character.isLetter(s.charAt(i)))
                {
                    currLength++;
                }
            }
            if(currLength >= counts.length)currLength = counts.length -1;
            counts[currLength]++;
        }
        
        for(int i=1; i<counts.length; i++)
        {
            System.out.println("The number of length of" + i +"\t is " + counts[i]);
        }
    }
    
    void testCountWordLengths()
    {
        int[] count = new int[31];
        FileResource fr = new FileResource();
        countWordLengths(fr, count);
    }
}
