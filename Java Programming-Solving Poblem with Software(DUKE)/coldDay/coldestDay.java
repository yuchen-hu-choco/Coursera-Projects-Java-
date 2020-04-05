import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;
/**
 * 在这里给出对类 coldestDay 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class coldestDay {
    
    CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord currRecord = null;
        for (CSVRecord rec : parser)
            {
             currRecord = minRecord(rec, currRecord, "TemperatureF");
            }
        return currRecord;
    }
   
    CSVRecord minRecord(CSVRecord rec, CSVRecord currRecord, String parameter)
    { 
        double temp1, temp2;
        if(currRecord == null) return rec;
        else
        {
            temp1 = Double.parseDouble(rec.get(parameter));
            temp2 = Double.parseDouble(currRecord.get(parameter));
            if(temp1 < temp2) currRecord = rec;
            return currRecord;
        }
    }
    
    CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord currRecord = null;
        for (CSVRecord rec : parser)
            {
             currRecord = minRecord(rec, currRecord, "Humidity");
            }
        return currRecord;
    }
    
    CSVRecord lowestTemperatureInFile(CSVParser parser)
    {
        CSVRecord currRecord = null;
        for (CSVRecord rec : parser)
            {
             currRecord = minRecord(rec, currRecord, "TemperatureF");
            }
        return currRecord;
    }
    
    void testLowestH()
    {
        FileResource fr = new FileResource("weather-2013-09-02.csv");
        //System.out.println(coldestHourInFile(fr.getCSVParser()).get("TemperatureF"));
        System.out.println(averageTemperatureWithHighHumidityInFile(fr.getCSVParser(), 80));
    }
    
    CSVRecord lowestHumidityInManyFiles()
    {
        CSVRecord lowest = null;
        CSVRecord currRecord = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            currRecord = lowestHumidityInFile(fr.getCSVParser());
            lowest = minRecord(currRecord, lowest, "Humidity");
        }
        return lowest;
    }
    
    CSVRecord lowestTemperatureInManyFiles()
    {
        CSVRecord lowest = null;
        CSVRecord currRecord = null;
        String lowestDay = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            if(lowestDay == null || Double.parseDouble(lowest.get("TemperatureF")) > Double.parseDouble(currRecord.get("TemperatureF")))
            {
                lowestDay = f.getName();
            }
            currRecord = lowestTemperatureInFile(fr.getCSVParser());
            lowest = minRecord(currRecord, lowest, "TemperatureF");

        }
        System.out.println(lowestDay);
        return lowest;
    }
    
    
    double averageTemperatureInFile(CSVParser parser)
    {
        double allTemp = 0;
        int num = 0;
        for (CSVRecord rec : parser)
        {
            allTemp += Double.parseDouble(rec.get("TemperatureF"));
            num++;
        }
        return allTemp/num;
    }
    
    double averageTemperatureWithHighHumidityInFile(CSVParser parser, int humidity)
    {
        double allTemp = 0;
        int num = 0;
        for (CSVRecord rec : parser)
        {
            if(Integer.parseInt(rec.get("Humidity")) >= humidity) 
            {
                allTemp += Double.parseDouble(rec.get("TemperatureF"));
                num++;
            }
        }
        return allTemp/num;
    }
    
    
    void testAll()
    {
        //CSVRecord lowest = lowestHumidityInManyFiles();
        CSVRecord lowest1 = lowestTemperatureInManyFiles();
        //System.out.println("The lowest Humidity is " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
        System.out.println("The lowest Temperature is " + lowest1.get("TemperatureF") + " at " + lowest1.get("DateUTC"));
        //System.out.println();
    }
    
}
