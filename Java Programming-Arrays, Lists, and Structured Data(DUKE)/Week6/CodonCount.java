import java.util.*;
/**
 * 在这里给出对类 CodonCount 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class CodonCount {
    private HashMap<String, Integer> cc = new HashMap<String, Integer>();
    
    void CodonCount()
    {}
    
    void buildCodonMap(int start, String dna)
    {
        String s = dna.substring(start);
        for(int i=0; i<s.length()/3; i++)
        {
            String codon = s.substring(3*i, 3*i+3);
            if(!cc.containsKey(codon))
            {
                cc.put(codon, 1);
            }
            else
            {
                cc.put(codon, cc.get(codon) + 1);
            }
        }
    }
    
    String getMostCommonCodon()
    {
        int temp = 0;
        String most = "";
        for(String s: cc.keySet())
        {
            if(cc.get(s)>temp)
            {
                temp = cc.get(s);
                most = s;
            }
        }
        return most;
    }
    
    void printCodonCounts(int start, int end)
    {
        for(String s : cc.keySet())
        {
            if(cc.get(s) > start && cc.get(s) < end)
            {
                System.out.println(s + "\t: " + cc.get(s));
            }
        }
    }
    
    void tester()
    {
        String dna = "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC";
        cc.clear();
        buildCodonMap(0, dna);
        printCodonCounts(6, 8);
        //String mostCommon = getMostCommonCodon();
        //System.out.println(mostCommon + " num is: " + cc.get(mostCommon));
        /*cc.clear();
        buildCodonMap(1, dna);
        //String mostCommon1 = getMostCommonCodon();
        //System.out.println(mostCommon1 + " num is: " + cc.get(mostCommon1));
        //System.out.println(cc.size());
        cc.clear();
        buildCodonMap(2, dna);
        String mostCommon2 = getMostCommonCodon();
        System.out.println(mostCommon2 + " num is: " + cc.get(mostCommon2));
        printCodonCounts(3,5);*/
        
    }
}
