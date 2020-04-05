import edu.duke.*;
import java.util.*;

public class GladLib {
    private HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
    private HashMap<String, ArrayList<String>> used = new HashMap<String, ArrayList<String>>();
        String[] label = {"adjective", "noun", "color", "country", "name", "animal", "timeframe", "verb", "fruit"}; 
    private Random myRandom;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "C:/Users/Choco_Hu/Desktop/java/Week6/data";
    
    public GladLib(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {

        for(int i=0; i<label.length; i++)
        {
            data.put(label[i], readIt(source+"/"+label[i]+".txt"));
        }
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
     private String getSubstitute(String label) {
        if(data.containsKey(label))
        {
            if(!used.containsKey(label))
            used.put(label, data.get(label));
            return randomFrom(data.get(label));
        }
        if (label.equals("number")){
        return ""+myRandom.nextInt(50)+5;
        }
        return "**UNKNOWN**";
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    int totalWordsInMap()
    {
        int total = 0;
        for(String s: data.keySet())
        {
            total += data.get(s).size();
        }
        return total;
    }
    
    int totalWordsConsidered()
    {
        int total = 0;
        for(String s: used.keySet())
        {
            total += used.get(s).size();
        }
        return total;
    }
    
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("C:/Users/Choco_Hu/Desktop/java/Week6/data/madtemplate2.txt");
        printOut(story, 60);
    }
    


}
