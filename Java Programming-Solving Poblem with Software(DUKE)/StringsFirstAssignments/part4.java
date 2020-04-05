import edu.duke.*;
/**
 * 在这里给出对类 part4 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class part4 {
    
    String testurl(String url)
    {
        int start, end, length;
        int a = url.toLowerCase().indexOf("youtube.com");
        if (a == -1)
        return "";
        start = url.indexOf("\"");
        end = url.lastIndexOf("\"",url.length());
        return (url.substring(start,end+1));
    }


    void findweb()
    {
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String s : ur.words())
        {
            if (testurl(s) == "") continue;
            System.out.println(testurl(s));
        }
    }
}
