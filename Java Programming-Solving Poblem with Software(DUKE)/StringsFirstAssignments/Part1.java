
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part1 {
    
    String findSimpleGene(String dna)
    {
        String d;
        int Sindex = dna.indexOf("ATG");
        if (Sindex == -1) return "";
        int Eindex = dna.indexOf("TAA", Sindex + 3);
        if (Eindex == -1) return "";
        d = dna.substring(Sindex, Eindex+3);
        if (d.length() % 3 == 0) return d;
        else return "";
    }
    
    void testSimpleGene()
    {
        String dna1 = "ATGSBTAA";
        String dna2 = "BDAUIDUIATGDASDSSTAADASD";
        String dna3 = "ATGDASDEE";
        String dna4 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println(findSimpleGene(dna1));
        System.out.println(findSimpleGene(dna2));
        System.out.println(findSimpleGene(dna3));
        System.out.println(findSimpleGene(dna4));
        
    }

}
