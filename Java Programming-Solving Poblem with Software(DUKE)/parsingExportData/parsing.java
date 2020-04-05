import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * 在这里给出对类 parsing 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class parsing {
    
    String countryinfo(CSVParser parser, String cName)
    {
        for (CSVRecord record: parser)
        {
            String country = record.get("Country");
            if (country.contains(cName))
            {
                return (cName + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
            }
        }
        return "Not Found!";
    }
    
    void listExportersTwoProducts(CSVParser parser, String exportitem1, String exportitem2)
    {
        for(CSVRecord record : parser)
        {
            if (record.get("Exports").contains(exportitem1) && record.get("Exports").contains(exportitem2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    int numberOfExporters(CSVParser parser, String exportItem)
    { 
        int num = 0;
        for (CSVRecord record : parser)
        {
            if(record.get("Exports").contains(exportItem)) num++;
        }
        return num;
    }
    
    void bigExporters(CSVParser parser, String amount)
    {
        for (CSVRecord record : parser)
        {
            if(record.get("Value (dollars)").length() > amount.length())
            {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    void tester()
    {
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        //String Nauru = countryinfo(parser, "Nauru");
        //System.out.println(Nauru);
        //listExportersTwoProducts(parser, "cotton", "flowers");
        //System.out.println(numberOfExporters(parser, "cocoa"));
        bigExporters(parser, "$999,999,999,999");
    }
   
    
}
