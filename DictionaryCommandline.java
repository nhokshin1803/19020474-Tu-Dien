public class DictionaryCommandline {
    public static void showAllWords(){
        System.out.println("No   | English          | Vietnamese");
        for(int i=0; i<Dictionary.count; ++i) {
            System.out.println((i+1) +"    |" + Dictionary.word[i].word_target +"           |"
                    + Dictionary.word[i].word_explain);
        }
    }
    public static void dictionaryBasic(){
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }
    public static void main(String[] args) {
        DictionaryCommandline.dictionaryBasic();
    }
}
