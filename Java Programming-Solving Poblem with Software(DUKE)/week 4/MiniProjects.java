import org.apache.commons.csv.*;
import edu.duke.*;
import java.io.*;
/**
 * 在这里给出对类 MiniProjects 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class MiniProjects {

    void totalBirths(FileResource fr)
    {
        int Girls = 0, Boys = 0;
        for (CSVRecord record : fr.getCSVParser(false))
        {
            if(record.get(1).equals("F"))
            {
                Girls++;
            }
            else
            Boys++;
        }
        System.out.println("The number of Girl's name:" + Girls
        +" Boy's name:" + Boys
        +" Total number:" + (Girls+Boys)
        );
    }
    
    int getRank(int year, String name, String gender)
    {
        String file = "C:\\Users\\Choco_Hu\\Desktop\\java\\week 4\\us_babynames_by_year\\yob" + year + ".csv";
        int rank = 0;
        FileResource fr = new FileResource(file);
        for (CSVRecord record : fr.getCSVParser(false))
        {
            if(gender.toUpperCase().equals("F"))
            {
                rank++;
                if(name.equals(record.get(0)))
                {
                    return rank;
                }
            }
            if (gender.toUpperCase().equals("M") && record.get(1).equals("M"))
            {
                rank++;
                if(name.equals(record.get(0)))
                {
                    return rank;
                }
            }
        }
        return -1;
    }
    
    String getName(int year, int rank, String gender)
    {
        String file = "C:\\Users\\Choco_Hu\\Desktop\\java\\week 4\\us_babynames_by_year\\yob" + year + ".csv";
        FileResource fr = new FileResource(file);
        String name = null;
        for(CSVRecord record : fr.getCSVParser(false))
        {
            if(gender.equals(record.get(1)))
            {
                name = record.get(0);
                rank--;
                if(rank == 0) return name;
            }
        }
        return "Too Large Rank";
    }
    
    void whatIsNameInYear(String name, int year, int newYear, String gender)
    {
        int rank = getRank(year, name, gender);
        String Newname = getName(newYear, rank, gender);
        System.out.println("The new name is " + Newname);
    }
    
    int yearOfHighestRank(String name, String gender)
    {
        int highestYear = -1;
        DirectoryResource dr = new DirectoryResource(); 
        int currRank = -1, year, highestRank = -1;
        String Y = null;
        for(File s : dr.selectedFiles())
        {
            Y = s.getName();
            year = Integer.parseInt(Y.substring(3,7));
            //System.out.println(year);
            if(getRank(year, name, gender) == -1) continue;
            currRank = getRank(year, name, gender);
            if (highestRank == -1) {highestRank = currRank; highestYear = year; continue;}
            if(highestRank > currRank)
            {
                currRank = highestRank;
                highestYear = year;
            }
        }
        return highestYear;
    }
    
    double getAverageRank(String name, String gender)
    {
        int num = 0;
        DirectoryResource dr = new DirectoryResource(); 
        int currRank = -1, year, total = 0;
        String Y = null;
        for(File s : dr.selectedFiles())
        {
            Y = s.getName();
            year = Integer.parseInt(Y.substring(3,7));
            currRank = getRank(year, name, gender);
            total += currRank;
            num++;
        }
        return (double)total/num;
    }
    
    int getBirth(int year, int rank)
    {   
        String file = "C:\\Users\\Choco_Hu\\Desktop\\java\\week 4\\us_babynames_by_year\\yob" + year + ".csv";
        FileResource fr = new FileResource(file);
        for(CSVRecord record : fr.getCSVParser(false))
        {
            rank--;
            if(rank == 0) return Integer.parseInt(record.get(2));
        }
        return -1;
    }
    
    int getTotalBirthsRankedHigher(int year, String name, String gender)
    {
        int rank = getRank(year, name, gender);
        int total = 0;
        for(int i=1; i<rank; i++)
        {
            total += getBirth(year, i);
        }
        return total;
    }
    
    int nums(int year, String gender)
    {
        String file = "C:\\Users\\Choco_Hu\\Desktop\\java\\week 4\\us_babynames_by_year\\yob" + year + ".csv";
        FileResource fr = new FileResource(file);
        int i = 0;
        for(CSVRecord record : fr.getCSVParser(false))
        {
            if(gender.equals("F") && record.get(1).equals("F")) {i++; continue;}
            if(gender.equals("M") && record.get(1).equals("M")) i++;
        }
        return i;
    }
    
    void main()
    {
        //FileResource fr = new FileResource();
        //totalBirths(fr);
        //System.out.println(getRank(1881,"Ida","f"));
        //System.out.println(nums(1900, "F"));
        //System.out.println(nums(1905, "M"));
        //System.out.println(getRank(1971, "Frank", "M"));
        //System.out.println(getName(1980, 350, "F"));
        //System.out.println(getName(1982, 450, "M"));
        //whatIsNameInYear("Owen", 1974, 2014, "M");
        //System.out.println(yearOfHighestRank("Genevieve", "F"));
        //System.out.println(getAverageRank("Robert", "M"));
        System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
}

