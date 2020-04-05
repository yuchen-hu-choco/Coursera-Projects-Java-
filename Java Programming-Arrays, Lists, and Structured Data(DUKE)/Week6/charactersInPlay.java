import java.util.*;
import edu.duke.*;
/**
 * 在这里给出对类 charactersInPlay 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class charactersInPlay {
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<Integer> counts = new ArrayList<Integer>();
    
    void update()
    {
        names.clear();
        counts.clear();
        int index,num;
        String possibleName;
        FileResource fr = new FileResource();
        for(String s : fr.lines())
        {
            index = s.indexOf(".");
            if(index == -1)
            {
                continue;
            }
            possibleName = s.substring(0, index);
            possibleName = possibleName.trim();
            if(!names.contains(possibleName))
            {
                names.add(possibleName);
                counts.add(1);
            }
            else
            {
                index = names.indexOf(possibleName);
                num = counts.get(index).intValue() + 1;
                counts.set(index, num);
            }
        }
    }
    
    void charactersWithNumParts(int num1, int num2)
    {
        for(int i=0; i<names.size(); i++)
        {
            if(counts.get(i) <= num2 && counts.get(i) >= num1)
            {
                System.out.println(names.get(i) + " : " +counts.get(i));
            }
        }
    }
    
    void test()
    {
        update();
        /*for(int i=0; i<names.size(); i++)
        {
            System.out.println(names.get(i) + " : " +counts.get(i));
        }
        int num = 0;
        for(int i=0; i<names.size(); i++)
        {
            if(counts.get(i)>num) num = counts.get(i);
        }
        System.out.println(names.get(counts.indexOf(num)) + " : " + num);*/
        charactersWithNumParts(10, 15);
    }
}
