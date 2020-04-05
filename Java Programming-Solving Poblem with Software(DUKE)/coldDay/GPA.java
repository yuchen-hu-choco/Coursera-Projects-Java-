import java.util.Scanner;
/**
 * 在这里给出对类 GPA 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class GPA {

    void gpa()
    {
        Scanner input = new Scanner(System.in);
        double score, credict, totalCredit = 0, total = 0;
        while(true)
        {
            score = input.nextInt();
            credict = input.nextDouble();
            if (score == -1) break;
            total += score*credict;
            totalCredit += credict;
        }
        System.out.println(total/totalCredit);
    }
}
