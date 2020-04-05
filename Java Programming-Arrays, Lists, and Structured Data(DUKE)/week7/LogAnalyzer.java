
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for(String s : fr.lines())
         {
             LogEntry le = WebLogParser.parseEntry(s);
             records.add(le);             
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     int countUniqueIPs()
     {
        ArrayList<String> unique = new ArrayList<String>();
        for(LogEntry lr : records)
        {
            if(!unique.contains(lr.getIpAddress()))
            {
                unique.add(lr.getIpAddress());
            }
        }
        return unique.size();
     }
     
     ArrayList<String> uniqueIPVisitsOnDay(String someday)
     {
         ArrayList<String> unique = new ArrayList<String>();
         
        for(LogEntry le : records)
        {
            if(!unique.contains(le.getIpAddress()) && le.getAccessTime().toString().contains(someday))
            {
                unique.add(le.getIpAddress());
            }
        }
         return unique;
     }
     
     int countUniqueIPsInRange(int low, int high)
     {
        ArrayList<String> unique = new ArrayList<String>();
         for(LogEntry le : records)
        {
            if(le.getStatusCode() <= high && le.getStatusCode() >= low)
            {
                if(!unique.contains(""+le.getIpAddress()))
                unique.add(""+le.getIpAddress());
            }
        }
         return unique.size();
     }
     
     HashMap<String, Integer> countVisitPerIP()
     {
         HashMap<String, Integer> count = new HashMap<String, Integer>();
         for(LogEntry le : records)
         {
             String s = le.getIpAddress();
             if(!count.containsKey(s))
             {
                 count.put(s, 1);
             }
             else
             {
                 count.put(s, count.get(s)+1);
             }
         }
         return count;
     }
     
     int mostNumberVisitsByIP(HashMap<String, Integer> count)
     {
         int num = 0;
         for(String s : count.keySet())
         {
             if(count.get(s) > num) num = count.get(s);
         }
         return num;
     }
     
     HashMap<String, ArrayList<String>> iPsForDays()
     { 
         HashMap<String, ArrayList<String>> count = new HashMap<String, ArrayList<String>>();
         for(LogEntry le : records)
         {
             String ip = le.getIpAddress();
             String time = le.getAccessTime().toString();
             String date = time.substring(4, 10);
             ArrayList ips = new ArrayList();
             if(!count.containsKey(date))
             {
                 ips.add(ip);
                 count.put(date, ips);
                }
             else
             {
                 ips = count.get(date);
                 ips.add(ip);
                 count.put(date, ips);
                }
         }
         return count;
     }
     
     ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> count, String date)
     {
         ArrayList<String> oneDay = count.get(date);
         HashMap<String, Integer> stat = new HashMap<String, Integer>();
         ArrayList<String> result = new ArrayList<String>();
         for(String s : oneDay)
         {
             if(!stat.containsKey(s)) stat.put(s, 1);
             else stat.put(s, stat.get(s)+1);
            }
         int num = 0;
         for(String s: stat.keySet())
         {
             if(stat.get(s) > num) num = stat.get(s);
            }
         for(String s: stat.keySet())
         {
             if(stat.get(s) == num) result.add(s);
            }
         return result;
        }
     
     String dayWithMostIPVisits(HashMap<String, ArrayList<String>> count)
     {
         int num = 0;
         String date = null;
         for(String s : count.keySet())
         {
             if(count.get(s).size() > num) 
             {num = count.get(s).size();
              date = s;  
             }   
         }
         return date;
     }
     
     void printAllHigherThanNum(int num)
     {
        ArrayList<Integer> code = new ArrayList<Integer>(); 
        for(LogEntry le : records)
        {
            Integer numb = new Integer(le.getStatusCode());
            if(le.getStatusCode() > num)
            {
                if(!code.contains(numb))
                code.add(numb);
            }
        }
        System.out.println(code.toString());
     }
     
     
}
