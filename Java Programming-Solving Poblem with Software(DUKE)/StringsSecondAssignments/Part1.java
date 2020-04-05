import edu.duke.*;
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part1 {
    
    String findGene(String dna, int sIndex)
    {   
        //System.out.println(sIndex + " sIndex");
        int i1, i2, i3, temp, min = -1;
        if (sIndex == -1) return "";
        i1 = findStopCodon(dna, sIndex, "TGA");
        i2 = findStopCodon(dna, sIndex, "TAG");
        i3 = findStopCodon(dna, sIndex, "TAA");
        //System.out.println(i1 + " i1");
        //System.out.println(i2 + " i2");
        //System.out.println(i3 + " i3");
        if (i1 == -1 && i2 == -1 && i3 ==-1) return "";
        if (i1 == -1) {min = Math.min(i2, i3); if (i2 == -1) min = i3; if(i3 == -1) min = i2;}
        else if (i2 == -1) {min = Math.min(i1, i3); if (i3 == -1) min = i1; if(i1 == -1) min = i3;}
        else if (i3 == -1) {min = Math.min(i2, i1); if (i1 == -1) min = i2; if(i2 == -1) min = i1;}
        else 
        {
            temp = Math.min(i1, i2);
            min = Math.min(temp, i3);
        };
        //System.out.println("min " + min);
        if (min == i1)
        return dna.substring(sIndex, i1+3);
        if (min == i2)
        return dna.substring(sIndex, i2+3);
        return dna.substring(sIndex, i3+3);
    }
    
    void testFindGene()
    {
        String dna = "ATGAATDSADADATAGDSTAGASAS";
        int sIndex = dna.indexOf("ATG");
        System.out.println(findGene(dna, sIndex));
    }

    int findStopCodon(String dna, int startIndex, String stopCodon)
    {   
        int currIndex = 0, temp = startIndex;
        while (currIndex != -1)
        {
            currIndex = dna.indexOf(stopCodon, startIndex+3);
            //System.out.print(currIndex + " ");
            if ((currIndex - temp)%3 == 0) return currIndex;
            startIndex = currIndex;
        }
        return -1;
    }

    void testFindStopCodon()
    {               //01234567890123456789012  
        String dna = "AATDSADADATAGDSTAGASAS";
        System.out.println(findStopCodon(dna, 0, "TAG"));
    }
    
    StorageResource getAllGenes(String dna)
    {   
        StorageResource aSet = new StorageResource(); 
        int sIndex = dna.indexOf("ATG");
        String temp;
        while (true)
        {
            temp = findGene(dna, sIndex);
            if(temp == "") break;
            aSet.add(temp);
            sIndex = dna.indexOf("ATG", sIndex+temp.length());
            //System.out.println(sIndex);
        }
        return aSet;
    }
    
    void testAll()
    {
                    //1234567891123456789212345678931234567894123456789512345678961234567897123456789812345678991234567890123456789112345678921234567893123456789412345678951234567896123
        
        //String dna = "asdATGsadaTAGssTAAhkghrATGeqwTGAiugrqiATCGufgrkfATGhsaTGAkjfdATGhqweiTAGuohfeTAAwuifhasfklashfoiATGAquewfgwoTAAiugcTAGvajhfgwATGeoiTAGAuyfgfTAAdsafqATGwgoiuyTAGgo";
        String dna = "CCGGSDFCGTCa";
        //StorageResource set = new StorageResource();
        //set = getAllGenes(dna);
        //processGenes(set);
        //System.out.println(countGenes(dna));
        System.out.println(cgRatio(dna));
    }
    
    int countGenes(String dna)
    {
        int sIndex = dna.indexOf("ATG"), num=0;
        String temp;
        while (true)
        {
            temp = findGene(dna, sIndex);
            if(temp == "") break;
            num++ ;
            sIndex = dna.indexOf("ATG", sIndex+temp.length());
        }
     return num;
    }
    
    float cgRatio(String dna)
    {   
        int pos=0,num=0,temp1, temp2;
        while(true)
        {
            temp1 = dna.indexOf("C", pos);
            temp2 = dna.indexOf("G", pos);
            if(temp1 != -1 && temp2 != -1)
            pos = Math.min(temp1, temp2);
            else if (temp1 == -1 && temp2 != -1)
            pos = temp2;
            else if (temp2 == -1 && temp2 != -1)
            pos = temp1;
            else break;
            //System.out.print
            num ++;
            pos ++;
        }
        return ((float)num/dna.length());
    }
    
    int countCTG(String dna)
    {
        int count = -1;
        int currIndex = 0;
        int pos = 0;
        while(currIndex != -1)
        {
            count++;
            currIndex = dna.indexOf("CTG", pos);
            pos = currIndex + 1;
            //System.out.println(count);
        }
        return count;
    }
    
    void processGenes(StorageResource sr)
    {
        int num1 = 0, num2 = 0, len = 0, total=0;
        for (String s : sr.data())
        {   
            if (s.length() > len) len = s.length(); 
            if (s.length() > 60) {num1++;}
            if (cgRatio(s) >= 0.35) {num2++;}
            total ++;
        }
        System.out.println(num1 + "the num of >60");
        System.out.println(num2 + "the num of >0.35");
        System.out.println(len + "the longest");
        System.out.println(total + "total");
    }
    
    void Main()
    {
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString().toUpperCase();
        System.out.println(countCTG(dna) + "ctgNum");
        StorageResource Dna = getAllGenes(dna);
        processGenes(Dna);
    }
}
