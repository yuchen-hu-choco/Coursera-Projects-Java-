
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
    }
    
    public void testUniqueIP()
    {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        /*
        //This part is to  find the ip with the most visits.
        int i = 0;
        String sb = null;
        HashMap<String, Integer> hm = la.countVisitPerIP();
        for(String s : hm.keySet())
        {
            if(hm.get(s) > i)
            {i = hm.get(s); sb = s;}
        }
        System.out.println(sb);*/
        System.out.println(la.countUniqueIPsInRange(200,299));
    }
}
