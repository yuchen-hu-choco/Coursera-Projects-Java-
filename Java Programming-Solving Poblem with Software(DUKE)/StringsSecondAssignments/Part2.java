
/**
 * 在这里给出对类 Part2 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part2 {
    int howMany(String a, String b)
    {
        int loc = b.indexOf(a);
        int num = 0, temp;
        while(loc != -1)
        {
            temp = loc + a.length();
            num++ ;
            loc = b.indexOf(a, temp);
        }
        return num;
    }
    
    void test()
    {
        String strA = "AABBCCAABBAAAABBCC";
        System.out.println(howMany("AA", strA));
    }
}
