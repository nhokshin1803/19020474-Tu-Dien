import java.io.File;
import java.io.FileNotFoundException;

public class DictionaryCommandline {
    public static void showAllWords(){
        System.out.format("No   |%-30s|%s%n","English","Vietnamese");
        for(int i=0; i<Dictionary.count; ++i) {
            System.out.format("%-5d|%-30s|%s%n",i+1, Dictionary.word.get(i).word_target, Dictionary.word.get(i).word_explain);
        }
    }
    public static void dictionaryBasic(){
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }
    public static void dictionaryAdvanced() throws FileNotFoundException {
        DictionaryManagement.insertFromFile();
        DictionaryManagement.delete("long");
        showAllWords();
    }
    public static String[] dictionarySearcher(String a) throws FileNotFoundException{
        String[] recommend = new String[10000];
        int length = 0;
        for(int i = 0;i < Dictionary.count; ++i) {
            if(Dictionary.word.get(i).word_target.contains(a)) {
                recommend[length] = Dictionary.word.get(i).word_target;
                length++;
            }
        }
        length = 0;
        return recommend;
    }
    public static void main (String[] args) throws FileNotFoundException {

        dictionaryAdvanced();
    }

}
